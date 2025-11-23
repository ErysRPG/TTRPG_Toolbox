package SaveLoad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.StyleConstants.CharacterConstants;

import CharacterSheet.Character;
import CharacterSheet.CharacterController;
import Journal.JournalController;
import RandomTables.tablesController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class saveLoadController {

	@FXML
	Button loadData, saveData;
	@FXML
	TextField fileName;

	@FXML
	Stage primaryStage;
	
	@FXML
	CharacterSheet.CharacterController cc;

	public void saveData() throws IOException {

		
		FileChooser fc = new FileChooser();

		fc.setTitle("Save data");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Text files", "*.txt"));
		fc.setInitialDirectory(new File(System.getProperty("user.home")+ "/Desktop"));
		
		
		File file = fc.showSaveDialog(primaryStage);

	    if (file != null) {
	        System.out.println(file.getAbsolutePath());
	        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			 for (Character chara : cc.characterList.getItems()) {
				 
		            bw.write("===CHARACTER===\n");
		            bw.write("Name: " + chara.getName() + "\n");
		            bw.write("Class: " + chara.getCharacterClass() + "\n");
		            bw.write("Species: " + chara.getSpecies() + "\n");
		            bw.write("Health Points: " + chara.getHealthPoints() + "\n");
		            bw.write("Magic Points: " + chara.getMagicPoints() + "\n");
		            bw.write("Skills: " + chara.getSkills() + "\n");
		            bw.write("Equipment: " + chara.getEquipment() + "\n");
		            bw.write("Backstory: " + chara.getBackstory() + "\n");
		            bw.write("Stats: " + chara.getStats() + "\n");
		            bw.write("\n"); 
		        }

			 bw.close();		
	    }



	}

	public void LoadData() {

	}
}