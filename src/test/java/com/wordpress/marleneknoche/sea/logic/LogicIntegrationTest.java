package com.wordpress.marleneknoche.sea.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * This integration test of all classes from the logic package shows the
 * complete workflow for the given example from the coding contest.
 * 
 * @author marlene
 * 
 */

public class LogicIntegrationTest {

	private static final String SEQUENCE = "GGAATTTAGGGAGTTCCCACATTGCCCAGACGACTCGTATAGAATTGGTAGTTGGCCATGCGTCCATATCACAAAGACACAGTCCCTGGCCGACCACACTGTAACCACGAATATGCCCTATCGTACGGGTTGGGATGCACTTTTGAGTTATACGCGCTCGAATCTATGCCCAGTACACATGGTGCCGACACCTAACTAGGCAGTGAGGGGCACTCAGACCTGACATGAGCGGAAGAAAGAACCCGCGGGGGCCCCACGACGTAGCGGCGACGGCTCAACCAATGCCCCGCCCCTTTCATAAGGCCAAGCGGACTGGGCTTTCGCCCGAGTCTAAACCCACTGTATTTACCATTCATAGTCAACAGAGGGACTTTCAAAATTCCTAAACTGGTTACTGACTAAGAGGAATCCTCGCGCTAATGAAGACAACCTCCATAGAGGTCAAATGGCGCGCAGTTGACTTCAGTATTGACCTTCTTCAGGGTCCCCCATCTTTGATACTTCACTTATGGACCCGGCCACCGTGAGTTGAATCCCGGCGTCCCTCGCGTCCCCAACACAGACAATATTTTTACGTGTCCAAGGGCGGAAAGTGACGAGGTGAGAACTGGCGCCGCGAGACCGGCCCGATTTCTAATAGGCGGGATAGAGATCTGCCCGACGCATTTCACTTGTAGTCACTCACGGTATGACTGTGCATGCACTGACCGTCGCTGGCGTGTCTTTAATTTAAGCTAGGCTTGACGTGGAGTGCAGAATGACCATGTTCAAGGTGCTTCGGGGCTATATACTTGGGATAAACGCGATCCTGCGGAGTAGCGTCGAGAACACCGACTGCCGAATGTACAATCCGCGTGACAATGCCGAGGCTCGAGATATCACTTGAACTGCGGGCGAATCGATTCGAGAGCCCGATCGTTAACAAGTCGTCGGCTGTAGCCAATAATATCTTGGTTTTAGATCTTGAGTGTGGGGGCGTTTACTTAACCATCCGAACGCG";

	private static final File EXAMPLE_FILE = new File(Thread.currentThread()
			.getContextClassLoader().getResource("sequence.txt").getFile());

	private static final String COMPLEMENTARY_SEQUENCE = "CGCGTTCGGATGGTTAAGTAAACGCCCCCACACTCAAGATCTAAAACCAAGATATTATTGGCTACAGCCGACGACTTGTTAACGATCGGGCTCTCGAATCGATTCGCCCGCAGTTCAAGTGATATCTCGAGCCTCGGCATTGTCACGCGGATTGTACATTCGGCAGTCGGTGTTCTCGACGCTACTCCGCAGGATCGCGTTTATCCCAAGTATATAGCCCCGAAGCACCTTGAACATGGTCATTCTGCACTCCACGTCAAGCCTAGCTTAAATTAAAGACACGCCAGCGACGGTCAGTGCATGCACAGTCATACCGTGAGTGACTACAAGTGAAATGCGTCGGGCAGATCTCTATCCCGCCTATTAGAAATCGGGCCGGTCTCGCGGCGCCAGTTCTCACCTCGTCACTTTCCGCCCTTGGACACGTAAAAATATTGTCTGTGTTGGGGACGCGAGGGACGCCGGGATTCAACTCACGGTGGCCGGGTCCATAAGTGAAGTATCAAAGATGGGGGACCCTGAAGAAGGTCAATACTGAAGTCAACTGCGCGCCATTTGACCTCTATGGAGGTTGTCTTCATTAGCGCGAGGATTCCTCTTAGTCAGTAACCAGTTTAGGAATTTTGAAAGTCCCTCTGTTGACTATGAATGGTAAATACAGTGGGTTTAGACTCGGGCGAAAGCCCAGTCCGCTTGGCCTTATGAAAGGGGCGGGGCATTGGTTGAGCCGTCGCCGCTACGTCGTGGGGCCCCCGCGGGTTCTTTCTTCCGCTCATGTCAGGTCTGAGTGCCCCTCACTGCCTAGTTAGGTGTCGGCACCATGTGTACTGGGCATAGATTCGAGCGCGTATAACTCAAAAGTGCATCCCAACCCGTACGATAGGGCATATTCGTGGTTACAGTGTGGTCGGCCAGGGACTGTGTCTTTGTGATATGGACGCATGGCCAACTACCAATTCTATACGAGTCGTCTGGGCAATGTGGGAACTCCCTAAATTCC";

	@Test
	public void solveAllQuestionstest() {

		/*
		 * Prepare for the first task: Load the text file and extract the DNA
		 * sequence.
		 */

		TextFileReader textFileReader = new TextFileReader();

		String loadedSequence = textFileReader.loadText(EXAMPLE_FILE);

		assertEquals(SEQUENCE, loadedSequence);

		PatternMatcher patternMatcher = new PatternMatcher();

		/*
		 * Task 1.1 "Three distinct sequences of 'GGG' within any
		 * 1000-nucleobases signify an elevated risk to acquiring Tyberius
		 * syndrome. Based on the given DNA segment, is this female at such
		 * risk?"
		 * 
		 * In the given sequence the sequence the pattern 'GGG' exists 10 times.
		 * Under the assumption that this pattern has to be exactly 3 times
		 * within a 1000-nucleobases, the woman is not at risk.
		 */
		assertEquals(10, patternMatcher.countGGG(loadedSequence));

		/*
		 * Task 1.2 The sequence "CAG" followed by exactly one "C" or one "G"
		 * and then not followed by T in the next 2 slots signifies brown eyes.
		 * Does this female have brown eyes?"
		 * 
		 * In the given sequence there is no sequence matching the given
		 * pattern. Therefore the woman has no brown eyes.
		 */

		assertFalse(patternMatcher.hasBrownEyes(loadedSequence));

		/*
		 * Task 1.3 "How many of each nucleobase does this segment have?"
		 * 
		 * There are: 259 G's, 265 C's, 248 A's and 228 T's
		 */
		NucleobaseCounter nucleobaseCounter = new NucleobaseCounter();

		Map<String, Integer> nucleobaseMap = new HashMap<String, Integer>();

		nucleobaseMap = nucleobaseCounter.countNucleobases(loadedSequence);

		int numberOfG = nucleobaseMap.get("G");
		int numberOfC = nucleobaseMap.get("C");
		int numberOfA = nucleobaseMap.get("A");
		int numberOfT = nucleobaseMap.get("T");

		assertEquals(259, numberOfG, 0);
		assertEquals(265, numberOfC, 0);
		assertEquals(248, numberOfA, 0);
		assertEquals(228, numberOfT, 0);

		/*
		 * Task 1.4 "What's the location of the first occurrence of the sequence
		 * "CTAG" in the given segment(assume nucleobases are numbered from 1 to
		 * 1000)."
		 * 
		 * The position of the first occurrence of the sequence is at position
		 * 196.
		 */

		int indexPosition = patternMatcher
				.checkFirstOccurenceOfCTAG(loadedSequence);

		assertEquals(196, indexPosition, 0);

		/*
		 * Task 2.1 "Does this segment have more purines than pyrimidines?"
		 * 
		 * The given segment has more purines than purimidines.
		 */

		assertTrue(nucleobaseCounter
				.hasMorePurinesThanPyrimidines(nucleobaseMap));

		/*
		 * Task 2.2 "Four purines followed by four pyrimidines have been shown
		 * to have a strong correlation with the early onset of Frømingen's
		 * dischrypsia. Does this DNA strand show evidence for this correlation?
		 * "
		 * 
		 * In the assumption that it has to be exactly 4 purines followed by 4
		 * pyrimidines, the DNA strand shows no evidence for this correlation.
		 */
		assertFalse(patternMatcher
				.hasSignsForFromingensDischrypsia(loadedSequence));

		/*
		 * Task 2.3
		 * "What's the complementary sequence for the entire 1000-nucleobase segment?"
		 * 
		 * The complementary seuqence for the DNA is:
		 * 
		 * CGCGTTCGGATGGTTAAGTAAACGCCCCCACACTCAAGATCTAAAACCAAGATATTATTGGCTACAGCCGACGA
		 * CTTGTTAACGATCGGGCTCTCGAATCGATTCGCCCGCAGTTCAAGTGATATCTCGAGCCTCGGCATTGTCACGC
		 * GGATTGTACATTCGGCAGTCGGTGTTCTCGACGCTACTCCGCAGGATCGCGTTTATCCCAAGTATATAGCCCCG
		 * AAGCACCTTGAACATGGTCATTCTGCACTCCACGTCAAGCCTAGCTTAAATTAAAGACACGCCAGCGACGGTCA
		 * GTGCATGCACAGTCATACCGTGAGTGACTACAAGTGAAATGCGTCGGGCAGATCTCTATCCCGCCTATTAGAAA
		 * TCGGGCCGGTCTCGCGGCGCCAGTTCTCACCTCGTCACTTTCCGCCCTTGGACACGTAAAAATATTGTCTGTGT
		 * TGGGGACGCGAGGGACGCCGGGATTCAACTCACGGTGGCCGGGTCCATAAGTGAAGTATCAAAGATGGGGGACC
		 * CTGAAGAAGGTCAATACTGAAGTCAACTGCGCGCCATTTGACCTCTATGGAGGTTGTCTTCATTAGCGCGAGGA
		 * TTCCTCTTAGTCAGTAACCAGTTTAGGAATTTTGAAAGTCCCTCTGTTGACTATGAATGGTAAATACAGTGGGT
		 * TTAGACTCGGGCGAAAGCCCAGTCCGCTTGGCCTTATGAAAGGGGCGGGGCATTGGTTGAGCCGTCGCCGCTAC
		 * GTCGTGGGGCCCCCGCGGGTTCTTTCTTCCGCTCATGTCAGGTCTGAGTGCCCCTCACTGCCTAGTTAGGTGTC
		 * GGCACCATGTGTACTGGGCATAGATTCGAGCGCGTATAACTCAAAAGTGCATCCCAACCCGTACGATAGGGCAT
		 * ATTCGTGGTTACAGTGTGGTCGGCCAGGGACTGTGTCTTTGTGATATGGACGCATGGCCAACTACCAATTCTAT
		 * ACGAGTCGTCTGGGCAATGTGGGAACTCCCTAAATTCC
		 */
		ComplementarySequenceBuilder complementarySequenceBuilder = new ComplementarySequenceBuilder();
		String complementarySequence = complementarySequenceBuilder
				.invertNucleobases(loadedSequence);

		assertEquals(COMPLEMENTARY_SEQUENCE, complementarySequence);

	}

}
