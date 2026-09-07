package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.data.JsonArrayNode;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal020;
import rockstar.client.internal.config.ConfigInternal022;
import rockstar.client.internal.config.ConfigInternal023;
import rockstar.client.internal.config.ConfigInternal004;
import rockstar.client.internal.auth.AuthInternal001;
import rockstar.client.internal.config.ConfigInternal005;

public class AuthInternal005
extends HttpPostRequest
implements ConfigInternal005<AuthInternal001> {
    public AuthInternal005(ConfigInternal022 typedValue086, ConfigInternal004 typedValue041, ConfigInternal023 typedValue088, String string) throws MalformedURLException {
        super("https://xsts.auth.xboxlive.com/xsts/authorize");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("SandboxId", "RETAIL");
        if (typedValue086 != null) {
            jsonObject.addProperty("DeviceToken", typedValue086.internalMethod05939());
        }
        jsonObject.add("UserTokens", (JsonElement)new JsonArrayNode().internalMethod03270(typedValue041.internalMethod04117()).internalMethod01532());
        if (typedValue088 != null) {
            jsonObject.addProperty("TitleToken", typedValue088.internalMethod01911());
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Properties", (JsonElement)jsonObject);
        jsonObject2.addProperty("RelyingParty", string);
        jsonObject2.addProperty("TokenType", "JWT");
        this.internalMethod07111(new ConfigInternal020(jsonObject2));
        this.internalMethod01193("x-xbl-contract-version", "1");
    }

    @Override
    public AuthInternal001 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) {
        return AuthInternal001.internalMethod04454(typedValue030);
    }
}

