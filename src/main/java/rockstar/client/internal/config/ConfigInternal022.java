package rockstar.client.internal.config;




import rockstar.client.data.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import lombok.Generated;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.internal.core.CoreInternal022;

public final class ConfigInternal022
implements CoreInternal022 {
    private final long internalField0229;
    private final String internalField0248;
    private final String internalField0247;

    public static ConfigInternal022 internalMethod01160(JsonObject jsonObject) {
        return ConfigInternal022.internalMethod05446(new JsonObjectNode(jsonObject));
    }

    public static ConfigInternal022 internalMethod05446(JsonObjectNode typedValue030) {
        return new ConfigInternal022(typedValue030.internalMethod02177("expireTimeMs"), typedValue030.internalMethod03457("token"), typedValue030.internalMethod03457("deviceId"));
    }

    public static JsonObject internalMethod02879(ConfigInternal022 typedValue086) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)typedValue086.internalField0229);
        jsonObject.addProperty("token", typedValue086.internalField0248);
        jsonObject.addProperty("deviceId", typedValue086.internalField0247);
        return jsonObject;
    }

    @Generated
    public ConfigInternal022(long l, String string, String string2) {
        this.internalField0229 = l;
        this.internalField0248 = string;
        this.internalField0247 = string2;
    }

    @Override
    @Generated
    public long internalMethod03800() {
        return this.internalField0229;
    }

    @Generated
    public String internalMethod05939() {
        return this.internalField0248;
    }

    @Generated
    public String internalMethod02508() {
        return this.internalField0247;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ConfigInternal022)) {
            return false;
        }
        ConfigInternal022 typedValue086 = (ConfigInternal022)object;
        if (this.internalMethod03800() != typedValue086.internalMethod03800()) {
            return false;
        }
        String string = this.internalMethod05939();
        String string2 = typedValue086.internalMethod05939();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.internalMethod02508();
        String string4 = typedValue086.internalMethod02508();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.internalMethod03800();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.internalMethod05939();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.internalMethod02508();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblDeviceToken(expireTimeMs=" + this.internalMethod03800() + ", token=" + this.internalMethod05939() + ", deviceId=" + this.internalMethod02508() + ")";
    }
}

