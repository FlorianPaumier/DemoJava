package com.tactfactory.demo1;

import java.util.ArrayList;

import com.tactfactory.demo1.calculator.AddCommand;
import com.tactfactory.demo1.calculator.Command;
import com.tactfactory.demo1.calculator.CommandType;
import com.tactfactory.demo1.calculator.ConsoleUtils;
import com.tactfactory.demo1.calculator.DivCommand;
import com.tactfactory.demo1.calculator.MultiCommand;
import com.tactfactory.demo1.calculator.SubCommand;

public class Application {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ArrayList<Command> commands = new ArrayList<Command>();

        CommandType choice = CommandType.Unknow;

        do {
            System.out.println("Operations :");
            System.out.println("\t- Addition : 1");
            System.out.println("\t- Subtraction : 2");
            System.out.println("\t- Multiplication : 3");
            System.out.println("\t- Division : 4");
            System.out.println("\t- Display History : 7");
            System.out.println("\t- Clear History : 8");
            System.out.println("\t- Quit : 9");
            choice = CommandType.parse(ConsoleUtils.displayAndAsk("Choose your operation"));

            Command command = (Command) choice.getType().newInstance();
//            switch (choice) {
//            case Addition :
//                command = new AddCommand();
//                break;
//            case Subtraction:
//                command = new SubCommand();
//                break;
//            case Multiplication:
//                command = new MultiCommand();
//                break;
//            case Division:
//                command = new DivCommand();
//                break;
//            case ListHistory:
//                for (Command histoCommand : commands) {
//                    histoCommand.displayResult();
//                }
//                break;
//            case CleanHistory:
//                commands.clear();
//                break;
//            case Quit:
//            default:
//                break;
//            }

            if (command != null) {
                command.ask();
                command.displayResult();
//                ConsoleUtils.displayAndAsk("");
                commands.add(command);
            }

        } while (choice != CommandType.Quit);

        System.out.println("bye !!");
    }
}







