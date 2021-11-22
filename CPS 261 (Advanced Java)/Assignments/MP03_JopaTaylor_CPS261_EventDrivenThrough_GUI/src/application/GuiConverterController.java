package application;



import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

public class GuiConverterController {

	public ToggleGroup conversionToggle;
	public RadioButton MK, FC, LBKG;
	public TextField txt1, txt2;
	public Button crunching;

	public void handleButtonChoice() {

		if (MK.isSelected()) {
			clear();
			txt1.setPromptText("Please Enter Number of Miles");
			txt2.setPromptText("Please Enter Number of Kilometers");
		} 
		if (FC.isSelected()) {
			clear();
			txt1.setPromptText("Please Enter Degrees in Farenheit");
			txt2.setPromptText("Please Enter Degrees in Celsius");
		}
		if (LBKG.isSelected())	{
			clear();
			txt1.setPromptText("Please Enter Number of Pounds");
			txt2.setPromptText("Please Enter Number of Kilograms");
		}
	}

	public void crunchNumbers() {

		double grabbedNum = 0;

		if (MK.isSelected()) {
			// convertDistance();
			if (!txt1.getText().isEmpty()) {

				grabbedNum = Double.valueOf(txt1.getText());
				txt2.setText(String.valueOf(grabbedNum / 1.609344));

			}

			if (!txt2.getText().isEmpty()) {

				grabbedNum = Double.valueOf(txt2.getText());
				txt1.setText(String.valueOf(grabbedNum * 1.609344));
			}

		}
		
		if (FC.isSelected()) {
			// crunchTemps();
			if (!txt1.getText().isEmpty()) {

				grabbedNum = Double.valueOf(txt1.getText());
				txt2.setText(String.valueOf((grabbedNum - 32) * 5 / 9));

			}

			if (!txt2.getText().isEmpty()) {

				grabbedNum = Double.valueOf(txt2.getText());
				txt1.setText(String.valueOf(grabbedNum * 5 / 9 + 32));

			}

		} 
		if (LBKG.isSelected())	{
			// crunchWeight();
			if (!txt1.getText().isEmpty()) {

				grabbedNum = Double.valueOf(txt1.getText());
				txt2.setText(String.valueOf(grabbedNum * 0.4536));

			}
			if (!txt2.getText().isEmpty()) {

				grabbedNum = Double.valueOf(txt2.getText());
				txt1.setText(String.valueOf(grabbedNum / 0.4536));

			}
		}

	}


	public void clear() {
		txt1.clear();
		txt2.clear();
	}

	public void clearNumbers(KeyEvent event) {
		if (event.getSource().equals(txt1)) {
			txt2.clear();
		} else {
			txt1.clear();
		}
	}

	
	
}
