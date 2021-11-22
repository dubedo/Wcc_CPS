package cards;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RandomCardsController {

	@FXML
	ImageView cardPane1, cardPane2, cardPane3, cardPane4;
	Button dealButton;
	String location = "file:C:\\Users\\idube\\Eclipse Workspace\\MP03_JopaTaylor_CPS261_EventDrivenThrough_GUI\\card\\";
	int card1, card2, card3, card4;

	Random randomizer = new Random();

	public void flipCard(MouseEvent e) {

		if (e.getSource().equals(cardPane1)) {
			cardPane1.setImage(new Image(location + card1 + ".png"));
		} else if (e.getSource().equals(cardPane2)) {
			cardPane2.setImage(new Image(location + card2 + ".png"));
		} else if (e.getSource().equals(cardPane3)) {
			cardPane3.setImage(new Image(location + card3 + ".png"));
		} else if (e.getSource().equals(cardPane4)) {
			cardPane4.setImage(new Image(location + card4 + ".png"));
		}

	}

	public void deal() {

		card1 = randomizer.nextInt(54) + 1;
		card2 = randomizer.nextInt(54) + 1;
		card3 = randomizer.nextInt(54) + 1;
		card4 = randomizer.nextInt(54) + 1;

		cardPane1.setImage(new Image(location + "back.png"));
		cardPane2.setImage(new Image(location + "back.png"));
		cardPane3.setImage(new Image(location + "back.png"));
		cardPane4.setImage(new Image(location + "back.png"));

	}

}
