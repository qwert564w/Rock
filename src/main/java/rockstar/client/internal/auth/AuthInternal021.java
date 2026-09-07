package rockstar.client.internal.auth;






import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.io.IOException;
import java.net.MalformedURLException;
import rockstar.client.network.HttpGetRequest;
import rockstar.client.internal.core.CoreInternal015;
import rockstar.client.internal.core.CoreInternal016;
import rockstar.client.internal.config.ConfigInternal013;
import rockstar.client.internal.config.ConfigInternal014;
import rockstar.client.internal.config.ConfigInternal015;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.core.CoreInternal026;

public class AuthInternal021
extends HttpGetRequest
implements ConfigInternal015<ConfigInternal013> {
    public AuthInternal021(ConfigInternal014 typedValue067) throws MalformedURLException {
        super("https://api.minecraftservices.com/minecraft/profile");
        this.internalMethod01193("Authorization", typedValue067.internalMethod06704());
    }

    @Override
    public ConfigInternal013 internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        return new ConfigInternal013(CoreInternal026.internalMethod01591(typedValue030.internalMethod03457("id")), typedValue030.internalMethod03457("name"));
    }

    @Override
    public void internalMethod05712(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        try {
            ConfigInternal015.super.internalMethod05712(typedValue035, typedValue030);
        }
        catch (CoreInternal016 typedValue064) {
            if (typedValue064.internalMethod00843().internalMethod00588() == 404) {
                throw new CoreInternal015(typedValue064);
            }
            throw typedValue064;
        }
    }
}

