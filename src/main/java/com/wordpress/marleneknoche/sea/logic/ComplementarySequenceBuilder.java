package com.wordpress.marleneknoche.sea.logic;

/**
 * 
 * @author marlene
 *
 */

public class ComplementarySequenceBuilder {

	public String invertNucleobases(String nucleobaseString) {

		String inverted = "";
			
		for(int i = nucleobaseString.length()-1; i >= 0;i--){
						
			String actual = nucleobaseString.substring(i,i+1);
			String changedChar;		
			switch(actual){
			case "A" :
				changedChar = actual.replace('A', 'T');
				break;
			case "T" :
				changedChar = actual.replace('T', 'A');
				break;
			case "G" :
				changedChar = actual.replace('G', 'C');
				break;
			case "C" :
				changedChar = actual.replace('C', 'G');
				break;
			default:
				changedChar = "";
			}
			
			inverted += changedChar;
			
		}
		
		return inverted;
	}

}
