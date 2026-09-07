package rockstar.client.ui;


import rockstar.client.*;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.ui.QuadColorGradient;

public class HorizontalColorGradient
extends QuadColorGradient {
    public HorizontalColorGradient(ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        super(colorRGBA, colorRGBA2, colorRGBA2, colorRGBA);
    }

    @Override
    public HorizontalColorGradient internalMethod01936() {
        return new HorizontalColorGradient(this.internalField1311, this.internalField0776);
    }
}

