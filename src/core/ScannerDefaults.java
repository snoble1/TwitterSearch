package core;

import java.util.Scanner;

public class ScannerDefaults {
	public static String readLine(Scanner scanner, String defaultValue) {
		try {
			return scanner.nextLine();
		} catch (Exception e) {
			scanner.nextLine();
			return defaultValue;
		}
	}
	
	public static boolean readBoolean(Scanner scanner, boolean defaultValue) {
		try {
			return scanner.nextBoolean();
		} catch (Exception e) {
			scanner.nextLine();
			return defaultValue;
		}
	}
	
	public static int readInteger(Scanner scanner, int defaultValue) {
		try {
			return scanner.nextInt(10);
		} catch (Exception e) {
			scanner.nextLine();
			return defaultValue;
		}
	}
}
