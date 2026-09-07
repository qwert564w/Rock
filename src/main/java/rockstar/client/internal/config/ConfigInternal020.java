package rockstar.client.internal.config;




import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.*;
import com.google.gson.JsonObject;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.MediaTypes;
import rockstar.client.network.StringRequestBody;

public class ConfigInternal020
extends StringRequestBody {
    public ConfigInternal020(JsonObjectNode typedValue030) {
        this(typedValue030.internalMethod02940());
    }

    public ConfigInternal020(JsonObject jsonObject) {
        super(MediaTypes.internalField1095, jsonObject.toString());
    }
}

