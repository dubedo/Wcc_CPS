package jingExamplesVid1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class EllipseHomework extends Application {

	@Override
	public void start(Stage primaryStage) {

		Ellipse ellipse;
		Pane root = new Pane();
		Scene scene = new Scene(root, 400, 400);

		int i = 0;

		while (root.widthProperty().subtract(i).getValue() > 0) {
			ellipse = new Ellipse();
			ellipse.centerXProperty().bind(root.widthProperty().divide(2));
			ellipse.centerYProperty().bind(root.widthProperty().divide(2));
			ellipse.radiusXProperty().bind(root.widthProperty().divide(2).subtract(i));
			ellipse.radiusYProperty().bind(root.widthProperty().divide(2).subtract(i));

			ellipse.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			ellipse.setFill(null);

			i += 3;

			root.getChildren().add(ellipse);

		}

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
