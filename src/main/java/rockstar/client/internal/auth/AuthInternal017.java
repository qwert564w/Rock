package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import rockstar.client.internal.auth.AuthInternal009;
import rockstar.client.internal.auth.AuthInternal010;
import rockstar.client.internal.auth.AuthInternal014;
import rockstar.client.internal.auth.AuthInternal015;
import rockstar.client.internal.core.CoreInternal014;
import rockstar.client.internal.config.ConfigInternal013;
import rockstar.client.internal.config.ConfigInternal014;
import rockstar.client.network.RockstarHttpClient;
import rockstar.client.internal.core.CoreInternal026;
import rockstar.client.internal.core.CoreInternal027;
import rockstar.client.network.RockstarHttpRequest;

public class AuthInternal017
extends CoreInternal014 {
    private final CoreInternal027<ConfigInternal014> internalField0071;
    private final CoreInternal027<ConfigInternal013> internalField0072;
    private final String internalField0247;

    public AuthInternal017(RockstarHttpClient typedValue034, String string, CoreInternal027<ConfigInternal014> typedValue081, CoreInternal027<ConfigInternal013> typedValue082) {
        super(typedValue034, "pc.realms.minecraft.net");
        this.internalField0071 = typedValue081;
        this.internalField0072 = typedValue082;
        this.internalField0247 = string;
    }

    @Override
    public AuthInternal009 internalMethod02758(AuthInternal010 typedValue062) throws IOException {
        return (AuthInternal009)this.internalField0058.internalMethod07532(this.internalMethod04103(new AuthInternal015(typedValue062)));
    }

    public void internalMethod02056() throws IOException {
        this.internalField0058.internalMethod07532(this.internalMethod04103(new AuthInternal014()));
    }

    @SneakyThrows(IOException.class)
    public void internalMethod02058() {
        this.internalMethod02056();
    }

    public CompletableFuture<Void> internalMethod08975() {
        return CompletableFuture.runAsync(this::internalMethod02058);
    }

    @Override
    public <T extends RockstarHttpRequest> T internalMethod04103(T t) throws IOException {
        CookieManager cookieManager = new CookieManager();
        ConfigInternal013 typedValue066 = this.internalField0072.internalMethod03989();
        cookieManager.getCookieStore().add(null, this.internalMethod04280("sid", "token:" + this.internalField0071.internalMethod03989().internalMethod08052() + ':' + CoreInternal026.internalMethod01381(typedValue066.internalMethod02519())));
        cookieManager.getCookieStore().add(null, this.internalMethod04280("user", typedValue066.internalMethod04925()));
        cookieManager.getCookieStore().add(null, this.internalMethod04280("version", this.internalField0247));
        t.internalMethod00332(cookieManager);
        t.internalMethod01193("Is-Prerelease", String.valueOf(!this.internalField0247.matches("\\d+\\.\\d+(\\.\\d+)?")));
        return t;
    }

    private HttpCookie internalMethod04280(String string, String string2) {
        HttpCookie httpCookie = new HttpCookie(string, string2);
        httpCookie.setDomain(this.internalField0248);
        httpCookie.setPath("/");
        return httpCookie;
    }
}
