package CharacterSheet;

import java.util.ArrayList;

public class Character {
private String name;
private String CharacterClass;
private String species;
private int HealthPoints;
private int MagicPoints;
private ArrayList<Stat> stats;
public Character(String name, String characterClass, String species, int healthPoints, int magicPoints,
		ArrayList<Stat> stats) {
	super();
	this.name = name;
	CharacterClass = characterClass;
	this.species = species;
	HealthPoints = healthPoints;
	MagicPoints = magicPoints;
	this.stats = stats;
}
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
public ArrayList<Stat> getStats() {
	return stats;
}
public void setStats(ArrayList<Stat> stats) {
	this.stats = stats;
}


}
