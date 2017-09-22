package com.tactfactory.demo1.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * History of commands.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class CommandHistory {

    // Singleton pattern

    private static CommandHistory histories = new CommandHistory();
    public static CommandHistory getCommandHistory() {
        return histories;
    }


    private List<Command> commands = new ArrayList<Command>();
    public List<Command> getCommands() {
        return this.commands;
    }
}
