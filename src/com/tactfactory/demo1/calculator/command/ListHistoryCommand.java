package com.tactfactory.demo1.calculator.command;

import java.util.List;

import com.tactfactory.demo1.calculator.BaseCommand;
import com.tactfactory.demo1.calculator.Calculator;
import com.tactfactory.demo1.calculator.Command;
import com.tactfactory.demo1.calculator.CommandHistory;
import com.tactfactory.demo1.calculator.ConsoleUtils;
import com.tactfactory.demo1.persistant.EntityManager;
import com.tactfactory.demo1.persistant.HistoryRepository;

/**
 * List history command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class ListHistoryCommand extends BaseCommand {

    // Local
    CommandHistory commandHistory = CommandHistory.getCommandHistory();

    // Database
    EntityManager manager = EntityManager.getInstance();
    HistoryRepository repo = manager.getHistoryRepository();

    public ListHistoryCommand() {
        this.isPersist = false;
    }

    @Override
    public void redo() {
        if (Calculator.IS_LOCAL) {
            if (this.commandHistory.getCommands().size() > 0) {
                for (Command histoCommand : this.commandHistory.getCommands()) {
                    histoCommand.displayResult();
                }
            } else {
                ConsoleUtils.display("No commands in history !");
            }
        } else {
            List<String> result  = this.repo.getAll();

            if (result.size() > 0) {
                for (String item : result) {
                    ConsoleUtils.display(item);
                }
            } else {
                ConsoleUtils.display("No commands in Database !");
            }
        }
    }

}
