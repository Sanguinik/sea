package com.wordpress.marleneknoche.sea.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author marlene
 *
 */

public class NucleobaseCounter {

	
	public Map<String, Integer> countNucleobases(String testString) {
		
		Map<String,Integer> nucleobaseMap = new HashMap<String,Integer>();

		for(int i = 0; i<testString.length(); i++){
			String actual = testString.substring(i,i+1);
			if(nucleobaseMap.containsKey(actual)){
				nucleobaseMap.put(actual,nucleobaseMap.get(actual)+1);
			}else{
			nucleobaseMap.put(actual, 1);
			}
		}
		
		return nucleobaseMap;
	}

	public int countPurines(Map<String, Integer> nucleobaseMap) {
		//A+G=pu
		
		return nucleobaseMap.get("A") + nucleobaseMap.get("G");
	}

	public int countPyrimidines(Map<String, Integer> nucleobaseMap) {
		return nucleobaseMap.get("C") + nucleobaseMap.get("T");
	}

	public boolean hasMorePurinesThanPyrimidines(
			Map<String, Integer> nucleobaseMap) {
		
		if(countPurines(nucleobaseMap) > countPyrimidines(nucleobaseMap)){
			return true;
		}
		
		return false;
	}

}
