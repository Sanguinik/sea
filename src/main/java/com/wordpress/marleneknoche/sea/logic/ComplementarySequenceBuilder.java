package com.wordpress.marleneknoche.sea.logic;


public class ComplementarySequenceBuilder {

	public String invertNucleobases(String nucleobaseString) {

		String inverted = "";
			
		/*
		 * jedes zeichen auf stapel legen (push)
		 * (erstes ganz unten, letzes ganz oben)
		 * dann von oben alle abholen und invertieren (pop)
		 */
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
