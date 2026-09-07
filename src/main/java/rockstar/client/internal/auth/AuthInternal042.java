package rockstar.client.internal.auth;




import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.internal.config.ConfigInternal023;
import rockstar.client.internal.config.ConfigInternal004;
import rockstar.client.internal.auth.AuthInternal001;

public final class AuthInternal042 {
    private final ConfigInternal004 internalField0463;
    private final ConfigInternal023 internalField0462;
    private final AuthInternal001 internalField0464;

    public static AuthInternal042 internalMethod06146(JsonObject jsonObject) {
        return AuthInternal042.internalMethod07517(new JsonObjectNode(jsonObject));
    }

    public static AuthInternal042 internalMethod07517(JsonObjectNode typedValue030) {
        return new AuthInternal042(ConfigInternal004.internalMethod00778(typedValue030.internalMethod01060("userToken")), ConfigInternal023.internalMethod06742(typedValue030.internalMethod01060("titleToken")), AuthInternal001.internalMethod06637(typedValue030.internalMethod01060("xstsToken")));
    }

    public static JsonObject internalMethod04856(AuthInternal042 typedValue087) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.add("userToken", (JsonElement)ConfigInternal004.internalMethod05736(typedValue087.internalField0463));
        jsonObject.add("titleToken", (JsonElement)ConfigInternal023.internalMethod03846(typedValue087.internalField0462));
        jsonObject.add("xstsToken", (JsonElement)AuthInternal001.internalMethod06839(typedValue087.internalField0464));
        return jsonObject;
    }

    @Generated
    public AuthInternal042(ConfigInternal004 typedValue041, ConfigInternal023 typedValue088, AuthInternal001 typedValue043) {
        this.internalField0463 = typedValue041;
        this.internalField0462 = typedValue088;
        this.internalField0464 = typedValue043;
    }

    @Generated
    public ConfigInternal004 internalMethod02222() {
        return this.internalField0463;
    }

    @Generated
    public ConfigInternal023 internalMethod02221() {
        return this.internalField0462;
    }

    @Generated
    public AuthInternal001 internalMethod02225() {
        return this.internalField0464;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AuthInternal042)) {
            return false;
        }
        AuthInternal042 typedValue087 = (AuthInternal042)object;
        ConfigInternal004 typedValue041 = this.internalMethod02222();
        ConfigInternal004 typedValue042 = typedValue087.internalMethod02222();
        if (typedValue041 == null ? typedValue042 != null : !((Object)typedValue041).equals(typedValue042)) {
            return false;
        }
        ConfigInternal023 typedValue088 = this.internalMethod02221();
        ConfigInternal023 typedValue089 = typedValue087.internalMethod02221();
        if (typedValue088 == null ? typedValue089 != null : !((Object)typedValue088).equals(typedValue089)) {
            return false;
        }
        AuthInternal001 typedValue043 = this.internalMethod02225();
        AuthInternal001 typedValue044 = typedValue087.internalMethod02225();
        return !(typedValue043 == null ? typedValue044 != null : !((Object)typedValue043).equals(typedValue044));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        ConfigInternal004 typedValue041 = this.internalMethod02222();
        n2 = n2 * 59 + (typedValue041 == null ? 43 : ((Object)typedValue041).hashCode());
        ConfigInternal023 typedValue088 = this.internalMethod02221();
        n2 = n2 * 59 + (typedValue088 == null ? 43 : ((Object)typedValue088).hashCode());
        AuthInternal001 typedValue043 = this.internalMethod02225();
        n2 = n2 * 59 + (typedValue043 == null ? 43 : ((Object)typedValue043).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblSisuTokens(userToken=" + this.internalMethod02222() + ", titleToken=" + this.internalMethod02221() + ", xstsToken=" + this.internalMethod02225() + ")";
    }
}

