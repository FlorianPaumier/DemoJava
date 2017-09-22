package com.tactfactory.demo1.calculator.command;

import com.tactfactory.demo1.calculator.BaseCommand;

/**
 * Exit command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class QuitCommand extends BaseCommand {

    public QuitCommand() {
        this.isPersist = false;
    }

    @Override
    public void redo() {
        // Nothing to do !
    }

}
