package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.util.Locale;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.auth.AuthInternal035;
import rockstar.client.internal.config.ConfigInternal018;
import rockstar.client.internal.config.ConfigInternal020;

public class AuthInternal037
extends HttpPostRequest
implements ConfigInternal018<AuthInternal035> {
    public AuthInternal037(AuthInternal035 typedValue078, String string, String string2, String string3) throws MalformedURLException {
        super("https://" + string.toLowerCase(Locale.ROOT) + ".playfabapi.com/Authentication/GetEntityToken");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Id", string2);
        jsonObject.addProperty("Type", string3);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Entity", (JsonElement)jsonObject);
        this.internalMethod07111(new ConfigInternal020(jsonObject2));
        this.internalMethod01193("X-EntityToken", typedValue078.internalMethod06972());
    }

    @Override
    public AuthInternal035 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) {
        return AuthInternal035.internalMethod03175(typedValue030.internalMethod03706("data"));
    }
}

