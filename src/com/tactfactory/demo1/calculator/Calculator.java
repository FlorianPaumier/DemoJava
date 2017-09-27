package com.tactfactory.demo1.calculator;

import com.tactfactory.demo1.persistant.EntityManager;
import com.tactfactory.demo1.persistant.HistoryRepository;

public class Calculator {

    public static final boolean IS_LOCAL = false;

    public void run() {
        EntityManager manager = EntityManager.getInstance();
        HistoryRepository repo = manager.getHistoryRepository();


        CommandType choice = CommandType.Unknow;
        Command command = null;

        do {
            ConsoleUtils.displayMenu();

            choice = CommandType.parse(ConsoleUtils.displayAndAsk("Choose your operation"));
            command = choice.makeCommand();

            if (command != null) {
                command.redo();

                if (command.isPersist()) {

                    if (IS_LOCAL) {
                        // Local
                        CommandHistory.getCommandHistory().getCommands().add(command);
                    } else {
                        // Database
                        repo.persist(command);
                    }
                }
            }

        } while (choice != CommandType.Quit);

        System.out.println("bye !!");
    }

}
