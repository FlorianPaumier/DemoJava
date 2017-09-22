package com.tactfactory.demo1.calculator.command;

import com.tactfactory.demo1.calculator.BaseCommand;

/**
 * Multiply command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class MultiCommand extends BaseCommand {

    public MultiCommand() {
        this.operation = "x";
    }

    @Override
    public void redo() {
        this.ask();
        this.result = this.val * this.val2;
        this.displayResult();
    }

}
