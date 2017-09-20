package com.tactfactory.demo1;

public class IfBase {

	public static void test() {
		int i = 1;
		
		// If statement
		if (i == 10) {
			// Code to execute
		}
		
		// Ternaire
		int j = (i==10) ? 2 : 1;		
		if (i==10) { j = 2; } else { j = 1; }
		
		// Switch statement
		switch (i) {
			case 10:
				// Code for 10
				break;
			case 20:
			case 21:
			case 22:
				// Code for 20-22
			default:
				break;
		}	
	}
}
