package javaOutils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Outils {
	
	public static String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(new java.util.Date());
	}
	
	static boolean isNumeric(String mot) {
		for (int i = 0; i < mot.length(); i++) {
			if (!Character.isDigit(mot.charAt(i)))
				return false;
		}
		return true;
	}
	static ArrayList<String> toArray(String[] tabStr) {
		return new ArrayList <String> ( Arrays.asList(tabStr));			
	}
	
	static ArrayList<Integer> toArray(Integer[] tabInt) {
		return new ArrayList <Integer> ( Arrays.asList(tabInt));			
	}
}
