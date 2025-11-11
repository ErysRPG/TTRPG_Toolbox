package CharacterSheet;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	
	private ArrayList<Stat> statList = new ArrayList<>();
	
	public void addCharacter() {
		String name = characterName.getText();
		String charaClass = characterClass.getText();
		String species = characterSpecies.getText();
		String HealthPoints = hp.getText();
		String MagicPoints = mp.getText();
		
	}
	
	public void editCharacter() {
		
	}
	
	public void deleteCharacter() {
		
	}
	
	public void createStat() {
		TextField stat = new TextField();
		stat.promptTextProperty().setValue(statName.getText());
		stat.setMinWidth(3);
		statArea.add(stat, 0, 0);
		statArea.add(stat, 0, 1);
		statArea.add(stat, 0, 2);
		statArea.add(stat, 1, 3);
		
	}
	
	public void deleteStat() {
		
	}
}
