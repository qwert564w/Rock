package rockstar.client.internal.config;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.io.IOException;
import rockstar.client.internal.core.CoreInternal011;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.core.CoreInternal034;
import rockstar.client.internal.config.ConfigInternal021;

public interface ConfigInternal009<R>
extends ConfigInternal021<R> {
    @Override
    default public void internalMethod05712(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        if (typedValue030.internalMethod09165("error") && typedValue030.internalMethod09165("errorMessage")) {
            throw new CoreInternal011(typedValue035, typedValue030.internalMethod03457("error"), typedValue030.internalMethod03457("errorMessage"));
        }
        if (typedValue030.internalMethod09165("errorMessage")) {
            throw new CoreInternal034(typedValue035, typedValue030.internalMethod03457("errorMessage"));
        }
    }
}

