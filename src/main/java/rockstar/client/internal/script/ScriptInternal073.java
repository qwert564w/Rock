package rockstar.client.internal.script;










import rockstar.client.setting.*;
import rockstar.client.module.*;
import rockstar.client.i18n.*;
import rockstar.client.internal.ui.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.framework.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pyrock.utility.render.ColorRGBA;
import rockstar.modules.visual.MenuModule;
import rockstar.client.internal.script.ScriptInternal082;
import rockstar.client.internal.script.ScriptInternal083;
import rockstar.client.setting.Setting;
import rockstar.client.setting.KeybindSetting;
import rockstar.client.setting.BooleanSetting;
import rockstar.client.setting.ButtonSetting;
import rockstar.client.setting.ColorSetting;
import rockstar.client.setting.ModeSetting;
import rockstar.client.internal.script.ScriptInternal068;
import rockstar.client.setting.RangeSetting;
import rockstar.client.setting.MultiSelectSetting;
import rockstar.client.setting.SliderSetting;
import rockstar.client.setting.TextSetting;
import rockstar.client.internal.script.ScriptInternal070;
import rockstar.client.i18n.LanguageManager;
import rockstar.client.internal.script.ScriptInternal072;
import rockstar.client.internal.network.NetworkInternal013;
import rockstar.client.internal.script.ScriptInternal076;
import rockstar.client.module.ModuleEntry;
import rockstar.client.RockstarClient;
import rockstar.client.internal.ui.UiInternal033;
import rockstar.client.MinecraftClientAccess;
import rockstar.client.internal.framework.FrameworkInternal001;
import rockstar.client.internal.core.CoreInternal051;
import rockstar.client.internal.config.ConfigInternal025;

public final class ScriptInternal073 {
    private ScriptInternal073() {
    }

    public static ModuleEntry internalMethod05485(String string) {
        if (string == null || string.isBlank()) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0443\u043a\u0430\u0437\u0430\u043d \u043c\u043e\u0434\u0443\u043b\u044c");
        }
        String string2 = ScriptInternal073.internalMethod01037(string);
        for (ModuleEntry object : RockstarClient.getInstance().getModuleManager().getModules()) {
            if (!ScriptInternal073.internalMethod01037(object.getName()).equals(string2)) continue;
            return object;
        }
        ArrayList arrayList = new ArrayList();
        for (ModuleEntry typedValue145 : RockstarClient.getInstance().getModuleManager().getModules()) {
            String string3 = ScriptInternal073.internalMethod01037(typedValue145.getName());
            boolean bl = string3.contains(string2) || string2.contains(string3) || string2.length() >= 3 && string3.startsWith(string2.substring(0));
            if (!bl) continue;
            arrayList.add(typedValue145.getName());
        }
        throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0442 \u043c\u043e\u0434\u0443\u043b\u044f \"" + string + "\"" + (String)(arrayList.isEmpty() ? "" : ", \u043f\u043e\u0445\u043e\u0436\u0438\u0435: " + String.join((CharSequence)", ", arrayList)));
    }

    public static JsonObject internalMethod02764(String string, String string2) {
        ModuleEntry typedValue145 = ScriptInternal073.internalMethod05485(string);
        boolean bl = switch (string2 == null ? "toggle" : string2.toLowerCase(Locale.ROOT)) {
            case "enable", "on", "true" -> true;
            case "disable", "off", "false" -> false;
            default -> !typedValue145.isEnabled();
        };
        typedValue145.setEnabled(bl, false);
        ScriptInternal073.internalMethod06881();
        return ScriptInternal076.internalMethod04760(typedValue145, false);
    }

    public static JsonObject internalMethod05565(String string, JsonElement jsonElement) {
        ModuleEntry typedValue145 = ScriptInternal073.internalMethod05485(string);
        typedValue145.setKeybind(ScriptInternal073.internalMethod04433(jsonElement));
        ScriptInternal073.internalMethod06881();
        return ScriptInternal076.internalMethod04760(typedValue145, false);
    }

    public static Setting internalMethod02214(ModuleEntry typedValue145, String string) {
        if (string == null || string.isBlank()) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0443\u043a\u0430\u0437\u0430\u043d\u0430 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430");
        }
        String string2 = ScriptInternal073.internalMethod01037(string);
        for (Setting typedValue158 : typedValue145.getSettings()) {
            if (!ScriptInternal073.internalMethod01037(typedValue158.getName()).equals(string2) && !ScriptInternal073.internalMethod01037(LanguageManager.internalMethod07214(typedValue158.getName())).equals(string2)) continue;
            return typedValue158;
        }
        for (Setting typedValue158 : typedValue145.getSettings()) {
            if (!ScriptInternal073.internalMethod01037(typedValue158.getName()).endsWith("." + string2)) continue;
            return typedValue158;
        }
        ArrayList arrayList = new ArrayList();
        typedValue145.getSettings().forEach(typedValue157 -> arrayList.add(typedValue157.getName()));
        throw new NetworkInternal013.InternalType0086("\u0443 \u043c\u043e\u0434\u0443\u043b\u044f " + typedValue145.getName() + " \u043d\u0435\u0442 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \"" + string + "\"; \u0435\u0441\u0442\u044c: " + String.join((CharSequence)", ", arrayList));
    }

    public static JsonObject internalMethod00575(String string, String string2, JsonElement jsonElement) {
        ModuleEntry typedValue145 = ScriptInternal073.internalMethod05485(string);
        Setting typedValue157 = ScriptInternal073.internalMethod02214(typedValue145, string2);
        ScriptInternal073.internalMethod01035(typedValue157, jsonElement);
        ScriptInternal073.internalMethod06881();
        return ScriptInternal076.internalMethod01496(typedValue157);
    }

    public static void internalMethod01035(Setting typedValue157, JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u043f\u0435\u0440\u0435\u0434\u0430\u043d\u043e \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435");
        }
        if (typedValue157 instanceof BooleanSetting) {
            BooleanSetting typedValue164 = (BooleanSetting)typedValue157;
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString() && "toggle".equalsIgnoreCase(jsonElement.getAsString())) {
                typedValue164.internalMethod02034(!typedValue164.internalMethod04496());
            } else {
                typedValue164.internalMethod02034(ScriptInternal073.internalMethod04434(jsonElement));
            }
            return;
        }
        if (typedValue157 instanceof SliderSetting) {
            SliderSetting typedValue174 = (SliderSetting)typedValue157;
            typedValue174.internalMethod04736(ScriptInternal073.internalMethod04432(jsonElement));
            return;
        }
        if (typedValue157 instanceof RangeSetting) {
            RangeSetting typedValue172 = (RangeSetting)typedValue157;
            if (jsonElement.isJsonArray() && jsonElement.getAsJsonArray().size() == 2) {
                typedValue172.internalMethod01445(jsonElement.getAsJsonArray().get(0).getAsFloat());
                typedValue172.internalMethod01501(jsonElement.getAsJsonArray().get(1).getAsFloat());
                return;
            }
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("first")) {
                    typedValue172.internalMethod01445(jsonObject.get("first").getAsFloat());
                }
                if (jsonObject.has("second")) {
                    typedValue172.internalMethod01501(jsonObject.get("second").getAsFloat());
                }
                return;
            }
            throw new NetworkInternal013.InternalType0086("\u0434\u043b\u044f range \u043d\u0443\u0436\u0435\u043d [min, max] \u0438\u043b\u0438 {\"first\":.., \"second\":..}");
        }
        if (typedValue157 instanceof ModeSetting) {
            ModeSetting typedValue170 = (ModeSetting)typedValue157;
            ModeSetting.InternalType0088 nestedValue2011 = null;
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                int n = jsonElement.getAsInt();
                if (n < 0 || n >= typedValue170.internalMethod06723().size()) {
                    throw new NetworkInternal013.InternalType0086("\u0440\u0435\u0436\u0438\u043c \u2116" + n + " \u0432\u043d\u0435 \u0441\u043f\u0438\u0441\u043a\u0430");
                }
                nestedValue2011 = typedValue170.internalMethod06723().get(n);
            } else {
                String string = ScriptInternal073.internalMethod01037(jsonElement.getAsString());
                for (ModeSetting.InternalType0088 nestedValue2012 : typedValue170.internalMethod06723()) {
                    if (!ScriptInternal073.internalMethod01037(nestedValue2012.getName()).equals(string) && !ScriptInternal073.internalMethod01037(LanguageManager.internalMethod07214(nestedValue2012.getName())).equals(string) && !ScriptInternal073.internalMethod01037(nestedValue2012.getName()).endsWith("." + string)) continue;
                    nestedValue2011 = nestedValue2012;
                    break;
                }
            }
            if (nestedValue2011 == null) {
                throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0442 \u0442\u0430\u043a\u043e\u0433\u043e \u0440\u0435\u0436\u0438\u043c\u0430; \u0435\u0441\u0442\u044c: " + ScriptInternal073.internalMethod02413(typedValue170));
            }
            nestedValue2011.select();
            return;
        }
        if (typedValue157 instanceof MultiSelectSetting) {
            MultiSelectSetting typedValue173 = (MultiSelectSetting)typedValue157;
            JsonArray jsonArray = new JsonArray();
            if (jsonElement.isJsonArray()) {
                jsonArray = jsonElement.getAsJsonArray();
            } else {
                jsonArray.add(jsonElement.getAsString());
            }
            ArrayList<MultiSelectSetting.InternalType0091> arrayList = new ArrayList<MultiSelectSetting.InternalType0091>();
            for (JsonElement object : jsonArray) {
                String string = ScriptInternal073.internalMethod01037(object.getAsString());
                MultiSelectSetting.InternalType0091 nestedValue2013 = null;
                for (MultiSelectSetting.InternalType0091 nestedValue2014 : typedValue173.internalMethod01792()) {
                    if (!ScriptInternal073.internalMethod01037(nestedValue2014.getName()).equals(string) && !ScriptInternal073.internalMethod01037(LanguageManager.internalMethod07214(nestedValue2014.getName())).equals(string) && !ScriptInternal073.internalMethod01037(nestedValue2014.getName()).endsWith("." + string)) continue;
                    nestedValue2013 = nestedValue2014;
                    break;
                }
                if (nestedValue2013 == null) {
                    throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0442 \u043f\u0443\u043d\u043a\u0442\u0430 \"" + object.getAsString() + "\"; \u0435\u0441\u0442\u044c: " + ScriptInternal073.internalMethod05623(typedValue173));
                }
                arrayList.add(nestedValue2013);
            }
            for (MultiSelectSetting.InternalType0091 nestedValue2013 : new ArrayList<MultiSelectSetting.InternalType0091>(typedValue173.internalMethod01792())) {
                if (arrayList.contains(nestedValue2013)) continue;
                nestedValue2013.deselect();
            }
            arrayList.forEach(MultiSelectSetting.InternalType0091::select);
            return;
        }
        if (typedValue157 instanceof ColorSetting) {
            ColorSetting typedValue167 = (ColorSetting)typedValue157;
            typedValue167.internalMethod04886(ColorRGBA.fromHex(jsonElement.getAsString()));
            return;
        }
        if (typedValue157 instanceof KeybindSetting) {
            KeybindSetting typedValue161 = (KeybindSetting)typedValue157;
            typedValue161.internalMethod02164(ScriptInternal073.internalMethod04433(jsonElement));
            return;
        }
        if (typedValue157 instanceof TextSetting) {
            TextSetting typedValue179 = (TextSetting)typedValue157;
            typedValue179.internalMethod00011(jsonElement.getAsString());
            return;
        }
        if (typedValue157 instanceof ButtonSetting) {
            ButtonSetting typedValue166 = (ButtonSetting)typedValue157;
            Runnable runnable = typedValue166.internalMethod03496();
            if (runnable == null) {
                throw new NetworkInternal013.InternalType0086("\u0443 \u043a\u043d\u043e\u043f\u043a\u0438 \u043d\u0435\u0442 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f");
            }
            runnable.run();
            return;
        }
        typedValue157.fromJson(jsonElement);
    }

    public static JsonArray internalMethod05607(String string, JsonElement jsonElement) {
        if (string == null || string.isBlank()) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0443\u043a\u0430\u0437\u0430\u043d\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u043c\u0430\u043a\u0440\u043e\u0441\u0430");
        }
        int n = ScriptInternal073.internalMethod04433(jsonElement);
        if (n <= 0) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0440\u0430\u0437\u043e\u0431\u0440\u0430\u043b \u043a\u043b\u0430\u0432\u0438\u0448\u0443 \u043c\u0430\u043a\u0440\u043e\u0441\u0430");
        }
        ScriptInternal072 typedValue144 = RockstarClient.getInstance().internalMethod05155();
        typedValue144.internalMethod01066(string.trim(), n);
        RockstarClient.getInstance().internalMethod03371().internalMethod05165("client");
        return ScriptInternal076.internalMethod02087();
    }

    public static JsonArray internalMethod06365(String string, JsonElement jsonElement) {
        boolean bl;
        ScriptInternal072 typedValue144 = RockstarClient.getInstance().internalMethod05155();
        if (string != null && !string.isBlank() && jsonElement != null && !jsonElement.isJsonNull()) {
            bl = typedValue144.internalMethod01067(string.trim(), ScriptInternal073.internalMethod04433(jsonElement));
        } else if (string != null && !string.isBlank()) {
            bl = typedValue144.internalMethod04540(string.trim());
        } else if (jsonElement != null && !jsonElement.isJsonNull()) {
            bl = typedValue144.internalMethod03189(ScriptInternal073.internalMethod04433(jsonElement));
        } else {
            throw new NetworkInternal013.InternalType0086("\u043d\u0443\u0436\u043d\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u0438\u043b\u0438 \u043a\u043b\u0430\u0432\u0438\u0448\u0430 \u043c\u0430\u043a\u0440\u043e\u0441\u0430");
        }
        if (!bl) {
            throw new NetworkInternal013.InternalType0086("\u0442\u0430\u043a\u043e\u0433\u043e \u043c\u0430\u043a\u0440\u043e\u0441\u0430 \u043d\u0435\u0442");
        }
        RockstarClient.getInstance().internalMethod03371().internalMethod05165("client");
        return ScriptInternal076.internalMethod02087();
    }

    public static JsonObject internalMethod02860(String string, String string2, String string3) {
        ScriptInternal068 typedValue132 = RockstarClient.getInstance().internalMethod02152();
        switch (string == null ? "list" : string.toLowerCase(Locale.ROOT)) {
            case "list": {
                break;
            }
            case "save": {
                typedValue132.internalMethod06089(ScriptInternal073.internalMethod00976(string2, "\u0438\u043c\u044f \u043a\u043e\u043d\u0444\u0438\u0433\u0430"));
                break;
            }
            case "load": {
                ScriptInternal073.internalMethod05437(typedValue132, string2);
                typedValue132.internalMethod04632(string2);
                break;
            }
            case "delete": {
                ScriptInternal073.internalMethod05437(typedValue132, string2);
                typedValue132.internalMethod07852(string2);
                break;
            }
            case "rename": {
                ScriptInternal073.internalMethod05437(typedValue132, string2);
                typedValue132.internalMethod06062(string2, ScriptInternal073.internalMethod00976(string3, "\u043d\u043e\u0432\u043e\u0435 \u0438\u043c\u044f"));
                break;
            }
            case "duplicate": {
                ScriptInternal073.internalMethod05437(typedValue132, string2);
                typedValue132.internalMethod08544(string2);
                break;
            }
            case "undo": {
                if (string2 != null && !string2.isBlank()) {
                    ScriptInternal073.internalMethod05437(typedValue132, string2);
                }
                typedValue132.internalMethod08118(string2);
                break;
            }
            case "reset": {
                typedValue132.internalMethod07825();
                break;
            }
            default: {
                throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435: " + string);
            }
        }
        return ScriptInternal076.internalMethod09906();
    }

    public static JsonObject internalMethod02783(String string, String string2, String string3) {
        ScriptInternal082 typedValue154 = RockstarClient.getInstance().internalMethod04979();
        JsonObject jsonObject = new JsonObject();
        switch (string == null ? "list" : string.toLowerCase(Locale.ROOT)) {
            case "list": {
                break;
            }
            case "read": {
                jsonObject.addProperty("content", ScriptInternal073.internalMethod05432(ScriptInternal073.internalMethod05405(ScriptInternal073.internalMethod00976(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430"))));
                break;
            }
            case "write": 
            case "create": {
                String string4 = ScriptInternal073.internalMethod00976(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430");
                boolean bl = ScriptInternal073.internalMethod07145(string4) == null;
                ScriptInternal073.internalMethod01845(string4, string3 == null ? "" : string3);
                typedValue154.internalMethod07673();
                if (bl) {
                    typedValue154.internalMethod03942(string4, true);
                }
                jsonObject.addProperty("written", string4);
                ScriptInternal083 typedValue155 = ScriptInternal073.internalMethod07145(string4);
                if (typedValue155 == null) break;
                jsonObject.addProperty("loaded", Boolean.valueOf(typedValue155.internalMethod08681()));
                if (typedValue155.internalMethod07951() == null) break;
                jsonObject.addProperty("error", typedValue155.internalMethod07951());
                break;
            }
            case "delete": {
                ScriptInternal083 typedValue155 = ScriptInternal073.internalMethod05405(ScriptInternal073.internalMethod00976(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430"));
                if (!typedValue155.internalMethod06690()) {
                    throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043a\u0440\u0438\u043f\u0442 " + string2);
                }
                jsonObject.addProperty("deleted", string2);
                break;
            }
            case "enable": 
            case "load": {
                typedValue154.internalMethod03942(ScriptInternal073.internalMethod00976(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430"), true);
                break;
            }
            case "disable": 
            case "unload": {
                typedValue154.internalMethod03942(ScriptInternal073.internalMethod00976(string2, "\u0438\u043c\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u0430"), false);
                break;
            }
            case "reload": {
                typedValue154.internalMethod07673();
                break;
            }
            default: {
                throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435: " + string);
            }
        }
        jsonObject.add("scripts", (JsonElement)ScriptInternal076.internalMethod02707());
        return jsonObject;
    }

    private static ScriptInternal083 internalMethod05405(String string) {
        ScriptInternal083 typedValue155 = ScriptInternal073.internalMethod07145(string);
        if (typedValue155 == null) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0442 \u0441\u043a\u0440\u0438\u043f\u0442\u0430 \"" + string + "\"");
        }
        return typedValue155;
    }

    private static ScriptInternal083 internalMethod07145(String string) {
        for (ScriptInternal083 typedValue155 : RockstarClient.getInstance().internalMethod04979().internalMethod02641()) {
            if (!ScriptInternal073.internalMethod01037(typedValue155.internalMethod01198()).equals(ScriptInternal073.internalMethod01037(string))) continue;
            return typedValue155;
        }
        return null;
    }

    private static String internalMethod05432(ScriptInternal083 typedValue155) {
        if (typedValue155.internalMethod05902() == null) {
            throw new NetworkInternal013.InternalType0086("\u0441\u043a\u0440\u0438\u043f\u0442 " + typedValue155.internalMethod01198() + " \u0437\u0430\u0449\u0438\u0449\u0451\u043d\u043d\u044b\u0439 (\u043a\u0443\u043f\u043b\u0435\u043d \u043d\u0430 \u0441\u0430\u0439\u0442\u0435) \u2014 \u0438\u0441\u0445\u043e\u0434\u043d\u0438\u043a\u0430 \u043d\u0435\u0442");
        }
        try {
            return Files.readString(typedValue155.internalMethod05902().toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException iOException) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u043b \u0441\u043a\u0440\u0438\u043f\u0442: " + iOException.getMessage());
        }
    }

    private static void internalMethod01845(String string, String string2) {
        File file = new File(ScriptInternal070.internalField0148, "scripts");
        if (!file.exists() && !file.mkdirs()) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0441\u043e\u0437\u0434\u0430\u043b \u043f\u0430\u043f\u043a\u0443 \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432");
        }
        Object object = string.endsWith(".py") ? string : string + ".py";
        try {
            Files.writeString(new File(file, (String)object).toPath(), (CharSequence)string2, StandardCharsets.UTF_8, new OpenOption[0]);
        }
        catch (IOException iOException) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0437\u0430\u043f\u0438\u0441\u0430\u043b \u0441\u043a\u0440\u0438\u043f\u0442: " + iOException.getMessage());
        }
    }

    public static JsonObject internalMethod05884(String string, String string2, String string3, String string4, JsonElement jsonElement) {
        FrameworkInternal001 typedValue108 = RockstarClient.getInstance().internalMethod00061();
        switch (string == null ? "state" : string.toLowerCase(Locale.ROOT)) {
            case "state": 
            case "list": {
                break;
            }
            case "apply": {
                ScriptInternal073.internalMethod00426(typedValue108, ScriptInternal073.internalMethod00976(string2, "\u0438\u043c\u044f \u043f\u0440\u0435\u0441\u0435\u0442\u0430"));
                break;
            }
            case "set": {
                List<Setting> list = switch (string3 == null ? "shared" : string3.toLowerCase(Locale.ROOT)) {
                    case "start" -> typedValue108.internalMethod04274().getSettings();
                    case "end" -> typedValue108.internalMethod05639().getSettings();
                    case "shared" -> typedValue108.internalMethod04275().getSettings();
                    default -> throw new NetworkInternal013.InternalType0086("phase \u0431\u044b\u0432\u0430\u0435\u0442 shared, start \u0438\u043b\u0438 end");
                };
                Object object = null;
                String string5 = ScriptInternal073.internalMethod01037(ScriptInternal073.internalMethod00976(string4, "\u0438\u043c\u044f \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438"));
                for (Setting typedValue157 : list) {
                    if (!ScriptInternal073.internalMethod01037(typedValue157.getName()).equals(string5) && !ScriptInternal073.internalMethod01037(typedValue157.getName()).endsWith("." + string5)) continue;
                    object = typedValue157;
                    break;
                }
                if (object == null) {
                    throw new NetworkInternal013.InternalType0086("\u0432 \u0444\u0430\u0437\u0435 \u043d\u0435\u0442 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \"" + string4 + "\"");
                }
                ScriptInternal073.internalMethod01035((Setting)object, jsonElement);
                RockstarClient.getInstance().internalMethod03371().internalMethod05165("client");
                break;
            }
            default: {
                throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435: " + string);
            }
        }
        return ScriptInternal076.internalMethod09577();
    }

    private static void internalMethod00426(FrameworkInternal001 typedValue108, String string) {
        String string2 = ScriptInternal073.internalMethod01037(string);
        for (CoreInternal051 object : typedValue108.internalMethod05754()) {
            if (!ScriptInternal073.internalMethod01037(object.internalMethod02665()).equals(string2) && !ScriptInternal073.internalMethod01037(LanguageManager.internalMethod07214(object.internalMethod02665())).equals(string2) && !ScriptInternal073.internalMethod01037(object.internalMethod02665()).endsWith("." + string2)) continue;
            typedValue108.internalMethod01403(object);
            RockstarClient.getInstance().internalMethod03371().internalMethod05165("client");
            return;
        }
        for (ConfigInternal025 typedValue117 : RockstarClient.getInstance().internalMethod01001().internalMethod01720()) {
            if (!ScriptInternal073.internalMethod01037(typedValue117.internalMethod02141()).equals(string2)) continue;
            typedValue117.internalMethod03765();
            RockstarClient.getInstance().internalMethod01001().internalMethod03314(typedValue117);
            RockstarClient.getInstance().internalMethod03371().internalMethod05165("client");
            return;
        }
        throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0442 \u043f\u0440\u0435\u0441\u0435\u0442\u0430 \u0441\u0432\u0438\u043d\u0433\u0430 \"" + string + "\"");
    }

    public static JsonObject internalMethod06444(String string) {
        if (string == null || string.isBlank()) {
            throw new NetworkInternal013.InternalType0086("\u043f\u0443\u0441\u0442\u043e\u0435 \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435");
        }
        if (MinecraftClientAccess.internalField0149.player == null || MinecraftClientAccess.internalField0149.getNetworkHandler() == null) {
            throw new NetworkInternal013.InternalType0086("\u0438\u0433\u0440\u043e\u043a \u043d\u0435 \u0432 \u0438\u0433\u0440\u0435 \u2014 \u043f\u0438\u0441\u0430\u0442\u044c \u043d\u0435\u043a\u0443\u0434\u0430");
        }
        String string2 = string.trim();
        JsonObject jsonObject = new JsonObject();
        String string3 = RockstarClient.getInstance().internalMethod05348().internalMethod03606();
        if (!string3.isEmpty() && string2.startsWith(string3 + string3)) {
            MinecraftClientAccess.internalField0149.getNetworkHandler().sendChatMessage(string2.substring(string3.length()));
            jsonObject.addProperty("sent", "\u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u0432 \u0447\u0430\u0442");
        } else if (!string3.isEmpty() && string2.startsWith(string3)) {
            RockstarClient.getInstance().internalMethod05348().internalMethod04610(string2);
            jsonObject.addProperty("sent", "\u043a\u043b\u0438\u0435\u043d\u0442\u0441\u043a\u0430\u044f \u043a\u043e\u043c\u0430\u043d\u0434\u0430");
        } else if (string2.startsWith("/")) {
            MinecraftClientAccess.internalField0149.getNetworkHandler().sendChatCommand(string2.substring(1));
            jsonObject.addProperty("sent", "\u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0430");
        } else {
            MinecraftClientAccess.internalField0149.getNetworkHandler().sendChatMessage(string2);
            jsonObject.addProperty("sent", "\u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u0432 \u0447\u0430\u0442");
        }
        jsonObject.addProperty("text", string2);
        return jsonObject;
    }

    public static JsonObject internalMethod05968(String string) {
        MenuModule typedValue321 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
        switch (string == null ? "open" : string.toLowerCase(Locale.ROOT)) {
            case "open": {
                if (typedValue321.isEnabled()) break;
                typedValue321.setEnabled(true, true);
                break;
            }
            case "close": {
                if (typedValue321.isEnabled()) {
                    typedValue321.setEnabled(false, true);
                }
                MinecraftClientAccess.internalField0149.setScreen(null);
                break;
            }
            case "toggle": {
                typedValue321.toggle();
                break;
            }
            default: {
                throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435: " + string);
            }
        }
        return ScriptInternal076.internalMethod08175();
    }

    public static JsonObject reloadResourcesForDiagnostics() {
        JsonObject result = new JsonObject();
        MinecraftClientAccess.internalField0149.execute(() -> MinecraftClientAccess.internalField0149
            .reloadResources()
            .whenComplete((ignored, error) -> {
                if (error == null) {
                    RockstarClient.internalField0572.info("[MCP] resource reload completed");
                } else {
                    RockstarClient.internalField0572.error("[MCP] resource reload failed", error);
                }
            }));
        result.addProperty("queued", true);
        return result;
    }

    public static int internalMethod04433(JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return 0;
        }
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            return jsonElement.getAsInt();
        }
        String string = jsonElement.getAsString().trim();
        if (string.isEmpty() || string.equalsIgnoreCase("none") || string.equalsIgnoreCase("\u043d\u0435\u0442")) {
            return 0;
        }
        int n = UiInternal033.internalMethod06543(string);
        if (n == -1) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0437\u043d\u0430\u044e \u043a\u043b\u0430\u0432\u0438\u0448\u0443 \"" + string + "\"");
        }
        return n;
    }

    private static boolean internalMethod04434(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
            return jsonElement.getAsBoolean();
        }
        String string = jsonElement.getAsString().trim().toLowerCase(Locale.ROOT);
        return string.equals("true") || string.equals("on") || string.equals("1") || string.equals("\u0434\u0430");
    }

    private static float internalMethod04432(JsonElement jsonElement) {
        try {
            return jsonElement.getAsFloat();
        }
        catch (Exception exception) {
            throw new NetworkInternal013.InternalType0086("\u043e\u0436\u0438\u0434\u0430\u043b\u043e\u0441\u044c \u0447\u0438\u0441\u043b\u043e, \u043f\u0440\u0438\u0448\u043b\u043e " + String.valueOf(jsonElement));
        }
    }

    private static String internalMethod02413(ModeSetting typedValue170) {
        ArrayList arrayList = new ArrayList();
        typedValue170.internalMethod06723().forEach(nestedValue2011 -> arrayList.add(nestedValue2011.getName()));
        return String.join((CharSequence)", ", arrayList);
    }

    private static String internalMethod05623(MultiSelectSetting typedValue173) {
        ArrayList arrayList = new ArrayList();
        typedValue173.internalMethod01792().forEach(nestedValue2013 -> arrayList.add(nestedValue2013.getName()));
        return String.join((CharSequence)", ", arrayList);
    }

    private static String internalMethod00976(String string, String string2) {
        if (string == null || string.isBlank()) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435 \u0443\u043a\u0430\u0437\u0430\u043d\u043e: " + string2);
        }
        return string.trim();
    }

    private static void internalMethod05437(ScriptInternal068 typedValue132, String string) {
        if (string == null || !typedValue132.internalMethod06090(string)) {
            throw new NetworkInternal013.InternalType0086("\u043d\u0435\u0442 \u043a\u043e\u043d\u0444\u0438\u0433\u0430 \"" + string + "\"; \u0435\u0441\u0442\u044c: " + String.join((CharSequence)", ", typedValue132.internalMethod07433()));
        }
    }

    private static void internalMethod06881() {
        RockstarClient.getInstance().internalMethod02152().internalMethod07804();
    }

    public static String internalMethod01037(String string) {
        return string == null ? "" : string.toLowerCase(Locale.ROOT).replace(" ", "").replace("_", "");
    }
}
