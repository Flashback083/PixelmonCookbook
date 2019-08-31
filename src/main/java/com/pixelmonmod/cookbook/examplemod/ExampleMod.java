package com.pixelmonmod.cookbook.examplemod;

import com.pixelmonmod.cookbook.examplemod.events.EventCapture;
import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MOD_ID,
     name = ExampleMod.MOD_NAME,
     version = ExampleMod.VERSION,
     serverSideOnly = true,
     acceptableRemoteVersions = "*")

public class ExampleMod {

    /*
      This mod showcases many of the various helpful classes, enums, methods, and from the Pixelmon Reforged API
     */

    public static final String MOD_ID = "ExampleMod";
    public static final String MOD_NAME = "ExampleMod";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MOD_ID)
    public static ExampleMod INSTANCE;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        Pixelmon.EVENT_BUS.register(new EventCapture());
    }
}
