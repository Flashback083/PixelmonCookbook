package com.pixelmonmod.cookbook.examplemod.storage;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PartyStorage;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;
import java.util.Optional;

/** @author NateCraft on 5/16/19
 *
 * Class is a wrapper aroung a given PartyStorage for a player
 *
 * PartyStorage extends PokemonStorage and only represents the player's actual party.
 * If you want to just look at PCStorage then use that class and if you want to access all of
 * the player's pokemon use PokemonStorage
 * */
public class PokemonParty {

    private EntityPlayerMP player;
    private PartyStorage party;

    public PokemonParty(EntityPlayerMP player) {
        this.player = player;
        party = Pixelmon.storageManager.getParty(player);
    }

    /**
     * Note: This includes null pokemon (non-existent) as well as egg pokemon so make sure to check or use
     * getTeam() instead
     * @return the party of the player
     */
    public PartyStorage getParty() {
        return party;
    }

    /**
     * This is especially useful if you want to edit each pokemon as you can turn the list into a stream
     * and use it from there.
     *
     * @return a list of non-egg pokemon
     */
    public List<Pokemon> getTeam() {
        return party.getTeam();
    }

    /**
     * This will return a pokemon from a given slot position. Generally the slot is 0-5 but I subtracted 1
     * to make it easier to understand here. Also I like to use optionals because you never have to worry
     * about the pokemon being null
     *
     * @param slot (1-6) to get the pokemon from
     * @return an optional pokemon
     */
    public Optional<Pokemon> getPokemonFromSlot(int slot) {
        if(getParty().get(slot - 1) != null) {
            return Optional.of(getParty().get(slot - 1));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Generally the slot is 0-5 but I subtracted 1 to make it easier to understand here. This will set a
     * given pokemon to a slot in the player's party
     *
     * @param slot (1-6) to set a pokemon to in the party
     * @param pokemon to set into the party
     */
    public void setSlot(int slot, Pokemon pokemon) {
        if(slot > 0 && slot < 7)
            party.set(slot - 1, pokemon);
    }
}
