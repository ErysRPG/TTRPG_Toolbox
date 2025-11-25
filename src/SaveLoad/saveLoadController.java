package SaveLoad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import CharacterSheet.CharacterController;
import Journal.JournalController;
import RandomTables.tablesController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class saveLoadController {
    @FXML private Button saveData;
    @FXML private Button loadData;

    // call the controllers
    private Stage primaryStage;
    private CharacterController characterController;
    private JournalController journalController;
    private tablesController tablesController;

    public saveLoadController() {} 

    // set the controllers
    public void setPrimaryStage(Stage stage) { this.primaryStage = stage; }
    public void setCharacterController(CharacterController cc) { this.characterController = cc; }
    public void setJournalController(JournalController jc) { this.journalController = jc; }
    public void setTablesController(tablesController tc) { this.tablesController = tc; }

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @FXML
    //create file chooser
    public void saveData() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save data");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
        File file = fc.showSaveDialog(primaryStage);

        if (file != null) {
        	// call GameData
            GameData bundle = new GameData();
            // call the setters
            bundle.setCharacters(characterController.getItems());
            bundle.setJournals(journalController.getItems());
            bundle.setTables(tablesController.getItems());
            // call gson
            String json = gson.toJson(bundle);
            // write json
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(json);
            }
        }
    }

    @FXML
    public void loadData() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Load data");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
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