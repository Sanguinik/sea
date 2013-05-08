package com.wordpress.marleneknoche.sea.logic;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TextFileReaderTest {

	private static final String TEST_TEXT = "GTAC";
	private static final String EMPTY_TEXT = "";
	private static final String TEXT_FILE = "\testtext.txt";
	
	
	private TextFileReader textFileReader;
	
	@Before
	public void setUp(){
		textFileReader  = new TextFileReader();
		
	}
	
	
	/**
	 * This testcase prooves the correct way of loading the textfile.
	 */
	@Test
	public void loadTextTest() {
		
		String loadedText = textFileReader.loadText(TEXT_FILE);
			
		System.out.println("Geladener Text:" + loadedText);
		
		assertTrue(loadedText == TEST_TEXT);
			
	}
	
	@Test
	public void loadTextNotNullTest() {
		
		String loadedText = textFileReader.loadText(null);
		
		assertTrue(loadedText == EMPTY_TEXT);
		
	}
	
	

}
