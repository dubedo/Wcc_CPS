package fourthFX_EventDemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EventDemoLambda extends Application {

	HBox pane = new HBox(10);

	Button btnOk = new Button("Ok");
	TextField textField = new TextField("This is The Text Field");

	@Override
	public void start(Stage primaryStage) {

		Scene scene = new Scene(pane, 400, 400);

		btnOk.setPrefSize(50, 50);

		// The Lambda
		btnOk.setOnAction(e -> {
			System.out.println("Button OK Clicked");
		});

		// The Anon Inner-Class
		btnOk.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				System.out.println(textField.getText());

			}
		});

		pane.getChildren().addAll(btnOk, textField);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
