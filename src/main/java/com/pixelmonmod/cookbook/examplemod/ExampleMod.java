package com.pixelmonmod.cookbook.examplemod;

import com.pixelmonmod.cookbook.examplemod.events.BattleListener;
import com.pixelmonmod.cookbook.examplemod.events.CaptureListener;
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
     * This mod showcases many of the various helpful classes, enums, methods, event,
     * and implementation and from the Pixelmon Reforged API.
     * Some classes have specific classes that are either containers or just helpful methods while anything else
     * may be placed inside the implementation package as that shows a command or something similar
     *
     * All authors have been indicated at the top of each file and any editors in the future if applicable
     *
     * Note: The entirety of this cookbook is written to work with the ForgeAPI without any additional
     * help but for Sponge developers, you can do the same implementation as long as you do the following:
     *
     * 1.) Add forge and pixelmon to your developer environment.
     * 2.) Specify this class as your @Plugin class and add Pixelmon as a dependency
     * 3.) Use @SubscribeEvent from Forge to handle your events wherever they may be registered
     * 3-5.) Generally in Sponge you register mod events in your PreInitializationEvent
     */

    public static final String MOD_ID = "ExampleMod";
    public static final String MOD_NAME = "ExampleMod";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MOD_ID)
    public static ExampleMod INSTANCE;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Pixelmon.EVENT_BUS.register(new CaptureListener());
        Pixelmon.EVENT_BUS.register(new BattleListener());
    }
}
