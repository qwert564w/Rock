package rockstar.client.internal.network;






import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.internal.auth.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.util.Base64;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.internal.config.ConfigInternal006;
import rockstar.client.internal.config.ConfigInternal009;
import rockstar.client.data.JsonArrayNode;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal020;
import rockstar.client.internal.auth.AuthInternal001;

public class NetworkInternal005
extends HttpPostRequest
implements ConfigInternal009<ConfigInternal006> {
    public NetworkInternal005(AuthInternal001 typedValue043, KeyPair keyPair) throws MalformedURLException {
        super("https://multiplayer.minecraft.net/authentication");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("identityPublicKey", Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        this.internalMethod07111(new ConfigInternal020(jsonObject));
        this.internalMethod01193("Authorization", typedValue043.internalMethod02091());
    }

    @Override
    public ConfigInternal006 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        JsonArrayNode typedValue026 = typedValue030.internalMethod03703("chain");
        if (typedValue026.internalMethod06014() != 2) {
            throw new IllegalStateException("Invalid certificate chain length: " + typedValue026.internalMethod06014());
        }
        return new ConfigInternal006(typedValue026.internalMethod06594(0).internalMethod00968(), typedValue026.internalMethod06594(1).internalMethod00968());
    }
}

