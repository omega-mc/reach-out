package draylar.reachout.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import draylar.reachout.ReachOut;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    private PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
            method = "createPlayerAttributes",
            at = @At("RETURN"),
            cancellable = true
    )
    private static void modifyPlayerAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        DefaultAttributeContainer.Builder builder = cir.getReturnValue();
        builder.add(ReachEntityAttributes.ATTACK_RANGE, ReachOut.CONFIG.attackDistance);
        builder.add(ReachEntityAttributes.REACH, ReachOut.CONFIG.reachDistance);
    }
}
