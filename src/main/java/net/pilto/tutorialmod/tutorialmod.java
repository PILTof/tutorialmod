package net.pilto.tutorialmod;

import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.pilto.tutorialmod.common.ai.entity.events.EmberEntityEvents;
import net.pilto.tutorialmod.client.GUI.GuiEventHandler;
import net.pilto.tutorialmod.common.ai.entity.events.EntitySpawnDeathEvent;
import net.pilto.tutorialmod.core.init.EntityInit;
import net.pilto.tutorialmod.core.init.ItemInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(tutorialmod.MOD_ID)
public class tutorialmod {

    public static final String MOD_ID = "tutorialmod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();


    public tutorialmod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(eventBus);

        eventBus.addListener(this::setup);

//        MinecraftForge.EVENT_BUS.addListener(EmberEntity::onAttack);
        //TODO =    REGISTER events

        eventBus.register(new GuiEventHandler());

        EntitySpawnDeathEvent EntitySpawnDeathEvent = new EntitySpawnDeathEvent();
        MinecraftForge.EVENT_BUS.register(EntitySpawnDeathEvent);

        EntityInit.ENTITIES.register(eventBus);
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());}
}
