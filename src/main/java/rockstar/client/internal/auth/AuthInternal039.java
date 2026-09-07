package rockstar.client.internal.auth;






import rockstar.client.data.*;
import rockstar.client.auth.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.UUID;
import rockstar.client.auth.OAuthClientConfig;
import rockstar.client.data.JsonNode;
import rockstar.client.auth.OAuthToken;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.internal.script.ScriptInternal016;
import rockstar.client.internal.config.ConfigInternal019;

public class AuthInternal039 {
    public static JsonObject internalMethod05157(JsonObject jsonObject) {
        return AuthInternal039.internalMethod04437(jsonObject, new OAuthClientConfig("00000000402b5328", "service::user.auth.xboxlive.com::MBI_SSL"));
    }

    public static JsonObject internalMethod04437(JsonObject jsonObject, OAuthClientConfig typedValue071) {
        String string = AuthInternal039.internalMethod06145(new JsonObjectNode(jsonObject));
        if (string == null) {
            throw new IllegalArgumentException("Failed to find refresh token in the provided save data");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("_saveVersion", (Number)1);
        jsonObject2.add("msaApplicationConfig", (JsonElement)OAuthClientConfig.internalMethod00727(typedValue071));
        jsonObject2.addProperty("deviceType", "Win32");
        jsonObject2.add("deviceKeyPair", (JsonElement)ConfigInternal019.internalMethod02216(ScriptInternal016.internalMethod03791()));
        jsonObject2.addProperty("deviceId", UUID.randomUUID().toString());
        jsonObject2.add("msaToken", (JsonElement)OAuthToken.internalMethod05498(new OAuthToken(0L, "", string)));
        return jsonObject2;
    }

    public static JsonObject internalMethod05824(JsonObject jsonObject) {
        return AuthInternal039.internalMethod04428(jsonObject, new OAuthClientConfig("0000000048183522", "service::user.auth.xboxlive.com::MBI_SSL"));
    }

    public static JsonObject internalMethod04428(JsonObject jsonObject, OAuthClientConfig typedValue071) {
        String string = AuthInternal039.internalMethod06145(new JsonObjectNode(jsonObject));
        if (string == null) {
            throw new IllegalArgumentException("Failed to find refresh token in the provided save data");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("_saveVersion", (Number)1);
        jsonObject2.add("msaApplicationConfig", (JsonElement)OAuthClientConfig.internalMethod00727(typedValue071));
        jsonObject2.addProperty("deviceType", "Android");
        jsonObject2.add("deviceKeyPair", (JsonElement)ConfigInternal019.internalMethod02216(ScriptInternal016.internalMethod03791()));
        jsonObject2.addProperty("deviceId", UUID.randomUUID().toString());
        jsonObject2.add("sessionKeyPair", (JsonElement)ConfigInternal019.internalMethod02216(ScriptInternal016.internalMethod05695()));
        jsonObject2.add("msaToken", (JsonElement)OAuthToken.internalMethod05498(new OAuthToken(0L, "", string)));
        return jsonObject2;
    }

    public static String internalMethod06145(JsonObjectNode typedValue030) {
        if (typedValue030.internalMethod09165("refreshToken")) {
            return typedValue030.internalMethod03457("refreshToken");
        }
        for (Map.Entry<String, JsonNode> entry : typedValue030.internalMethod02843()) {
            String string;
            if (!entry.getValue().internalMethod07307() || (string = AuthInternal039.internalMethod06145(entry.getValue().internalMethod04512())) == null) continue;
            return string;
        }
        return null;
    }
}

