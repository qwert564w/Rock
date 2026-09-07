package rockstar.client.internal.script;




import rockstar.client.module.*;
import rockstar.client.i18n.*;
import rockstar.client.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import rockstar.client.module.ModuleEntry;
import rockstar.client.RockstarClient;

public class ScriptInternal160 {
    private static final String internalField0248 = "wss://api.deepgram.com/v1/listen?model=nova-2&language=ru&encoding=linear16&sample_rate=16000&interim_results=true&punctuate=true&smart_format=true&endpointing=1000";
    private final String internalField0247;
    private final OkHttpClient internalField0754;
    private WebSocket internalField0055;
    private TargetDataLine internalField0045;
    private Thread internalField0380;
    private volatile boolean internalField0277;
    private Consumer<String> internalField0922 = string -> {};
    private Consumer<String> internalField0921 = string -> {};

    public ScriptInternal160(String string2) {
        this.internalField0247 = Objects.requireNonNull(string2, "apiKey");
        this.internalField0754 = new OkHttpClient.Builder().readTimeout(0L, TimeUnit.MILLISECONDS).build();
    }

    public ScriptInternal160 internalMethod04669(Consumer<String> consumer) {
        this.internalField0922 = consumer != null ? consumer : string -> {};
        return this;
    }

    public ScriptInternal160 internalMethod05400(Consumer<String> consumer) {
        this.internalField0921 = consumer != null ? consumer : string -> {};
        return this;
    }

    public void internalMethod07037() throws Exception {
        if (this.internalField0277) {
            return;
        }
        this.internalField0277 = true;
        StringBuilder stringBuilder = new StringBuilder(internalField0248);
        for (ModuleEntry typedValue145 : RockstarClient.getInstance().getModuleManager().getModules()) {
            stringBuilder.append("&keywords=" + typedValue145.getName() + ":5");
        }
        Request request = new Request.Builder().url(stringBuilder.toString()).addHeader("Authorization", "Token " + this.internalField0247).build();
        this.internalField0055 = this.internalField0754.newWebSocket(request, new WebSocketListener(){

            public void onOpen(WebSocket webSocket, Response response) {
                try {
                    ScriptInternal160.this.internalMethod05601(webSocket);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    ScriptInternal160.this.internalMethod07040();
                }
            }

            public void onMessage(WebSocket webSocket, String string) {
                ScriptInternal160.this.internalMethod06794(string);
            }

            public void onMessage(WebSocket webSocket, ByteString byteString) {
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                System.err.println("[Deepgram] WS failure: " + String.valueOf(throwable));
                ScriptInternal160.this.internalMethod07040();
            }

            public void onClosing(WebSocket webSocket, int n, String string) {
                webSocket.close(1000, null);
            }

            public void onClosed(WebSocket webSocket, int n, String string) {
            }
        });
    }

    public void internalMethod07040() {
        this.internalField0277 = false;
        try {
            if (this.internalField0055 != null) {
                this.internalField0055.send("{\"type\":\"CloseStream\"}");
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (this.internalField0380 != null) {
                this.internalField0380.join(500L);
                this.internalField0380 = null;
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        try {
            if (this.internalField0045 != null) {
                this.internalField0045.stop();
                this.internalField0045.close();
                this.internalField0045 = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (this.internalField0055 != null) {
                this.internalField0055.close(1000, "bye");
                this.internalField0055 = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void internalMethod05601(WebSocket webSocket) throws Exception {
        AudioFormat audioFormat = new AudioFormat(16000.0f, 16, 1, true, false);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
        this.internalField0045 = (TargetDataLine)AudioSystem.getLine(info);
        this.internalField0045.open(audioFormat);
        this.internalField0045.start();
        this.internalField0380 = new Thread(() -> {
            byte[] byArray = new byte[3200];
            long l = System.currentTimeMillis();
            while (this.internalField0277 && this.internalField0045.isOpen()) {
                int n = this.internalField0045.read(byArray, 0, byArray.length);
                if (n > 0) {
                    webSocket.send(ByteString.of((byte[])byArray, (int)0, (int)n));
                    l = System.currentTimeMillis();
                }
                if (System.currentTimeMillis() - l <= 4000L) continue;
                webSocket.send("{\"type\":\"KeepAlive\"}");
                l = System.currentTimeMillis();
            }
        }, "Deepgram-MicPump");
        this.internalField0380.setDaemon(true);
        this.internalField0380.start();
    }

    public void internalMethod06794(String string) {
        try {
            JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
            if (!jsonObject.has("type") || !"Results".equals(jsonObject.get("type").getAsString())) {
                return;
            }
            boolean bl = jsonObject.has("is_final") && jsonObject.get("is_final").getAsBoolean();
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("channel");
            if (jsonObject2 == null) {
                return;
            }
            JsonArray jsonArray = jsonObject2.getAsJsonArray("alternatives");
            if (jsonArray == null || jsonArray.size() == 0) {
                return;
            }
            String string2 = jsonArray.get(0).getAsJsonObject().get("transcript").getAsString();
            if (string2 == null || string2.isBlank()) {
                return;
            }
            if (bl) {
                this.internalField0921.accept(string2);
            } else {
                this.internalField0922.accept(string2);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

