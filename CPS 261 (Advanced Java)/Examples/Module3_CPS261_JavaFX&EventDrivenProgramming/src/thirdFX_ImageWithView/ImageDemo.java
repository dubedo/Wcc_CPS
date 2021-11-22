package thirdFX_ImageWithView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImageDemo extends Application {

	@Override
	public void start(Stage primaryStage) {

		Image image1 = new Image("Dubedo Logo.png");
		Image image2 = new Image("C:\\Users\\idube\\Pictures\\Saved Pictures\\Charlie.jpg");
		Image image3 = new Image(
				"https://abcbirds.org/wp-content/uploads/2021/07/Blue-Jay-on-redbud-tree-by-Tom-Reichner_news.png");

		ImageView theView = new ImageView(image1);
		ImageView theView2 = new ImageView(image1);
		ImageView theView3 = new ImageView(image1);
		ImageView theView4 = new ImageView(image1);

		ImageView theView5 = new ImageView(image2);

		ImageView theView6 = new ImageView(image3);

		theView2.setFitHeight(100);

		theView3.setFitHeight(100);
		theView3.setPreserveRatio(true);

		theView4.setRotate(90);

		theView5.setFitHeight(100);
		theView5.setRotate(90);
		theView5.setPreserveRatio(true);

		theView6.setFitHeight(100);
		theView6.setPreserveRatio(true);

		Pane flowPane = new FlowPane();

		flowPane.getChildren().addAll(theView, theView2, theView3, theView4, theView5, theView6);

		Scene scene = new Scene(flowPane, 250, 250);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
