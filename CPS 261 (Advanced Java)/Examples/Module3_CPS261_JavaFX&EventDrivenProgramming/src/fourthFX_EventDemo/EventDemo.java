package fourthFX_EventDemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EventDemo extends Application {

	HBox pane = new HBox(10);
	Button btnOk = new Button("Ok");
	TextField textField = new TextField("This is The Text Field");

	@Override
	public void start(Stage primaryStage) {

		Scene scene = new Scene(pane, 400, 400);
		OkHandler handler1 = new OkHandler();

		btnOk.setPrefSize(50, 50);
		btnOk.setOnAction(handler1);

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

class OkHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Ok Clicked");
	}

}
