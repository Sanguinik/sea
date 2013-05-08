package com.wordpress.marleneknoche.sea.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
	 * @param textFile The path to the file should be read.
	 * @return a string with the text of the file
	 */
	
	public String loadText(String textFile) {
				
		String documentText = "";
		
		InputStream fileInputStream;
		
		if(textFile == null){
			return documentText;
		}
		
		try{
			
			File file = new File(textFile);
			file.createNewFile();
			fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer bufferedText = new StringBuffer();	
			while(bufferedReader.readLine() != null){
			bufferedText.append(bufferedReader.readLine());
			}
			documentText = bufferedText.toString();
			System.out.println("Mein Text:" + documentText);
			
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return documentText;
	}

}
