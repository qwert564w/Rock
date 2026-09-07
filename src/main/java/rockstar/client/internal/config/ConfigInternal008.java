package rockstar.client.internal.config;





import rockstar.client.data.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.internal.core.CoreInternal022;
import rockstar.client.internal.network.NetworkInternal009;

public final class ConfigInternal008
implements CoreInternal022 {
    private final long internalField0229;
    private final String internalField0248;
    private final AtomicReference<Object> internalField0746 = new AtomicReference();

    public static ConfigInternal008 internalMethod03285(JsonObject jsonObject) {
        return ConfigInternal008.internalMethod03814(new JsonObjectNode(jsonObject));
    }

    public static ConfigInternal008 internalMethod03814(JsonObjectNode typedValue030) {
        return new ConfigInternal008(typedValue030.internalMethod02177("expireTimeMs"), typedValue030.internalMethod03457("authorizationHeader"));
    }

    public static JsonObject internalMethod01874(ConfigInternal008 internalValue0009) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)internalValue0009.internalField0229);
        jsonObject.addProperty("authorizationHeader", internalValue0009.internalField0248);
        return jsonObject;
    }

    @Generated
    public ConfigInternal008(long l, String string) {
        this.internalField0229 = l;
        this.internalField0248 = string;
    }

    @Override
    @Generated
    public long internalMethod03800() {
        return this.internalField0229;
    }

    @Generated
    public String internalMethod03445() {
        return this.internalField0248;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ConfigInternal008)) {
            return false;
        }
        ConfigInternal008 internalValue0009 = (ConfigInternal008)object;
        if (this.internalMethod03800() != internalValue0009.internalMethod03800()) {
            return false;
        }
        String string = this.internalMethod03445();
        String string2 = internalValue0009.internalMethod03445();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.internalMethod03800();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.internalMethod03445();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftSession(expireTimeMs=" + this.internalMethod03800() + ", authorizationHeader=" + this.internalMethod03445() + ")";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public NetworkInternal009 internalMethod01324() {
        Object object = this.internalField0746.get();
        if (object == null) {
            AtomicReference<Object> atomicReference = this.internalField0746;
            synchronized (atomicReference) {
                object = this.internalField0746.get();
                if (object == null) {
                    NetworkInternal009 typedValue085 = NetworkInternal009.internalMethod04997(this.internalField0248.split(" ", 2)[1]);
                    object = typedValue085 == null ? this.internalField0746 : typedValue085;
                    this.internalField0746.set(object);
                }
            }
        }
        return (NetworkInternal009)(object == this.internalField0746 ? null : object);
    }
}

