package com.wordpress.marleneknoche.sea.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class is responsible for all methods that are used in correlation with
 * counting nucleobases.
 * 
 * @author marlene
 * 
 */

public class NucleobaseCounter {

	/**
	 * 
	 * This method counts how often each nucleobase in a sequence exists.
	 * 
	 * @param nucleobaseSequence
	 *            The sequence of nucleobases.
	 * @return HashMap<String,Integer> with all nucleobases and the number of
	 *         their occurrence.
	 */
	public Map<String, Integer> countNucleobases(String nucleobaseSequence) {

		Map<String, Integer> nucleobaseMap = new HashMap<String, Integer>();

		for (int i = 0; i < nucleobaseSequence.length(); i++) {
			String actual = nucleobaseSequence.substring(i, i + 1);
			if (nucleobaseMap.containsKey(actual)) {
				nucleobaseMap.put(actual, nucleobaseMap.get(actual) + 1);
			} else {
				nucleobaseMap.put(actual, 1);
			}
		}

		return nucleobaseMap;
	}

	/**
	 * 
	 * This method counts all purines in a given nucleobase sequence.
	 * 
	 * @param nucleobaseMap
	 *            A map of the nucleobases with its occurence in a sequence.
	 * @return int The number of purines in a sequence.
	 */
	public int countPurines(Map<String, Integer> nucleobaseMap) {

		return nucleobaseMap.get("A") + nucleobaseMap.get("G");
	}

	/**
	 * 
	 * This method counts all pyrimidines in a given nucleobase sequence.
	 * 
	 * @param nucleobaseMap
	 *            A map of the nucleobases with its occurence in a sequence.
	 * @return int The number of pyrimidines in a sequence.
	 */
	public int countPyrimidines(Map<String, Integer> nucleobaseMap) {
		return nucleobaseMap.get("C") + nucleobaseMap.get("T");
	}

	/**
	 * 
	 * This method prooves wether there are more purines than pyrimidines within
	 * a sequence.
	 * 
	 * @param nucleobaseMap
	 *            A map of the nucleobases with its occurence in a sequence.
	 * @return true if more purines than pyrimidines extists and returns false
	 *         if there are equal or less purines than pyrimidines within a
	 *         sequence.
	 */
	public boolean hasMorePurinesThanPyrimidines(
			Map<String, Integer> nucleobaseMap) {

		if (countPurines(nucleobaseMap) > countPyrimidines(nucleobaseMap)) {
			return true;
		}

		return false;
	}

}
