package UI;

import java.lang.ModuleLayer.Controller;

import DiceRoller.DiceController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	DiceController diceController;
	TextField diceNotationField;
	
	public void diceRoll() {
		diceController.roll();
	}
}
