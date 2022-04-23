package net.pilto.tutorialmod.core.event;


import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.pilto.tutorialmod.common.entity.ExampleEntity;
import net.pilto.tutorialmod.common.entity.FirstEntity;
import net.pilto.tutorialmod.core.init.EntityInit;
import net.pilto.tutorialmod.tutorialmod;

//регистрируем атрибуты: ВАЖНО, ЧТОБЫ МОЖНО БЫЛО СУМОНИТЬ МОБА

@Mod.EventBusSubscriber(modid = tutorialmod.MOD_ID, bus = Bus.MOD)
public class CommonModEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());

        event.put(EntityInit.FIRST_ENTITY.get(), FirstEntity.createAttributes().build());
    }
}