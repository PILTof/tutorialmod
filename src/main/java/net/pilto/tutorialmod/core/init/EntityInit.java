package net.pilto.tutorialmod.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.pilto.tutorialmod.common.entity.EmberEntity;
import net.pilto.tutorialmod.common.entity.FirstEntity;
import net.pilto.tutorialmod.tutorialmod;

public class EntityInit {

    private EntityInit() {}

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            tutorialmod.MOD_ID);


    public static final RegistryObject<EntityType<FirstEntity>> FIRST_ENTITY = ENTITIES.register("first_entity",
            () -> EntityType.Builder.of(FirstEntity::new, MobCategory.MONSTER).sized(2f,2f)
                    .build(new ResourceLocation(tutorialmod.MOD_ID, "first_entity").toString()));

    public static final RegistryObject<EntityType<EmberEntity>> EMBER_ENTITY = ENTITIES.register("ember_entity",
            () -> EntityType.Builder.of(EmberEntity::new, MobCategory.MONSTER).sized(2f,1f).
                    build(new ResourceLocation(tutorialmod.MOD_ID, "ember_entity").toString()));

}

