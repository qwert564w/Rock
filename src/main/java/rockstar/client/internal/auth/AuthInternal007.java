package rockstar.client.internal.auth;









import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.auth.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.network.*;
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
import rockstar.client.internal.config.ConfigInternal006;
import rockstar.client.internal.config.ConfigInternal007;
import rockstar.client.internal.config.ConfigInternal008;
import rockstar.client.internal.network.NetworkInternal005;
import rockstar.client.internal.network.NetworkInternal006;
import rockstar.client.internal.auth.AuthInternal008;
import rockstar.client.auth.OAuthClientConfig;
import rockstar.client.auth.OAuthToken;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.internal.auth.AuthInternal027;
import rockstar.client.internal.auth.AuthInternal028;
import rockstar.client.network.RockstarHttpClient;
import rockstar.client.internal.auth.AuthInternal033;
import rockstar.client.internal.auth.AuthInternal034;
import rockstar.client.internal.auth.AuthInternal035;
import rockstar.client.internal.auth.AuthInternal036;
import rockstar.client.internal.auth.AuthInternal037;
import rockstar.client.internal.auth.AuthInternal038;
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

public class AuthInternal007 {
    private final RockstarHttpClient internalField0058;
    private final String internalField0248;
    private final OAuthClientConfig internalField0727;
    private final String internalField0247;
    private final KeyPair internalField0069;
    private final UUID internalField0428;
    private final KeyPair internalField0070;
    private final CoreInternal031 internalField0080 = new CoreInternal031();
    private final Object internalField0290 = new Object();
    private final CoreInternal027<OAuthToken> internalField0071 = new CoreInternal027<OAuthToken>(this::internalMethod05547);
    private final CoreInternal027<ConfigInternal022> internalField0072 = new CoreInternal027<ConfigInternal022>(this::internalMethod03541);
    private final CoreInternal027<ConfigInternal004> internalField0979 = new CoreInternal027<ConfigInternal004>(this::internalMethod03543, this.internalField0290);
    private final CoreInternal027<ConfigInternal023> internalField0978 = new CoreInternal027<ConfigInternal023>(this::internalMethod03542, this.internalField0290);
    private final CoreInternal027<AuthInternal001> internalField0977 = new CoreInternal027<AuthInternal001>(this::internalMethod03545, this.internalField0290);
    private final CoreInternal027<AuthInternal001> internalField0980 = new CoreInternal027<AuthInternal001>(this::internalMethod04425);
    private final CoreInternal027<AuthInternal001> internalField1411 = new CoreInternal027<AuthInternal001>(this::internalMethod08051);
    private final CoreInternal027<AuthInternal001> internalField1410 = new CoreInternal027<AuthInternal001>(this::internalMethod08205);
    private final CoreInternal027<AuthInternal036> internalField1406 = new CoreInternal027<AuthInternal036>(this::internalMethod06788);
    private final CoreInternal027<AuthInternal035> internalField1409 = new CoreInternal027<AuthInternal035>(this::internalMethod06787);
    private final CoreInternal027<ConfigInternal008> internalField1408 = new CoreInternal027<ConfigInternal008>(this::internalMethod00478);
    private final CoreInternal027<ConfigInternal007> internalField1407 = new CoreInternal027<ConfigInternal007>(this::internalMethod00477);
    private final CoreInternal027<ConfigInternal006> internalField1412 = new CoreInternal027<ConfigInternal006>(this::internalMethod00474);

    public static AuthInternal007 internalMethod03382(RockstarHttpClient typedValue034, String string, JsonObject jsonObject) {
        return AuthInternal007.internalMethod01802(typedValue034, string, new JsonObjectNode(jsonObject));
    }

    public static AuthInternal007 internalMethod01802(RockstarHttpClient typedValue034, String string, JsonObjectNode typedValue030) {
        return new AuthInternal007(typedValue034, string, OAuthClientConfig.internalMethod00614(typedValue030.internalMethod03706("msaApplicationConfig")), typedValue030.internalMethod03457("deviceType"), ConfigInternal019.internalMethod06552(typedValue030.internalMethod03706("deviceKeyPair")), UUID.fromString(typedValue030.internalMethod03457("deviceId")), ConfigInternal019.internalMethod06552(typedValue030.internalMethod03706("sessionKeyPair")), OAuthToken.internalMethod05862(typedValue030.internalMethod03706("msaToken")), typedValue030.internalMethod06509("xblDeviceToken").map(ConfigInternal022::internalMethod05446).orElse(null), typedValue030.internalMethod06509("xblUserToken").map(ConfigInternal004::internalMethod00778).orElse(null), typedValue030.internalMethod06509("xblTitleToken").map(ConfigInternal023::internalMethod06742).orElse(null), typedValue030.internalMethod06509("bedrockXstsToken").map(AuthInternal001::internalMethod06637).orElse(null), typedValue030.internalMethod06509("playFabXstsToken").map(AuthInternal001::internalMethod06637).orElse(null), typedValue030.internalMethod06509("realmsXstsToken").map(AuthInternal001::internalMethod06637).orElse(null), typedValue030.internalMethod06509("xboxLiveXstsToken").map(AuthInternal001::internalMethod06637).orElse(null), typedValue030.internalMethod06509("playFabToken").map(AuthInternal036::internalMethod07539).orElse(null), typedValue030.internalMethod06509("playFabMasterToken").map(AuthInternal035::internalMethod05463).orElse(null), typedValue030.internalMethod06509("minecraftSession").map(ConfigInternal008::internalMethod03814).orElse(null), typedValue030.internalMethod06509("minecraftMultiplayerToken").map(ConfigInternal007::internalMethod01728).orElse(null), typedValue030.internalMethod06509("minecraftCertificateChain").map(ConfigInternal006::internalMethod03937).orElse(null));
    }

    public static JsonObject internalMethod04208(AuthInternal007 typedValue056) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.add("msaApplicationConfig", (JsonElement)OAuthClientConfig.internalMethod00727(typedValue056.internalField0727));
        jsonObject.addProperty("deviceType", typedValue056.internalField0247);
        jsonObject.add("deviceKeyPair", (JsonElement)ConfigInternal019.internalMethod02216(typedValue056.internalField0069));
        jsonObject.addProperty("deviceId", typedValue056.internalField0428.toString());
        jsonObject.add("sessionKeyPair", (JsonElement)ConfigInternal019.internalMethod02216(typedValue056.internalField0070));
        jsonObject.add("msaToken", (JsonElement)OAuthToken.internalMethod05498(typedValue056.internalField0071.internalMethod03112()));
        if (typedValue056.internalField0072.internalMethod04847()) {
            jsonObject.add("xblDeviceToken", (JsonElement)ConfigInternal022.internalMethod02879(typedValue056.internalField0072.internalMethod03112()));
        }
        if (typedValue056.internalField0979.internalMethod04847()) {
            jsonObject.add("xblUserToken", (JsonElement)ConfigInternal004.internalMethod05736(typedValue056.internalField0979.internalMethod03112()));
        }
        if (typedValue056.internalField0978.internalMethod04847()) {
            jsonObject.add("xblTitleToken", (JsonElement)ConfigInternal023.internalMethod03846(typedValue056.internalField0978.internalMethod03112()));
        }
        if (typedValue056.internalField0977.internalMethod04847()) {
            jsonObject.add("bedrockXstsToken", (JsonElement)AuthInternal001.internalMethod06839(typedValue056.internalField0977.internalMethod03112()));
        }
        if (typedValue056.internalField0980.internalMethod04847()) {
            jsonObject.add("playFabXstsToken", (JsonElement)AuthInternal001.internalMethod06839(typedValue056.internalField0980.internalMethod03112()));
        }
        if (typedValue056.internalField1411.internalMethod04847()) {
            jsonObject.add("realmsXstsToken", (JsonElement)AuthInternal001.internalMethod06839(typedValue056.internalField1411.internalMethod03112()));
        }
        if (typedValue056.internalField1410.internalMethod04847()) {
            jsonObject.add("xboxLiveXstsToken", (JsonElement)AuthInternal001.internalMethod06839(typedValue056.internalField1410.internalMethod03112()));
        }
        if (typedValue056.internalField1406.internalMethod04847()) {
            jsonObject.add("playFabToken", (JsonElement)AuthInternal036.internalMethod04598(typedValue056.internalField1406.internalMethod03112()));
        }
        if (typedValue056.internalField1409.internalMethod04847()) {
            jsonObject.add("playFabMasterToken", (JsonElement)AuthInternal035.internalMethod02677(typedValue056.internalField1409.internalMethod03112()));
        }
        if (typedValue056.internalField1408.internalMethod04847()) {
            jsonObject.add("minecraftSession", (JsonElement)ConfigInternal008.internalMethod01874(typedValue056.internalField1408.internalMethod03112()));
        }
        if (typedValue056.internalField1407.internalMethod04847()) {
            jsonObject.add("minecraftMultiplayerToken", (JsonElement)ConfigInternal007.internalMethod06693(typedValue056.internalField1407.internalMethod03112()));
        }
        if (typedValue056.internalField1412.internalMethod04847()) {
            jsonObject.add("minecraftCertificateChain", (JsonElement)ConfigInternal006.internalMethod06949(typedValue056.internalField1412.internalMethod03112()));
        }
        return jsonObject;
    }

    public static InternalType0124 internalMethod01644(RockstarHttpClient typedValue034, String string) {
        return new InternalType0124(typedValue034, string);
    }

    private AuthInternal007(RockstarHttpClient typedValue034, String string, OAuthClientConfig typedValue071, String string2, KeyPair keyPair, UUID uUID, KeyPair keyPair2, OAuthToken typedValue074) {
        this.internalField0058 = typedValue034;
        this.internalField0248 = string;
        this.internalField0727 = typedValue071;
        this.internalField0247 = string2;
        this.internalField0069 = keyPair;
        this.internalField0428 = uUID;
        this.internalField0070 = keyPair2;
        this.internalField0071.internalMethod06986(typedValue074);
        this.internalMethod05293();
    }

    private AuthInternal007(RockstarHttpClient typedValue034, String string, OAuthClientConfig typedValue071, String string2, KeyPair keyPair, UUID uUID, KeyPair keyPair2, OAuthToken typedValue074, ConfigInternal022 typedValue086, ConfigInternal004 typedValue041, ConfigInternal023 typedValue088, AuthInternal001 typedValue043, AuthInternal001 typedValue044, AuthInternal001 typedValue045, AuthInternal001 typedValue046, AuthInternal036 typedValue080, AuthInternal035 typedValue078, ConfigInternal008 internalValue0009, ConfigInternal007 typedValue060, ConfigInternal006 typedValue059) {
        this.internalField0058 = typedValue034;
        this.internalField0248 = string;
        this.internalField0727 = typedValue071;
        this.internalField0247 = string2;
        this.internalField0069 = keyPair;
        this.internalField0428 = uUID;
        this.internalField0070 = keyPair2;
        this.internalField0071.internalMethod06986(typedValue074);
        this.internalField0072.internalMethod06986(typedValue086);
        this.internalField0979.internalMethod06986(typedValue041);
        this.internalField0978.internalMethod06986(typedValue088);
        this.internalField0977.internalMethod06986(typedValue043);
        this.internalField0980.internalMethod06986(typedValue044);
        this.internalField1411.internalMethod06986(typedValue045);
        this.internalField1410.internalMethod06986(typedValue046);
        this.internalField1406.internalMethod06986(typedValue080);
        this.internalField1409.internalMethod06986(typedValue078);
        this.internalField1408.internalMethod06986(internalValue0009);
        this.internalField1407.internalMethod06986(typedValue060);
        this.internalField1412.internalMethod06986(typedValue059);
        this.internalMethod05293();
    }

    private OAuthToken internalMethod05547() throws IOException {
        if (this.internalField0071.internalMethod03112().internalMethod06617() == null) {
            throw new IllegalStateException("Can't refresh MSA token, because it was created without a refresh token. The user has to sign in again.");
        }
        return (OAuthToken)this.internalField0058.internalMethod07532(new AuthInternal027(this.internalField0727, this.internalField0071.internalMethod03112()));
    }

    private ConfigInternal022 internalMethod03541() throws IOException {
        return (ConfigInternal022)this.internalField0058.internalMethod07532(new AuthInternal002(this.internalField0247, this.internalField0428, this.internalField0069));
    }

    private ConfigInternal004 internalMethod03543() throws IOException {
        if (this.internalField0727.internalMethod06891()) {
            this.internalMethod05292();
            return this.internalField0979.internalMethod03112();
        }
        return (ConfigInternal004)this.internalField0058.internalMethod07532(new AuthInternal004(this.internalField0727, this.internalField0071.internalMethod03989()));
    }

    private ConfigInternal023 internalMethod03542() throws IOException {
        if (!this.internalField0727.internalMethod06891()) {
            throw new UnsupportedOperationException("Can't refresh XBL title token, because the MSA application client ID is not a title client ID");
        }
        this.internalMethod05292();
        return this.internalField0978.internalMethod03112();
    }

    private AuthInternal001 internalMethod03545() throws IOException {
        if (this.internalField0727.internalMethod06891()) {
            this.internalMethod05292();
            return this.internalField0977.internalMethod03112();
        }
        return (AuthInternal001)this.internalField0058.internalMethod07532(new AuthInternal005(this.internalField0072.internalMethod03989(), this.internalField0979.internalMethod03989(), null, "https://multiplayer.minecraft.net/"));
    }

    private AuthInternal001 internalMethod04425() throws IOException {
        ConfigInternal023 typedValue088 = this.internalField0727.internalMethod06891() ? this.internalField0978.internalMethod03989() : null;
        return (AuthInternal001)this.internalField0058.internalMethod07532(new AuthInternal005(this.internalField0072.internalMethod03989(), this.internalField0979.internalMethod03989(), typedValue088, "https://b980a380.minecraft.playfabapi.com/"));
    }

    private AuthInternal001 internalMethod08051() throws IOException {
        ConfigInternal023 typedValue088 = this.internalField0727.internalMethod06891() ? this.internalField0978.internalMethod03989() : null;
        return (AuthInternal001)this.internalField0058.internalMethod07532(new AuthInternal005(this.internalField0072.internalMethod03989(), this.internalField0979.internalMethod03989(), typedValue088, "https://pocket.realms.minecraft.net/"));
    }

    private AuthInternal001 internalMethod08205() throws IOException {
        ConfigInternal023 typedValue088 = this.internalField0727.internalMethod06891() ? this.internalField0978.internalMethod03989() : null;
        return (AuthInternal001)this.internalField0058.internalMethod07532(new AuthInternal005(this.internalField0072.internalMethod03989(), this.internalField0979.internalMethod03989(), typedValue088, "http://xboxlive.com"));
    }

    private AuthInternal036 internalMethod06788() throws IOException {
        return (AuthInternal036)this.internalField0058.internalMethod07532(new AuthInternal038(this.internalField0980.internalMethod03989(), "20CA2"));
    }

    private AuthInternal035 internalMethod06787() throws IOException {
        AuthInternal036 typedValue080 = this.internalField1406.internalMethod03989();
        return (AuthInternal035)this.internalField0058.internalMethod07532(new AuthInternal037(typedValue080.internalMethod04406(), "20CA2", typedValue080.internalMethod05787(), "master_player_account"));
    }

    private ConfigInternal008 internalMethod00478() throws IOException {
        return (ConfigInternal008)this.internalField0058.internalMethod07532(new AuthInternal008(this.internalField1406.internalMethod03989(), this.internalField0248, this.internalField0428));
    }

    private ConfigInternal007 internalMethod00477() throws IOException {
        return (ConfigInternal007)this.internalField0058.internalMethod07532(new NetworkInternal006(this.internalField1408.internalMethod03989(), this.internalField0070));
    }

    private ConfigInternal006 internalMethod00474() throws IOException {
        return (ConfigInternal006)this.internalField0058.internalMethod07532(new NetworkInternal005(this.internalField0977.internalMethod03989(), this.internalField0070));
    }

    private void internalMethod05292() throws IOException {
        AuthInternal042 typedValue087 = (AuthInternal042)this.internalField0058.internalMethod07532(new AuthInternal003(this.internalField0727, this.internalField0071.internalMethod03989(), this.internalField0072.internalMethod03989(), this.internalField0069, "https://multiplayer.minecraft.net/"));
        this.internalField0979.internalMethod06986(typedValue087.internalMethod02222());
        this.internalField0978.internalMethod06986(typedValue087.internalMethod02221());
        this.internalField0977.internalMethod06986(typedValue087.internalMethod02225());
    }

    private void internalMethod05293() {
        this.internalField0071.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0072.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0979.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0978.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0977.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField0980.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1411.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1410.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1406.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1409.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1408.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1407.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
        this.internalField1412.internalMethod04962().internalMethod01208(this.internalField0080::internalMethod07273);
    }

    @Generated
    public RockstarHttpClient internalMethod03198() {
        return this.internalField0058;
    }

    @Generated
    public String internalMethod05179() {
        return this.internalField0248;
    }

    @Generated
    public OAuthClientConfig internalMethod05488() {
        return this.internalField0727;
    }

    @Generated
    public String internalMethod01717() {
        return this.internalField0247;
    }

    @Generated
    public KeyPair internalMethod00425() {
        return this.internalField0069;
    }

    @Generated
    public UUID internalMethod02053() {
        return this.internalField0428;
    }

    @Generated
    public KeyPair internalMethod02279() {
        return this.internalField0070;
    }

    @Generated
    public CoreInternal031 internalMethod00415() {
        return this.internalField0080;
    }

    @Generated
    public CoreInternal027<OAuthToken> internalMethod00356() {
        return this.internalField0071;
    }

    @Generated
    public CoreInternal027<ConfigInternal022> internalMethod01199() {
        return this.internalField0072;
    }

    @Generated
    public CoreInternal027<ConfigInternal004> internalMethod08981() {
        return this.internalField0979;
    }

    @Generated
    public CoreInternal027<ConfigInternal023> internalMethod09132() {
        return this.internalField0978;
    }

    @Generated
    public CoreInternal027<AuthInternal001> internalMethod08788() {
        return this.internalField0977;
    }

    @Generated
    public CoreInternal027<AuthInternal001> internalMethod07862() {
        return this.internalField0980;
    }

    @Generated
    public CoreInternal027<AuthInternal001> internalMethod09292() {
        return this.internalField1411;
    }

    @Generated
    public CoreInternal027<AuthInternal001> internalMethod09365() {
        return this.internalField1410;
    }

    @Generated
    public CoreInternal027<AuthInternal036> internalMethod09434() {
        return this.internalField1406;
    }

    @Generated
    public CoreInternal027<AuthInternal035> internalMethod09507() {
        return this.internalField1409;
    }

    @Generated
    public CoreInternal027<ConfigInternal008> internalMethod09343() {
        return this.internalField1408;
    }

    @Generated
    public CoreInternal027<ConfigInternal007> internalMethod09453() {
        return this.internalField1407;
    }

    @Generated
    public CoreInternal027<ConfigInternal006> internalMethod09496() {
        return this.internalField1412;
    }

    public static class InternalType0124 {
        private final RockstarHttpClient internalField0058;
        private final String internalField0248;
        private OAuthClientConfig internalField0727 = new OAuthClientConfig("0000000048183522", "service::user.auth.xboxlive.com::MBI_SSL");
        private String internalField0247 = "Android";
        private KeyPair internalField0069;
        private UUID internalField0428;
        private KeyPair internalField0070;

        public AuthInternal007 internalMethod03798(AuthInternal033 typedValue076) throws IOException, InterruptedException, TimeoutException {
            AuthInternal028 typedValue075 = typedValue076.internalMethod04508(this.internalField0058, this.internalField0727);
            return this.internalMethod01778(typedValue075.internalMethod04761());
        }

        public <T> AuthInternal007 internalMethod01935(AuthInternal034<T> typedValue077, T t) throws IOException, InterruptedException, TimeoutException {
            AuthInternal028 typedValue075 = typedValue077.internalMethod01631(this.internalField0058, this.internalField0727, t);
            return this.internalMethod01778(typedValue075.internalMethod04761());
        }

        public AuthInternal007 internalMethod02440(String string) throws IOException {
            return this.internalMethod01778((OAuthToken)this.internalField0058.internalMethod07532(new AuthInternal027(this.internalField0727, string)));
        }

        public AuthInternal007 internalMethod01778(OAuthToken typedValue074) {
            return new AuthInternal007(this.internalField0058, this.internalField0248, this.internalField0727, this.internalField0247, this.internalField0069 != null ? this.internalField0069 : ScriptInternal016.internalMethod03791(), this.internalField0428 != null ? this.internalField0428 : UUID.randomUUID(), this.internalField0070 != null ? this.internalField0070 : ScriptInternal016.internalMethod05695(), typedValue074);
        }

        @Generated
        public InternalType0124 internalMethod07345(OAuthClientConfig typedValue071) {
            this.internalField0727 = typedValue071;
            return this;
        }

        @Generated
        public InternalType0124 internalMethod05779(String string) {
            this.internalField0247 = string;
            return this;
        }

        @Generated
        public InternalType0124 internalMethod06781(KeyPair keyPair) {
            this.internalField0069 = keyPair;
            return this;
        }

        @Generated
        public InternalType0124 internalMethod05335(UUID uUID) {
            this.internalField0428 = uUID;
            return this;
        }

        @Generated
        public InternalType0124 internalMethod03958(KeyPair keyPair) {
            this.internalField0070 = keyPair;
            return this;
        }

        @Generated
        private InternalType0124(RockstarHttpClient typedValue034, String string) {
            this.internalField0058 = typedValue034;
            this.internalField0248 = string;
        }
    }
}

