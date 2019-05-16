package com.pixelmonmod.cookbook.examplemod.pokemon;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

/** @author TSEcho on 5/16/19 */
public class EntityManipulation {

    /*
     Pixelmon does not story a Pokemon's data with the entity but rather in a wrapper object called Pokemon
     From a pokemon object you can create an EntityPixelmon and vice versa. Generally, if you want to make
     changes to a pokemon, you will be making them to the Pokemon object and it will update automatically although
     some methods may take extra steps to update.
     */

    /**
     * When creating an entity there are several things you need to keep in mind. If the pokemon does not have
     * an owner you cannot use the player to spawn it in or maniuplate it so you cannot access the owner in any way.
     * Instead you can get a world from Forge or Sponge (if you are using a server API) and spawn it manually
     *
     * @param pokemon to spawn into the world
     */
    public static void spawnPokemon(Pokemon pokemon, int x, int y, int z, int yaw, int pitch) {
        World world = DimensionManager.getWorld(0);
        pokemon.getOrSpawnPixelmon(world, x, y, z, yaw,pitch);
    }

    /**
     * This method will spawn a pokemon from a player's location and return the Entity for you to manipulate
     * Since EntityPixelmon is an instanceof Entity you have access to all of its methods + extra methods such
     * as setting if the pokemon is a boss or not as that is not controlled by the Pokemon object
     *
     * @param pokemon to get an entity from
     * @param owner of the pokemon
     */
    public static EntityPixelmon getEntityPixelmon(Pokemon pokemon, EntityPlayerMP owner) {
        return pokemon.getOrSpawnPixelmon(owner);
    }

    /**
     * getPokemonData will return the pokemon's information from an EntityPixelmon. This can be used to set
     * any kind of data onto the pixlemon including persistent data if you want it to stay onto the pokemon
     *
     * @param entity to get the Pokemon object from
     * @return a Pokemon object with data to maniupate
     */
    public static Pokemon getPokemon(EntityPixelmon entity) {
        return entity.getPokemonData();
    }
}
