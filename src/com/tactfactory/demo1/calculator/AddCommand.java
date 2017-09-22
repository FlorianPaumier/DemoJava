package com.tactfactory.demo1.calculator;

/**
 * Addition command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class AddCommand extends BaseCommand {

    protected Integer val;
    protected Integer val2;

    @Override
    public void ask() {
        System.out.println("== Mode Addition ==");

        this.val = ConsoleUtils.displayAndAsk("Enter value");
        this.val2 = ConsoleUtils.displayAndAsk("Enter value");
    }

    @Override
    public Integer redo() {
        return val + val2;
    }

    @Override
    public void displayResult() {
        String operation = "+";
        System.out.println(String.format("%d %s %d = %d", this.val, operation, this.val2, this.redo()));
    }

}
