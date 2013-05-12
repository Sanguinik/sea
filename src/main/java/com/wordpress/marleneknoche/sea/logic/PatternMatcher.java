package com.wordpress.marleneknoche.sea.logic;

/**
 * 
 * The PatternMatcher provides all methods that are needed to check a DNA
 * sequence for several patterns.
 * 
 * @author marlene
 * 
 */

public class PatternMatcher {

	/**
	 * 
	 * This method counts all occurrences of the pattern 'GGG' within a
	 * nucleobase sequence.
	 * 
	 * @param sequence
	 *            The sequence which should be checked.
	 * @return int The number of 'GGG' within the sequence.
	 */
	public int countGGG(String sequence) {

		int numberOfGGG = 0;

		String replacedPattern = sequence.replaceAll("(?<!G)[G]{3}(?!G)", "V");

		for (int i = 0; i < replacedPattern.length(); i++) {
			if (replacedPattern.charAt(i) == 'V') {
				numberOfGGG += 1;
			}
		}

		return numberOfGGG;
	}

	/**
	 * 
	 * This method looks for the first occurrence of the pattern 'CTAG'.
	 * 
	 * @param sequence
	 *            The sequence which should be checked.
	 * @return int The position of the first occurence.
	 */
	public int checkFirstOccurenceOfCTAG(String sequence) {
		return sequence.indexOf("CTAG") + 1;
	}

	/**
	 * 
	 * This method checks weather a person has brown eyes or not.
	 * 
	 * @param sequence
	 *            The sequence which should be checked.
	 * @return true if the person has brown eyes and returns false if the person
	 *         has no brown eyes.
	 */
	public boolean hasBrownEyes(String sequence) {

		if (sequence.contains("CAG")) {
			int index = sequence.indexOf("CAG");

			if (sequence.charAt(index + 3) == 'C'
					|| sequence.charAt(index + 3) == 'G') {

				if (sequence.charAt(index + 4) != 'T'
						&& sequence.charAt(index + 5) != 'T') {
					return true;
				}

			}

		}

		return false;
	}

	
	/**
	 * 
	 * This method checks for sings for Frømingen's dischrypsia.
	 * 
	 * @param sequence
	 *            The sequence which should be checked.
	 * @return true if there is a pattern of exactly 4 purines followed by 4
	 *         pyrimidines. Else returns false.
	 */
	public boolean hasSignsForFromingensDischrypsia(String sequence) {

		String replaceC = sequence.replace('C', 'Y');
		String replaceT = replaceC.replace('T', 'Y');
		String replaceA = replaceT.replace('A', 'R');
		String allBasesReplaced = replaceA.replace('G', 'R');

		String patternToCheck = "RRRRYYYY";
		if (allBasesReplaced.contains(patternToCheck)) {

			char beforeFirstR = 'Y';
			char afterLastY = 'R';

			if (allBasesReplaced.indexOf(patternToCheck) != 0) {
				beforeFirstR = allBasesReplaced.charAt(allBasesReplaced
						.indexOf(patternToCheck) - 1);

				if ((allBasesReplaced.indexOf(patternToCheck) + 8) != allBasesReplaced
						.length()) {
					afterLastY = allBasesReplaced.charAt(allBasesReplaced
							.indexOf(patternToCheck) + 8);
				}
			}

			if (beforeFirstR == 'Y' && afterLastY == 'R') {
				return true;
			}
		}
		return false;

	}

}
