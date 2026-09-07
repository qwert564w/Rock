package rockstar.client.internal.network;






import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.internal.config.*;
import rockstar.client.internal.auth.*;
import rockstar.client.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import rockstar.client.network.HttpGetRequest;
import rockstar.client.internal.auth.AuthInternal010;
import rockstar.client.internal.config.ConfigInternal011;
import rockstar.client.data.JsonNode;
import rockstar.client.data.JsonObjectNode;
import rockstar.client.network.RockstarHttpResponse;

public class NetworkInternal008
extends HttpGetRequest
implements ConfigInternal011<List<AuthInternal010>> {
    public NetworkInternal008(String string) throws MalformedURLException {
        super("https://" + string + "/worlds");
    }

    @Override
    public List<AuthInternal010> internalMethod05428(RockstarHttpResponse typedValue035, JsonObjectNode typedValue030) throws IOException {
        ArrayList<AuthInternal010> arrayList = new ArrayList<AuthInternal010>();
        for (JsonNode typedValue029 : typedValue030.internalMethod03703("servers")) {
            arrayList.add(AuthInternal010.internalMethod01457(typedValue029.internalMethod04512()));
        }
        return arrayList;
    }
}

