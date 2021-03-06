package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiConverterMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("GuiConverterFXML.fxml"));
		
		primaryStage.setTitle("Scene Builder Window");
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
