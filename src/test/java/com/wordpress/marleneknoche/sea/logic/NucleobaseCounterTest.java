package com.wordpress.marleneknoche.sea.logic;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class NucleobaseCounterTest {

	private NucleobaseCounter nucleobaseCounter;
	private static final String TEST_STRING = "GTACGCCTGGGAGTCGACTGACTGCTGAAGATACAGAACCTGA";
	
	@Before
	public void setUp(){
		nucleobaseCounter = new NucleobaseCounter();
	}

	@Test
	public void countNucleobasesTest() {
		
		Map<String,Integer> nucleobaseMap = new HashMap<String,Integer>();
		
		nucleobaseMap = nucleobaseCounter.countNucleobases(TEST_STRING);
		
		assertEquals(13, nucleobaseMap.get("G"),0);
		assertEquals(8, nucleobaseMap.get("T"),0);
		assertEquals(10, nucleobaseMap.get("C"),0);
		assertEquals(12, nucleobaseMap.get("A"),0);
	}
	
	@Test
	public void countPurinesTest(){
		
		
		
		Map<String,Integer> nucleobaseMap = new HashMap<String,Integer>();
		
		nucleobaseMap.put("G", 13);
		nucleobaseMap.put("T", 8);
		nucleobaseMap.put("C", 10);
		nucleobaseMap.put("A", 12);
		
		int numberOfPurines = nucleobaseCounter.countPurines(nucleobaseMap);
		
		assertEquals(25, numberOfPurines);
		
	}
	
	@Test
	public void countPyrimidinesTest(){
		
		//C+T=py
		
		Map<String,Integer> nucleobaseMap = new HashMap<String,Integer>();
		
		nucleobaseMap.put("G", 13);
		nucleobaseMap.put("T", 8);
		nucleobaseMap.put("C", 10);
		nucleobaseMap.put("A", 12);
		
		int numberOfPyrimidines = nucleobaseCounter.countPyrimidines(nucleobaseMap);
		
		assertEquals(18, numberOfPyrimidines);
		
	}

}
