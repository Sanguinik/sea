package com.wordpress.marleneknoche.sea.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FileChooserController {

	@FXML
	private TextField textFileURL;
	
	@FXML
	public void analyze(){
		ViewManager.getInstance().loadReportScreen();	
	}
	
	@FXML
	public void chooseFile(){
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extensionFilter);
		
		Sequence.getInstance().setFile(fileChooser.showOpenDialog(null));

		textFileURL.setText(Sequence.getInstance().getFile().getAbsolutePath());
	}
}
