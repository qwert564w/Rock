package rockstar.client.internal.core;


import rockstar.client.*;
import java.util.Map;
import java.util.Set;
import rockstar.client.internal.core.CoreInternal098;
import rockstar.client.internal.core.CoreInternal099;
import rockstar.client.internal.core.CoreInternal100;
import rockstar.client.internal.core.CoreInternal101;
import rockstar.client.internal.core.CoreInternal103;
import rockstar.client.internal.core.CoreInternal104;
import rockstar.client.internal.core.CoreInternal105;
import rockstar.client.internal.core.CoreInternal106;
import rockstar.client.internal.core.CoreInternal107;
import rockstar.client.internal.core.CoreInternal108;
import rockstar.client.internal.core.CoreInternal109;
import rockstar.client.internal.core.CoreInternal111;
import rockstar.client.internal.core.CoreInternal112;

public class CoreInternal110 {
    private final char[] internalField0611;
    private final int internalField0227;
    private final Map<String, CoreInternal098> internalField0543;
    private final Map<String, CoreInternal100> internalField0544;
    private final Set<String> internalField0546;
    private final boolean internalField0277;
    private int internalField0228 = 0;
    private CoreInternal109 internalField0552;

    public CoreInternal110(String string, Map<String, CoreInternal098> map, Map<String, CoreInternal100> map2, Set<String> set, boolean bl) {
        this.internalField0611 = string.trim().toCharArray();
        this.internalField0227 = this.internalField0611.length;
        this.internalField0543 = map;
        this.internalField0544 = map2;
        this.internalField0546 = set;
        this.internalField0277 = bl;
    }

    public CoreInternal110(String string, Map<String, CoreInternal098> map, Map<String, CoreInternal100> map2, Set<String> set) {
        this.internalField0611 = string.trim().toCharArray();
        this.internalField0227 = this.internalField0611.length;
        this.internalField0543 = map;
        this.internalField0544 = map2;
        this.internalField0546 = set;
        this.internalField0277 = true;
    }

    public boolean internalMethod02671() {
        return this.internalField0611.length > this.internalField0228;
    }

    public CoreInternal109 internalMethod03330() {
        char c = this.internalField0611[this.internalField0228];
        while (Character.isWhitespace(c)) {
            c = this.internalField0611[++this.internalField0228];
        }
        if (Character.isDigit(c) || c == '.') {
            if (this.internalField0552 != null) {
                if (this.internalField0552.internalMethod01431() == 1) {
                    throw new IllegalArgumentException("Unable to parse char '" + c + "' (Code:" + c + ") at [" + this.internalField0228 + "]");
                }
                if (this.internalField0277 && this.internalField0552.internalMethod01431() != 2 && this.internalField0552.internalMethod01431() != 4 && this.internalField0552.internalMethod01431() != 3 && this.internalField0552.internalMethod01431() != 7) {
                    this.internalField0552 = new CoreInternal108(CoreInternal101.internalMethod00317('*', 2));
                    return this.internalField0552;
                }
            }
            return this.internalMethod03688(c);
        }
        if (this.internalMethod07474(c)) {
            return this.internalMethod04057();
        }
        if (this.internalMethod07529(c)) {
            if (this.internalField0552 != null && this.internalField0277 && this.internalField0552.internalMethod01431() != 2 && this.internalField0552.internalMethod01431() != 4 && this.internalField0552.internalMethod01431() != 3 && this.internalField0552.internalMethod01431() != 7) {
                this.internalField0552 = new CoreInternal108(CoreInternal101.internalMethod00317('*', 2));
                return this.internalField0552;
            }
            return this.internalMethod04518(true);
        }
        if (this.internalMethod08109(c)) {
            return this.internalMethod04518(false);
        }
        if (CoreInternal100.internalMethod02426(c)) {
            return this.internalMethod06827(c);
        }
        if (CoreInternal110.internalMethod07475(c) || c == '_') {
            if (this.internalField0552 != null && this.internalField0277 && this.internalField0552.internalMethod01431() != 2 && this.internalField0552.internalMethod01431() != 4 && this.internalField0552.internalMethod01431() != 3 && this.internalField0552.internalMethod01431() != 7) {
                this.internalField0552 = new CoreInternal108(CoreInternal101.internalMethod00317('*', 2));
                return this.internalField0552;
            }
            return this.internalMethod08571();
        }
        throw new IllegalArgumentException("Unable to parse char '" + c + "' (Code:" + c + ") at [" + this.internalField0228 + "]");
    }

    private CoreInternal109 internalMethod04057() {
        ++this.internalField0228;
        this.internalField0552 = new CoreInternal103();
        return this.internalField0552;
    }

    private boolean internalMethod07474(char c) {
        return c == ',';
    }

    private CoreInternal109 internalMethod04518(boolean bl) {
        this.internalField0552 = bl ? new CoreInternal107() : new CoreInternal104();
        ++this.internalField0228;
        return this.internalField0552;
    }

    private boolean internalMethod07529(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean internalMethod08109(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private CoreInternal109 internalMethod08571() {
        int n = this.internalField0228++;
        int n2 = 1;
        CoreInternal109 typedValue243 = null;
        int n3 = 1;
        if (this.internalMethod08110(n)) {
            // empty if block
        }
        int n4 = n + n3 - 1;
        while (!this.internalMethod08110(n4) && CoreInternal110.internalMethod07530(this.internalField0611[n4])) {
            String string = new String(this.internalField0611, n, n3);
            if (this.internalField0546 != null && this.internalField0546.contains(string)) {
                n2 = n3;
                typedValue243 = new CoreInternal112(string);
            } else {
                CoreInternal098 typedValue238 = this.internalMethod05110(string);
                if (typedValue238 != null) {
                    n2 = n3;
                    typedValue243 = new CoreInternal105(typedValue238);
                }
            }
            n4 = n + ++n3 - 1;
        }
        if (typedValue243 == null) {
            throw new CoreInternal111(new String(this.internalField0611), this.internalField0228, n3);
        }
        this.internalField0228 += n2;
        this.internalField0552 = typedValue243;
        return this.internalField0552;
    }

    private CoreInternal098 internalMethod05110(String string) {
        CoreInternal098 typedValue238 = null;
        if (this.internalField0543 != null) {
            typedValue238 = this.internalField0543.get(string);
        }
        if (typedValue238 == null) {
            typedValue238 = CoreInternal099.internalMethod03979(string);
        }
        return typedValue238;
    }

    private CoreInternal109 internalMethod06827(char c) {
        int n = this.internalField0228;
        int n2 = 1;
        StringBuilder stringBuilder = new StringBuilder();
        CoreInternal100 typedValue239 = null;
        stringBuilder.append(c);
        while (!this.internalMethod08110(n + n2) && CoreInternal100.internalMethod02426(this.internalField0611[n + n2])) {
            stringBuilder.append(this.internalField0611[n + n2++]);
        }
        while (!stringBuilder.isEmpty()) {
            CoreInternal100 typedValue240 = this.internalMethod05111(stringBuilder.toString());
            if (typedValue240 == null) {
                stringBuilder.setLength(stringBuilder.length() - 1);
                continue;
            }
            typedValue239 = typedValue240;
            break;
        }
        this.internalField0228 += stringBuilder.length();
        this.internalField0552 = new CoreInternal108(typedValue239);
        return this.internalField0552;
    }

    private CoreInternal100 internalMethod05111(String string) {
        CoreInternal100 typedValue239 = null;
        if (this.internalField0544 != null) {
            typedValue239 = this.internalField0544.get(string);
        }
        if (typedValue239 == null && string.length() == 1) {
            int n = 2;
            if (this.internalField0552 == null) {
                n = 1;
            } else {
                CoreInternal100 typedValue240;
                int n2 = this.internalField0552.internalMethod01431();
                if (n2 == 4 || n2 == 7) {
                    n = 1;
                } else if (n2 == 2 && ((typedValue240 = ((CoreInternal108)this.internalField0552).internalMethod02443()).internalMethod01042() == 2 || typedValue240.internalMethod01042() == 1 && !typedValue240.internalMethod01043())) {
                    n = 1;
                }
            }
            typedValue239 = CoreInternal101.internalMethod00317(string.charAt(0), n);
        }
        return typedValue239;
    }

    private CoreInternal109 internalMethod03688(char c) {
        int n;
        int n2 = 1;
        if (this.internalMethod08110((n = this.internalField0228++) + n2)) {
            this.internalField0552 = new CoreInternal106(Double.parseDouble(String.valueOf(c)));
            return this.internalField0552;
        }
        while (!this.internalMethod08110(n + n2) && CoreInternal110.internalMethod02150(this.internalField0611[n + n2], this.internalField0611[n + n2 - 1] == 'e' || this.internalField0611[n + n2 - 1] == 'E')) {
            ++n2;
            ++this.internalField0228;
        }
        if (this.internalField0611[n + n2 - 1] == 'e' || this.internalField0611[n + n2 - 1] == 'E') {
            --n2;
            --this.internalField0228;
        }
        this.internalField0552 = new CoreInternal106(this.internalField0611, n, n2);
        return this.internalField0552;
    }

    private static boolean internalMethod02150(char c, boolean bl) {
        return Character.isDigit(c) || c == '.' || c == 'e' || c == 'E' || bl && (c == '-' || c == '+');
    }

    public static boolean internalMethod07475(int n) {
        return Character.isLetter(n);
    }

    public static boolean internalMethod07530(int n) {
        return CoreInternal110.internalMethod07475(n) || Character.isDigit(n) || n == 95 || n == 46;
    }

    private boolean internalMethod08110(int n) {
        return this.internalField0227 <= n;
    }
}

