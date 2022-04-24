package net.pilto.tutorialmod.client.renderer.model;

import net.minecraft.resources.ResourceLocation;
import net.pilto.tutorialmod.common.entity.EmberEntity;
import net.pilto.tutorialmod.tutorialmod;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EmberEntityModel extends AnimatedGeoModel<EmberEntity> {


    @Override
    public ResourceLocation getAnimationFileLocation(EmberEntity animatable) {
        return new ResourceLocation(tutorialmod.MOD_ID, "animations/model.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(EmberEntity object) {

        return new ResourceLocation(tutorialmod.MOD_ID, "geo/pup.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EmberEntity object) {
        return new ResourceLocation(tutorialmod.MOD_ID, "textures/entities/pup.png");
    }
}