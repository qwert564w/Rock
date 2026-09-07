package rockstar.client.internal.auth;





import rockstar.client.network.*;
import rockstar.client.i18n.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import rockstar.client.internal.core.CoreInternal019;
import rockstar.client.network.RockstarHttpClient;
import rockstar.client.network.MediaTypes;

public class AuthInternal006 {
    public static final String internalField0248 = "5.0.1";
    public static final String internalField0247 = "5.0.1+55146ff";

    public static RockstarHttpClient internalMethod01056() {
        return AuthInternal006.internalMethod06963("MinecraftAuth/5.0.1");
    }

    public static RockstarHttpClient internalMethod06963(String string) {
        return (RockstarHttpClient)((RockstarHttpClient)((RockstarHttpClient)new RockstarHttpClient().internalMethod05495(5000).internalMethod00765(30000).internalMethod07183(null).internalMethod00928(false).internalMethod05937(new CoreInternal019(0, 50)).internalMethod01193("Accept", MediaTypes.internalField1095.toString())).internalMethod01193("Accept-Language", "en-US,en")).internalMethod01193("User-Agent", string);
    }
}

