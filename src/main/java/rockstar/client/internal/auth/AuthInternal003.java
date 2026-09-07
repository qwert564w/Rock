package rockstar.client.internal.auth;







import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.auth.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import rockstar.client.auth.OAuthClientConfig;
import rockstar.client.auth.OAuthToken;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal020;
import rockstar.client.internal.config.ConfigInternal022;
import rockstar.client.internal.auth.AuthInternal042;
import rockstar.client.internal.config.ConfigInternal023;
import rockstar.client.internal.config.ConfigInternal004;
import rockstar.client.internal.auth.AuthInternal001;
import rockstar.client.internal.network.NetworkInternal001;
import rockstar.client.internal.config.ConfigInternal005;

public class AuthInternal003
extends NetworkInternal001
implements ConfigInternal005<AuthInternal042> {
    public AuthInternal003(OAuthClientConfig typedValue071, OAuthToken typedValue074, ConfigInternal022 typedValue086, KeyPair keyPair, String string) throws MalformedURLException {
        super("https://sisu.xboxlive.com/authorize");
        if (!typedValue071.internalMethod06891()) {
            throw new IllegalArgumentException("Client id must be a title client id for XBL SISU authentication");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Sandbox", "RETAIL");
        jsonObject.addProperty("UseModernGamertag", Boolean.valueOf(true));
        jsonObject.addProperty("AppId", typedValue071.internalMethod06157());
        jsonObject.addProperty("AccessToken", "t=" + typedValue074.internalMethod01950());
        jsonObject.addProperty("DeviceToken", typedValue086.internalMethod05939());
        jsonObject.add("ProofKey", (JsonElement)this.internalMethod05780((ECPublicKey)keyPair.getPublic()));
        jsonObject.addProperty("RelyingParty", string);
        this.internalMethod07111(new ConfigInternal020(jsonObject));
        this.internalMethod05279((ECPrivateKey)keyPair.getPrivate());
    }

    @Override
    public AuthInternal042 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) {
        return new AuthInternal042(ConfigInternal004.internalMethod06706(typedValue030.internalMethod03706("UserToken")), ConfigInternal023.internalMethod04585(typedValue030.internalMethod03706("TitleToken")), AuthInternal001.internalMethod04454(typedValue030.internalMethod03706("AuthorizationToken")));
    }
}

