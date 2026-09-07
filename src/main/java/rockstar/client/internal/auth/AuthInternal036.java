package rockstar.client.internal.auth;




import rockstar.client.data.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.internal.auth.AuthInternal035;
import rockstar.client.internal.core.CoreInternal022;

public final class AuthInternal036
implements CoreInternal022 {
    private final AuthInternal035 internalField0866;
    private final String internalField0248;
    private final String internalField0247;

    public static AuthInternal036 internalMethod00064(JsonObject jsonObject) {
        return AuthInternal036.internalMethod07539(new JsonObjectNode(jsonObject));
    }

    public static AuthInternal036 internalMethod07539(JsonObjectNode typedValue030) {
        if (typedValue030.internalMethod02176("_saveVersion") == 1) {
            AuthInternal035 typedValue078 = new AuthInternal035(typedValue030.internalMethod02177("expireTimeMs"), typedValue030.internalMethod03457("entityToken"), typedValue030.internalMethod03457("entityId"), "title_player_account");
            return new AuthInternal036(typedValue078, typedValue030.internalMethod03457("playFabId"), typedValue030.internalMethod03457("sessionTicket"));
        }
        return new AuthInternal036(AuthInternal035.internalMethod05463(typedValue030.internalMethod01060("entityToken")), typedValue030.internalMethod03457("playFabId"), typedValue030.internalMethod03457("sessionTicket"));
    }

    public static JsonObject internalMethod04598(AuthInternal036 typedValue080) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)2);
        jsonObject.add("entityToken", (JsonElement)AuthInternal035.internalMethod02677(typedValue080.internalField0866));
        jsonObject.addProperty("playFabId", typedValue080.internalField0248);
        jsonObject.addProperty("sessionTicket", typedValue080.internalField0247);
        return jsonObject;
    }

    @Override
    public long internalMethod03800() {
        return this.internalField0866.internalMethod03800();
    }

    @Deprecated
    public String internalMethod01124() {
        return this.internalField0866.internalMethod03503();
    }

    @Generated
    public AuthInternal036(AuthInternal035 typedValue078, String string, String string2) {
        this.internalField0866 = typedValue078;
        this.internalField0248 = string;
        this.internalField0247 = string2;
    }

    @Generated
    public AuthInternal035 internalMethod04406() {
        return this.internalField0866;
    }

    @Generated
    public String internalMethod05787() {
        return this.internalField0248;
    }

    @Generated
    public String internalMethod09087() {
        return this.internalField0247;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AuthInternal036)) {
            return false;
        }
        AuthInternal036 typedValue080 = (AuthInternal036)object;
        AuthInternal035 typedValue078 = this.internalMethod04406();
        AuthInternal035 typedValue079 = typedValue080.internalMethod04406();
        if (typedValue078 == null ? typedValue079 != null : !((Object)typedValue078).equals(typedValue079)) {
            return false;
        }
        String string = this.internalMethod05787();
        String string2 = typedValue080.internalMethod05787();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.internalMethod09087();
        String string4 = typedValue080.internalMethod09087();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        AuthInternal035 typedValue078 = this.internalMethod04406();
        n2 = n2 * 59 + (typedValue078 == null ? 43 : ((Object)typedValue078).hashCode());
        String string = this.internalMethod05787();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.internalMethod09087();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "PlayFabToken(entityToken=" + this.internalMethod04406() + ", playFabId=" + this.internalMethod05787() + ", sessionTicket=" + this.internalMethod09087() + ")";
    }
}

