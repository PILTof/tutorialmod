package net.pilto.tutorialmod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.pilto.tutorialmod.client.renderer.model.SoulessKnightModel;
import net.pilto.tutorialmod.common.entity.SoulessKnight;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SoulessKnightRenderer extends GeoEntityRenderer<SoulessKnight> {
    public SoulessKnightRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SoulessKnightModel());
    }
}
