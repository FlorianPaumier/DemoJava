package com.tactfactory.demo1.calculator;

public class DivCommand extends BaseCommand {

    protected Integer val;
    protected Integer val2;

    @Override
    public void ask() {
        System.out.println("== Mode Division ==");

        this.val = ConsoleUtils.displayAndAsk("Enter value");
        this.val2 = ConsoleUtils.displayAndAsk("Enter value");
    }

    @Override
    public void displayResult() {
        String operation = ":";
        System.out.println(String.format("%d %s %d = %d", this.val, operation, this.val2, this.redo()));
    }

    @Override
    public Integer redo() {
        return val / val2;
    }

}
