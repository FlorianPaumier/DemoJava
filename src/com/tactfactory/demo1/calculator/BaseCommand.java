package com.tactfactory.demo1.calculator;

import java.util.Date;

/**
 * Common function of Command.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public abstract class BaseCommand implements Command {

    /** Date Time of the created command. */
    protected Date createdAt = new Date();

    /**
     * @return the created date time of the command.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void ask() {
        System.out.println("This is command not full implemented !");
    }

    @Override
    public void help() {
        System.out.println("This command has no help ! (call the dev !)");
    }

}
