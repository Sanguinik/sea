package com.wordpress.marleneknoche.sea.ui;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import com.wordpress.marleneknoche.sea.logic.ComplementarySequenceBuilder;
import com.wordpress.marleneknoche.sea.logic.NucleobaseCounter;
import com.wordpress.marleneknoche.sea.logic.PatternMatcher;
import com.wordpress.marleneknoche.sea.logic.TextFileReader;

public class ReportController {

	private PatternMatcher patternMatcher = new PatternMatcher();
	private NucleobaseCounter nucleobaseCounter = new NucleobaseCounter();
	private ComplementarySequenceBuilder complementarySequenceBuilder = new ComplementarySequenceBuilder();
	
	@FXML
	private TextArea task11;

	@FXML
	private TextArea task12;

	@FXML
	private TextArea task13;

	@FXML
	private TextArea task14;

	@FXML
	private TextArea task21;

	@FXML
	private TextArea task22;

	@FXML
	private TextArea task23;
	private Map<String, Integer> nucleobaseMap;

	@FXML
	public void newReport() {
		ViewManager.getInstance().loadFileLoaderScreen();
	}

	@FXML
	public void initialize() {
		File sequence = Sequence.getInstance().getFile();
		TextFileReader textFileReader = new TextFileReader();
		String loadedSequence = textFileReader.loadText(sequence);

		loadTask11(loadedSequence);
		loadTask12(loadedSequence);
		loadTask13(loadedSequence);
		loadTask14(loadedSequence);
		loadTask21(loadedSequence);
		loadTask22(loadedSequence);
		loadTask23(loadedSequence);

	}

	private void loadTask11(String loadedSequence) {
		// TODO Auto-generated method stub

	}

	private void loadTask12(String loadedSequence) {

		if (patternMatcher.hasBrownEyes(loadedSequence)) {
			task12.setText("This person has brown eyes.");
		} else {
			task12.setText("This person has no brown eyes.");
		}

	}

	private void loadTask13(String loadedSequence) {

		nucleobaseMap = new HashMap<String, Integer>();

		nucleobaseMap = nucleobaseCounter.countNucleobases(loadedSequence);

		int numberOfG = nucleobaseMap.get("G");
		int numberOfC = nucleobaseMap.get("C");
		int numberOfA = nucleobaseMap.get("A");
		int numberOfT = nucleobaseMap.get("T");

		task13.setText("Number of each nucleobase:\n \n" + "A: " + numberOfA
				+ "\n" + "C: " + numberOfC + "\n" + "G: " + numberOfG + "\n"
				+ "T: " + numberOfT);

	}

	private void loadTask14(String loadedSequence) {
		int indexPosition = patternMatcher
				.checkFirstOccurenceOfCTAG(loadedSequence);
		task14.setText("The location of the first occurence of 'CTAG' is:\n \n"
				+ indexPosition);
	}

	private void loadTask21(String loadedSequence) {
		int numberOfPurines = nucleobaseCounter.countPurines(nucleobaseMap);
		int numberOfPyrimidines = nucleobaseCounter.countPyrimidines(nucleobaseMap);
		boolean hasMorePurines = nucleobaseCounter.hasMorePurinesThanPyrimidines(nucleobaseMap);
	
		if(hasMorePurines){
			task21.setText("Purines: " + numberOfPurines + "\n" + "Pyrimidines: " + numberOfPyrimidines + "\n \n" + "The sequence has more purines than pyrimidines.");
		}else{
			task21.setText("Purines: " + numberOfPurines + "\n" + "Pyrimidines: " + numberOfPyrimidines + "\n \n" + "The sequence has less purines than pyrimidines.");
		}
		
	}

	private void loadTask22(String loadedSequence) {

		// TODO Auto-generated method stub

	}

	private void loadTask23(String loadedSequence) {
		String complementarySequence = complementarySequenceBuilder.invertNucleobases(loadedSequence);
		
		task23.setText("The complementary sequence of the given DNA: \n \n" + complementarySequence);
	}

}
