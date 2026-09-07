package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.io.IOException;
import java.net.MalformedURLException;
import rockstar.client.network.HttpGetRequest;
import rockstar.client.internal.auth.AuthInternal009;
import rockstar.client.internal.auth.AuthInternal010;
import rockstar.client.internal.config.ConfigInternal011;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;

public class AuthInternal013
extends HttpGetRequest
implements ConfigInternal011<AuthInternal009> {
    public AuthInternal013(AuthInternal010 typedValue062) throws MalformedURLException {
        super("https://pocket.realms.minecraft.net/worlds/" + typedValue062.internalMethod02976() + "/join");
    }

    @Override
    public AuthInternal009 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        return AuthInternal009.internalMethod07377(typedValue030);
    }
}

