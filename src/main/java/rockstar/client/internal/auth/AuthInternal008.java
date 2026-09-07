package rockstar.client.internal.auth;







import rockstar.client.network.*;
import rockstar.client.i18n.*;
import rockstar.client.data.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Instant;
import java.util.UUID;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.internal.config.ConfigInternal008;
import rockstar.client.internal.config.ConfigInternal010;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.auth.AuthInternal036;
import rockstar.client.internal.core.CoreInternal026;
import rockstar.client.internal.config.ConfigInternal020;
import rockstar.client.internal.auth.AuthInternal001;

public class AuthInternal008
extends HttpPostRequest
implements ConfigInternal010<ConfigInternal008> {
    @Deprecated
    public AuthInternal008(AuthInternal001 typedValue043, AuthInternal036 typedValue080, String string, UUID uUID) throws MalformedURLException {
        this(typedValue080, string, uUID);
    }

    public AuthInternal008(AuthInternal036 typedValue080, String string, UUID uUID) throws MalformedURLException {
        super("https://authorization.franchise.minecraft-services.net/api/v1.0/session/start");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("applicationType", "MinecraftPE");
        jsonObject.addProperty("gameVersion", string);
        jsonObject.addProperty("id", CoreInternal026.internalMethod01381(uUID));
        jsonObject.addProperty("memory", (Number)0x800000000L);
        jsonObject.addProperty("hardwareMemoryTier", (Number)5);
        jsonObject.addProperty("platform", "Windows10");
        jsonObject.addProperty("playFabTitleId", "20CA2");
        jsonObject.addProperty("storePlatform", "uwp.store");
        jsonObject.addProperty("type", "Windows10");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("language", "en");
        jsonObject2.addProperty("regionCode", "US");
        jsonObject2.addProperty("languageCode", "en-US");
        jsonObject2.addProperty("tokenType", "PlayFab");
        jsonObject2.addProperty("token", typedValue080.internalMethod09087());
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("device", (JsonElement)jsonObject);
        jsonObject3.add("user", (JsonElement)jsonObject2);
        this.internalMethod07111(new ConfigInternal020(jsonObject3));
    }

    @Override
    public ConfigInternal008 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        JsonObjectNode typedValue031 = typedValue030.internalMethod03706("result");
        return new ConfigInternal008(Instant.parse(typedValue031.internalMethod03457("validUntil")).toEpochMilli(), typedValue031.internalMethod03457("authorizationHeader"));
    }
}

