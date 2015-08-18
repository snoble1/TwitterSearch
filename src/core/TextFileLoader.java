package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFileLoader {
	public static void read(BufferedReader reader, boolean closeReader)
			throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void read(String filename, boolean isExternal)
			throws IOException {
		read(load(filename, isExternal), true);
	}

	public static BufferedReader load(String filename, boolean isExternal)
			throws IOException {
		if (isExternal) {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(filename);

			// Always wrap FileReader in BufferedReader.
			return new BufferedReader(fileReader);
		} else {
			ClassLoader loader = TextFileLoader.class.getClassLoader();
			InputStream stream = loader.getResourceAsStream("resources/" + filename);
			
			return new BufferedReader(new InputStreamReader(stream));
		}
	}
}
