package com.tactfactory.demo1.calculator.command;

import com.tactfactory.demo1.calculator.BaseCommand;

/**
 * Unknow command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class UnknowCommand extends BaseCommand {

    public UnknowCommand() {
        this.isPersist = false;
        this.isInternal = true;
    }

    @Override
    public void redo() {
        System.out.println("Command not found !!!");
    }

}
