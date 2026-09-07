package rockstar.client.internal.game;



import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.util.PlayerInput;
import rockstar.client.MinecraftClientAccess;
import rockstar.client.internal.core.CoreInternal044;

public class GameInternal008
implements CoreInternal044 {
    private boolean internalField0277 = false;

    @Override
    public void internalMethod01925() {
        if (MinecraftClientAccess.internalField0149.player != null && MinecraftClientAccess.internalField0149.player.isOnGround()) {
            PlayerInput playerInput = MinecraftClientAccess.internalField0149.player.input.playerInput;
            MinecraftClientAccess.internalField0149.player.input.playerInput = new PlayerInput(playerInput.forward(), playerInput.backward(), playerInput.left(), playerInput.right(), playerInput.jump(), playerInput.sneak(), playerInput.sprint());
            MinecraftClientAccess.internalField0149.player.networkHandler.sendPacket((Packet)new PlayerInputC2SPacket(MinecraftClientAccess.internalField0149.player.input.playerInput));
            MinecraftClientAccess.internalField0149.player.jump();
        }
        this.internalField0277 = true;
    }

    @Override
    public boolean internalMethod01926() {
        return this.internalField0277;
    }

    @Override
    public void internalMethod01928() {
        this.internalField0277 = false;
    }
}

