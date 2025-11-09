package DiceRoller;

import java.util.Arrays;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class DiceController {

	
	@FXML 
	Label rollResult, separatedDice;
	@FXML
	TextField diceNotationField;
	@FXML
	Button diceRollButton;
	
	public void roll() {
		// get text from field
		String diceNotation = diceNotationField.getText();
		
		// split dice to separate size from quantity
		String [] diceSplit = diceNotation.split("d");
		String diceQuantity = diceSplit[0];
		String diceSize = diceSplit[1];
		
		// create random number based on the size of the dice
		Random rand = new Random();
		int randomNumber = rand.nextInt(1, Integer.parseInt(diceSize) + 1);
		
		// Create an array to store the result of each dice
		int diceResultArray[] = new int[Integer.parseInt(diceQuantity)];
		
		// for each dice in the array, choose a random number and set the labels
		for (int dice : diceResultArray) {
			int diceResult = Integer.parseInt(diceQuantity) * randomNumber;
			diceResultArray[dice] = dice;
			rollResult.setText(String.valueOf(diceResult));
			separatedDice.setText(String.valueOf(Arrays.toString(diceResultArray)));
		}
		
	
		
	}
}
