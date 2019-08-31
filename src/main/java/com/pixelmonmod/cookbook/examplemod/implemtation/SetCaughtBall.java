package com.pixelmonmod.cookbook.examplemod.implemtation;

import com.pixelmonmod.cookbook.examplemod.storage.PokemonParty;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import com.sun.deploy.util.StringUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.Arrays;
import java.util.List;

/** @author NateCraft on 5/16/19 */
public class SetCaughtBall extends CommandBase {

     /*
     This is a command to set the ball for a given Pokemon based on slot and player as an argument
     The command will use the Pokemon object and how to use it
     */

    @Override
    public String getName() {
        return "setcaughtball";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/setcaughtball <slot> <ball>";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("setcaughtball", "setball", "ballset");
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if(sender.getCommandSenderEntity() instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender.getCommandSenderEntity();
            PokemonParty party = new PokemonParty(player);

            if(args.length != 3) {
                TextComponentBase text = new TextComponentString("Usage: " + getUsage(sender));
                text.getStyle().setColor(TextFormatting.DARK_RED);
                player.sendMessage(text);
                return;
            }

            if(!getSlots().contains(args[1])) {
                TextComponentBase text = new TextComponentString("You need a slot 1 - 6!");
                text.getStyle().setColor(TextFormatting.DARK_RED);
                player.sendMessage(text);
                return;
            }

            if(party.getPokemonFromSlot(Integer.valueOf(args[1])).isPresent()) {
                Pokemon poke = party.getPokemonFromSlot(Integer.valueOf(args[2])).get();

                if(EnumPokeballs.hasPokeball(args[2])) {
                    poke.setCaughtBall(EnumPokeballs.getPokeballFromString(args[2]));
                } else {
                    TextComponentBase text = new TextComponentString("That is not a valid pokeball type! Options: " +
                            StringUtils.join(Arrays.asList(EnumPokeballs.values()), ", "));
                    text.getStyle().setColor(TextFormatting.DARK_RED);
                    player.sendMessage(text);
                }
            }
        }
    }

    private List<String> getSlots() {
        return Arrays.asList("1","2","3","4","5","6");
    }
}
