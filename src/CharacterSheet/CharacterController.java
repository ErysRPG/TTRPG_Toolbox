package CharacterSheet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import SaveLoad.saveLoadController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import SaveLoad.saveLoadController;

public class CharacterController {


	@FXML
	private TextField characterName, characterSpecies, characterClass, hp, mp;
	@FXML
	private Button addCharacter, editCharacter, deleteCharacter, saveCharacter, searchCharacter;
	@FXML
	public ListView<Character> characterList;
	@FXML
	private TextArea skillsArea, equipmentArea, backstoryArea, statArea;

	@FXML
	private Label infoLabel;
	

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
		String stats = statArea.getText();

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
		        characterName.clear(); characterClass.clear(); characterSpecies.clear(); hp.clear(); mp.clear(); skillsArea.clear();
		        equipmentArea.clear(); backstoryArea.clear(); statArea.clear();


		    }} catch (NumberFormatException e) {
		        infoLabel.setText("HP and MP must be >= 0");
		    } catch (Exception e) {
		       
		    }
	}

	

	public void editCharacter() {
	    try {
	    	// check if there's content. If not, notify the user
	        Character item = characterList.getSelectionModel().getSelectedItem();
	        
	        if (item == null) {
	            infoLabel.setText("Select a character first");
	            return;
	        }

	        // Load fields
	        characterName.setText(item.getName());
	        characterSpecies.setText(item.getSpecies());
	        characterClass.setText(item.getCharacterClass());
	        hp.setText(String.valueOf(item.getHealthPoints()));
	        mp.setText(String.valueOf(item.getMagicPoints()));
	       statArea.setText(item.getStats());
	       skillsArea.setText(item.getSkills());
	       equipmentArea.setText(item.getEquipment());
	       backstoryArea.setText(item.getBackstory());

	        infoLabel.setText("Character loaded");

	    } catch (Exception e) {
	        infoLabel.setText("Error loading character");
	    }
	}

	public void saveCharacter() {
		try {
			// if no content is present or no character is selected, notify the user. Else,
			// proceed with the else block
			if (characterList == null || characterList.getSelectionModel().getSelectedItem() == null) {
				infoLabel.setText("Add or select a character first");
			} else {
				// gets the content
				String name = characterName.getText();
				String charaClass = characterClass.getText();
				String species = characterSpecies.getText();
				String HealthPoints = hp.getText();
				String MagicPoints = mp.getText();
				String skills = skillsArea.getText();
				String equipment = equipmentArea.getText();
				String backstory = backstoryArea.getText();
				String stats = statArea.getText();

				// adds the new content to the list
				characterList.getSelectionModel().getSelectedItem().setName(name);
				characterList.getSelectionModel().getSelectedItem().setCharacterClass(charaClass);
				characterList.getSelectionModel().getSelectedItem().setSpecies(species);
				characterList.getSelectionModel().getSelectedItem().setHealthPoints(Integer.parseInt(HealthPoints));
				characterList.getSelectionModel().getSelectedItem().setMagicPoints(Integer.parseInt(MagicPoints));
				characterList.getSelectionModel().getSelectedItem().setSkills(skills);
				characterList.getSelectionModel().getSelectedItem().setEquipment(equipment);
				characterList.getSelectionModel().getSelectedItem().setBackstory(backstory);
				characterList.getSelectionModel().getSelectedItem().setStats(stats);
				
				// updates the list content
				characterList.refresh();
			}
		} catch (Exception e) {
			infoLabel.setText("Add or select a character first");
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
	
	public void searchCharacter() {
		try {
			
		// get title from field
					String name = characterName.getText();
					

					// check if content is empty. If not, proceed with the else block
					if (name == null || name.isEmpty() || characterList == null) {
						infoLabel.setText("Introduce a name to search for characters");
					} else {
						// Creates an original list and another one that will store the results.
						ObservableList<Character> list = characterList.getItems();
						ObservableList<Character> filteredList = FXCollections.observableArrayList();
						
						// iterates through first list
						for (Character character : list) {
							// if matching coincidences are found the filtered list gets the coincidence in
							if (character.getName().toLowerCase().contains(name.toLowerCase())) {
								filteredList.add(character);
							}
						}

						if (filteredList.isEmpty()) {
							infoLabel.setText("No coincidences found");
						
						} else {
							// if the filtered list has items, those are shown in the screen
							characterList.setItems(filteredList);
						
						}
						// restores the original list if the name is empty
						characterName.textProperty().addListener((obs, oldVal, newVal) -> {
						    if (newVal.isEmpty()) {
						    	characterList.setItems(list);
						        
						    }
						});

					}
					
					 
					
		}catch (Exception e) {
			infoLabel.setText("Enter a name to search for characters");
			e.printStackTrace();
					}
	}



	public List<Character> getItems() {
	    return new ArrayList<>(characterList.getItems());
	}

	public void setItems(List<Character> newItems) {
	    characterList.getItems().setAll(newItems);
	}







}
