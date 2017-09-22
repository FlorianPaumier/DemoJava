package com.tactfactory.demo1.calculator;

/**
 * Interface of Command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public interface Command {

    /**
     * Display/ask value of the command.
     */
    void ask();

    /** Display help message of the command. */
    void help();

    /** Display full function and result */ //String operation
    void displayResult();

    /**
     * Do the command.
     *
     * @return new result.
     */
    Integer redo();

//    /**
//     * Un-Do the command.
//     * @return old-result.
//     */
//    Integer undo(Integer current);
}




