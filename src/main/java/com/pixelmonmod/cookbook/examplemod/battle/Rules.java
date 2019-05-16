package com.pixelmonmod.cookbook.examplemod.battle;

import com.pixelmonmod.pixelmon.battles.rules.BattleRules;

/** @author Flashback083 on 5/16/19 */
public class Rules {

    private boolean fullHeal;
    public BattleRules rules = new BattleRules();

    public BattleRules getRules(){
        return rules;
    }

    public void addfullHeal(boolean enable){
        rules.fullHeal = enable;
    }


}
