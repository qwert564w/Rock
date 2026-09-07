package pyrock.classes;





import rockstar.client.i18n.*;
import rockstar.client.asset.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.core.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Map;
import pyrock.utility.render.PyAssets;
import rockstar.client.internal.script.ScriptInternal083;
import rockstar.client.i18n.Language;
import rockstar.client.i18n.LanguageManager;
import rockstar.client.internal.core.CoreInternal063;
import rockstar.client.RockstarClient;
import rockstar.client.asset.FileDownloader;

public class PyLang {
    private static final Gson GSON = new Gson();

    public void add(String string, Map<String, String> map) {
        Language typedValue141 = CoreInternal063.internalMethod00068(string);
        if (typedValue141 == null) {
            throw new IllegalArgumentException("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u044f\u0437\u044b\u043a: " + string + " (\u0431\u044b\u0432\u0430\u044e\u0442 ru_ru, en_us, uk_ua, pl_pl)");
        }
        if (map == null) {
            return;
        }
        Object object = this.owner();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            CoreInternal063.internalMethod01132(object, typedValue141, entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    public void loadFile(String string) {
        if (FileDownloader.internalMethod06346(string)) {
            Path path2 = FileDownloader.internalMethod03010(string);
            if (path2 != null) {
                this.apply(this.read(path2), string);
                return;
            }
            Object object = this.owner();
            FileDownloader.internalMethod07340(string, path -> {
                try {
                    this.apply(this.read((Path)path), string, object);
                }
                catch (Exception exception) {
                    RockstarClient.internalField0572.warn("\u041f\u0435\u0440\u0435\u0432\u043e\u0434\u044b: {}", (Object)exception.getMessage());
                }
            });
            return;
        }
        Path path3 = PyAssets.resolve(string);
        if (!Files.isRegularFile(path3, new LinkOption[0])) {
            throw new IllegalArgumentException("\u0444\u0430\u0439\u043b\u0430 \u0441 \u043f\u0435\u0440\u0435\u0432\u043e\u0434\u0430\u043c\u0438 \u043d\u0435\u0442: " + String.valueOf(path3));
        }
        this.apply(this.read(path3), string);
    }

    public String get(String string) {
        return LanguageManager.internalMethod07214(string);
    }

    public String current() {
        return LanguageManager.internalMethod00625().internalMethod03875();
    }

    public boolean has(String string) {
        return CoreInternal063.internalMethod02060(string) || !LanguageManager.internalMethod07214(string).equals(string);
    }

    public void clear() {
        CoreInternal063.internalMethod00186(this.owner());
    }

    public String plural(double d, String string, String string2, String string3) {
        long l = Math.abs(Math.round(d));
        if (this.current().startsWith("en")) {
            return l == 1L ? string : string2;
        }
        long l2 = l % 100L;
        long l3 = l % 10L;
        if (l2 >= 11L && l2 <= 14L) {
            return string3;
        }
        if (l3 == 1L) {
            return string;
        }
        if (l3 >= 2L && l3 <= 4L) {
            return string2;
        }
        return string3;
    }

    private void apply(JsonObject jsonObject, String string) {
        this.apply(jsonObject, string, this.owner());
    }

    private void apply(JsonObject jsonObject, String string, Object object) {
        if (jsonObject == null) {
            return;
        }
        for (Map.Entry entry : jsonObject.entrySet()) {
            Language typedValue141 = CoreInternal063.internalMethod00068((String)entry.getKey());
            if (typedValue141 == null || !((JsonElement)entry.getValue()).isJsonObject()) {
                RockstarClient.internalField0572.warn("\u041f\u0435\u0440\u0435\u0432\u043e\u0434\u044b: \u043d\u0435\u043f\u043e\u043d\u044f\u0442\u043d\u044b\u0439 \u044f\u0437\u044b\u043a {} \u0432 {}", entry.getKey(), (Object)string);
                continue;
            }
            for (Map.Entry entry2 : ((JsonElement)entry.getValue()).getAsJsonObject().entrySet()) {
                if (!((JsonElement)entry2.getValue()).isJsonPrimitive()) continue;
                CoreInternal063.internalMethod01132(object, typedValue141, (String)entry2.getKey(), ((JsonElement)entry2.getValue()).getAsString());
            }
        }
    }

    private JsonObject read(Path path) {
        try {
            return (JsonObject)GSON.fromJson(Files.readString(path), JsonObject.class);
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("\u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f \u0444\u0430\u0439\u043b \u043f\u0435\u0440\u0435\u0432\u043e\u0434\u043e\u0432 " + String.valueOf(path) + ": " + exception.getMessage(), exception);
        }
    }

    private Object owner() {
        ScriptInternal083 typedValue155 = ScriptInternal083.internalMethod00581();
        return typedValue155 != null ? typedValue155 : this;
    }
}

