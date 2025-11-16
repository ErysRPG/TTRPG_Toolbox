package CharacterSheet;

import java.util.ArrayList;
import java.util.List;

import RandomTables.RandomTable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.GridPane;

public class CharacterController {

	@FXML
	private TextField characterName, characterSpecies, characterClass, hp, mp, statName, stat;
	@FXML
	private Button addStat, deleteStat, addCharacter, editCharacter, deleteCharacter;
	@FXML
	private ListView<Character> characterList;
	@FXML
	private TextArea skillsArea, equipmentArea, backstoryArea;
	@FXML
	private GridPane statArea;

	@FXML
	private Label infoLabel;

	private ArrayList<Stat> statList = new ArrayList<>();
	private Node stat2;

	public void addCharacter() {
		// gets values from fields
		String name = characterName.getText();
		String charaClass = characterClass.getText();
		String species = characterSpecies.getText();
		String HealthPoints = hp.getText();
		String MagicPoints = mp.getText();
		String skills = skillsArea.getText();
		String equipment = equipmentArea.getText();
		String backstory = backstoryArea.getText();
		ObservableList<Node> stats = statArea.getChildren();
		// creates array of characters
		ArrayList<Character> characterArrayList = new ArrayList<>();
		try {
			//if content is null or empty, notifies the user. Else, proceed with the else block
			if (name == null || name.isEmpty()) {
				infoLabel.setText("Character needs a name!");
			} else {
				// if values are empty, the value is 0
		        int hpValue = (HealthPoints != null && !HealthPoints.isEmpty()) ? Integer.parseInt(HealthPoints) : 0;
		        int mpValue = (MagicPoints != null && !MagicPoints.isEmpty()) ? Integer.parseInt(MagicPoints) : 0;

		        // instantiate a new character
		        Character chara = new Character(name, charaClass, species, hpValue, mpValue, stats, skills, equipment, backstory);
		        // add character to list
		        characterList.getItems().add(chara);
		        // clear fields
		        characterName.clear(); characterClass.clear(); characterSpecies.clear(); hp.clear(); mp.clear(); statName.clear(); skillsArea.clear();
		        equipmentArea.clear(); backstoryArea.clear();
		        
		        // clears stat fields text
		        for (Node node : statArea.getChildren()) {
		        	// if there's a textfield in the node
		            if (node instanceof TextField tf) {
		                tf.clear(); 
		            }
		        }



		    }} catch (NumberFormatException e) {
		        infoLabel.setText("HP and MP must be >= 0");
		    } catch (Exception e) {
		        infoLabel.setText("Error adding character");
		    }
	}

	

	public void editCharacter() {
		try {
			if (characterList == null) {
				infoLabel.setText("Add a character first");
			} else {
				// get selected item
				Character item = characterList.getSelectionModel().getSelectedItem();
				// load the fields
				characterName.setText(item.getName());
				characterSpecies.setText(item.getSpecies());
				characterClass.setText(item.getCharacterClass());
				hp.setText(String.valueOf(item.getHealthPoints()));
				mp.setText(String.valueOf(item.getMagicPoints()));
				skillsArea.setText(item.getSkills());
				equipmentArea.setText(item.getEquipment());
				backstoryArea.setText(item.getEquipment());
				
				// load the stats. One list gets the stats
				List<Node> savedStats = item.getStats();
				// iterates through the list
				for (int i = 0; i < savedStats.size(); i++) {
					//the statArea's items set at each position. Each position gets the corresponding stat
				    ((TextField) statArea.getChildren().get(i)).setText(((TextField) savedStats.get(i)).getText());
				}


		        }

		} catch (Exception e) {
			infoLabel.setText("Add a character first");
		}

	}
	

	public void deleteCharacter() {
		try {
			// check if content is empty. If not, proceed with the else block
			if (characterList == null || characterList.getSelectionModel().getSelectedItem() == null) {
				infoLabel.setText("Select a character from the list");
			} else {
				// select the item from the list
				Character item = characterList.getSelectionModel().getSelectedItem();
				// remove the selected item
				characterList.getItems().remove(item);
			}
		} catch (Exception e) {
			infoLabel.setText("Select a character from the list");
		}
	}
	

	public void createStat() {
		// gets text field prompt
		String name = statName.getText();
		// creates a new textField
		TextField stat = new TextField();
		// sets the prompt chosen by the user
		stat.setPromptText(name);
		// sets textField's width
		stat.setMaxWidth(100);

		// gets the size of the gridpane
		int count = statArea.getChildren().size();
		System.out.println(count);

		int col = 0;
		int row = 0;

		if (count >= 12) {
			return;
		}

		// assigns textfield to an empty cell
		col = count % 4;
		row = count / 4;

		statArea.add(stat, col, row);
	}

	public void deleteStat() {
		ObservableList<Node> statList = statArea.getChildren();
		String name = statName.getText();

		if (statArea.getChildren() != null) {
			for (Node stat : statList) {
				if (((TextInputControl) stat).getPromptText().toLowerCase().equals(name.toLowerCase())) {
					statList.remove(stat);
				}
			}
		}
	}

}
