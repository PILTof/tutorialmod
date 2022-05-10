package net.pilto.tutorialmod.common.ai.entity.events;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.pilto.tutorialmod.common.entity.SoulessKnight;
//TODO  =   EVENT    entity     [SPAWN / DEATH]
public class EntitySpawnDeathEvent {
    @SubscribeEvent
    public void onSpawnEvent(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof SoulessKnight)
            SoulessKnight.SOULESS_KNIGHT_SPAWNED = true;
    }

    @SubscribeEvent
    public void onDeathEvent(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof SoulessKnight)
            SoulessKnight.SOULESS_KNIGHT_SPAWNED = false;
    }
}
