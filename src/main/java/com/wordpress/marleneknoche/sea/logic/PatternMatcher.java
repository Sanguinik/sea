package com.wordpress.marleneknoche.sea.logic;

/**
 * 
 * @author marlene
 * 
 */

public class PatternMatcher {

	;

	public boolean findGGG(String sequence) {
		// TODO Auto-generated method stub
		return sequence.contains("GGG");
	}

	public int checkFirstOccurenceOfCTAG(String sequence) {
		return sequence.indexOf("CTAG") + 1;
	}

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

	public boolean hasSignsForFromingensDischrypsia(String sequence) {

		String replaceC = sequence.replace('C', 'Y');
		String replaceT = replaceC.replace('T', 'Y');
		String replaceA = replaceT.replace('A', 'R');
		String allBasesReplaced = replaceA.replace('G', 'R');

		String patternToCheck = "RRRRYYYY";
		if (allBasesReplaced.contains(patternToCheck)) {
			
			char beforeFirstR = 'Y';
			char afterLastY = 'R';
			
			if(allBasesReplaced.indexOf(patternToCheck) != 0){
				beforeFirstR = allBasesReplaced.charAt(allBasesReplaced
						.indexOf(patternToCheck) - 1);			

				if((allBasesReplaced.indexOf(patternToCheck) + 8) != allBasesReplaced.length() ){
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
