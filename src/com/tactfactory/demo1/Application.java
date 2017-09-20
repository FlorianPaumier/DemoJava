package com.tactfactory.demo1;

import java.io.Console;
import java.util.Scanner;

public class Application {
	
	public static void main(String[] args) {
		
		System.out.println("Hello W");
		
//		Console console = System.console();
//		
//        String username = console.readLine("Please enter user name : ");   
//        System.out.println("You entered : " + username);
		
		 Scanner in = new Scanner(System.in);
	     System.out.print("Please enter user name : ");
	     String username = in.nextLine();    // In from keyboard 
	     
	     System.out.println(username); // Out Screen
	}
}
