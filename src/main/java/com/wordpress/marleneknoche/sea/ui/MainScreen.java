package com.wordpress.marleneknoche.sea.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainScreen extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		primaryStage.setTitle("sea - dna sequence analyzer");
		
		AnchorPane root = FXMLLoader.load(getClass().getResource("FileLoaderScreen.fxml"));
		
		Scene scene = new Scene(root, 600,400);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
