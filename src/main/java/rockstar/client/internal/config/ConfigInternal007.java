package rockstar.client.internal.config;





import rockstar.client.data.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.internal.core.CoreInternal022;
import rockstar.client.internal.network.NetworkInternal009;

public final class ConfigInternal007
implements CoreInternal022 {
    private final long internalField0229;
    private final String internalField0248;
    private final AtomicReference<Object> internalField0746 = new AtomicReference();

    public static ConfigInternal007 internalMethod06452(JsonObject jsonObject) {
        return ConfigInternal007.internalMethod01728(new JsonObjectNode(jsonObject));
    }

    public static ConfigInternal007 internalMethod01728(JsonObjectNode typedValue030) {
        return new ConfigInternal007(typedValue030.internalMethod02177("expireTimeMs"), typedValue030.internalMethod03457("token"));
    }

    public static JsonObject internalMethod06693(ConfigInternal007 typedValue060) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", (Number)1);
        jsonObject.addProperty("expireTimeMs", (Number)typedValue060.internalField0229);
        jsonObject.addProperty("token", typedValue060.internalField0248);
        return jsonObject;
    }

    public String internalMethod01295() {
        return this.internalMethod00601().internalMethod03211().internalMethod03457("xname");
    }

    public String internalMethod05904() {
        return this.internalMethod00601().internalMethod03211().internalMethod03457("xid");
    }

    public UUID internalMethod04279() {
        return UUID.nameUUIDFromBytes(("pocket-auth-1-xuid:" + this.internalMethod05904()).getBytes(StandardCharsets.UTF_8));
    }

    @Generated
    public ConfigInternal007(long l, String string) {
        this.internalField0229 = l;
        this.internalField0248 = string;
    }

    @Override
    @Generated
    public long internalMethod03800() {
        return this.internalField0229;
    }

    @Generated
    public String internalMethod08424() {
        return this.internalField0248;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ConfigInternal007)) {
            return false;
        }
        ConfigInternal007 typedValue060 = (ConfigInternal007)object;
        if (this.internalMethod03800() != typedValue060.internalMethod03800()) {
            return false;
        }
        String string = this.internalMethod08424();
        String string2 = typedValue060.internalMethod08424();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = this.internalMethod03800();
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        String string = this.internalMethod08424();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "MinecraftMultiplayerToken(expireTimeMs=" + this.internalMethod03800() + ", token=" + this.internalMethod08424() + ")";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Generated
    public NetworkInternal009 internalMethod00601() {
        Object object = this.internalField0746.get();
        if (object == null) {
            AtomicReference<Object> atomicReference = this.internalField0746;
            synchronized (atomicReference) {
                object = this.internalField0746.get();
                if (object == null) {
                    NetworkInternal009 typedValue085 = NetworkInternal009.internalMethod04997(this.internalField0248);
                    object = typedValue085 == null ? this.internalField0746 : typedValue085;
                    this.internalField0746.set(object);
                }
            }
        }
        return (NetworkInternal009)(object == this.internalField0746 ? null : object);
    }
}

