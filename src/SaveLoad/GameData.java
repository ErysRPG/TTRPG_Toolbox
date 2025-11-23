package SaveLoad;

import java.util.List;

import CharacterSheet.Character;
import Journal.JournalEntry;
import RandomTables.RandomTable;


public class GameData {
    
    private List<Character> characters; 
    private List<JournalEntry> journalEntries; 
    private List<RandomTable> tables; 

    public GameData() {
    }

   // Saving constructor
    public GameData(List<Character> characters, List<JournalEntry> journalEntries, List<RandomTable> tables) {
        this.characters = characters;
        this.journalEntries = journalEntries;
        this.tables = tables;
    }

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public List<JournalEntry> getJournalEntries() {
		return journalEntries;
	}

	public void setJournalEntries(List<JournalEntry> journalEntries) {
		this.journalEntries = journalEntries;
	}

	public List<RandomTable> getTables() {
		return tables;
	}

	public void setTables(List<RandomTable> tables) {
		this.tables = tables;
	}
}
    

