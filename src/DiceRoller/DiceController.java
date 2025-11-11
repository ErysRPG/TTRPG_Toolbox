package DiceRoller;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DiceController {

	@FXML
	Label rollResult, separatedDice;
	@FXML
	TextField diceNotationField;
	@FXML
	Button diceRollButton;

	public void roll() {
		try {
			// get text from field
			String diceNotation = diceNotationField.getText();

			// Use a regex tp detect dice notation
			Pattern regex = Pattern.compile("(\\d+)?d(\\d+)(?:([\\+\\*\\/\\-])(\\d+))?");
			Matcher m = regex.matcher(diceNotation);

			String diceQuantity = "";
			String diceSize = "";
			String diceSign = "";
			String diceModifier = "";

			// Call Random to create a random number
			Random rand = new Random();

			// if the dice quantity is null is set to 1
			if (diceQuantity == null || diceQuantity.isEmpty()) {
				diceQuantity = "1";
			}

			// regex matcher check
			if (!m.matches()) {
				rollResult.setText("Intruduce dice notation");
			} else if (m.matches()) {
				diceQuantity = m.group(1);
				diceSize = m.group(2);
				diceSign = m.group(3);
				diceModifier = m.group(4);

				// if there's no sign the string stays empty
				if (diceSign == null || !diceNotation.contains(diceSign) || diceModifier == null || !diceNotation.contains(diceModifier) ) {
					diceSign = "";
					diceModifier = "";
				} 

			// Create an array to store the result of each dice
			int diceResultArray[] = new int[Integer.parseInt(diceQuantity)];

			// this variable will generate a random number rolling the dice
			int randomResultInDice = 0;

			// this variable stores the total result
			int total = 0;

			for (int i = 0; i < Integer.parseInt(diceQuantity); i++) {
				// generates a random number on the dice,
				randomResultInDice = rand.nextInt(1, Integer.parseInt(diceSize) + 1);
				// stores the separate values of each dice's results in an array
				diceResultArray[i] = randomResultInDice;
				// sums the result of the separate dice
				total += randomResultInDice;
			}

				// stores the total result of the dice plus the operation corresponding to the
				// modifier
				int totalMod = 0;

				// based on the sign, adds, substracts, multiplies or divides the modifier
				switch (diceSign) {
				case "+":
					totalMod = total + Integer.parseInt(diceModifier);
					rollResult.setText(String.valueOf(totalMod));
					separatedDice.setText(String.valueOf(Arrays.toString(diceResultArray)));
					break;
				case "-":
					totalMod = total - Integer.parseInt(diceModifier);
					rollResult.setText(String.valueOf(totalMod));
					separatedDice.setText(String.valueOf(Arrays.toString(diceResultArray)));
					break;
				case "*":
					totalMod = total * Integer.parseInt(diceModifier);
					rollResult.setText(String.valueOf(totalMod));
					separatedDice.setText(String.valueOf(Arrays.toString(diceResultArray)));
					break;
				case "/":
					if (Integer.parseInt(diceModifier) != 0) {
						totalMod = total / Integer.parseInt(diceModifier);
						rollResult.setText(String.valueOf(totalMod));
						separatedDice.setText(String.valueOf(Arrays.toString(diceResultArray)));
					} else {
						totalMod = total;
						rollResult.setText(String.valueOf(total));
					}
					break;

				default:
					rollResult.setText(String.valueOf(total));
					separatedDice.setText(String.valueOf(Arrays.toString(diceResultArray)));
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			rollResult.setText("Intruduce dice notation")
			;
			
		}

	}
}
