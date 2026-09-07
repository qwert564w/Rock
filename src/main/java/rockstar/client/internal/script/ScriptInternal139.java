package rockstar.client.internal.script;



import rockstar.client.animation.*;
import rockstar.client.*;
import rockstar.client.compat.RenderSystem;
import lombok.Generated;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.animation.AnimatedValue;
import rockstar.client.animation.Easing;
import rockstar.client.MinecraftClientAccess;

public class ScriptInternal139
implements MinecraftClientAccess {
    private Vec3d internalField0283;
    private Vec3d internalField0282;
    private Vec3d internalField1104;
    private float internalField0205 = 3.0f;
    private final Identifier internalField0354;
    private int internalField0227;
    private int internalField0228 = 100;
    private double internalField0194 = 0.04;
    private boolean internalField0277;
    private boolean internalField0276;
    private final AnimatedValue internalField0808;
    private final AnimatedValue internalField0809;
    private final ColorRGBA internalField0777;

    public ScriptInternal139(Vec3d vec3d, Vec3d vec3d2, Identifier identifier, ColorRGBA colorRGBA) {
        this.internalField0283 = vec3d;
        this.internalField0282 = vec3d;
        this.internalField1104 = vec3d2;
        this.internalField0354 = identifier;
        this.internalField0777 = colorRGBA;
        this.internalField0227 = 0;
        long l = this.internalField0228 * 5;
        this.internalField0808 = new AnimatedValue(l, Easing.internalField1814);
        this.internalField0809 = new AnimatedValue(l, Easing.internalField1627);
        this.internalField0277 = true;
    }

    public void internalMethod01225() {
        ++this.internalField0227;
        if (this.internalField0227 >= this.internalField0228) {
            this.internalMethod01230();
        }
        this.internalField0282 = this.internalField0283;
        this.internalField0283 = this.internalField0283.add(this.internalField1104);
    }

    public void internalMethod06661(BufferBuilder bufferBuilder, Camera camera) {
        this.internalField0808.internalMethod07059(this.internalMethod01226() ? 0.0f : 1.0f);
        this.internalField0809.internalMethod07059(this.internalMethod01226() ? 0.0f : 1.0f);
        float f = 10.0f;
        ColorRGBA colorRGBA = ColorRGBA.fromInt(this.internalField0777.getRGB()).withAlpha(255.0f * this.internalField0808.internalMethod02881());
        RenderSystem.setShaderTexture((int)0, (Identifier)this.internalField0354);
        MatrixStack matrixStack = new MatrixStack();
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(camera.getPitch()));
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(camera.getYaw() + 180.0f));
        Vec3d vec3d = this.internalMethod05116(this.internalField0282, this.internalField0283);
        matrixStack.translate(vec3d.getX(), vec3d.getY(), vec3d.getZ());
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-camera.getYaw()));
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(camera.getPitch()));
        bufferBuilder.vertex(matrix4f, 0.0f, -f, 0.0f).texture(0.0f, 1.0f).color(colorRGBA.getRGB());
        bufferBuilder.vertex(matrix4f, -f, -f, 0.0f).texture(1.0f, 1.0f).color(colorRGBA.getRGB());
        bufferBuilder.vertex(matrix4f, -f, 0.0f, 0.0f).texture(1.0f, 0.0f).color(colorRGBA.getRGB());
        bufferBuilder.vertex(matrix4f, 0.0f, 0.0f, 0.0f).texture(0.0f, 0.0f).color(colorRGBA.getRGB());
    }

    public void internalMethod01938(double d, double d2, double d3) {
        this.internalField0283 = new Vec3d(d, d2, d3);
    }

    public void internalMethod06880(double d, double d2, double d3) {
        this.internalField1104 = new Vec3d(d, d2, d3);
    }

    private void internalMethod01230() {
        this.internalField0277 = false;
    }

    public boolean internalMethod01226() {
        return !this.internalField0277;
    }

    public boolean internalMethod01231() {
        return this.internalMethod01226() && this.internalField0808.internalMethod02881() == 0.0f;
    }

    private Vec3d internalMethod05116(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d.getX() + (vec3d2.getX() - vec3d.getX()) * (double)ScriptInternal139.internalMethod01228() - ScriptInternal139.internalField0149.getEntityRenderDispatcher().camera.getCameraPos().getX();
        double d2 = vec3d.getY() + (vec3d2.getY() - vec3d.getY()) * (double)ScriptInternal139.internalMethod01228() - ScriptInternal139.internalField0149.getEntityRenderDispatcher().camera.getCameraPos().getY();
        double d3 = vec3d.getZ() + (vec3d2.getZ() - vec3d.getZ()) * (double)ScriptInternal139.internalMethod01228() - ScriptInternal139.internalField0149.getEntityRenderDispatcher().camera.getCameraPos().getZ();
        return new Vec3d(d, d2, d3);
    }

    private static float internalMethod01228() {
        return internalField0149.getRenderTickCounter().getTickProgress(false);
    }

    @Generated
    public Vec3d internalMethod04795() {
        return this.internalField0283;
    }

    @Generated
    public Vec3d internalMethod01832() {
        return this.internalField0282;
    }

    @Generated
    public Vec3d internalMethod07981() {
        return this.internalField1104;
    }

    @Generated
    public float internalMethod01223() {
        return this.internalField0205;
    }

    @Generated
    public Identifier internalMethod05267() {
        return this.internalField0354;
    }

    @Generated
    public int internalMethod01224() {
        return this.internalField0227;
    }

    @Generated
    public int internalMethod01229() {
        return this.internalField0228;
    }

    @Generated
    public double internalMethod01222() {
        return this.internalField0194;
    }

    @Generated
    public boolean internalMethod08094() {
        return this.internalField0277;
    }

    @Generated
    public boolean internalMethod08095() {
        return this.internalField0276;
    }

    @Generated
    public AnimatedValue internalMethod07521() {
        return this.internalField0808;
    }

    @Generated
    public AnimatedValue internalMethod00059() {
        return this.internalField0809;
    }

    @Generated
    public ColorRGBA internalMethod00429() {
        return this.internalField0777;
    }

    @Generated
    public void internalMethod06502(Vec3d vec3d) {
        this.internalField0283 = vec3d;
    }

    @Generated
    public void internalMethod05404(Vec3d vec3d) {
        this.internalField0282 = vec3d;
    }

    @Generated
    public void internalMethod08242(Vec3d vec3d) {
        this.internalField1104 = vec3d;
    }

    @Generated
    public void internalMethod02130(float f) {
        this.internalField0205 = f;
    }

    @Generated
    public void internalMethod02131(int n) {
        this.internalField0227 = n;
    }

    @Generated
    public void internalMethod02193(int n) {
        this.internalField0228 = n;
    }

    @Generated
    public void internalMethod02129(double d) {
        this.internalField0194 = d;
    }

    @Generated
    public void internalMethod02132(boolean bl) {
        this.internalField0277 = bl;
    }

    @Generated
    public void internalMethod02194(boolean bl) {
        this.internalField0276 = bl;
    }
}

