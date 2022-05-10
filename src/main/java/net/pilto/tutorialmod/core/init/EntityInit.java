package net.pilto.tutorialmod.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.pilto.tutorialmod.common.entity.SoulessKnight;
import net.pilto.tutorialmod.tutorialmod;

public class EntityInit {

    private EntityInit() {}

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            tutorialmod.MOD_ID);


    //TODO =    REGISTER Entities
    public static final RegistryObject<EntityType<SoulessKnight>> SOULESS_KNIGHT = ENTITIES.register("souless_knight",
            () -> EntityType.Builder.of(SoulessKnight::new, MobCategory.CREATURE).sized(1f,2f).
                    build(new ResourceLocation(tutorialmod.MOD_ID, "souless_knight").toString()));

}

