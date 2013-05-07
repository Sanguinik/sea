package com.wordpress.marleneknoche.sea.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainScreen extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("sea - dna sequence analyzer");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(grid, 400,200);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
