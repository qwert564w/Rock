package rockstar.client.internal.core;


import rockstar.client.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import rockstar.client.internal.core.CoreInternal098;
import rockstar.client.internal.core.CoreInternal100;
import rockstar.client.internal.core.CoreInternal108;
import rockstar.client.internal.core.CoreInternal109;
import rockstar.client.internal.core.CoreInternal110;

public class CoreInternal102 {
    public static CoreInternal109[] internalMethod07162(String string, Map<String, CoreInternal098> map, Map<String, CoreInternal100> map2, Set<String> set, boolean bl) {
        CoreInternal109 typedValue243;
        Stack<CoreInternal109> stack = new Stack<CoreInternal109>();
        ArrayList<CoreInternal109> arrayList = new ArrayList<CoreInternal109>();
        CoreInternal110 typedValue244 = new CoreInternal110(string, map, map2, set, bl);
        block8: while (typedValue244.internalMethod02671()) {
            typedValue243 = typedValue244.internalMethod03330();
            switch (typedValue243.internalMethod01431()) {
                case 1: 
                case 6: {
                    arrayList.add(typedValue243);
                    continue block8;
                }
                case 3: {
                    stack.add(typedValue243);
                    continue block8;
                }
                case 7: {
                    while (!stack.empty() && ((CoreInternal109)stack.peek()).internalMethod01431() != 4) {
                        arrayList.add((CoreInternal109)stack.pop());
                    }
                    if (!stack.empty() && ((CoreInternal109)stack.peek()).internalMethod01431() == 4) continue block8;
                    throw new IllegalArgumentException("Misplaced function separator ',' or mismatched parentheses");
                }
                case 2: {
                    while (!stack.empty() && ((CoreInternal109)stack.peek()).internalMethod01431() == 2) {
                        CoreInternal108 typedValue241 = (CoreInternal108)typedValue243;
                        CoreInternal108 typedValue242 = (CoreInternal108)stack.peek();
                        if (typedValue241.internalMethod02443().internalMethod01042() == 1 && typedValue242.internalMethod02443().internalMethod01042() == 2 || (!typedValue241.internalMethod02443().internalMethod01043() || typedValue241.internalMethod02443().internalMethod01076() > typedValue242.internalMethod02443().internalMethod01076()) && typedValue241.internalMethod02443().internalMethod01076() >= typedValue242.internalMethod02443().internalMethod01076()) break;
                        arrayList.add((CoreInternal109)stack.pop());
                    }
                    stack.push(typedValue243);
                    continue block8;
                }
                case 4: {
                    stack.push(typedValue243);
                    continue block8;
                }
                case 5: {
                    while (((CoreInternal109)stack.peek()).internalMethod01431() != 4) {
                        arrayList.add((CoreInternal109)stack.pop());
                    }
                    stack.pop();
                    if (stack.isEmpty() || ((CoreInternal109)stack.peek()).internalMethod01431() != 3) continue block8;
                    arrayList.add((CoreInternal109)stack.pop());
                    continue block8;
                }
            }
            throw new IllegalArgumentException("Unknown Token type encountered. This should not happen");
        }
        while (!stack.empty()) {
            typedValue243 = (CoreInternal109)stack.pop();
            if (typedValue243.internalMethod01431() == 5 || typedValue243.internalMethod01431() == 4) {
                throw new IllegalArgumentException("Mismatched parentheses detected. Please check the expression");
            }
            arrayList.add(typedValue243);
        }
        return arrayList.toArray(new CoreInternal109[0]);
    }
}

