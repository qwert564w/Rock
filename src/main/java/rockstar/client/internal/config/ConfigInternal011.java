package rockstar.client.internal.config;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.io.IOException;
import rockstar.client.internal.core.CoreInternal013;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal021;

public interface ConfigInternal011<R>
extends ConfigInternal021<R> {
    @Override
    default public void internalMethod05712(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        if (typedValue030.internalMethod07773("errorCode") && typedValue030.internalMethod09165("errorMsg")) {
            throw new CoreInternal013(typedValue035, typedValue030.internalMethod02176("errorCode"), typedValue030.internalMethod03457("errorMsg"));
        }
    }
}

