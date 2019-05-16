package com.pixelmonmod.cookbook.examplemod.battle;

import com.pixelmonmod.pixelmon.battles.rules.BattleRules;

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
