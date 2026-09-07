package rockstar.client.internal.auth;






import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.auth.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.auth.OAuthClientConfig;
import rockstar.client.auth.OAuthToken;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal020;
import rockstar.client.internal.config.ConfigInternal004;
import rockstar.client.internal.config.ConfigInternal005;

public class AuthInternal004
extends HttpPostRequest
implements ConfigInternal005<ConfigInternal004> {
    public AuthInternal004(OAuthClientConfig typedValue071, OAuthToken typedValue074) throws MalformedURLException {
        super("https://user.auth.xboxlive.com/user/authenticate");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("SiteName", "user.auth.xboxlive.com");
        jsonObject.addProperty("AuthMethod", "RPS");
        jsonObject.addProperty("RpsTicket", (typedValue071.internalMethod06891() ? "t=" : "d=") + typedValue074.internalMethod01950());
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Properties", (JsonElement)jsonObject);
        jsonObject2.addProperty("RelyingParty", "http://auth.xboxlive.com");
        jsonObject2.addProperty("TokenType", "JWT");
        this.internalMethod07111(new ConfigInternal020(jsonObject2));
        this.internalMethod01193("x-xbl-contract-version", "1");
    }

    @Override
    public ConfigInternal004 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) {
        return ConfigInternal004.internalMethod06706(typedValue030);
    }
}

