package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.io.IOException;
import java.net.MalformedURLException;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.internal.auth.AuthInternal010;
import rockstar.client.internal.config.ConfigInternal011;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;

public class AuthInternal012
extends HttpPostRequest
implements ConfigInternal011<AuthInternal010> {
    public AuthInternal012(String string) throws MalformedURLException {
        super("https://pocket.realms.minecraft.net/invites/v1/link/accept/" + string);
    }

    @Override
    public AuthInternal010 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        return AuthInternal010.internalMethod01457(typedValue030);
    }
}

