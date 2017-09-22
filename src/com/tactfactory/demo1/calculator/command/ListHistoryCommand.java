package com.tactfactory.demo1.calculator.command;

import com.tactfactory.demo1.calculator.BaseCommand;
import com.tactfactory.demo1.calculator.Command;
import com.tactfactory.demo1.calculator.CommandHistory;
import com.tactfactory.demo1.calculator.ConsoleUtils;

/**
 * List history command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class ListHistoryCommand extends BaseCommand {

    CommandHistory commandHistory = CommandHistory.getCommandHistory();

    public ListHistoryCommand() {
        this.isPersist = false;
    }

    @Override
    public void redo() {
        if (this.commandHistory.getCommands().size() > 0) {
            for (Command histoCommand : this.commandHistory.getCommands()) {
                histoCommand.displayResult();
            }
        } else {
            ConsoleUtils.display("No commands in history !");
        }
    }

}
