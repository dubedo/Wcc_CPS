package jingExamplesVid3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class RegController {

	FXCollections a;
	@FXML
	ChoiceBox<String> classList;
	@FXML
	RadioButton onlineR;
	@FXML
	RadioButton mixedModeR;
	@FXML
	RadioButton f2fR;
	@FXML
	ToggleGroup classOption;
	@FXML
	TextArea noteField;
	@FXML
	Button addBtn;
	@FXML
	TextArea listTxtArea;
	Registration myList;
	String optionVal;

	@FXML
	public void initialize() {
		ObservableList<String> list = FXCollections.observableArrayList();
		list.addAll("CPS161", "CPS261", "CPS171");
		// populate the Choicebox;
		classList.setItems(list);
		classList.setValue("");
		myList = new Registration();
		f2fR.setUserData("Face to Face");
		mixedModeR.setUserData("Mixed Mode");
		onlineR.setUserData("Online");

	}

	public void onAddClicked() {
		myList.addToList(new RegistrationInfo(classList.getValue(),
				classOption.getSelectedToggle().getUserData().toString(), noteField.getText()));
		listTxtArea.setText(myList.toString());
		noteField.setText(null);
		// classOption.selectToggle(f2fR);
		classOption.selectToggle(null);
		classList.setValue(null);
		;

	}

	public void onRBtnSelected() {
		/*
		 * if (onlineR.isSelected()){ optionVal = "Online"; }else if
		 * (f2fR.isSelected()){ optionVal = "Face to Face"; }else { optionVal =
		 * "Mixed Mode"; }
		 */
	}

}