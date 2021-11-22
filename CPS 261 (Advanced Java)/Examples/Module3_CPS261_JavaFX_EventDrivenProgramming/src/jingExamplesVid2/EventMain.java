package jingExamplesVid2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EventMain extends Application {

	Circle circle;

	@Override
	public void start(Stage primaryStage) {

		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 400);

		pane.setOnMousePressed(e -> {
			circle = new Circle();
			Color color = new Color(Math.random(), Math.random(), Math.random(), .5);

			circle.setCenterX(e.getX());
			circle.setCenterY(e.getY());

			circle.setFill(color);

			pane.getChildren().add(circle);

		});

		pane.setOnMouseDragged(e -> {
			double xDistance = e.getX() - circle.getCenterX();
			double yDistance = e.getY() - circle.getCenterY();

			circle.setRadius(Math.sqrt(xDistance * xDistance + yDistance * yDistance));

		});

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
