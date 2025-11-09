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
		try {
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
			
			// this variable will generate a random number rolling the dice
			int randomResultInDice= Integer.parseInt(diceQuantity) * randomNumber;;

			// generates a random number on the dice and
			// stores the separate values of each dice's results
			
			for (int i = 0; i < diceResultArray.length; i++) {
				diceResultArray[i] = Integer.parseInt(diceQuantity) * randomNumber;
				System.out.println(Arrays.toString(diceResultArray));
			}
			
			rollResult.setText(String.valueOf(randomResultInDice));
			separatedDice.setText(String.valueOf(Arrays.toString(diceResultArray)));
			
		} catch (Exception e) {
			rollResult.setText("Introduce dice notation");
		}
		
		
		
			
		}
		
	
		
	}
