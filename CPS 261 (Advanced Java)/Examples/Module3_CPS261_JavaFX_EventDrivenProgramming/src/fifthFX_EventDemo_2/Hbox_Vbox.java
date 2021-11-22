package fifthFX_EventDemo_2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hbox_Vbox extends Application {

	private HBox getHBox() {

		HBox hBox = new HBox(10);
		hBox.getChildren().add(new Button("CIS"));
		hBox.getChildren().add(new Button("MTH"));

		return hBox;
	}

	private VBox getVBox() {

		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(30, 5, 5, 5));
		vBox.getChildren().addAll(new Label("CPS 161"), new Label("CPS 261"));

		return vBox;
	}

	@Override
	public void start(Stage primaryStage) {

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(getHBox());
		borderPane.setLeft(getVBox());

		Scene scene = new Scene(borderPane, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
