package com.wordpress.marleneknoche.sea.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComplementarySequenceBuilderTest {

	private ComplementarySequenceBuilder complementarySequenceBuilder;
	
	private static final String NUCLEOBASE_STRING = "TTAC";
	
	@Before
	public void setUp() {
		complementarySequenceBuilder = new ComplementarySequenceBuilder();
	}

	@Test
	public void invertNucleobasesTest() {
		String invertedString = complementarySequenceBuilder.invertNucleobases(NUCLEOBASE_STRING);
		
		assertEquals("GTAA", invertedString);
	}

}
