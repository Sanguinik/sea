package com.wordpress.marleneknoche.sea.logic;

/**
 * 
 * @author marlene
 *
 */

public class PatternMatcher {

	public boolean findGGG(String sequence) {
		// TODO Auto-generated method stub
		return false;
	}

	public int checkFirstOccurenceOfCTAG(String sequence) {
		return sequence.indexOf("CTAG") + 1;
	}

	public boolean hasBrownEyes(String sequence) {
		
		if(sequence.contains("CAG")){
			int index = sequence.indexOf("CAG");
			
			if(sequence.charAt(index + 3) == 'C' || sequence.charAt(index + 3) == 'G'){
				
				if(sequence.charAt(index + 4) != 'T' && sequence.charAt(index+5) != 'T'){
					return true;
				}
				
			}
			
		}
		
		return false;
	}

}
