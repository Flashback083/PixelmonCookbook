package com.pixelmonmod.cookbook.examplemod.battle;

import com.pixelmonmod.pixelmon.battles.rules.BattleRules;
import com.pixelmonmod.pixelmon.battles.rules.clauses.BattleClause;
import com.pixelmonmod.pixelmon.battles.rules.clauses.BattleClauseRegistry;

import java.util.ArrayList;

/** @author Flashback083 on 5/16/19 */
public class Rules {

    private boolean fullHeal;
    public BattleRules rules = new BattleRules();
    public BattleClause bag = BattleClauseRegistry.getClauseRegistry().getClauseList().get(0);
    public ArrayList<String> clause = new ArrayList<>();

    public BattleRules getRules(){
        return rules;
    }

    public void addfullHeal(boolean enable){
        rules.fullHeal = enable;
    }






}
