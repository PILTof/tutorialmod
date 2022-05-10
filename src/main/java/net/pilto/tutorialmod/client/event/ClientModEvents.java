package net.pilto.tutorialmod.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
//import net.pilto.tutorialmod.client.renderer.ExampleEntityRenderer;
import net.pilto.tutorialmod.client.renderer.SoulessKnightRenderer;
import net.pilto.tutorialmod.core.init.EntityInit;
//import net.pilto.tutorialmod.client.renderer.model.ExampleEntityModel;
import net.pilto.tutorialmod.tutorialmod;

@Mod.EventBusSubscriber(modid = tutorialmod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    private ClientModEvents() {
    }

    @SubscribeEvent
    public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
//        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.SOULESS_KNIGHT.get(), SoulessKnightRenderer::new);


    }
}