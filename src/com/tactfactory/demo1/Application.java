package com.tactfactory.demo1;

import java.util.ArrayList;

import com.tactfactory.demo1.calculator.AddCommand;
import com.tactfactory.demo1.calculator.Command;
import com.tactfactory.demo1.calculator.ConsoleUtils;
import com.tactfactory.demo1.calculator.DivCommand;
import com.tactfactory.demo1.calculator.MultiCommand;
import com.tactfactory.demo1.calculator.SubCommand;

public class Application {

    public static void main(String[] args) {
        ArrayList<Command> commands = new ArrayList<Command>();

        Integer choice = Integer.MAX_VALUE;

        do {
            System.out.println("Operations :");
            System.out.println("\t- Addition : 1");
            System.out.println("\t- Subtraction : 2");
            System.out.println("\t- Multiplication : 3");
            System.out.println("\t- Division : 4");
            System.out.println("\t- Display History : 8");
            System.out.println("\t- Quit : 9");
            choice = ConsoleUtils.displayAndAsk("Choose your operation");

            Command command = null;
            switch (choice) {
            case 1:
                command = new AddCommand();
                break;
            case 2:
                command = new SubCommand();
                break;
            case 3:
                command = new MultiCommand();
                break;
            case 4:
                command = new DivCommand();
                break;
            case 8:
                for (Command histoCommand : commands) {
                    histoCommand.displayResult();
                }
                break;
            case 9:
                break;
            default:
                break;
            }

            if (command != null) {
                command.ask();
                command.displayResult();
//                ConsoleUtils.displayAndAsk("");
                commands.add(command);
            }

        } while (choice != 9);

        System.out.println("bye !!");
    }
}







