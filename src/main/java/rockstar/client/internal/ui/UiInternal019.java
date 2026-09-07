package rockstar.client.internal.ui;




import rockstar.client.ui.*;
import rockstar.client.internal.network.*;
import rockstar.client.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import rockstar.client.ui.UiRenderContext;
import rockstar.client.internal.network.NetworkInternal016;
import rockstar.client.RockstarClient;
import rockstar.client.ui.ThemeColors;
import rockstar.client.MinecraftClientAccess;
import rockstar.client.ui.LegacyUiElement;

public class UiInternal019
extends LegacyUiElement
implements MinecraftClientAccess {
    private final int internalField0227;
    private int internalField0228 = 0;
    private long internalField0229 = 0L;
    private final NetworkInternal016 internalField0573 = new NetworkInternal016();
    private final Map<Integer, Integer> internalField0543 = new HashMap<Integer, Integer>();
    private NativeImageBackedTexture internalField0789;
    private final Identifier internalField0354;
    private float internalField1049 = 1.0f;
    private final NativeImage internalField0771;

    public UiInternal019(Identifier identifier, float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
        try {
            Resource resource = internalField0149.getResourceManager().getResourceOrThrow(identifier);
            this.internalField0573.internalMethod06978(resource.getInputStream());
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.internalField0227 = this.internalField0573.internalMethod07887();
        for (int i = 0; i < this.internalField0227; ++i) {
            this.internalField0543.put(i, this.internalField0573.internalMethod00920(i));
        }
        BufferedImage bufferedImage = this.internalField0573.internalMethod07338(0);
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        this.internalField0771 = new NativeImage(NativeImage.Format.RGBA, n, n2, false);
        this.internalField0789 = new NativeImageBackedTexture(() -> "Rockstar UI image", this.internalField0771);
        this.internalField0354 = RockstarClient.id("gif_texture_" + identifier.getPath().hashCode());
        internalField0149.getTextureManager().registerTexture(this.internalField0354, (AbstractTexture)this.internalField0789);
    }

    private void internalMethod05763(int n) {
        BufferedImage bufferedImage = this.internalField0573.internalMethod07338(n);
        for (int i = 0; i < bufferedImage.getHeight(); ++i) {
            for (int j = 0; j < bufferedImage.getWidth(); ++j) {
                int n2 = bufferedImage.getRGB(j, i);
                this.internalField0771.setColorArgb(j, i, n2);
            }
        }
        this.internalField0789.upload();
    }

    @Override
    public void internalMethod08744(UiRenderContext iII) {
        long l = System.currentTimeMillis();
        if (l - this.internalField0229 > (long)this.internalField0543.get(this.internalField0228).intValue()) {
            this.internalField0229 = l;
            this.internalField0228 = (this.internalField0228 + 1) % this.internalField0227;
            this.internalMethod05763(this.internalField0228);
        }
    }

    @Override
    public void internalMethod05619(UiRenderContext iII) {
        iII.drawTexture(this.internalField0354, this.internalField0205, this.internalField0206, this.internalField1048, this.internalField1047, ThemeColors.internalField1312.mulAlpha(this.internalField1049));
    }

    public void internalMethod06267() {
        if (this.internalField0789 != null) {
            internalField0149.getTextureManager().destroyTexture(this.internalField0354);
            this.internalField0789.close();
            this.internalField0789 = null;
        }
    }

    @Generated
    public void internalMethod08944(float f) {
        this.internalField1049 = f;
    }
}
