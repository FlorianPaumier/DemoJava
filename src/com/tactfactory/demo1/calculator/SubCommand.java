package com.tactfactory.demo1.calculator;

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
    public Integer redo() {
        return val - val2;
    }
}
