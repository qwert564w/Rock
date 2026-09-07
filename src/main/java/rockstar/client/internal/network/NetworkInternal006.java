package rockstar.client.internal.network;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.time.Instant;
import java.util.Base64;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.internal.config.ConfigInternal007;
import rockstar.client.internal.config.ConfigInternal008;
import rockstar.client.internal.config.ConfigInternal010;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal020;

public class NetworkInternal006
extends HttpPostRequest
implements ConfigInternal010<ConfigInternal007> {
    public NetworkInternal006(ConfigInternal008 internalValue0009, KeyPair keyPair) throws MalformedURLException {
        super("https://authorization.franchise.minecraft-services.net/api/v1.0/multiplayer/session/start");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("publicKey", Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        this.internalMethod07111(new ConfigInternal020(jsonObject));
        this.internalMethod01193("Authorization", internalValue0009.internalMethod03445());
    }

    @Override
    public ConfigInternal007 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        JsonObjectNode typedValue031 = typedValue030.internalMethod03706("result");
        return new ConfigInternal007(Instant.parse(typedValue031.internalMethod03457("validUntil")).toEpochMilli(), typedValue031.internalMethod03457("signedToken"));
    }
}

