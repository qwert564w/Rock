package rockstar.client.internal.auth;






import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.time.Instant;
import java.util.UUID;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal020;
import rockstar.client.internal.config.ConfigInternal022;
import rockstar.client.internal.network.NetworkInternal001;
import rockstar.client.internal.config.ConfigInternal005;

public class AuthInternal002
extends NetworkInternal001
implements ConfigInternal005<ConfigInternal022> {
    public AuthInternal002(String string, UUID uUID, KeyPair keyPair) throws MalformedURLException {
        super("https://device.auth.xboxlive.com/device/authenticate");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("DeviceType", string);
        jsonObject.addProperty("Id", "{" + uUID + "}");
        jsonObject.addProperty("AuthMethod", "ProofOfPossession");
        jsonObject.add("ProofKey", (JsonElement)this.internalMethod05780((ECPublicKey)keyPair.getPublic()));
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("Properties", (JsonElement)jsonObject);
        jsonObject2.addProperty("RelyingParty", "http://auth.xboxlive.com");
        jsonObject2.addProperty("TokenType", "JWT");
        this.internalMethod07111(new ConfigInternal020(jsonObject2));
        this.internalMethod01193("x-xbl-contract-version", "1");
        this.internalMethod05279((ECPrivateKey)keyPair.getPrivate());
    }

    @Override
    public ConfigInternal022 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) {
        return new ConfigInternal022(Instant.parse(typedValue030.internalMethod03457("NotAfter")).toEpochMilli(), typedValue030.internalMethod03457("Token"), typedValue030.internalMethod03706("DisplayClaims").internalMethod03706("xdi").internalMethod03457("did"));
    }
}

