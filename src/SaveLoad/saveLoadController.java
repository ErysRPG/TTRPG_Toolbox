package SaveLoad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import CharacterSheet.CharacterController;
import Journal.JournalController;
import Journal.JournalEntry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class saveLoadController {
    @FXML private Button saveData;
    @FXML private Button loadData;

    // Aquí se inyectan los controladores completos gracias al fx:id en mainView.fxml
    @FXML private JournalController journalController;
    @FXML private CharacterController characterController;
    @FXML private RandomTables.tablesController tablesController;

    public void saveData() {
        Stage stage = (Stage) saveData.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Save all data");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
        File file = fc.showSaveDialog(stage);

        if (file != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                //characterController.saveCharacterData(bw);
                journalController.saveJournalData(bw);
               // tablesController.saveTablesData(bw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadData() {
        // igual, llamando a loadCharacterData, loadJournalData, loadTablesData
    }
}