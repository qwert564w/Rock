package rockstar.client.internal.network;


import rockstar.client.*;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Generated;

public final class NetworkInternal020 {
    private static ExecutorService internalField0124 = Executors.newSingleThreadExecutor();
    private static final String internalField0248 = "http://89.111.169.151:10020/webhook";
    private static final HttpClient internalField0791 = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10L)).build();

    public static void internalMethod03328(String string) {
    }

    private static String internalMethod00004(String string) {
        return string.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    @Generated
    private NetworkInternal020() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

