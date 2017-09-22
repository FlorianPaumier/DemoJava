package com.tactfactory.demo1.calculator;

/**
 * Interface of Command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public interface Command {

    /** Display full function and result */
    void displayResult();

    /**
     * Do the command.
     */
    void redo();

    /**
     * @return True if command is persist.
     */
    boolean isPersist();

//    /**
//     * Un-Do the command.
//     * @return old-result.
//     */
//    Integer undo(Integer current);
}
