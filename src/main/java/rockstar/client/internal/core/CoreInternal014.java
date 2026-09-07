package rockstar.client.internal.core;





import rockstar.client.network.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.auth.*;
import rockstar.client.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;
import lombok.SneakyThrows;
import rockstar.client.internal.auth.AuthInternal009;
import rockstar.client.internal.auth.AuthInternal010;
import rockstar.client.internal.network.NetworkInternal007;
import rockstar.client.internal.network.NetworkInternal008;
import rockstar.client.network.RockstarHttpClient;
import rockstar.client.network.RockstarHttpRequest;

public abstract class CoreInternal014 {
    public final RockstarHttpClient internalField0058;
    public final String internalField0248;

    public CoreInternal014(RockstarHttpClient typedValue034, String string) {
        this.internalField0058 = typedValue034;
        this.internalField0248 = string;
    }

    public boolean internalMethod02568() throws IOException {
        String string = (String)this.internalField0058.internalMethod07532(this.internalMethod04103(new NetworkInternal007(this.internalField0248)));
        return string.equals("COMPATIBLE");
    }

    @SneakyThrows(IOException.class)
    public boolean internalMethod02571() {
        return this.internalMethod02568();
    }

    public CompletableFuture<Boolean> internalMethod05930() {
        return CompletableFuture.supplyAsync(this::internalMethod02571);
    }

    public List<AuthInternal010> internalMethod00400() throws IOException {
        return (List)this.internalField0058.internalMethod07532(this.internalMethod04103(new NetworkInternal008(this.internalField0248)));
    }

    @SneakyThrows(IOException.class)
    public List<AuthInternal010> internalMethod06135() {
        return this.internalMethod00400();
    }

    public CompletableFuture<List<AuthInternal010>> internalMethod03099() {
        return CompletableFuture.supplyAsync(this::internalMethod06135);
    }

    public abstract AuthInternal009 internalMethod02758(AuthInternal010 localValue1) throws IOException;

    @SneakyThrows(IOException.class)
    public AuthInternal009 internalMethod05105(AuthInternal010 typedValue062) {
        return this.internalMethod02758(typedValue062);
    }

    public CompletableFuture<AuthInternal009> internalMethod01851(AuthInternal010 typedValue062) {
        return CompletableFuture.supplyAsync(() -> this.internalMethod05105(typedValue062));
    }

    public abstract <T extends RockstarHttpRequest> T internalMethod04103(T localValue1) throws IOException;

    @Generated
    public RockstarHttpClient internalMethod04780() {
        return this.internalField0058;
    }

    @Generated
    public String internalMethod04874() {
        return this.internalField0248;
    }
}
