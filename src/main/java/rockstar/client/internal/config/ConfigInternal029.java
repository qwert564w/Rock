package rockstar.client.internal.config;



import rockstar.client.internal.auth.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import globals.client.api.RockNetClient;
import globals.shared.proto.Packet;
import globals.shared.proto.Packets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.MinecraftClient;
import rockstar.client.internal.config.ConfigInternal030;
import rockstar.client.internal.auth.AuthInternal044;
import rockstar.client.RockstarClient;

public class ConfigInternal029 {
    private static final long internalField0229 = 15L;
    private final AtomicBoolean internalField0020 = new AtomicBoolean(false);
    private final AtomicBoolean internalField0019 = new AtomicBoolean(false);
    private final AtomicBoolean internalField0960 = new AtomicBoolean(false);
    private volatile String internalField0248;
    private final ScheduledExecutorService internalField0220 = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ClientData-Autosave");
        thread.setDaemon(true);
        return thread;
    });

    public ConfigInternal029() {
        this.internalField0220.scheduleWithFixedDelay(this::internalMethod08902, 15L, 15L, TimeUnit.SECONDS);
    }

    public void internalMethod05802() {
        this.internalField0019.set(false);
        this.internalMethod07285(new Packets.InternalType0284());
    }

    public void internalMethod01357(JsonObject jsonObject) {
        AuthInternal044 typedValue139 = this.internalMethod03290();
        if (jsonObject != null && jsonObject.size() > 0) {
            this.internalField0020.set(true);
            MinecraftClient.getInstance().execute(() -> {
                try {
                    if (typedValue139 != null) {
                        AuthInternal044.InternalType0291 nestedValue0110 = typedValue139.internalMethod01758(jsonObject);
                        if (!nestedValue0110.internalMethod05255()) {
                            typedValue139.internalMethod06333(true);
                        }
                        if (nestedValue0110.internalMethod05250() && !typedValue139.internalMethod02134()) {
                            this.internalMethod07285(new Packets.InternalType0283(typedValue139.internalMethod03450()));
                        }
                        if (!typedValue139.internalMethod02134()) {
                            this.internalField0248 = typedValue139.internalMethod03450().toString();
                        }
                    }
                }
                catch (Exception exception) {
                    RockstarClient.internalField0572.error("[ClientData] apply failed", (Throwable)exception);
                }
                finally {
                    this.internalField0020.set(false);
                }
            });
        } else if (this.internalField0960.compareAndSet(false, true) && typedValue139 != null && !typedValue139.internalMethod02134()) {
            this.internalMethod08903();
            typedValue139.internalMethod06333(true);
        }
        this.internalField0019.set(true);
    }

    private void internalMethod08902() {
        if (!this.internalField0019.get() || this.internalField0020.get()) {
            return;
        }
        AuthInternal044 typedValue139 = this.internalMethod03290();
        if (typedValue139 == null) {
            return;
        }
        if (typedValue139.internalMethod02134()) {
            return;
        }
        JsonObject jsonObject = typedValue139.internalMethod03450();
        String string = jsonObject.toString();
        if (string.equals(this.internalField0248)) {
            return;
        }
        this.internalField0248 = string;
        this.internalMethod07285(new Packets.InternalType0283(jsonObject));
    }

    public void internalMethod05805() {
        if (!this.internalField0019.get() && !this.internalField0960.get()) {
            return;
        }
        this.internalMethod08903();
    }

    public void internalMethod08884() {
        AuthInternal044 typedValue139 = this.internalMethod03290();
        if (typedValue139 == null) {
            return;
        }
        typedValue139.internalMethod08891();
        this.internalField0248 = null;
    }

    private void internalMethod08903() {
        if (this.internalField0020.get()) {
            return;
        }
        AuthInternal044 typedValue139 = this.internalMethod03290();
        if (typedValue139 == null) {
            return;
        }
        if (typedValue139.internalMethod02134()) {
            return;
        }
        JsonObject jsonObject = typedValue139.internalMethod03450();
        this.internalField0248 = jsonObject.toString();
        this.internalMethod07285(new Packets.InternalType0283(jsonObject));
    }

    public void internalMethod08886() {
        this.internalField0220.shutdownNow();
    }

    private AuthInternal044 internalMethod03290() {
        ConfigInternal030 typedValue138 = RockstarClient.getInstance().internalMethod03371().internalMethod01175("client");
        return typedValue138 instanceof AuthInternal044 ? (AuthInternal044)typedValue138 : null;
    }

    private void internalMethod07285(Packet packet) {
        RockNetClient rockNetClient = RockstarClient.getInstance().internalMethod06050();
        if (rockNetClient != null) {
            rockNetClient.send(packet);
        }
    }
}

