package application;
	
import java.io.IOException;

import Controller.FirstLevelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Game;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Stage currentStage=new Stage();
	public static Game game;
	@Override
	public void start(Stage primaryStage) {
		BorderPane root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/FirstLevel.fxml"));
			root = (BorderPane)loader.load();
			FirstLevelController firstLevelController = loader.getController();
			firstLevelController.setMain(this);
			
			Scene scene = new Scene(root);
			currentStage.setScene(scene);
			currentStage.setHeight(500);
			currentStage.setWidth(700);
			currentStage.show();
			
			firstLevelController.start();
			
			firstLevelController.load();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Game getGame() {
		return game;
		
	}
	
	public static void main(String[] args) {
		game=new Game();
		game.createObjects(7);
		launch(args);
	}
}
