package com.tactfactory.demo1;

import java.util.ArrayList;

public class LoopBase {

	public static void test() {
		int i = 0;
		
		// Do-While
		do {
			++i;
			// Code
		} while (i < 10);
		
		// While
		while (i < 20) {
			++i;
			// Code
		}
		
		// For
		for (i = 0; i < 10; i++) {
			// Code
		}
		
		
		// Foreach
		ArrayList<Integer> tmp = new ArrayList<>();
		for (Integer integer : tmp) {
			
		}
		
		for (int j = 0; j < tmp.size(); j++) {
			Integer integer = tmp.get(j);
			
		}
		
		
		// Sample
//		HashMap<String, Integer> tmp = new HashMap<>();
//		tmp.put("1", 10);
//		tmp.put("5", 50);
//		
//		tmp.get("1");
//		
//		for (String key : tmp.keySet()) {
//			System.out.println(key);
//		}
//		
//		for (Integer integer : tmp.values()) {
//			System.out.println(integer);
//		}
//		
//		for (Entry<String, Integer> val : tmp.entrySet()) {
//			System.out.println(val.getKey() + " " + val.getValue());
//		}
//		
//		for (int j = 0; j < tmp.size(); j++) {
//			Entry<String, Integer> val = tmp.entrySet().iterator().next();
//			
//		}
	}
	
}
