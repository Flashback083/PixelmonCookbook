package com.pixelmonmod.cookbook.examplemod;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = ExampleMod.MOD_ID,
        name = ExampleMod.MOD_NAME,
        version = ExampleMod.VERSION,
        serverSideOnly = true,
        acceptableRemoteVersions = "*")

public class ExampleMod {

    /*
      This mod showcases many of the various classes, enums, and methods from the Pixelmon Reforged API
     */

    public static final String MOD_ID = "ExampleMod";
    public static final String MOD_NAME = "ExampleMod";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MOD_ID)
    public static ExampleMod INSTANCE;
}
