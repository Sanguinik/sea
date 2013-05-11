package com.wordpress.marleneknoche.sea.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class TextFileReaderTest {

	private static final String TEST_TEXT = "GTAC";
	private static final String EMPTY_TEXT = "";
	private static final File TEXT_FILE = new File(Thread.currentThread().getContextClassLoader().getResource("testtext.txt").getFile()) ;
	

	
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
			
		
		assertEquals(TEST_TEXT, loadedText);
			
	}
	
	@Test
	public void loadTextNotNullTest() {
		
		String loadedText = textFileReader.loadText(null);
		
		assertTrue(loadedText == EMPTY_TEXT);
		
	}
	
	

}
