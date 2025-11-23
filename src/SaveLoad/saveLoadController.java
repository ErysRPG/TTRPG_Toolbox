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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class saveLoadController {
    @FXML private Button saveData;
    @FXML private Button loadData;

        private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Save everything into one file
        public void saveData() {
        }

        // Load everything from one file
        public void loadData() {
    }}