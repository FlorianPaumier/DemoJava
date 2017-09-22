package com.tactfactory.demo1.calculator.command;

import com.tactfactory.demo1.calculator.BaseCommand;

/**
 * Subtraction command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class SubCommand extends BaseCommand {

    public SubCommand() {
        this.operation = "-";
    }

    @Override
    public void redo() {
        this.ask();
        this.result = this.val - this.val2;
        this.displayResult();
    }
}
