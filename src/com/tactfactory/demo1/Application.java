package com.tactfactory.demo1;

import com.tactfactory.demo1.calculator.Command;
import com.tactfactory.demo1.calculator.CommandHistory;
import com.tactfactory.demo1.calculator.CommandType;
import com.tactfactory.demo1.calculator.ConsoleUtils;

public class Application {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        CommandType choice = CommandType.Unknow;
        Command command = null;

        do {
            ConsoleUtils.displayMenu();

            choice = CommandType.parse(ConsoleUtils.displayAndAsk("Choose your operation"));
            command = choice.makeCommand();

            if (command != null) {
                command.redo();

                if (command.isPersist()) {
                    CommandHistory.getCommandHistory().getCommands().add(command);
                }
            }

        } while (choice != CommandType.Quit);

        System.out.println("bye !!");
    }
}







