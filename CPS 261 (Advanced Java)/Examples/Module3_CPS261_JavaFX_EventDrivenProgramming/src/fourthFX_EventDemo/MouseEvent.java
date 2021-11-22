package fourthFX_EventDemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MouseEvent extends Application {

	Rectangle r1;

	@Override
	public void start(Stage primaryStage) {

		Pane pane = new Pane();

		pane.setOnMousePressed(e -> {
			r1 = new Rectangle();
			r1.setX(e.getX());
			r1.setY(e.getY());

			pane.getChildren().add(r1);
		});

		pane.setOnMouseDragged(e -> {
			r1.setWidth(e.getX() - r1.getX());
			r1.setHeight(e.getY() - r1.getY());
		});

		Scene scene = new Scene(pane, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
