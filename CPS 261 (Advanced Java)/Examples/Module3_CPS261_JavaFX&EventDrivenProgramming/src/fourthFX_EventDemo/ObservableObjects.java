package fourthFX_EventDemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ObservableObjects extends Application {

	@Override
	public void start(Stage primaryStage) {

		Rectangle r1 = new Rectangle();

		StackPane pane = new StackPane();

		// the Old Way
		// r1.widthProperty().bind(pane.widthProperty().subtract(30));
		// r1.heightProperty().bind(pane.heightProperty().subtract(30));
		pane.getChildren().add(r1);

		pane.widthProperty().addListener(obv -> {
			r1.setWidth(pane.getWidth() - 30);
		});

		pane.heightProperty().addListener(obv -> {
			r1.setHeight(pane.getHeight() - 30);
		});

		Scene scene = new Scene(pane, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
