package hockey;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HockeyStatsMain extends Application {

	ArrayList<Data> hockeyTeams = new ArrayList<>();
	double maxScore;

	public void populateList() {
		Scanner readList = null;
		String singleString, teamName;
		String[] splitStrings;
		double goals;

		try {

			readList = new Scanner(new FileInputStream("hockey.txt"));

			while (readList.hasNextLine()) {

				singleString = readList.nextLine();
				splitStrings = singleString.split(",");
				teamName = splitStrings[0];
				goals = Double.valueOf(splitStrings[1]);

				hockeyTeams.add(new Data(teamName, goals));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			readList.close();
		}

		for (Data data : hockeyTeams) {
			if (data.goals > maxScore) {
				maxScore = data.goals;
			}
		}

	}

	@Override
	public void start(Stage primaryStage) {

		GridPane thePane = new GridPane();
		int numOfRows;

		populateList();
		numOfRows = hockeyTeams.size();

		for (int i = 0; i < numOfRows; i++) {
			Rectangle barInGraph = new Rectangle();
			barInGraph.heightProperty().bind(thePane.heightProperty().divide(numOfRows));
			
			barInGraph.widthProperty()
					.bind(thePane.widthProperty().subtract(200).multiply(hockeyTeams.get(i).goals / maxScore));
			barInGraph.setFill(Color.OLIVE);
			thePane.add(new Label(hockeyTeams.get(i).name), 0, i);
			thePane.add(barInGraph, 1, i);
			

		}

		Scene theScene = new Scene(thePane, 400, 400);
		primaryStage.setScene(theScene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

class Data {

	String name;
	double goals;

	public Data(String name, double goals) {
		this.name = name;
		this.goals = goals;
	}

}
