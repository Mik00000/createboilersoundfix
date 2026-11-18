package com.mik.createboilersoundfix.mixin;

import com.simibubi.create.content.fluids.tank.SoundPool;
import it.unimi.dsi.fastutil.longs.LongList;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SoundPool.class, remap = false)
public class SoundPoolMixin {
    @Shadow
    private LongList queuedPositions;

    /**
     * Fixes Create steam boiler sound bug:
     * Clears queuedPositions in O(1) and cancels playback to eliminate deafening
     * candle/steam sound stacking and 5-12% CPU lag in rollNextPosition / sound raytracing.
     */
    @Inject(method = "play", at = @At("HEAD"), cancellable = true)
    private void onBoilerSoundPlay(Level level, CallbackInfo ci) {
        if (this.queuedPositions != null && !this.queuedPositions.isEmpty()) {
            this.queuedPositions.clear();
        }
        ci.cancel();
    }
}
