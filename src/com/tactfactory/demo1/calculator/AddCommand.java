package com.tactfactory.demo1.calculator;

/**
 * Addition command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class AddCommand extends BaseCommand {

    public AddCommand() {
        this.operation = "+";
    }

    @Override
    public Integer redo() {
        return this.val + this.val2;
    }
}
