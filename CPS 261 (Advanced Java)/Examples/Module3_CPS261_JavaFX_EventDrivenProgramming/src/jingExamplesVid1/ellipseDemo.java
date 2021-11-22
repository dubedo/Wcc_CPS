package jingExamplesVid1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ellipseDemo extends Application {

	@Override
	public void start(Stage primaryStage) {

		Circle circle1 = new Circle();

		circle1.setRadius(70);
		circle1.setCenterX(200);
		circle1.setCenterY(200);

		circle1.setFill(null);
		circle1.setStroke(Color.RED);

		Pane root = new Pane();

		root.getChildren().add(circle1);

		Scene scene = new Scene(root, 400, 400);

		circle1.centerXProperty().bind(scene.widthProperty().divide(2));
		circle1.centerYProperty().bind(scene.heightProperty().divide(2));

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
