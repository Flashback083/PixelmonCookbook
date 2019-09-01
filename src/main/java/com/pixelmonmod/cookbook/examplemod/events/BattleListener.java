package com.pixelmonmod.cookbook.examplemod.events;

import com.pixelmonmod.pixelmon.api.events.battles.BattleEndEvent;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.TrainerParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.WildPixelmonParticipant;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.battle.BattleResults;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/** @author NateCraft on 8/31/19 */
public class BattleListener {

    /*
     * This event can be used to figure out a variety of things based on the battle results
     *
     * The battle participant is a super class of several sub classes such as the PlayerParticipant
     * and from that we can figure out what each participant was.
     *
     * With the battle results we can figure out who won, loss, or tied the battle.
     */
    @SubscribeEvent
    public void onEndBattle(BattleEndEvent e) {
        e.results.forEach((participant, result) -> {

            if(participant instanceof TrainerParticipant) {
                NPCTrainer trainer = (NPCTrainer) participant.getEntity();  // this participant was an NPC Trainer
            } else if(participant instanceof PlayerParticipant) {
                EntityPlayerMP player = (EntityPlayerMP) participant.getEntity(); // this participant was an EntityPlayerMP
            } else if(participant instanceof WildPixelmonParticipant) {
                EntityPixelmon pokemon = (EntityPixelmon) participant.getEntity(); // this participant was an EntityPixelmon
            }

            if(result == BattleResults.VICTORY) {
                // this participant won the battle
            } else if(result == BattleResults.DEFEAT) {
                // this participant loss the battle
            } else if(result == BattleResults.DRAW) {
                // this was a tie battle
            } else if(result == BattleResults.FLEE) {
                // this participant fled the battle
            }
        });
    }
}
