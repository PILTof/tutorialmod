package net.pilto.tutorialmod.client.renderer.model;

import net.minecraft.resources.ResourceLocation;
import net.pilto.tutorialmod.common.entity.SoulessKnight;
import net.pilto.tutorialmod.tutorialmod;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SoulessKnightModel extends AnimatedGeoModel<SoulessKnight> {


    @Override
    public ResourceLocation getAnimationFileLocation(SoulessKnight animatable) {
        return new ResourceLocation(tutorialmod.MOD_ID, "animations/soulessknight/soulessknight.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(SoulessKnight object) {

        return new ResourceLocation(tutorialmod.MOD_ID, "geo/soulessnight.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SoulessKnight object) {
        return new ResourceLocation(tutorialmod.MOD_ID, "textures/entities/souless_knight.png");
    }


}
