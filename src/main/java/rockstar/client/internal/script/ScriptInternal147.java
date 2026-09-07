package rockstar.client.internal.script;



import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import rockstar.client.internal.core.CoreInternal094;
import rockstar.client.internal.core.CoreInternal097;
import rockstar.client.internal.core.CoreInternal098;
import rockstar.client.internal.core.CoreInternal099;
import rockstar.client.internal.core.CoreInternal100;
import rockstar.client.internal.core.CoreInternal105;
import rockstar.client.internal.core.CoreInternal106;
import rockstar.client.internal.core.CoreInternal108;
import rockstar.client.internal.core.CoreInternal109;
import rockstar.client.internal.core.CoreInternal112;

public class ScriptInternal147 {
    private final CoreInternal109[] internalField0167;
    private final Map<String, Double> internalField0543;
    private final Set<String> internalField0546;

    private static Map<String, Double> internalMethod04218() {
        HashMap<String, Double> hashMap = new HashMap<String, Double>(4);
        hashMap.put("pi", Math.PI);
        hashMap.put("\u03c0", Math.PI);
        hashMap.put("\u03c6", 1.61803398874);
        hashMap.put("e", Math.E);
        return hashMap;
    }

    public ScriptInternal147(ScriptInternal147 typedValue236) {
        this.internalField0167 = Arrays.copyOf(typedValue236.internalField0167, typedValue236.internalField0167.length);
        this.internalField0543 = new HashMap<String, Double>();
        this.internalField0543.putAll(typedValue236.internalField0543);
        this.internalField0546 = new HashSet<String>(typedValue236.internalField0546);
    }

    public ScriptInternal147(CoreInternal109[] iIiIiIIii_Class340Array) {
        this.internalField0167 = iIiIiIIii_Class340Array;
        this.internalField0543 = ScriptInternal147.internalMethod04218();
        this.internalField0546 = Collections.emptySet();
    }

    public ScriptInternal147(CoreInternal109[] iIiIiIIii_Class340Array, Set<String> set) {
        this.internalField0167 = iIiIiIIii_Class340Array;
        this.internalField0543 = ScriptInternal147.internalMethod04218();
        this.internalField0546 = set;
    }

    public void internalMethod07284(String string, double d) {
        this.internalMethod05077(string);
        this.internalField0543.put(string, d);
    }

    private void internalMethod05077(String string) {
        if (this.internalField0546.contains(string) || CoreInternal099.internalMethod03979(string) != null) {
            throw new IllegalArgumentException("The variable name '" + string + "' is invalid. Since there exists a function with the same name");
        }
    }

    public ScriptInternal147 internalMethod01084(Map<String, Double> map) {
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            this.internalMethod07284(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public ScriptInternal147 internalMethod05521() {
        this.internalField0543.clear();
        return this;
    }

    public Set<String> internalMethod04219() {
        HashSet<String> hashSet = new HashSet<String>();
        for (CoreInternal109 typedValue243 : this.internalField0167) {
            if (typedValue243.internalMethod01431() != 6) continue;
            hashSet.add(((CoreInternal112)typedValue243).internalMethod04449());
        }
        return hashSet;
    }

    public CoreInternal097 internalMethod07150(boolean bl) {
        ArrayList<String> arrayList = new ArrayList<String>(0);
        if (bl) {
            for (CoreInternal109 typedValue243 : this.internalField0167) {
                String object;
                if (typedValue243.internalMethod01431() != 6 || this.internalField0543.containsKey(object = ((CoreInternal112)typedValue243).internalMethod04449())) continue;
                arrayList.add("The setVariable '" + object + "' has not been set");
            }
        }
        int n = 0;
        for (CoreInternal109 typedValue243 : this.internalField0167) {
            switch (typedValue243.internalMethod01431()) {
                case 1: 
                case 6: {
                    ++n;
                    break;
                }
                case 3: {
                    CoreInternal098 typedValue238 = ((CoreInternal105)typedValue243).internalMethod02363();
                    int n2 = typedValue238.internalMethod02745();
                    if (n2 > n) {
                        arrayList.add("Not enough arguments for '" + typedValue238.internalMethod04838() + "'");
                    }
                    if (n2 > 1) {
                        n -= n2 - 1;
                        break;
                    }
                    if (n2 != 0) break;
                    ++n;
                    break;
                }
                case 2: {
                    CoreInternal100 typedValue239 = ((CoreInternal108)typedValue243).internalMethod02443();
                    if (typedValue239.internalMethod01042() != 2) break;
                    --n;
                }
            }
            if (n >= 1) continue;
            arrayList.add("Too many operators");
            return new CoreInternal097(false, arrayList);
        }
        if (n > 1) {
            arrayList.add("Too many operands");
        }
        return arrayList.isEmpty() ? CoreInternal097.internalField0369 : new CoreInternal097(false, arrayList);
    }

    public CoreInternal097 internalMethod05522() {
        return this.internalMethod07150(true);
    }

    public Future<Double> internalMethod06566(ExecutorService executorService) {
        return executorService.submit(this::internalMethod06442);
    }

    public double internalMethod06442() {
        CoreInternal094 typedValue235 = new CoreInternal094();
        for (CoreInternal109 typedValue243 : this.internalField0167) {
            Object object;
            if (typedValue243.internalMethod01431() == 1) {
                typedValue235.internalMethod06182(((CoreInternal106)typedValue243).internalMethod02759());
                continue;
            }
            if (typedValue243.internalMethod01431() == 6) {
                object = ((CoreInternal112)typedValue243).internalMethod04449();
                Double d = this.internalField0543.get(object);
                if (d == null) {
                    throw new IllegalArgumentException("No value has been set for the setVariable '" + (String)object + "'.");
                }
                typedValue235.internalMethod06182(d);
                continue;
            }
            if (typedValue243.internalMethod01431() == 2) {
                object = (CoreInternal108)typedValue243;
                if (typedValue235.internalMethod03377() < ((CoreInternal108)object).internalMethod02443().internalMethod01042()) {
                    throw new IllegalArgumentException("Invalid number of operands available for '" + ((CoreInternal108)object).internalMethod02443().internalMethod00746() + "' operator");
                }
                if (((CoreInternal108)object).internalMethod02443().internalMethod01042() == 2) {
                    double d = typedValue235.internalMethod03379();
                    double d2 = typedValue235.internalMethod03379();
                    typedValue235.internalMethod06182(((CoreInternal108)object).internalMethod02443().internalMethod07375(d2, d));
                    continue;
                }
                if (((CoreInternal108)object).internalMethod02443().internalMethod01042() != 1) continue;
                double d = typedValue235.internalMethod03379();
                typedValue235.internalMethod06182(((CoreInternal108)object).internalMethod02443().internalMethod07375(d));
                continue;
            }
            if (typedValue243.internalMethod01431() != 3) continue;
            object = (CoreInternal105)typedValue243;
            int n = ((CoreInternal105)object).internalMethod02363().internalMethod02745();
            if (typedValue235.internalMethod03377() < n) {
                throw new IllegalArgumentException("Invalid number of arguments available for '" + ((CoreInternal105)object).internalMethod02363().internalMethod04838() + "' function");
            }
            double[] dArray = new double[n];
            for (int i = n - 1; i >= 0; --i) {
                dArray[i] = typedValue235.internalMethod03379();
            }
            typedValue235.internalMethod06182(((CoreInternal105)object).internalMethod02363().internalMethod03000(dArray));
        }
        if (typedValue235.internalMethod03377() > 1) {
            throw new IllegalArgumentException("Invalid number of items on the output queue. Might be caused by an invalid number of arguments for a function.");
        }
        return typedValue235.internalMethod03379();
    }
}

