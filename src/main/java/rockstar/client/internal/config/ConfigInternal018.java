package rockstar.client.internal.config;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.io.IOException;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.core.CoreInternal021;
import rockstar.client.internal.config.ConfigInternal021;

public interface ConfigInternal018<R>
extends ConfigInternal021<R> {
    @Override
    default public void internalMethod05712(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        if (typedValue030.internalMethod09165("error") && typedValue030.internalMethod09165("errorMessage")) {
            throw new CoreInternal021(typedValue035, typedValue030.internalMethod03457("error"), typedValue030.internalMethod03457("errorMessage"));
        }
    }
}

