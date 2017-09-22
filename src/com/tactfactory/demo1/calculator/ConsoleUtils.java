package com.tactfactory.demo1.calculator;

import java.util.Scanner;

public class ConsoleUtils {

    public static Integer displayAndAsk(String displayMsg) {
        Integer vali = Integer.MAX_VALUE;
        Scanner in = new Scanner(System.in);

        do {
            System.out.print(String.format("%s : ", displayMsg));
            String val = in.nextLine();
            try {
                vali = Integer.valueOf(val);
            } catch (Exception e) {
                System.out.println("Bad value !!");
            }
        } while (vali == Integer.MAX_VALUE);

        return vali;
    }
}
