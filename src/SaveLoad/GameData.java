package SaveLoad;

import java.util.List;

import CharacterSheet.Character;
import Journal.JournalEntry;
import RandomTables.RandomTable;
// data-saving class
public class GameData {
    private List<Character> characters;
    private List<JournalEntry> journalEntries;
    private List<RandomTable> tables;

    // --- Characters ---
    public List<Character> getCharacters() {
        return characters;
    }
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    // --- Journal Entries ---
    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }
    public void setJournals(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    // --- Tables ---
    public List<RandomTable> getTables() {
        return tables;
    }
    public void setTables(List<RandomTable> tables) {
        this.tables = tables;
    }
}