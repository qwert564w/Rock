package rockstar.client.internal.auth;






import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyPair;
import java.time.Instant;
import java.util.Base64;
import rockstar.client.network.HttpPostRequest;
import rockstar.client.internal.config.ConfigInternal012;
import rockstar.client.internal.config.ConfigInternal014;
import rockstar.client.internal.config.ConfigInternal015;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.script.ScriptInternal016;

public class AuthInternal020
extends HttpPostRequest
implements ConfigInternal015<ConfigInternal012> {
    public AuthInternal020(ConfigInternal014 typedValue067) throws MalformedURLException {
        super("https://api.minecraftservices.com/player/certificates");
        this.internalMethod01193("Authorization", typedValue067.internalMethod06704());
    }

    @Override
    public ConfigInternal012 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        JsonObjectNode typedValue031 = typedValue030.internalMethod03706("keyPair");
        return new ConfigInternal012(Instant.parse(typedValue030.internalMethod03457("expiresAt")).toEpochMilli(), new KeyPair(ScriptInternal016.internalMethod07348(Base64.getMimeDecoder().decode(typedValue031.internalMethod03457("publicKey").replace("-----BEGIN RSA PUBLIC KEY-----", "").replace("-----END RSA PUBLIC KEY-----", ""))), ScriptInternal016.internalMethod04136(Base64.getMimeDecoder().decode(typedValue031.internalMethod03457("privateKey").replace("-----BEGIN RSA PRIVATE KEY-----", "").replace("-----END RSA PRIVATE KEY-----", "")))), Base64.getDecoder().decode(typedValue030.internalMethod03457("publicKeySignatureV2")), typedValue030.internalMethod08532("publicKeySignature").map(Base64.getDecoder()::decode).orElse(null));
    }
}

