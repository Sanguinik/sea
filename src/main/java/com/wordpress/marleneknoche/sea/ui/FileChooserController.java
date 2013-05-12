package com.wordpress.marleneknoche.sea.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * This is the controller class for the FileLoaderScreen. It provides the
 * methods needed to handle the UI interactions.
 * 
 * @author marlene
 * 
 */

public class FileChooserController {

	@FXML
	private TextField textFileURL;

	/**
	 * This method defines the action for the analyze button in the UI. It loads
	 * the ReportScreen.
	 */
	@FXML
	public void analyze() {
		ViewManager.getInstance().loadReportScreen();
	}

	/**
	 * This method defines the action for the chooseFile button in the UI. It
	 * gets a *.txt-file from the file system.  
	 */
	@FXML
	public void chooseFile() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
				"Text files (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extensionFilter);

		Sequence.getInstance().setFile(fileChooser.showOpenDialog(null));

		textFileURL.setText(Sequence.getInstance().getFile().getAbsolutePath());
	}
}
