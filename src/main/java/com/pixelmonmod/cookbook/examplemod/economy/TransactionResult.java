package com.pixelmonmod.cookbook.examplemod.economy;

/** @author NateCraft on 5/16/19 */
public enum TransactionResult {

    SUCCESS, FAILURE;

    public String getMessage() {
        if(this == FAILURE)
            return "&cThe transaction was not successful!";
        else
            return "&cThe transaction was completed succesfully!";
    }
}
