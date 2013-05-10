package com.wordpress.marleneknoche.sea.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * This class is used to load the text of a text file.
 * 
 * @author marlene
 * 
 */

public class TextFileReader {

	/**
	 * This method loads a text file and extracts its content to a string.
	 * 
	 * @param textFile
	 *            The path to the file should be read.
	 * @return a string with the text of the file
	 */

	public String loadText(File textFile) {

		String documentText = "";

		if (textFile == null) {
			return documentText;
		}

		FileReader fileReader;
		try {
			
			fileReader = new FileReader(textFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {

				documentText += line;
			}

			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
		
		return documentText.toUpperCase();
	}

}
