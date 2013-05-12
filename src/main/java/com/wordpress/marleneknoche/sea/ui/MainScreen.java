package com.wordpress.marleneknoche.sea.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * This class is the main application launcher. It loads the first view of the application.
 * 
 * @author marlene
 *
 */

public class MainScreen extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		ViewManager manager = ViewManager.getInstance();
		
		manager.setStage(primaryStage);
		manager.loadFileLoaderScreen();
				
	}

	public static void main(String[] args) {
		launch(args);
	}
}
