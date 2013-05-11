package com.wordpress.marleneknoche.sea.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PatternMatcherTest {

	private PatternMatcher patternMatcher;
	private static final String SEQUENCE = "GGGCTAGACGAGGGCTAGTCGGGGCAGTAGGATCTTGGG";
	private static final String SEQUENCE_WITH_NO_SIGN = "AGTGACTACGCTAGCTAGGTCATCTTCAAGGA";
	
	private static final String BROWN_EYES = "CAGCAA";
	
	
	@Before
	public void setUp(){
		patternMatcher = new PatternMatcher();
	}

	@Test
	public void countGGGtest() {
		
		int numberOfGGG = patternMatcher.countGGG(SEQUENCE);
		
		assertEquals(3, numberOfGGG);
		
	}
	
	@Test
	public void countNoGGGtest(){
		int numberOfGGG = patternMatcher.countGGG(SEQUENCE_WITH_NO_SIGN);
		assertEquals(0, numberOfGGG);
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
	
	
	@Test
	public void hasSignsForFromingensDischrypsiaTest(){
		
		boolean hasSigns = patternMatcher.hasSignsForFromingensDischrypsia(SEQUENCE);
		
		assertTrue(hasSigns);
		
	}
	
	@Test
	public void hasNoSignsForFromingensDischrypsiaTest(){
		
		boolean hasSigns = patternMatcher.hasSignsForFromingensDischrypsia(SEQUENCE_WITH_NO_SIGN);
		
		assertFalse(hasSigns);
		
	}
	
}
