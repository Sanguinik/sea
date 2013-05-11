package com.wordpress.marleneknoche.sea.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public final class ViewManager {

	private static ViewManager singleton = new ViewManager();
	private Stage primaryStage;

	public static ViewManager getInstance() {
		return singleton;
	}

	private ViewManager() {

	}

	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void loadFileLoaderScreen() {

		primaryStage.hide();
		
		try {
			primaryStage.setTitle("sea - dna sequence analyzer");
			AnchorPane root = FXMLLoader.load(FileChooserController.class.getResource("FileLoaderScreen.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	public void loadReportScreen() {
		
	primaryStage.hide();
		
		try {
			primaryStage.setTitle("sea - dna sequence analyzer");
			AnchorPane root = FXMLLoader.load(ReportController.class.getResource("ReportScreen.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
