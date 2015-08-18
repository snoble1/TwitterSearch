package core;

import java.util.Scanner;

public class TwitterSearch {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	// Project resource.
	public static void test1() {
		String[][] data = DataParser.getData("Sample.txt", false);

		DataParser.printData(data);
	}

	// File system file.
	public static void test2() {
		String filepath = System.getProperty("user.home") + "\\My Documents\\";
		String[][] data = DataParser.getData(filepath + "Sample.txt", true, 2, 3);

		DataParser.printData(data);
	}
	
	// User defined file.
	public static void test3() {
		Scanner scanner = null;
		String[][] data = null;

		try {
			scanner = new Scanner(System.in);

			System.out.print("Filename ?: ");
			String filename = ScannerDefaults.readLine(scanner, "Sample.txt");

			System.out.print("Is External ?: ");
			boolean isExternal = ScannerDefaults.readBoolean(scanner, false);

			System.out.print("Has Metadata ?: ");
			boolean hasMetadata = ScannerDefaults.readBoolean(scanner, true);

			if (!hasMetadata) {
				System.out.print("Rows ?: ");
				int rows = ScannerDefaults.readInteger(scanner, 2);

				System.out.print("Columns ?: ");
				int cols = ScannerDefaults.readInteger(scanner, 3);
				
				data = DataParser.getData(filename, isExternal, rows, cols);
			} else {
				data = DataParser.getData(filename, isExternal);
			}
		} catch (Exception e) {
			System.out.println("Error occured; using default values: " + e.getMessage());
		} finally {
			scanner.close();
		}

		DataParser.printData(data);
	}
}