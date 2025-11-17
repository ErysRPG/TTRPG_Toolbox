package CharacterSheet;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Character {

private String name;
private String CharacterClass;
private String species;
private int HealthPoints;
private int MagicPoints;
private String stats;
private String skills;
private String equipment;
private String backstory;



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getCharacterClass() {
	return CharacterClass;
}



public void setCharacterClass(String characterClass) {
	CharacterClass = characterClass;
}



public String getSpecies() {
	return species;
}



public void setSpecies(String species) {
	this.species = species;
}



public int getHealthPoints() {
	return HealthPoints;
}



public void setHealthPoints(int healthPoints) {
	HealthPoints = healthPoints;
}



public int getMagicPoints() {
	return MagicPoints;
}



public void setMagicPoints(int magicPoints) {
	MagicPoints = magicPoints;
}



public String getStats() {
	return stats;
}



public void setStats(String stats) {
	this.stats = stats;
}



public String getSkills() {
	return skills;
}



public void setSkills(String skills) {
	this.skills = skills;
}



public String getEquipment() {
	return equipment;
}



public void setEquipment(String equipment) {
	this.equipment = equipment;
}



public String getBackstory() {
	return backstory;
}



public void setBackstory(String backstory) {
	this.backstory = backstory;
}



public Character(String name, String characterClass, String species, int healthPoints, int magicPoints,
       String stats, String skills, String equipment, String backstory) {
this.name = name;
this.CharacterClass = characterClass;
this.species = species;
this.HealthPoints = healthPoints;
this.MagicPoints = magicPoints;
this.stats = stats;
this.skills = skills;
this.equipment = equipment;
this.backstory = backstory;
}




@Override
public String toString() {
	return name;
}
}
