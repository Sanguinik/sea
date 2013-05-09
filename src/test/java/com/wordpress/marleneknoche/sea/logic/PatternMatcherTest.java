package com.wordpress.marleneknoche.sea.logic;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PatternMatcherTest {

	private PatternMatcher patternMatcher;
	private static final String SEQUENCE = "AGGCTAGACGAGGGCTAG7TCGGGGCAGTA";
	
	private static final String BROWN_EYES = "CAGCAA";
	
	
	@Before
	public void setUp(){
		patternMatcher = new PatternMatcher();
	}

	@Test
	public void findGGGtest() {
		
		boolean hasGGG = patternMatcher.findGGG(SEQUENCE);
		
		assertTrue(hasGGG);
		//nach 'ggg' suchen und checken, ob davor oder danach auch ein g ist
				
	}
	
	@Test
	public void checkFirstOccurenceOfCTAGTest(){
		
		int position = patternMatcher.checkFirstOccurenceOfCTAG(SEQUENCE);
		
		assertEquals(4, position);
		
	}
	
	
	@Test
	public void hasBrownEyesTest(){
		boolean brownEyes = patternMatcher.hasBrownEyes(BROWN_EYES);
		assertTrue(brownEyes);
	}
	
	@Test
	public void hasNoBrownEyesTest(){
		
		boolean brownEyes = patternMatcher.hasBrownEyes(SEQUENCE);
		
		assertFalse(brownEyes);
		
	}
	
	
}
