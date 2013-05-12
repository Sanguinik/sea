package com.wordpress.marleneknoche.sea.logic;

/**
 * 
 * The ComplementarySequenceBuilder is a stateless service that provides the
 * method for creating a complementary nucleobase sequence.
 * 
 * @author marlene
 * 
 */

public class ComplementarySequenceBuilder {

	/**
	 * 
	 * This method takes a nucleobase sequence, inverts it and creates its
	 * complementary sequence.
	 * 
	 * @param nucleobaseString
	 *            The nucleobase sequence that should be inverted.
	 * @return String The inverted String of a nucleobase sequence.
	 */
	public String invertNucleobases(String nucleobaseString) {

		String inverted = "";

		for (int i = nucleobaseString.length() - 1; i >= 0; i--) {

			String actual = nucleobaseString.substring(i, i + 1);
			String changedChar;
			switch (actual) {
			case "A":
				changedChar = actual.replace('A', 'T');
				break;
			case "T":
				changedChar = actual.replace('T', 'A');
				break;
			case "G":
				changedChar = actual.replace('G', 'C');
				break;
			case "C":
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
