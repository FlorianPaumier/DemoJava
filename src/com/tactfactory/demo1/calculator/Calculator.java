package com.tactfactory.demo1.calculator;

public class Calculator {

    public void run() {
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
