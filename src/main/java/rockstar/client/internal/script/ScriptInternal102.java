package rockstar.client.internal.script;





import rockstar.client.ui.*;
import rockstar.client.internal.ui.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.internal.core.CoreInternal078;
import rockstar.client.internal.ui.UiInternal021;
import rockstar.client.internal.script.ScriptInternal106;
import rockstar.client.internal.script.ScriptInternal112;
import rockstar.client.RockstarClient;
import rockstar.client.ui.ScreenMetricsAccess;

public class ScriptInternal102 {
    private final List<CoreInternal078> internalField0416 = new ArrayList<CoreInternal078>();

    public void internalMethod05682(CustomDrawContext customDrawContext) {
        for (CoreInternal078 typedValue195 : this.internalField0416) {
            if (!typedValue195.internalMethod05367()) continue;
            float f = typedValue195.internalMethod04528() == CoreInternal078.InternalType0164.internalField0502 ? typedValue195.internalMethod05366() - 0.5f : 0.0f;
            float f2 = typedValue195.internalMethod04528() == CoreInternal078.InternalType0164.internalField0501 ? typedValue195.internalMethod05366() - 0.5f : 0.0f;
            float f3 = typedValue195.internalMethod04528() == CoreInternal078.InternalType0164.internalField0502 ? 1.0f : ScreenMetricsAccess.internalField0389.internalMethod03585();
            float f4 = typedValue195.internalMethod04528() == CoreInternal078.InternalType0164.internalField0501 ? 1.0f : ScreenMetricsAccess.internalField0389.internalMethod03589();
            customDrawContext.drawRect(f, f2, f3, f4, ColorRGBA.WHITE.mulAlpha(0.3f));
        }
    }

    public void internalMethod02073() {
        this.internalField0416.clear();
        this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0502, 0.0f));
        this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0502, ScreenMetricsAccess.internalField0389.internalMethod03585() * 0.5f));
        this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0502, ScreenMetricsAccess.internalField0389.internalMethod03585()));
        this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0501, 0.0f));
        this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0501, ScreenMetricsAccess.internalField0389.internalMethod03589() * 0.5f));
        this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0501, ScreenMetricsAccess.internalField0389.internalMethod03589()));
        for (UiInternal021 typedValue197 : RockstarClient.getInstance().internalMethod01271().internalMethod09520()) {
            if (!typedValue197.isShowing() || typedValue197.isDragging() || typedValue197 instanceof ScriptInternal112 || typedValue197 instanceof ScriptInternal106) continue;
            this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0501, typedValue197.y));
            this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0501, typedValue197.y + typedValue197.height * 0.5f));
            this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0501, typedValue197.y + typedValue197.height));
            this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0502, typedValue197.x));
            this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0502, typedValue197.x + typedValue197.width * 0.5f));
            this.internalField0416.add(new CoreInternal078(CoreInternal078.InternalType0164.internalField0502, typedValue197.x + typedValue197.width));
        }
    }

    @Generated
    public List<CoreInternal078> internalMethod00333() {
        return this.internalField0416;
    }
}

