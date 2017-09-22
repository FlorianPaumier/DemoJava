package com.tactfactory.demo1.calculator;

public class DivCommand extends BaseCommand {

    public DivCommand() {
        this.operation = "/";
    }

    @Override
    public Integer redo() {
        return val / val2;
    }

}
