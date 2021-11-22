package secondFx_PaneDemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BorderPanes extends Application {

	@Override
	public void start(Stage primaryStage) {

		Stage borderStage = new Stage();
		BorderPane borderPane = new BorderPane();

		StackPane topPane = new StackPane();
		topPane.setStyle("-fx-border-color:red"); // CSS Style
		topPane.getChildren().add(new Label("Top"));
		borderPane.setTop(topPane);

		borderPane.setCenter(new MyPane("Center"));
		borderPane.setLeft(new MyPane("Left"));
		borderPane.setBottom(new MyPane("Bottom"));
		borderPane.setRight(new MyPane("Right"));

		Scene borderScene = new Scene(borderPane, 250, 250);

		borderStage.setTitle("Border Stage");
		borderStage.setScene(borderScene);
		borderStage.show();

	}

	class MyPane extends StackPane {

		public MyPane(String title) {
			getChildren().add(new Label(title));
			setStyle("-fx-border-color:red");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
