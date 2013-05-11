package com.wordpress.marleneknoche.sea.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FileChooserController {

	@FXML
	private TextField textfileURL;
	
	@FXML
	public void analyze(){
		ViewManager.getInstance().loadReportScreen();
	}
}
