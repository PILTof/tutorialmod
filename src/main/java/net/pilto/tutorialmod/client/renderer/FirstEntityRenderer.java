package net.pilto.tutorialmod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.pilto.tutorialmod.client.renderer.model.FirstEntityModel;
import net.pilto.tutorialmod.common.entity.FirstEntity;
import net.pilto.tutorialmod.tutorialmod;

public class FirstEntityRenderer<Type extends FirstEntity> extends MobRenderer<Type, FirstEntityModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(tutorialmod.MOD_ID, "textures/entities/first_entity.png");

    public FirstEntityRenderer(EntityRendererProvider.Context context) {
        super(context,
                new FirstEntityModel<>(context.bakeLayer(FirstEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
}
