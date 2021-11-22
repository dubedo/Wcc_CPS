package fifthFX_EventDemo_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TempConvert extends Application {

	TextField fahren = new TextField();
	TextField cel = new TextField();
	Button f2c = new Button("To Celsius");
	Button c2f = new Button("To Fahrenheit");

	@Override
	public void start(Stage primaryStage) {

		GridPane gridPane = new GridPane();

		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.add(new Label("Fahrenheit"), 0, 0);
		gridPane.add(fahren, 1, 0);
		gridPane.add(new Label("Celsius"), 0, 1);
		gridPane.add(cel, 1, 1);
		gridPane.add(f2c, 0, 2);
		gridPane.add(c2f, 1, 2);

		f2c.setOnAction(e -> {
			double c;

			c = (Double.parseDouble(fahren.getText()) - 32) * 5 / 9;
			cel.setText(String.valueOf(c));

		});

		c2f.setOnAction(e -> {
			double f;

			f = (Double.parseDouble(cel.getText()) * 9 / 5) + 32;
			fahren.setText(String.valueOf(f));

		});

		Scene scene = new Scene(gridPane, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
