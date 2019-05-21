package com.pixelmonmod.cookbook.examplemod.events;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.entities.pokeballs.EntityPokeBall;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/** @author Flashback083 on 5/21/19 */
public class EventCapture {

    @SubscribeEvent
    public void onCaptureSuccessfull(CaptureEvent.SuccessfulCapture event){
        EntityPlayerMP player = event.player;
        EntityPokeBall pokeball = event.pokeball;
        EntityPixelmon pixelmon = event.getPokemon();
        Pokemon pokemon = pixelmon.getPokemonData();
        player.sendMessage(new TextComponentString("Gg for your capture ! " + pokemon.getSpecies().getPokemonName()));
    }

    @SubscribeEvent
    public void onFailCapture(CaptureEvent.FailedCapture event){
        EntityPlayerMP player = event.player;
        EntityPokeBall pokeball = event.pokeball;
        EntityPixelmon pixelmon = event.getPokemon();
        Pokemon pokemon = pixelmon.getPokemonData();
        player.sendMessage(new TextComponentString("Sorry but you failed to capture : " + pokemon.getSpecies().getPokemonName()));
    }

    @SubscribeEvent
    public void onStartedCapture(CaptureEvent.StartCapture event){
        EntityPlayerMP player = event.player;
        EntityPokeBall pokeball = event.pokeball;
        EntityPixelmon pixelmon = event.getPokemon();
        Pokemon pokemon = pixelmon.getPokemonData();
        player.sendMessage(new TextComponentString("You start to capture : " + pokemon.getSpecies().getPokemonName()));
    }

}
