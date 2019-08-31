package com.pixelmonmod.cookbook.examplemod.economy;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.economy.IPixelmonBankAccount;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.UUID;

/**
 * @author NateCraft on 5/16/19
 *
 * Class is a wrapper for a given IPixelmonBankAccount
 * Can be used to easily add, remove, and see a player's account without having to worry about implementation details
 *
 * @see TransactionResult
 */
public class PixelmonEcon {

    private IPixelmonBankAccount account;

    /** @param player UUID to represent this object */
    public PixelmonEcon(UUID player) {

        /* This assumes that the uuid supplied is a valid account. Check the optional */
        account = Pixelmon.moneyManager.getBankAccount(player).get();
    }

    /** @param player UUID to represent this object */
    public PixelmonEcon(EntityPlayerMP player) {
        account = Pixelmon.moneyManager.getBankAccount(player).get();
    }

    /**  @return the amount of money the player currently has */
    public int getBalance() {
        return account.getMoney();
    }

    /**
     * The amount must be positive
     * @param amount to be withdrawn from the account
     * @return TransactionResult of success or failure depending if the amount could be taken
     * @see IPixelmonBankAccount#updatePlayer(int)
     */
    public TransactionResult withdraw(int amount) {
        if((getBalance() - amount >= 0) && amount >= 0) {
            account.changeMoney(-amount);
            account.updatePlayer(getBalance());
            return TransactionResult.SUCCESS;
        }
        return TransactionResult.FAILURE;
    }

    /**
     * The amount must be positive
     * @param amount to be deposited from the account
     * @return TransactionResult of success or failure depending if the amount could be given
     * @see IPixelmonBankAccount#updatePlayer(int)
     */
    public TransactionResult deposit(int amount) {
        if(amount >= 0) {
            account.changeMoney(-amount);
            account.updatePlayer(getBalance());
            return TransactionResult.SUCCESS;
        }
        return TransactionResult.FAILURE;
    }

    /**
     * The amount must be positive
     * @param amount to be set to the account
     * @return TransactionResult of success or failure depending if the amount could be set
     * @see IPixelmonBankAccount#updatePlayer(int)
     */
    public TransactionResult setBalance(int amount) {
        if(amount >= 0) {
            account.setMoney(amount);
            account.updatePlayer(getBalance());
            return TransactionResult.SUCCESS;
        }
        return TransactionResult.FAILURE;
    }
}
