package SaveLoad;

import java.util.List;
import CharacterSheet.Character;
import Journal.JournalEntry;
import RandomTables.RandomTable;
import javafx.scene.control.ListView;

public class GameData {
    private List<Character> characters;
    private List<JournalEntry> journalEntries;
    private List<RandomTable> tables;

    public GameData() {}

    // Getters y setters
    public List<Character> getCharacters() {
        return characters;
    }
    public void setCharacters(List<Character> characterList) {
        this.characters = characterList;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }
    public void setJournals(List<JournalEntry> list) {
        this.journalEntries = list;
    }

    public List<RandomTable> getTables() {
        return tables;
    }
    public void setTables(List<RandomTable> tablesList) {
        this.tables = tablesList;
    }
}