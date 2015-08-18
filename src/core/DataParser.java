package core;

import java.io.BufferedReader;
import java.io.IOException;

public class DataParser {
	public static String[][] getData(String filename, boolean isExternal,
			int rows, int cols) {
		return getData(filename, isExternal, false, rows, cols);
	}

	public static String[][] getData(String filename, boolean isExternal) {
		return getData(filename, isExternal, true, 0, 0);
	}
	
	private static String[][] getData(String filename, boolean isExternal,
			boolean hasMetadata, int rows, int cols) {
		BufferedReader reader = null;

		try {
			reader = TextFileLoader.load(filename, isExternal);
			
			return getData(reader, hasMetadata, rows, cols);
		} catch (IOException e) {
			System.out.println("Unable to open file '" + filename + "'");
		} finally {
			try {
				// Always close files.
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	private static String[][] getData(BufferedReader reader,
			boolean hasMetadata, int rows, int cols) {
		String[][] data = null;
		String line = null;
		int currRow = 0;
		int currCol = 0;

		try {
			if (hasMetadata) {
				String[] metadata = reader.readLine().trim().split("\\s+");

				rows = Integer.parseInt(metadata[0], 10);
				cols = Integer.parseInt(metadata[1], 10);
			}

			data = new String[rows][cols];

			while ((line = reader.readLine()) != null) {
				// Use conditionals to add to array
				if (line.trim().isEmpty()) {
					currRow++;
					currCol = 0;
				} else {
					data[currRow][currCol++] = line;
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return data;
	}

	public static void printData(String[][] data) {
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				System.out.print(data[row][col] + ", ");
			}
			System.out.println();
		}
	}
}
