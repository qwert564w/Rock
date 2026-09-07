package rockstar.client.internal.auth;








import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.auth.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.security.KeyPair;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import lombok.Generated;
import rockstar.client.internal.config.ConfigInternal012;
import rockstar.client.internal.config.ConfigInternal013;
import rockstar.client.internal.config.ConfigInternal014;
import rockstar.client.internal.auth.AuthInternal019;
import rockstar.client.internal.auth.AuthInternal020;
import rockstar.client.internal.auth.AuthInternal021;
import rockstar.client.auth.OAuthClientConfig;
import rockstar.client.auth.OAuthToken;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.internal.auth.AuthInternal027;
import rockstar.client.internal.auth.AuthInternal028;
import rockstar.client.network.RockstarHttpClient;
import rockstar.client.internal.auth.AuthInternal033;
import rockstar.client.internal.auth.AuthInternal034;
import rockstar.client.internal.script.ScriptInternal016;
import rockstar.client.internal.config.ConfigInternal019;
import rockstar.client.internal.core.CoreInternal027;
import rockstar.client.internal.core.CoreInternal031;
import rockstar.client.internal.config.ConfigInternal022;
import rockstar.client.internal.auth.AuthInternal042;
import rockstar.client.internal.config.ConfigInternal023;
import rockstar.client.internal.config.ConfigInternal004;
import rockstar.client.internal.auth.AuthInternal001;
import rockstar.client.internal.auth.AuthInternal002;
import rockstar.client.internal.auth.AuthInternal003;
import rockstar.client.internal.auth.AuthInternal004;
import rockstar.client.internal.auth.AuthInternal005;

public class AuthInternal018 {
    private final RockstarHttpClient internalField0058;
    private final OAuthClientConfig internalField0727;
    private final String internalField0248;
    private final KeyPair internalField0069;
    private final UUID internalField0428;
    private final CoreInternal031 internalField0080 = new CoreInternal031();
    private final Object internalField0290 = new Object();
    private final CoreInternal027<OAuthToken> internalField0071 = new CoreInternal027<OAuthToken>(this::internalMethod05760);
    private final CoreInternal027<ConfigInternal022> internalField0072 = new CoreInternal027<ConfigInternal022>(this::internalMethod03821);
    private final CoreInternal027<ConfigInternal004> internalField0979 = new CoreInternal027<ConfigInternal004>(this::internalMethod03823, this.internalField0290);
    private final CoreInternal027<ConfigInternal023> internalField0978 = new CoreInternal027<ConfigInternal023>(this::internalMethod03822, this.internalField0290);
    private final CoreInternal027<AuthInternal001> internalField0977 = new CoreInternal027<AuthInternal001>(this::internalMethod03826, this.internalField0290);
    private final CoreInternal027<ConfigInternal014> internalField0980 = new CoreInternal027<ConfigInternal014>(this::internalMethod03998);
    private final CoreInternal027<ConfigInternal013> internalField1411 = new CoreInternal027<ConfigInternal013>(this::internalMethod03997);
    private final CoreInternal027<ConfigInternal012> internalField1410 = new CoreInternal027<ConfigInternal012>(this::internalMethod03996);

    public static AuthInternal018 internalMethod00134(RockstarHttpClient typedValue034, JsonObject jsonObject) {
        return AuthInternal018.internalMethod06862(typedValue034, new JsonObjectNode(jsonObject));
    }

    public static AuthInternal018 internalMethod06862(RockstarHttpClient typedValue034, JsonObjectNode typedValue030) {
        return new AuthInternal018(typedValue034, OAuthClientConfig.internalMethod00614(typedValue030.internalMethod03706("msaApplicationConfig")), typedValue030.internalMethod03457("deviceType"), ConfigInternal019.internalMethod06552(typedValue030.internalMethod03706("deviceKeyPair")), UUID.fromString(typedValue030.internalMethod03457("deviceId")), OAuthToken.internalMethod05862(typedValue030.internalMethod03706("msaToken")), typedValue030.internalMethod06509("xblDeviceToken").map(ConfigInternal022::internalMethod05446).orElse(null), typedValue030.internalMethod06509("xblUserToken").map(ConfigInternal004::internalMethod00778).orElse(null), typedValue030.internalMethod06509("xblTitleToken").map(ConfigInternal023::internalMethod06742).orElse(null), typedValue030.internalMethod06509("javaXstsToken").map(AuthInternal001::internalMethod06637).orElse(null), typedValue030.internalMethod06509("minecraftToken").map(ConfigInternal014::internalMethod00151).orElse(null), typedValue030.internalMethod06509("minecraftProfile").map(ConfigInternal013::internalMethod00387).orElse(null), typedValue030.internalMethod06509("minecraftPlayerCertificates").map(ConfigInternal012::internalMethod06341).orElse(null));
    }

    public static JsonObject internalMethod02305(AuthInternal018 typedValue063) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.add("msaApplicationConfig", (JsonElement)OAuthClientConfig.internalMethod00727(typedValue063.internalField0727));
        jsonObject.addProperty("deviceType", typedValue063.internalField0248);
        jsonObject.add("deviceKeyPair", (JsonElement)ConfigInternal019.internalMethod02216(typedValue063.internalField0069));
        jsonObject.addProperty("deviceId", typedValue063.internalField0428.toString());
        jsonObject.add("msaToken", (JsonElement)OAuthToken.internalMethod05498(typedValue063.internalField0071.internalMethod03112()));
        if (typedValue063.internalField0072.internalMethod04847()) {
            jsonObject.add("xblDeviceToken", (JsonElement)ConfigInternal022.internalMethod02879(typedValue063.internalField0072.internalMethod03112()));
        }
        if (typedValue063.internalField0979.internalMethod04847()) {
            jsonObject.add("xblUserToken", (JsonElement)ConfigInternal004.internalMethod05736(typedValue063.internalField0979.internalMethod03112()));
        }
        if (typedValue063.internalField0978.internalMethod04847()) {
            jsonObject.add("xblTitleToken", (JsonElement)ConfigInternal023.internalMethod03846(typedValue063.internalField0978.internalMethod03112()));
        }
        if (typedValue063.internalField0977.internalMethod04847()) {
            jsonObject.add("javaXstsToken", (JsonElement)AuthInternal001.internalMethod06839(typedValue063.internalField0977.internalMethod03112()));
        }
        if (typedValue063.internalField0980.internalMethod04847()) {
            jsonObject.add("minecraftToken", (JsonElement)ConfigInternal014.internalMethod05332(typedValue063.internalField0980.internalMethod03112()));
        }
        if (typedValue063.internalField1411.internalMethod04847()) {
            jsonObject.add("minecraftProfile", (JsonElement)ConfigInternal013.internalMethod06203(typedValue063.internalField1411.internalMethod03112()));
        }
        if (typedValue063.internalField1410.internalMethod04847()) {
            jsonObject.add("minecraftPlayerCertificates", (JsonElement)ConfigInternal012.internalMethod04368(typedValue063.internalField1410.internalMethod03112()));
        }
        return jsonObject;
    }

    public static InternalType0460 internalMethod04720(RockstarHttpClient typedValue034) {
        return new InternalType0460(typedValue034);
    }

    private AuthInternal018(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071, String string, KeyPair keyPair, UUID uUID, OAuthToken typedValue074) {
        this.internalField0058 = typedValue034;
        this.internalField0727 = typedValue071;
        this.internalField0248 = string;
        this.internalField0069 = keyPair;
        this.internalField0428 = uUID;
        this.internalField0071.internalMethod06986(typedValue074);
        this.internalMethod03779();
    }

    private AuthInternal018(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071, String string, KeyPair keyPair, UUID uUID, OAuthToken typedValue074, ConfigInternal022 typedValue086, ConfigInternal004 typedValue041, ConfigInternal023 typedValue088, AuthInternal001 typedValue043, ConfigInternal014 typedValue067, ConfigInternal013 typedValue066, ConfigInternal012 typedValue065) {
        this.internalField0058 = typedValue034;
        this.internalField0727 = typedValue071;
        this.internalField0248 = string;
        this.internalField0069 = keyPair;
        this.internalField0428 = uUID;
        this.internalField0071.internalMethod06986(typedValue074);
        this.internalField0072.internalMethod06986(typedValue086);
        this.internalField0979.internalMethod06986(typedValue041);
        this.internalField0978.internalMethod06986(typedValue088);
        this.internalField0977.internalMethod06986(typedValue043);
        this.internalField0980.internalMethod06986(typedValue067);
        this.internalField1411.internalMethod06986(typedValue066);
        this.internalField1410.internalMethod06986(typedValue065);
        this.internalMethod03779();
    }

    private OAuthToken internalMethod05760() throws IOException {
        if (this.internalField0071.internalMethod03112().internalMethod06617() == null) {
            throw new IllegalStateException("Can't refresh MSA token, because it was created without a refresh token. The user has to sign in again.");
        }
        return (OAuthToken)this.internalField0058.internalMethod07532(new AuthInternal027(this.internalField0727, this.internalField0071.internalMethod03112()));
    }

    private ConfigInternal022 internalMethod03821() throws IOException {
        return (ConfigInternal022)this.internalField0058.internalMethod07532(new AuthInternal002(this.internalField0248, this.internalField0428, this.internalField0069));
    }

    private ConfigInternal004 internalMethod03823() throws IOException {
        if (this.internalField0727.internalMethod06891()) {
            this.internalMethod03777();
            return this.internalField0979.internalMethod03112();
        }
        return (ConfigInternal004)this.internalField0058.internalMethod07532(new AuthInternal004(this.internalField0727, this.internalField0071.internalMethod03989()));
    }

    private ConfigInternal023 internalMethod03822() throws IOException {
        if (!this.internalField0727.internalMethod06891()) {
            throw new UnsupportedOperationException("Can't refresh XBL title token, because the MSA application client ID is not a title client ID");
        }
        this.internalMethod03777();
        return this.internalField0978.internalMethod03112();
    }

    private AuthInternal001 internalMethod03826() throws IOException {
        if (this.internalField0727.internalMethod06891()) {
            this.internalMethod03777();
            return this.internalField0977.internalMethod03112();
        }
        return (AuthInternal001)this.internalField0058.internalMethod07532(new AuthInternal005(this.internalField0072.internalMethod03989(), this.internalField0979.internalMethod03989(), null, "rp://api.minecraftservices.com/"));
    }

    private ConfigInternal014 internalMethod03998() throws IOException {
        return (ConfigInternal014)this.internalField0058.internalMethod07532(new AuthInternal019(this.internalField0977.internalMethod03989()));
    }

    private ConfigInternal013 internalMethod03997() throws IOException {
        return (ConfigInternal013)this.internalField0058.internalMethod07532(new AuthInternal021(this.internalField0980.internalMethod03989()));
    }

    private ConfigInternal012 internalMethod03996() throws IOException {
        return (ConfigInternal012)this.internalField0058.internalMethod07532(new AuthInternal020(this.internalField0980.internalMethod03989()));
    }

    private void internalMethod03777() throws IOException {
        AuthInternal042 typedValue087 = (AuthInternal042)this.internalField0058.internalMethod07532(new AuthInternal003(this.internalField0727, this.internalField0071.internalMethod03989(), this.internalField0072.internalMethod03989(), this.internalField0069, "rp://api.minecraftservices.com/"));
        this.internalField0979.internalMethod06986(typedValue087.internalMethod02222());
        this.internalField0978.internalMethod06986(typedValue087.internalMethod02221());
        this.internalField0977.internalMethod06986(typedValue087.internalMethod02225());
    }

    private void internalMethod03779() {
        this.internalField0071.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0072.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0979.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0978.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0977.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0980.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1411.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1410.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
    }

    @Generated
    public RockstarHttpClient internalMethod00585() {
        return this.internalField0058;
    }

    @Generated
    public OAuthClientConfig internalMethod05716() {
        return this.internalField0727;
    }

    @Generated
    public String internalMethod00608() {
        return this.internalField0248;
    }

    @Generated
    public KeyPair internalMethod03835() {
        return this.internalField0069;
    }

    @Generated
    public UUID internalMethod00269() {
        return this.internalField0428;
    }

    @Generated
    public CoreInternal031 internalMethod00651() {
        return this.internalField0080;
    }

    @Generated
    public CoreInternal027<OAuthToken> internalMethod00597() {
        return this.internalField0071;
    }

    @Generated
    public CoreInternal027<ConfigInternal022> internalMethod01456() {
        return this.internalField0072;
    }

    @Generated
    public CoreInternal027<ConfigInternal004> internalMethod08862() {
        return this.internalField0979;
    }

    @Generated
    public CoreInternal027<ConfigInternal023> internalMethod09035() {
        return this.internalField0978;
    }

    @Generated
    public CoreInternal027<AuthInternal001> internalMethod09117() {
        return this.internalField0977;
    }

    @Generated
    public CoreInternal027<ConfigInternal014> internalMethod07671() {
        return this.internalField0980;
    }

    @Generated
    public CoreInternal027<ConfigInternal013> internalMethod09506() {
        return this.internalField1411;
    }

    @Generated
    public CoreInternal027<ConfigInternal012> internalMethod09205() {
        return this.internalField1410;
    }

    public static class InternalType0460 {
        private final RockstarHttpClient internalField0058;
        private OAuthClientConfig internalField0727 = new OAuthClientConfig("00000000402b5328", "service::user.auth.xboxlive.com::MBI_SSL");
        private String internalField0248 = "Win32";
        private KeyPair internalField0069;
        private UUID internalField0428;

        public AuthInternal018 internalMethod04451(AuthInternal033 typedValue076) throws IOException, InterruptedException, TimeoutException {
            AuthInternal028 typedValue075 = typedValue076.internalMethod04508(this.internalField0058, this.internalField0727);
            return this.internalMethod02376(typedValue075.internalMethod04761());
        }

        public <T> AuthInternal018 internalMethod00645(AuthInternal034<T> typedValue077, T t) throws IOException, InterruptedException, TimeoutException {
            AuthInternal028 typedValue075 = typedValue077.internalMethod01631(this.internalField0058, this.internalField0727, t);
            return this.internalMethod02376(typedValue075.internalMethod04761());
        }

        public AuthInternal018 internalMethod03815(String string) throws IOException {
            return this.internalMethod02376((OAuthToken)this.internalField0058.internalMethod07532(new AuthInternal027(this.internalField0727, string)));
        }

        public AuthInternal018 internalMethod02376(OAuthToken typedValue074) {
            return new AuthInternal018(this.internalField0058, this.internalField0727, this.internalField0248, this.internalField0069 != null ? this.internalField0069 : ScriptInternal016.internalMethod03791(), this.internalField0428 != null ? this.internalField0428 : UUID.randomUUID(), typedValue074);
        }

        @Generated
        public InternalType0460 internalMethod00316(OAuthClientConfig typedValue071) {
            this.internalField0727 = typedValue071;
            return this;
        }

        @Generated
        public InternalType0460 internalMethod02538(String string) {
            this.internalField0248 = string;
            return this;
        }

        @Generated
        public InternalType0460 internalMethod05472(KeyPair keyPair) {
            this.internalField0069 = keyPair;
            return this;
        }

        @Generated
        public InternalType0460 internalMethod04706(UUID uUID) {
            this.internalField0428 = uUID;
            return this;
        }

        @Generated
        private InternalType0460(RockstarHttpClient typedValue034) {
            this.internalField0058 = typedValue034;
        }
    }
}

