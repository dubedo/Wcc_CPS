package cards;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RandomCardsMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		GridPane cards = FXMLLoader.load(getClass().getResource("RandomCardsFXML.fxml"));
		
		primaryStage.setTitle("Scene Builder Window");
		primaryStage.setScene(new Scene(cards, 800, 500));
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
