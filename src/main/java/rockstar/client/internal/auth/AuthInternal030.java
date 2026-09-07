package rockstar.client.internal.auth;






import rockstar.client.network.*;
import rockstar.client.auth.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import rockstar.client.internal.core.CoreInternal017;
import rockstar.client.auth.OAuthClientConfig;
import rockstar.client.internal.config.ConfigInternal017;
import rockstar.client.auth.OAuthToken;
import rockstar.client.internal.auth.AuthInternal025;
import rockstar.client.internal.auth.AuthInternal026;
import rockstar.client.internal.auth.AuthInternal028;
import rockstar.client.network.RockstarHttpClient;

public class AuthInternal030
extends AuthInternal028 {
    private final Consumer<ConfigInternal017> internalField0922;
    private final int internalField0227;

    public AuthInternal030(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071, Consumer<ConfigInternal017> consumer) {
        this(typedValue034, typedValue071, consumer, 300000);
    }

    public AuthInternal030(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071, Consumer<ConfigInternal017> consumer, int n) {
        super(typedValue034, typedValue071);
        this.internalField0922 = consumer;
        this.internalField0227 = n;
    }

    @Override
    public OAuthToken internalMethod04761() throws IOException, InterruptedException, TimeoutException {
        ConfigInternal017 typedValue073 = this.internalMethod05351();
        this.internalField0922.accept(typedValue073);
        return this.internalMethod06602(typedValue073);
    }

    public ConfigInternal017 internalMethod05351() throws IOException {
        return (ConfigInternal017)this.internalField0058.internalMethod07532(new AuthInternal025(this.internalField0727));
    }

    public OAuthToken internalMethod06602(ConfigInternal017 typedValue073) throws IOException, InterruptedException, TimeoutException {
        long l = System.currentTimeMillis();
        while (!typedValue073.internalMethod01680() && System.currentTimeMillis() - l <= (long)this.internalField0227) {
            try {
                return (OAuthToken)this.internalField0058.internalMethod07532(new AuthInternal026(this.internalField0727, typedValue073));
            }
            catch (CoreInternal017 typedValue070) {
                if (typedValue070.internalMethod00843().internalMethod00588() == 400 && typedValue070.internalMethod00836().equals("authorization_pending")) {
                    Thread.sleep(typedValue073.internalMethod06388());
                    continue;
                }
                throw typedValue070;
            }
        }
        throw new TimeoutException("Login timed out");
    }
}

