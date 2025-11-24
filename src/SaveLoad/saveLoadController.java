package SaveLoad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import CharacterSheet.Character;
import CharacterSheet.CharacterController;
import Journal.JournalController;
import Journal.JournalEntry;
import RandomTables.RandomTable;
import RandomTables.tablesController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class saveLoadController {
    @FXML private Button saveData;
    @FXML private Button loadData;
    private Stage primaryStage;

    private CharacterController characterController;
    private JournalController journalController;
    private tablesController tablesController;

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void setCharacterController(CharacterController cc) {
        this.characterController = cc;
    }

    public void setJournalController(JournalController jc) {
        this.journalController = jc;
    }

    public void setTablesController(tablesController tc) {
        this.tablesController = tc;
    }

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Save everything into one file
    @FXML
    public void saveData() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save data");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
        fc.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));

        File file = fc.showSaveDialog(primaryStage);

        if (file != null) {
            GameData bundle = new GameData();
            bundle.setCharacters(characterController.getItems());
            bundle.setJournals(journalController.getItems());
            bundle.setTables(tablesController.getItems());

            String json = gson.toJson(bundle);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(json);
            }
        }
    }

    // Load everything from one file
    @FXML
    public void loadData() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Load data");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
        fc.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));

        File file = fc.showOpenDialog(primaryStage);

        if (file != null) {
            try (FileReader reader = new FileReader(file)) {
                GameData bundle = gson.fromJson(reader, GameData.class);

                characterController.setItems(bundle.getCharacters());
                journalController.setItems(bundle.getJournalEntries());
                tablesController.setItems(bundle.getTables());
            }
        }
    }
}