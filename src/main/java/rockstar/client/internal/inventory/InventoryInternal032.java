package rockstar.client.internal.inventory;




import rockstar.client.inventory.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;
import rockstar.client.internal.inventory.InventoryInternal025;
import rockstar.client.MinecraftClientAccess;
import rockstar.client.inventory.InventorySlot;
import rockstar.client.internal.inventory.InventoryInternal034;
import rockstar.client.internal.core.CoreInternal092;
import rockstar.client.internal.inventory.InventoryInternal035;

public class InventoryInternal032
implements MinecraftClientAccess {
    private static final int internalField0227 = 5;
    private final InventoryInternal034 internalField0216;
    private final InventoryInternal035 internalField0219;
    private CoreInternal092 internalField0218 = CoreInternal092.internalField0218;
    private ItemStack internalField0878 = ItemStack.EMPTY;
    private int internalField0228 = -1;
    private int internalField1053 = 0;
    private boolean internalField0277 = true;
    @Nullable
    private InternalType0363 internalField0711;
    private boolean internalField0276;

    public void internalMethod05365(@Nullable InternalType0363 nestedValue0137) {
        this.internalField0711 = nestedValue0137;
    }

    public InventoryInternal032(InventoryInternal034 typedValue226, InventoryInternal035 typedValue227) {
        this.internalField0216 = Objects.requireNonNull(typedValue226);
        this.internalField0219 = Objects.requireNonNull(typedValue227);
    }

    public InventoryInternal032 internalMethod03734(boolean bl) {
        this.internalField0277 = bl;
        return this;
    }

    public int internalMethod01274(Item item) {
        return this.internalField0216.internalMethod04400(item);
    }

    public boolean internalMethod06520() {
        return this.internalField0218 == CoreInternal092.internalField0217;
    }

    public void internalMethod06519() {
        this.internalField0218 = CoreInternal092.internalField0218;
        this.internalField0878 = ItemStack.EMPTY;
        this.internalField0228 = -1;
        this.internalField1053 = 0;
        this.internalField0276 = false;
    }

    public void internalMethod01087(Item item, boolean bl, Predicate<ItemStack> predicate, BooleanSupplier booleanSupplier) {
        boolean bl2;
        if (InventoryInternal032.internalField0149.player == null || InventoryInternal032.internalField0149.world == null || item == null) {
            return;
        }
        ItemStack itemStack = InventoryInternal032.internalField0149.player.getOffHandStack();
        boolean bl3 = bl2 = itemStack.getItem() == item;
        if (bl) {
            if (!booleanSupplier.getAsBoolean()) {
                return;
            }
            this.internalMethod07001(item, bl2, itemStack, predicate);
            return;
        }
        if (this.internalField0218 == CoreInternal092.internalField0218) {
            return;
        }
        if (!booleanSupplier.getAsBoolean()) {
            return;
        }
        this.internalMethod00218(itemStack);
    }

    private void internalMethod07001(Item item, boolean bl, ItemStack itemStack, Predicate<ItemStack> predicate) {
        if (bl && item == Items.TOTEM_OF_UNDYING) {
            int n = InventoryInternal025.internalMethod04472(itemStack);
            InventorySlot typedValue222 = this.internalField0216.internalMethod04352(item);
            if (typedValue222 == null) {
                this.internalField0218 = CoreInternal092.internalField0217;
                return;
            }
            int n2 = InventoryInternal025.internalMethod04472(typedValue222.internalMethod03427());
            if (n2 >= n) {
                this.internalField0218 = CoreInternal092.internalField0217;
                return;
            }
            if (this.internalField0878.isEmpty()) {
                this.internalField0878 = itemStack.copy();
            }
            this.internalField0228 = -1;
            this.internalMethod06522();
            if (this.internalField0219.internalMethod01313(typedValue222)) {
                this.internalField0218 = CoreInternal092.internalField0217;
                if (this.internalField0711 != null && InventoryInternal032.internalField0149.player != null && item == Items.TOTEM_OF_UNDYING) {
                    this.internalField0711.internalMethod00133(InventoryInternal032.internalField0149.player.getHealth() + InventoryInternal032.internalField0149.player.getAbsorptionAmount());
                }
            }
            return;
        }
        if (bl) {
            this.internalField0218 = CoreInternal092.internalField0217;
            return;
        }
        if (!predicate.test(itemStack)) {
            return;
        }
        InventorySlot typedValue223 = this.internalField0216.internalMethod04352(item);
        if (typedValue223 == null) {
            return;
        }
        this.internalMethod05494(itemStack);
        this.internalField0228 = typedValue223.internalMethod06662();
        this.internalMethod06522();
        if (this.internalField0219.internalMethod01313(typedValue223)) {
            this.internalField0218 = CoreInternal092.internalField0217;
            if (this.internalField0711 != null && InventoryInternal032.internalField0149.player != null && item == Items.TOTEM_OF_UNDYING) {
                this.internalField0711.internalMethod00133(InventoryInternal032.internalField0149.player.getHealth() + InventoryInternal032.internalField0149.player.getAbsorptionAmount());
            }
        }
    }

    private void internalMethod00218(ItemStack itemStack) {
        int n;
        int n2;
        if (this.internalField0878.isEmpty()) {
            InventorySlot typedValue222 = this.internalField0216.internalMethod02934(Items.TOTEM_OF_UNDYING);
            if (typedValue222 != null && itemStack.getItem() == Items.TOTEM_OF_UNDYING) {
                int n3 = InventoryInternal025.internalMethod04472(itemStack);
                int n4 = InventoryInternal025.internalMethod04472(typedValue222.internalMethod03427());
                if (n4 > n3) {
                    this.internalMethod06522();
                    this.internalField0219.internalMethod01313(typedValue222);
                }
            }
            this.internalMethod06519();
            return;
        }
        if (ItemStack.areEqual((ItemStack)itemStack, (ItemStack)this.internalField0878)) {
            this.internalMethod06519();
            return;
        }
        if (itemStack.getItem() == Items.TOTEM_OF_UNDYING && this.internalField0878.getItem() == Items.TOTEM_OF_UNDYING && (n2 = InventoryInternal025.internalMethod04472(itemStack)) >= (n = InventoryInternal025.internalMethod04472(this.internalField0878))) {
            this.internalMethod06519();
            return;
        }
        if (this.internalField0218 != CoreInternal092.internalField1050) {
            this.internalField0218 = CoreInternal092.internalField1050;
            this.internalField1053 = 5;
            this.internalField0276 = false;
        }
        if (this.internalField1053-- <= 0) {
            this.internalMethod06519();
            return;
        }
        InventorySlot typedValue223 = this.internalMethod01749();
        if (typedValue223 == null) {
            this.internalMethod06519();
            return;
        }
        this.internalMethod06522();
        if (this.internalField0219.internalMethod01313(typedValue223) && this.internalField0711 != null && !this.internalField0276 && !this.internalField0878.isEmpty()) {
            this.internalField0711.internalMethod05133(this.internalField0878);
            this.internalField0276 = true;
        }
    }

    private void internalMethod05494(ItemStack itemStack) {
        if (this.internalField0878.isEmpty()) {
            this.internalField0878 = itemStack.copy();
        }
    }

    private void internalMethod06522() {
        if (this.internalField0277 && InventoryInternal032.internalField0149.player.isUsingItem()) {
            InventoryInternal032.internalField0149.player.stopUsingItem();
        }
    }

    @Nullable
    private InventorySlot internalMethod01749() {
        InventorySlot typedValue222;
        if (this.internalField0228 != -1 && (typedValue222 = this.internalField0216.internalMethod04947(this.internalField0228)) != null) {
            if (ItemStack.areEqual((ItemStack)typedValue222.internalMethod03427(), (ItemStack)this.internalField0878)) {
                return typedValue222;
            }
            this.internalField0228 = -1;
        }
        return this.internalField0216.internalMethod05459(this.internalField0878);
    }

    public static interface InternalType0363 {
        public void internalMethod00133(float localValue1);

        public void internalMethod05133(ItemStack localValue1);
    }
}

