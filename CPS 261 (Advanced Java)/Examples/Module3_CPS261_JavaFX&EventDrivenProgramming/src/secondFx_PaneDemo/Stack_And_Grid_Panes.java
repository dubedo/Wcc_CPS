package secondFx_PaneDemo;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Stack_And_Grid_Panes extends Application {

	@Override
	public void start(Stage primaryStage) {

		// Stack Pane

		Stage stackStage = new Stage();
		StackPane stackPane = new StackPane();

		stackPane.setPadding(new Insets(10));

		stackPane.getChildren().addAll(new Label("Street Address: "), new TextField());
		stackPane.getChildren().addAll(new Label("City: "), new TextField());
		stackPane.getChildren().addAll(new Label("State: "), new TextField());

		Scene stackScene = new Scene(stackPane, 250, 250);

		stackStage.setTitle("Stack Stage");
		stackStage.setScene(stackScene);
		stackStage.show();

		// Flow Pane

		Stage flowStage = new Stage();
		FlowPane flowPane = new FlowPane();

		flowPane.setPadding(new Insets(10));
		flowPane.setVgap(5);
		flowPane.setHgap(5);

		flowPane.getChildren().addAll(new Label("Street Address: "), new TextField());
		flowPane.getChildren().addAll(new Label("City: "), new TextField());
		flowPane.getChildren().addAll(new Label("State: "), new TextField());

		Scene flowScene = new Scene(flowPane, 250, 250);

		flowStage.setTitle("Flow Stage");
		flowStage.setScene(flowScene);
		flowStage.show();

		// Grid Pane

		Stage gridStage = new Stage();
		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		gridPane.add(new Label("Street Address: "), 0, 0);
		gridPane.add(new TextField(), 1, 0);
		gridPane.add(new Label("City: "), 0, 1);
		gridPane.add(new TextField(), 1, 1);
		gridPane.add(new Label("State: "), 0, 2);
		gridPane.add(new TextField(), 1, 2);

		Button btn = new Button("Add Address");
		gridPane.add(btn, 1, 3);
		GridPane.setHalignment(btn, HPos.RIGHT); // It's a Static Call. Call The Class, not the Object.

		Scene gridScene = new Scene(gridPane, 250, 250);

		gridStage.setTitle("Grid Stage");
		gridStage.setScene(gridScene);
		gridStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
