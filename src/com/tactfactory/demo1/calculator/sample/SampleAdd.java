package com.tactfactory.demo1.calculator.sample;

import java.util.Scanner;

public class SampleAdd {
	
	public static void test() {
		System.out.println("My Calculator !!\r\n============================");
		
		 Scanner in = new Scanner(System.in);
	     System.out.print("Please enter first number : ");
	     String val1 = in.nextLine();    // In from keyboard
	     Integer val1i = Integer.valueOf(val1);
	     
	     System.out.print("Please enter 2nd number : ");
	     String val2 = in.nextLine();    // In from keyboard 
	     Integer val2i = Integer.valueOf(val2);
	     
	     System.out.println( val1 + " + " + val2 + " = " + (val1i+val2i)); // Out Screen
	}

}
