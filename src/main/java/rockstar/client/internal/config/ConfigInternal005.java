package rockstar.client.internal.config;





import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.auth.*;
import rockstar.client.*;
import java.io.IOException;
import java.util.Optional;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.config.ConfigInternal021;
import rockstar.client.internal.auth.AuthInternal041;

public interface ConfigInternal005<R>
extends ConfigInternal021<R> {
    @Override
    default public R handle(RockstarHttpResponse typedValue035) throws IOException {
        Optional<String> optional;
        if (typedValue035.internalMethod00588() >= 300 && (optional = typedValue035.internalMethod04855("X-Err")).isPresent()) {
            throw new AuthInternal041(typedValue035, Long.parseLong(optional.get()));
        }
        return ConfigInternal021.super.handle(typedValue035);
    }

    @Override
    default public void internalMethod05712(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        if (typedValue030.internalMethod07773("XErr")) {
            throw new AuthInternal041(typedValue035, typedValue030.internalMethod02177("XErr"));
        }
    }
}

