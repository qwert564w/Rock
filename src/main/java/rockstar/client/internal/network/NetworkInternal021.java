package rockstar.client.internal.network;



import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import rockstar.client.internal.network.NetworkInternal019;
import rockstar.client.internal.config.ConfigInternal037;

public class NetworkInternal021 {
    private static final String internalField0248 = "https://api.deezer.com";

    public static float internalMethod01642(String string, String string2) {
        return NetworkInternal021.internalMethod05651(string, string2, 0L);
    }

    public static float internalMethod05651(String string, String string2, long l) {
        String string3;
        if (string == null || string2 == null || string.isBlank() || string2.isBlank()) {
            return 0.0f;
        }
        long l2 = NetworkInternal021.internalMethod07240("artist:\"" + string + "\" track:\"" + string2 + "\"", string, string2, l);
        if (l2 == 0L) {
            l2 = NetworkInternal021.internalMethod07240(string + " " + string2, string, string2, l);
        }
        if (l2 == 0L && !(string3 = ConfigInternal037.internalMethod00620(string)).isBlank() && !string3.equalsIgnoreCase(string.trim())) {
            l2 = NetworkInternal021.internalMethod07240(string3 + " " + string2, string, string2, l);
        }
        if (l2 == 0L) {
            return 0.0f;
        }
        return NetworkInternal021.internalMethod06985(l2);
    }

    private static long internalMethod07240(String string, String string2, String string3, long l) {
        try {
            String string4 = NetworkInternal021.internalMethod07547("https://api.deezer.com/search?limit=10&q=" + NetworkInternal021.internalMethod00475(string));
            if (string4 == null) {
                return 0L;
            }
            JsonArray jsonArray = JsonParser.parseString((String)string4).getAsJsonObject().getAsJsonArray("data");
            if (jsonArray == null || jsonArray.isEmpty()) {
                return 0L;
            }
            long l2 = 0L;
            double d = Double.NEGATIVE_INFINITY;
            for (JsonElement jsonElement : jsonArray) {
                double d2;
                JsonObject jsonObject;
                if (!jsonElement.isJsonObject() || !(jsonObject = jsonElement.getAsJsonObject()).has("id") || jsonObject.get("id").isJsonNull() || !((d2 = ConfigInternal037.internalMethod03931(NetworkInternal021.internalMethod01556(jsonObject), string2, string3, l)) > d)) continue;
                d = d2;
                l2 = jsonObject.get("id").getAsLong();
            }
            return l2;
        }
        catch (Exception exception) {
            return 0L;
        }
    }

    private static JsonObject internalMethod01556(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject.has("artist") && jsonObject.get("artist").isJsonObject() ? jsonObject.getAsJsonObject("artist") : null;
        double d = jsonObject.has("duration") && !jsonObject.get("duration").isJsonNull() ? jsonObject.get("duration").getAsDouble() : 0.0;
        return ConfigInternal037.internalMethod05056(ConfigInternal037.internalMethod06952(jsonObject, "title"), ConfigInternal037.internalMethod06952(jsonObject2, "name"), d);
    }

    private static float internalMethod06985(long l) {
        try {
            String string = NetworkInternal021.internalMethod07547("https://api.deezer.com/track/" + l);
            if (string == null) {
                return 0.0f;
            }
            JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
            if (!jsonObject.has("bpm") || jsonObject.get("bpm").isJsonNull()) {
                return 0.0f;
            }
            float f = jsonObject.get("bpm").getAsFloat();
            return f >= 40.0f && f <= 250.0f ? f : 0.0f;
        }
        catch (Exception exception) {
            return 0.0f;
        }
    }

    private static String internalMethod07547(String string) {
        try {
            NetworkInternal019.InternalType0449 nestedValue0157 = NetworkInternal019.internalMethod02390(string, new String[0]);
            return nestedValue0157.internalMethod02740() ? nestedValue0157.internalMethod00694() : null;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static String internalMethod00475(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }
}

