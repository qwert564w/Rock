package rockstar.client.internal.auth;




import rockstar.client.network.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import rockstar.client.internal.auth.AuthInternal009;
import rockstar.client.internal.auth.AuthInternal010;
import rockstar.client.internal.auth.AuthInternal011;
import rockstar.client.internal.auth.AuthInternal012;
import rockstar.client.internal.auth.AuthInternal013;
import rockstar.client.internal.core.CoreInternal014;
import rockstar.client.network.RockstarHttpClient;
import rockstar.client.internal.core.CoreInternal027;
import rockstar.client.internal.auth.AuthInternal001;
import rockstar.client.network.RockstarHttpRequest;

public class AuthInternal016
extends CoreInternal014 {
    private final CoreInternal027<AuthInternal001> internalField0071;
    private final String internalField0247;

    public AuthInternal016(RockstarHttpClient typedValue034, String string, CoreInternal027<AuthInternal001> typedValue081) {
        super(typedValue034, "pocket.realms.minecraft.net");
        this.internalField0071 = typedValue081;
        this.internalField0247 = string;
    }

    public AuthInternal010 internalMethod06325(String string) throws IOException {
        return (AuthInternal010)this.internalField0058.internalMethod07532(this.internalMethod04103(new AuthInternal012(string)));
    }

    @SneakyThrows(IOException.class)
    public AuthInternal010 internalMethod02199(String string) {
        return this.internalMethod06325(string);
    }

    public CompletableFuture<AuthInternal010> internalMethod06448(String string) {
        return CompletableFuture.supplyAsync(() -> this.internalMethod02199(string));
    }

    public void internalMethod01354(AuthInternal010 typedValue062) throws IOException {
        this.internalField0058.internalMethod07532(this.internalMethod04103(new AuthInternal011(typedValue062)));
    }

    @SneakyThrows(IOException.class)
    public void internalMethod02630(AuthInternal010 typedValue062) {
        this.internalMethod01354(typedValue062);
    }

    public CompletableFuture<Void> internalMethod07196(AuthInternal010 typedValue062) {
        return CompletableFuture.runAsync(() -> this.internalMethod02630(typedValue062));
    }

    @Override
    public AuthInternal009 internalMethod02758(AuthInternal010 typedValue062) throws IOException {
        return (AuthInternal009)this.internalField0058.internalMethod07532(this.internalMethod04103(new AuthInternal013(typedValue062)));
    }

    @Override
    public <T extends RockstarHttpRequest> T internalMethod04103(T t) throws IOException {
        t.internalMethod01193("Authorization", this.internalField0071.internalMethod03989().internalMethod02091());
        t.internalMethod01193("Client-Version", this.internalField0247);
        return t;
    }
}
