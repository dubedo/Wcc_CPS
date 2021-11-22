package firstFX_BasicDrawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BasicDrawing extends Application {

	@Override
	public void start(Stage primaryStage) {

		Button btn = new Button("Ok");
		Scene scene = new Scene(btn, 250, 250);

		primaryStage.setTitle("My Fx Applications");
		primaryStage.setScene(scene);
		primaryStage.show();

		Stage secondStage = new Stage();

		secondStage.setTitle("Second Stage");
		secondStage.setScene(new Scene(new Button("Second Button"), 250, 250 ));
		secondStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
