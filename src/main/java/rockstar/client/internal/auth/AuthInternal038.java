package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.auth.AuthInternal035;
import rockstar.client.internal.auth.AuthInternal036;
import rockstar.client.internal.config.ConfigInternal018;
import rockstar.client.internal.config.ConfigInternal020;
import rockstar.client.internal.auth.AuthInternal001;

public class AuthInternal038
extends HttpPostRequest
implements ConfigInternal018<AuthInternal036> {
    public AuthInternal038(AuthInternal001 typedValue043, String string) throws MalformedURLException {
        super("https://" + string.toLowerCase(Locale.ROOT) + ".playfabapi.com/Client/LoginWithXbox");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("GetPlayerProfile", Boolean.valueOf(true));
        jsonObject.addProperty("GetUserAccountInfo", Boolean.valueOf(true));
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("CreateAccount", Boolean.valueOf(true));
        jsonObject2.add("InfoRequestParameters", (JsonElement)jsonObject);
        jsonObject2.addProperty("TitleId", string.toUpperCase(Locale.ROOT));
        jsonObject2.addProperty("XboxToken", typedValue043.internalMethod02091());
        this.internalMethod07111(new ConfigInternal020(jsonObject2));
    }

    @Override
    public AuthInternal036 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        JsonObjectNode typedValue031 = typedValue030.internalMethod03706("data");
        return new AuthInternal036(AuthInternal035.internalMethod03175(typedValue031.internalMethod03706("EntityToken")), typedValue031.internalMethod03457("PlayFabId"), typedValue031.internalMethod03457("SessionTicket"));
    }
}

