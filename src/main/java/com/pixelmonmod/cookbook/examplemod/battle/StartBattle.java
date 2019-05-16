package com.pixelmonmod.cookbook.examplemod.battle;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.battles.BattleQuery;
import com.pixelmonmod.pixelmon.battles.BattleRegistry;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;
import com.pixelmonmod.pixelmon.battles.rules.BattleRules;
import com.pixelmonmod.pixelmon.comm.packetHandlers.battles.EnumBattleQueryResponse;
import com.pixelmonmod.pixelmon.enums.battle.EnumBattleType;
import net.minecraft.entity.player.EntityPlayerMP;

/** @author Flashback083 on 5/16/19 */
public class StartBattle {

   private EntityPlayerMP player1;
   private EntityPlayerMP player2;
   private BattleRules rules = new Rules().getRules();



   /* Start a battle, simple like /pokebattle command */
   public void StartBattleSingle(EntityPlayerMP player1, EntityPlayerMP player2) {
       PlayerParticipant[] p1 = {new PlayerParticipant(player1, Pixelmon.storageManager.getParty(player1).getAndSendOutFirstAblePokemon(player1))};
       PlayerParticipant[] p2 = {new PlayerParticipant(player2, Pixelmon.storageManager.getParty(player2).getAndSendOutFirstAblePokemon(player2))};
       BattleRegistry.startBattle(p1,p2, EnumBattleType.Single);
   }

   /* Start a battle with specified rules */
    public void StartBattleWithRules(EntityPlayerMP player1, EntityPlayerMP player2, BattleRules rules) {
        PlayerParticipant[] p1 = {new PlayerParticipant(player1, Pixelmon.storageManager.getParty(player1).getAndSendOutFirstAblePokemon(player1))};
        PlayerParticipant[] p2 = {new PlayerParticipant(player2, Pixelmon.storageManager.getParty(player2).getAndSendOutFirstAblePokemon(player2))};
        BattleRegistry.startBattle(p1,p2,rules);
    }


    /**
     * Start a battle with the screen that allow player to accept, change rules, or deny the battle with another player
     *
     * @param forceAccept (false/true) to force the player to accept the battle and go to choose pokemon screen
     */
    public void StartBattleQuery(EntityPlayerMP player1, EntityPlayerMP player2, boolean forceAccept){
        BattleQuery battlequery = new BattleQuery(player1,Pixelmon.storageManager.getParty(player1).getAndSendOutFirstAblePokemon(player1),player2,Pixelmon.storageManager.getParty(player2).getAndSendOutFirstAblePokemon(player2));
        if (forceAccept){
            battlequery.acceptQuery(player1, EnumBattleQueryResponse.Accept);
            battlequery.acceptQuery(player2, EnumBattleQueryResponse.Accept);
        }
    }

    /**
     * Start a battle with the screen that allow player to accept, change rules, or deny the battle with another player
     *
     * @param forceAccept (false/true) to force the player to accept the battle and go to choose pokemon screen
     */
    public void StartBattleQueryWithRules(EntityPlayerMP player1, EntityPlayerMP player2, BattleRules rules, boolean forceAccept){
        BattleQuery battlequery = new BattleQuery(player1,Pixelmon.storageManager.getParty(player1).getAndSendOutFirstAblePokemon(player1),player2,Pixelmon.storageManager.getParty(player2).getAndSendOutFirstAblePokemon(player2));
        battlequery.battleRules = rules;
        if (forceAccept){
            battlequery.acceptQuery(player1, EnumBattleQueryResponse.Accept);
            battlequery.acceptQuery(player2, EnumBattleQueryResponse.Accept);
        }
   }
}
