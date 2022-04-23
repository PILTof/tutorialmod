package net.pilto.tutorialmod.client.renderer;

import net.pilto.tutorialmod.client.renderer.model.ExampleEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.pilto.tutorialmod.common.entity.ExampleEntity;
import net.pilto.tutorialmod.tutorialmod;

//Тут указывается локация ресурсов для конкретного существа

public class ExampleEntityRenderer<Type extends ExampleEntity> extends MobRenderer<Type, ExampleEntityModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(tutorialmod.MOD_ID, "textures/entities/example_entity.png");

    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context,
                new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
}
