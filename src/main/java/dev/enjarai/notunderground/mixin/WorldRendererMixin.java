package dev.enjarai.notunderground.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

// This mixin has a low priority to hopefully prevent conflicts arising from not returning the original value in any case.
@Mixin(value = WorldRenderer.class, priority = 800)
public abstract class WorldRendererMixin {
	@ModifyExpressionValue(
			method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/world/ClientWorld$Properties;getSkyDarknessHeight(Lnet/minecraft/world/HeightLimitView;)D"
			)
	)
	private double init(double original) {
		return -2048;
	}
}