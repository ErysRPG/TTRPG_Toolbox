package DiceRoller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class DiceController {

	
	@FXML 
	Label rollResult;
	@FXML
	TextField diceNotationField;
	@FXML
	Button rollButton;
	
	public void roll() {
		String diceNotation = diceNotationField.getText();
		System.out.println(diceNotation);
		rollResult.setText(diceNotation.toString());
	}
}
