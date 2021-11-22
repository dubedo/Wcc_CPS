package firstFX_BasicDrawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MyCircle extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Circle circle = new Circle();
		Pane pane = new StackPane();

		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(2));
		// circle.setCenterX(100);
		// circle.setCenterY(100);

		// circle.radiusProperty().bind(pane.widthProperty().divide(2));
		circle.setRadius(50);

		circle.setStroke(new Color(0.3, 0.6, 0.9, 0.9));
		circle.setFill(Color.OLIVE);

		Label label = new Label("Java");

		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

		pane.getChildren().add(circle);
		pane.getChildren().add(label);

		Scene scene = new Scene(pane, 250, 250);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
