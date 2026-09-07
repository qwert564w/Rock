package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.io.IOException;
import java.net.MalformedURLException;
import rockstar.client.network.HttpDeleteRequest;
import rockstar.client.internal.auth.AuthInternal010;
import rockstar.client.internal.config.ConfigInternal011;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;

public class AuthInternal011
extends HttpDeleteRequest
implements ConfigInternal011<Void> {
    public AuthInternal011(AuthInternal010 typedValue062) throws MalformedURLException {
        super("https://pocket.realms.minecraft.net/invites/" + typedValue062.internalMethod02976());
    }

    @Override
    public Void internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        throw new UnsupportedOperationException("This request is not supposed to return any data");
    }
}

