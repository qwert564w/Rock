package rockstar.client.internal.framework;




import rockstar.client.internal.media.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.time.LocalTime;
import java.util.Random;
import lombok.Generated;
import rockstar.modules.other.SoundsModule;
import rockstar.client.RockstarClient;
import rockstar.client.internal.media.MediaInternal001;
import rockstar.client.internal.core.CoreInternal125;

public final class FrameworkInternal008 {
    private static final Random internalField0362 = new Random();

    public static void internalMethod07535() {
        MediaInternal001 typedValue276 = switch (internalField0362.nextInt(4)) {
            case 0 -> CoreInternal125.internalField1431;
            case 1 -> CoreInternal125.internalField1430;
            default -> CoreInternal125.internalField1684;
        };
        typedValue276.internalMethod03864(FrameworkInternal008.internalMethod07534());
    }

    public static void internalMethod07538() {
        MediaInternal001 typedValue276 = switch (internalField0362.nextInt(4)) {
            case 0 -> CoreInternal125.internalField1690;
            case 1 -> CoreInternal125.internalField1838;
            default -> FrameworkInternal008.internalMethod06606();
        };
        typedValue276.internalMethod03864(FrameworkInternal008.internalMethod07534());
    }

    public static void internalMethod08440() {
        MediaInternal001 typedValue276 = switch (internalField0362.nextInt(8)) {
            case 0 -> CoreInternal125.internalField1677;
            case 1 -> CoreInternal125.internalField1682;
            case 2 -> CoreInternal125.internalField1676;
            case 3 -> CoreInternal125.internalField1683;
            case 4 -> CoreInternal125.internalField1680;
            case 5 -> CoreInternal125.internalField1687;
            case 6 -> CoreInternal125.internalField1688;
            default -> CoreInternal125.internalField1679;
        };
        typedValue276.internalMethod03864(FrameworkInternal008.internalMethod07534());
    }

    public static void internalMethod08441() {
        MediaInternal001 typedValue276 = switch (internalField0362.nextInt(4)) {
            case 0 -> CoreInternal125.internalField1837;
            case 1 -> CoreInternal125.internalField1835;
            default -> CoreInternal125.internalField1836;
        };
        typedValue276.internalMethod03864(FrameworkInternal008.internalMethod07534());
    }

    public static void internalMethod08455() {
        MediaInternal001 typedValue276 = switch (internalField0362.nextInt(4)) {
            case 0 -> CoreInternal125.internalField1678;
            case 1 -> CoreInternal125.internalField1681;
            default -> CoreInternal125.internalField1686;
        };
        typedValue276.internalMethod03864(FrameworkInternal008.internalMethod07534());
    }

    private static float internalMethod07534() {
        return RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class).internalMethod01798();
    }

    private static MediaInternal001 internalMethod06606() {
        LocalTime localTime = LocalTime.now();
        int n = localTime.getHour();
        if (n >= 6 && n < 12) {
            return CoreInternal125.internalField1685;
        }
        if (n >= 12 && n < 18) {
            return CoreInternal125.internalField1691;
        }
        return CoreInternal125.internalField1689;
    }

    @Generated
    private FrameworkInternal008() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
