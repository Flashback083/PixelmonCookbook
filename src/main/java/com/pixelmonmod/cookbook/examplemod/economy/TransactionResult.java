package com.pixelmonmod.cookbook.examplemod.economy;

/** @author NateCraft on 5/16/19
 *
 * Enum is intended to help the programmer easily figure out how a transaction went with the
 * pixelmon economy without having to check it each time but instead just check if it was a success
 */
public enum TransactionResult {

    SUCCESS, FAILURE;

    public String getMessage() {
        if(this == FAILURE)
            return "&cThe transaction was not successful!";
        else
            return "&cThe transaction was completed succesfully!";
    }
}
