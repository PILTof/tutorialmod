package net.pilto.tutorialmod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.pilto.tutorialmod.client.renderer.model.EmberEntityModel;
import net.pilto.tutorialmod.common.entity.EmberEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EmberEntityRenderer extends GeoEntityRenderer<EmberEntity> {
    public EmberEntityRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EmberEntityModel());
    }
}
