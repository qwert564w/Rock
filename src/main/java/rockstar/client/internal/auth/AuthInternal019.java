package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.internal.config.ConfigInternal014;
import rockstar.client.internal.config.ConfigInternal015;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal020;
import rockstar.client.internal.auth.AuthInternal001;

public class AuthInternal019
extends HttpPostRequest
implements ConfigInternal015<ConfigInternal014> {
    public AuthInternal019(AuthInternal001 typedValue043) throws MalformedURLException {
        super("https://api.minecraftservices.com/launcher/login");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("platform", "PC_LAUNCHER");
        jsonObject.addProperty("xtoken", typedValue043.internalMethod02091());
        this.internalMethod07111(new ConfigInternal020(jsonObject));
    }

    @Override
    public ConfigInternal014 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        return new ConfigInternal014(System.currentTimeMillis() + (long)typedValue030.internalMethod02176("expires_in") * 1000L, typedValue030.internalMethod03457("token_type"), typedValue030.internalMethod03457("access_token"));
    }
}

