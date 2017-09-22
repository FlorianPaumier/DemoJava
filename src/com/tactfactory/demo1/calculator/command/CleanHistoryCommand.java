package com.tactfactory.demo1.calculator.command;

import com.tactfactory.demo1.calculator.BaseCommand;
import com.tactfactory.demo1.calculator.CommandHistory;
import com.tactfactory.demo1.calculator.ConsoleUtils;

/**
 * Clean history command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class CleanHistoryCommand extends BaseCommand {

    CommandHistory commandHistory = CommandHistory.getCommandHistory();

    public CleanHistoryCommand() {
        this.isPersist = false;
    }

    @Override
    public void redo() {
        int count = this.commandHistory.getCommands().size();
        this.commandHistory.getCommands().clear();
        ConsoleUtils.display("History clean of %d commands.", count);
    }

}
