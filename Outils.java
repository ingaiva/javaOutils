package javaOutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Outils {

	public static String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(new java.util.Date());
	}

	static boolean isNumeric(String mot) {
		if (mot.charAt(0) == '-')
			mot = mot.substring(1);
		return mot.chars().allMatch(x -> Character.isDigit(x));
//		for (int i = 0; i < mot.length(); i++) {
//			if (!Character.isDigit(mot.charAt(i)))
//				return false;
//		}
//		return true;
	}

	static boolean isNumericRegEx(String mot) {
		String regexNum = "-{0,1}(?!0)\\d+";
		return mot.matches(regexNum);
	}

	static ArrayList<String> toArray(String[] tabStr) {
		return new ArrayList<String>(Arrays.asList(tabStr));
	}

	static ArrayList<Integer> toArray(Integer[] tabInt) {
		return new ArrayList<Integer>(Arrays.asList(tabInt));
	}

	static void listerEnvVar() {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}
	}

	static String getDeskTopPath() {
//	String oneDrivePath=System.getenv("OneDrive");
		File dirRoot = new File(
				System.getProperty("user.home") + File.separator + "OneDrive" + File.separator + "Bureau");
		return dirRoot.getPath();
	}

	static void readFileToConsole(File monFile) {
		try {
			if (monFile.exists()) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(new FileInputStream(monFile), "UTF-8"));
				String line;
				do {
					line = reader.readLine();
					if (line != null)
						System.out.println(line);
				} while (line != null);
				reader.close();
			} else
				System.out.println("Le fichier  '" + monFile.getPath() + "' n'existe pas");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void writeToFile(File monFile, ArrayList<String> data) {
		try {
			if (!monFile.exists())
				monFile.createNewFile();

			FileWriter writer = new FileWriter(monFile);
			BufferedWriter bwriter = new BufferedWriter(writer);

			for (String elt : data) {
				bwriter.write(elt);
				bwriter.newLine();
			}
			bwriter.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
