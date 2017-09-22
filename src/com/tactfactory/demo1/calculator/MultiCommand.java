package com.tactfactory.demo1.calculator;

public class MultiCommand extends BaseCommand {

    public MultiCommand() {
        this.operation = "x";
    }

    @Override
    public Integer redo() {
        return val * val2;
    }

}
