package com.tactfactory.demo1.calculator;

import java.util.Scanner;

/**
 * Console utility.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class ConsoleUtils {

    public static void displayMenu() {
        System.out.println("Operations :");
        for (CommandType type : CommandType.getAvailableUserCommand()) {
            System.out.println(String.format("\t- %s \t: %d", type.getTitle(), type.getValue()));
        }
    }

    public static Integer displayAndAsk(String displayMsg) {
        Integer vali = Integer.MAX_VALUE;
        Scanner in = new Scanner(System.in);

        do {
            System.out.print(String.format("%s : ", displayMsg));
            String val = in.nextLine();
            try {
                vali = Integer.valueOf(val);
            } catch (Exception e) {
                System.out.println("Only numerical value !!");
            }
        } while (vali == Integer.MAX_VALUE);

        return vali;
    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static void display(String message, Object... args) {
        System.out.println(String.format(message, args));
    }
}
