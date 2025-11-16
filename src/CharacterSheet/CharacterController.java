package CharacterSheet;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
	
	private ArrayList<Stat> statList = new ArrayList<>();
	
	public void addCharacter() {
		String name = characterName.getText();
		String charaClass = characterClass.getText();
		String species = characterSpecies.getText();
		String HealthPoints = hp.getText();
		String MagicPoints = mp.getText();
		ObservableList<Node> stats = statArea.getChildren();
		
	}
	
	public void editCharacter() {
		
	}
	
	public void deleteCharacter() {
		
	}
	
	public void createStat() {
		// gets text field prompt
		    String name = statName.getText();
		    		// creates a new textField
		            TextField stat = new TextField();
		            // sets the prompt chosen by the user
		            stat.setPromptText(name);
		            // sets textField's width
		            stat.setMaxWidth(2);
		            // gets the size of the gridpane
		            int count = statArea.getChildren().size();
		            System.out.println(count);
		            
		           int col = 0;
		           int row = 0;
		            
		           for (count = 0; count <= 9; count++) {
		        	   col = count * 3;
		        	   row = count / 3;
		
		        	   if (count > 9) {
			        	   break;
			            }
		           }
		           
		            
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
