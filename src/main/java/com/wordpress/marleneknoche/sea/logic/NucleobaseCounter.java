package com.wordpress.marleneknoche.sea.logic;

import java.util.HashMap;
import java.util.Map;

public class NucleobaseCounter {

	
	public Map<String, Integer> countNucleobases(String testString) {
		
		Map<String,Integer> nucleobaseMap = new HashMap<String,Integer>();

		for(int i = 0; i<testString.length(); i++){
			String actual = testString.substring(i,i+1);
			//System.out.println(actual);
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
		// TODO Auto-generated method stub
		return nucleobaseMap.get("C") + nucleobaseMap.get("T");
	}

}
