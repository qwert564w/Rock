package rockstar.client.internal.auth;



import rockstar.client.data.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import lombok.Generated;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.data.JsonObjectNode;

public final class AuthInternal009 {
    public static final String internalField0248 = "DEFAULT";
    public static final String internalField0247 = "NETHERNET";
    public static final String internalField1077 = "NETHERNET_JSONRPC";
    private final String internalField1076;
    private final String internalField1079;
    private final JsonObject internalField0539;

    @ApiStatus.Internal
    public static AuthInternal009 internalMethod07377(JsonObjectNode typedValue030) {
        return new AuthInternal009(typedValue030.internalMethod03457("address"), typedValue030.internalMethod01170("networkProtocol", internalField0248), typedValue030.internalMethod02940());
    }

    @Generated
    public AuthInternal009(String string, String string2, JsonObject jsonObject) {
        this.internalField1076 = string;
        this.internalField1079 = string2;
        this.internalField0539 = jsonObject;
    }

    @Generated
    public String internalMethod03078() {
        return this.internalField1076;
    }

    @Generated
    public String internalMethod01675() {
        return this.internalField1079;
    }

    @Generated
    public JsonObject internalMethod03866() {
        return this.internalField0539;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AuthInternal009)) {
            return false;
        }
        AuthInternal009 typedValue061 = (AuthInternal009)object;
        String string = this.internalMethod03078();
        String string2 = typedValue061.internalMethod03078();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.internalMethod01675();
        String string4 = typedValue061.internalMethod01675();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        JsonObject jsonObject = this.internalMethod03866();
        JsonObject jsonObject2 = typedValue061.internalMethod03866();
        return !(jsonObject == null ? jsonObject2 != null : !jsonObject.equals(jsonObject2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.internalMethod03078();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.internalMethod01675();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        JsonObject jsonObject = this.internalMethod03866();
        n2 = n2 * 59 + (jsonObject == null ? 43 : jsonObject.hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "RealmsJoinInformation(address=" + this.internalMethod03078() + ", networkProtocol=" + this.internalMethod01675() + ", rawResponse=" + this.internalMethod03866() + ")";
    }
}

