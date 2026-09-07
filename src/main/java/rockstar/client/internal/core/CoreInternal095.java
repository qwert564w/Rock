package rockstar.client.internal.core;



import rockstar.client.internal.script.*;
import rockstar.client.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rockstar.client.internal.script.ScriptInternal147;
import rockstar.client.internal.core.CoreInternal098;
import rockstar.client.internal.core.CoreInternal099;
import rockstar.client.internal.core.CoreInternal100;
import rockstar.client.internal.core.CoreInternal102;

public class CoreInternal095 {
    private final String internalField0248;
    private final Map<String, CoreInternal098> internalField0543;
    private final Map<String, CoreInternal100> internalField0544;
    private final Set<String> internalField0546;
    private boolean internalField0277 = true;

    public CoreInternal095(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression can not be empty");
        }
        this.internalField0248 = string;
        this.internalField0544 = new HashMap<String, CoreInternal100>(4);
        this.internalField0543 = new HashMap<String, CoreInternal098>(4);
        this.internalField0546 = new HashSet<String>(4);
    }

    public CoreInternal095 internalMethod03206(CoreInternal098 typedValue238) {
        this.internalField0543.put(typedValue238.internalMethod04838(), typedValue238);
        return this;
    }

    public CoreInternal095 internalMethod01831(CoreInternal098 ... iIiIIiIII_Class329Array) {
        for (CoreInternal098 typedValue238 : iIiIIiIII_Class329Array) {
            this.internalField0543.put(typedValue238.internalMethod04838(), typedValue238);
        }
        return this;
    }

    public CoreInternal095 internalMethod03859(List<CoreInternal098> list) {
        for (CoreInternal098 typedValue238 : list) {
            this.internalField0543.put(typedValue238.internalMethod04838(), typedValue238);
        }
        return this;
    }

    public CoreInternal095 internalMethod02756(Set<String> set) {
        this.internalField0546.addAll(set);
        return this;
    }

    public CoreInternal095 internalMethod04828(String ... stringArray) {
        Collections.addAll(this.internalField0546, stringArray);
        return this;
    }

    public CoreInternal095 internalMethod04588(String string) {
        this.internalField0546.add(string);
        return this;
    }

    public CoreInternal095 internalMethod05045(boolean bl) {
        this.internalField0277 = bl;
        return this;
    }

    public void internalMethod05207(CoreInternal100 typedValue239) {
        this.internalMethod02027(typedValue239);
        this.internalField0544.put(typedValue239.internalMethod00746(), typedValue239);
    }

    private void internalMethod02027(CoreInternal100 typedValue239) {
        String string = typedValue239.internalMethod00746();
        for (char c : string.toCharArray()) {
            if (CoreInternal100.internalMethod02426(c)) continue;
            throw new IllegalArgumentException("The operator symbol '" + string + "' is invalid");
        }
    }

    public CoreInternal095 internalMethod06791(CoreInternal100 ... iIiIIiIiI_Class331Array) {
        for (CoreInternal100 typedValue239 : iIiIIiIiI_Class331Array) {
            this.internalMethod05207(typedValue239);
        }
        return this;
    }

    public CoreInternal095 internalMethod05395(List<CoreInternal100> list) {
        for (CoreInternal100 typedValue239 : list) {
            this.internalMethod05207(typedValue239);
        }
        return this;
    }

    public ScriptInternal147 internalMethod05680() {
        if (this.internalField0248.isEmpty()) {
            throw new IllegalArgumentException("The expression can not be empty");
        }
        this.internalField0546.add("pi");
        this.internalField0546.add("\u03c0");
        this.internalField0546.add("e");
        this.internalField0546.add("\u03c6");
        for (String string : this.internalField0546) {
            if (CoreInternal099.internalMethod03979(string) == null && !this.internalField0543.containsKey(string)) continue;
            throw new IllegalArgumentException("A variable can not have the same name as a function [" + string + "]");
        }
        return new ScriptInternal147(CoreInternal102.internalMethod07162(this.internalField0248, this.internalField0543, this.internalField0544, this.internalField0546, this.internalField0277), this.internalField0543.keySet());
    }
}

