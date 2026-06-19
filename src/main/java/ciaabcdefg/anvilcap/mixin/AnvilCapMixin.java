package ciaabcdefg.anvilcap.mixin;

import net.minecraft.world.inventory.AnvilMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilMenu.class)
public class AnvilCapMixin {
	@Inject(
			method = "createResult",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/inventory/DataSlot;get()I",
					ordinal = 1
			)
	)
	private void anvilcap$modifyCost(CallbackInfo ci) {
		var self = (AnvilMenu)(Object)this;
		var accessor = (AnvilCapAccessor)self;
		var cost = accessor.anvilcap$getCost();
		cost.set(Math.min(cost.get(), 39));
	}
}