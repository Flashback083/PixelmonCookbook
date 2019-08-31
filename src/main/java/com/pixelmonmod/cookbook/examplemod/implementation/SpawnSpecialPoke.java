package com.pixelmonmod.cookbook.examplemod.implementation;

import com.pixelmonmod.cookbook.examplemod.pokemon.EntityManipulation;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import com.pixelmonmod.pixelmon.battles.attacks.Attack;
import com.pixelmonmod.pixelmon.battles.attacks.AttackBase;
import com.pixelmonmod.pixelmon.config.PixelmonItemsHeld;
import com.pixelmonmod.pixelmon.entities.pixelmon.abilities.AbilityBase;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Pokerus;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import com.pixelmonmod.pixelmon.enums.EnumNature;
import com.pixelmonmod.pixelmon.enums.EnumPokerusType;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

import java.util.Collections;
import java.util.List;

/** @author NateCraft on 8/31/19
 *
 *  This is a command that will spawn a pokemon on the source player with some modifications done to it.
 *  Optionally, this also contains how to spawn a pokemon with a PokemonSpec
 */
public class SpawnSpecialPoke extends CommandBase {

    @Override
    public String getName() {
        return "spawnpokemon";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/spawnpokemon";
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("spawnpokemon");
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if(sender.getCommandSenderEntity() instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender.getCommandSenderEntity();

            // Create a random pokemon (Can also be created via PokemonSpec for easy setup)
            Pokemon pokemon = Pixelmon.pokemonFactory.create(EnumSpecies.randomPoke(true));

            // None of the following are necessary to create the pokemon
            pokemon.setLevel(10);
            AbilityBase.getAbility("Overgrow").ifPresent(pokemon::setAbility); // Check optional to make sure the ability exists
            AttackBase.getAttackBase("Tackle").ifPresent(attack -> pokemon.getMoveset().set(0, new Attack(attack))); // ^
            pokemon.setShiny(true);
            pokemon.setGrowth(EnumGrowth.Enormous);
            pokemon.setNature(EnumNature.Bashful);
            pokemon.setCaughtBall(EnumPokeballs.MasterBall);
            pokemon.setForm(1); // This can depend on which pokemon it is
            pokemon.setGender(Gender.Male);
            pokemon.setHeldItem(new ItemStack(PixelmonItemsHeld.amuletCoin));
            pokemon.getEVs().set(StatsType.HP, 100);
            pokemon.getIVs().set(StatsType.HP, 31);
            pokemon.setPokerus(new Pokerus(EnumPokerusType.A));

            int x = player.getPosition().getX();
            int y = player.getPosition().getY();
            int z = player.getPosition().getZ();

            // Custom wrapper class made for simplicity in this example mod. Is not necessary but can be used in larger projects
            EntityManipulation.spawnPokemon(pokemon, x, y, z, 0,0);
        }
    }

    /**
     * This can show how to spawn a pokemon with a PokemonSpec.
     *
     * PokemonSpecs are representations of the Pokemon object but instead they are created
     * with a few Bytes that represent various values. You may recognize these values as the flags
     * needs when using a command like /pokespawn.
     *
     * PokemonSpecs are great for quick setup of a pokemon in a very small amount of lines. They should not be used for larger
     * setups where there needs to be a lot of manipulations of variables before settings the spec up.
     * Specs also allow you to easily serialize and deserialize to NBT since it is represented in such a raw case.
     */
    private void spawnWithSpec(EntityPlayerMP player) {
        Pokemon pokemon = PokemonSpec.from("Mew", "lvl:5", "g:1", "s").create();

        int x = player.getPosition().getX();
        int y = player.getPosition().getY();
        int z = player.getPosition().getZ();

        // Custom wrapper class made for simplicity in this example mod. Is not necessary but can be used in larger projects
        EntityManipulation.spawnPokemon(pokemon, x, y, z, 0,0);
    }
}
