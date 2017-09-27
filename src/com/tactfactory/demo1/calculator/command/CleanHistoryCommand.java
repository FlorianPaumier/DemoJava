package com.tactfactory.demo1.calculator.command;

import com.tactfactory.demo1.calculator.BaseCommand;
import com.tactfactory.demo1.calculator.Calculator;
import com.tactfactory.demo1.calculator.CommandHistory;
import com.tactfactory.demo1.calculator.ConsoleUtils;
import com.tactfactory.demo1.persistant.EntityManager;
import com.tactfactory.demo1.persistant.HistoryRepository;

/**
 * Clean history command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class CleanHistoryCommand extends BaseCommand {

    // Local
    CommandHistory commandHistory = CommandHistory.getCommandHistory();

    // Database
    EntityManager manager = EntityManager.getInstance();
    HistoryRepository repo = manager.getHistoryRepository();

    public CleanHistoryCommand() {
        this.isPersist = false;
    }

    @Override
    public void redo() {
        int count = 0;

        if (Calculator.IS_LOCAL) {
            count = this.commandHistory.getCommands().size();
            this.commandHistory.getCommands().clear();
        } else {
            count = this.repo.getAll().size();
            this.repo.deleteAll();
        }

        ConsoleUtils.display("History clean of %d commands.", count);
    }

}
