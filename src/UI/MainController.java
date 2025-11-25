package UI;

import CharacterSheet.CharacterController;
import Journal.JournalController;
import RandomTables.tablesController;
import SaveLoad.saveLoadController;
import javafx.fxml.FXML;
import javafx.stage.Stage;


public class MainController {

	// call the controllers
    @FXML private CharacterController characterViewController;
    @FXML private JournalController journalViewController;
    @FXML private tablesController tablesViewController;
    @FXML private saveLoadController saveLoadViewController;

    // Initialize controllers and pass the references
    public void initializeControllers(Stage primaryStage) {
        if (saveLoadViewController == null) {
            throw new IllegalStateException("Save/load view controller not injected");
        }
        saveLoadViewController.setPrimaryStage(primaryStage);
        saveLoadViewController.setCharacterController(characterViewController);
        saveLoadViewController.setJournalController(journalViewController);
        saveLoadViewController.setTablesController(tablesViewController);
    }
}
