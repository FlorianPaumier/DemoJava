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

    protected String operation = "unknow";

    protected Integer val;
    protected Integer val2;
    protected Integer result;

    protected Boolean isPersist = true;
    protected Boolean isInternal = false;

    /**
     * @return the created date time of the command.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Display/ask value of the command.
     */
    public void ask() {
        this.val = ConsoleUtils.displayAndAsk("Enter value");
        this.val2 = ConsoleUtils.displayAndAsk("Enter value");
    }

    /** Display help message of the command. */
    public void help() {
        System.out.println("This command has no help ! (call the dev !)");
    }

    /** Display full function and result */
    public void displayResult() {
        System.out.println(
                String.format("[%s] %d %s %d = %d",
                        this.createdAt.toString(),
                        this.val,
                        this.operation,
                        this.val2,
                        this.result));
    }

    public boolean isPersist() {
        return this.isPersist;
    }
}
