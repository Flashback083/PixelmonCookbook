package com.pixelmonmod.cookbook.examplemod.battle;

import com.pixelmonmod.pixelmon.battles.rules.BattleRules;
import com.pixelmonmod.pixelmon.battles.rules.clauses.BattleClause;
import com.pixelmonmod.pixelmon.battles.rules.clauses.BattleClauseRegistry;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Flashback083 on 5/16/19
 * @author NateCraft on 8/31/19 - Edited
 *
 * This is an example abstracted class for the BattleRules and BattleClause system. It can easily
 * be used to add in a bunch of rules and clauses without having to write a lot of extra code.
 *
 * The BattleRules contains BattleClauses inside of the class itself but it also has regular BattleRules
 * saved as variables such as booleans or integers depending on which it is.
 * For example, BattleRules#fullHeal is a boolean public variable you can set to true or false.
 *
 * Since this class extends BattleRules from pixelmon, it can use all of the parent's methods and variables
 * at any time. It can also be used when starting a battle like our BattleStarter class
 *
 * @see BattleRules#fullHeal
 * @see BattleStarter#StartBattleQueryWithRules(EntityPlayerMP, EntityPlayerMP, BattleRules, boolean)
 */
public class Rules extends BattleRules {

    private BattleRules rules;
    private List<BattleClause> clauses;

    public Rules() {
        this.rules = new BattleRules();
        this.clauses = new ArrayList<>();
    }

    /**
     * Adds a particular claus to the the list which will be added to the overall Rules later
     * @param id to grab a clause from. Clauses can be found in the BattleClauseRegistry class
     */
    public void addClause(String id) {
        clauses.add(BattleClauseRegistry.getClauseRegistry().getClause(id));
        rules.setNewClauses(clauses);
    }

    /**
     * @return the complete BattleRules
     */
    public BattleRules getRules() {
        return rules;
    }
}
