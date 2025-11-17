package SaveLoad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class saveLoadController {

	@FXML
	Button loadData, saveData;
	@FXML
	TextField fileName;
	
	public void saveData() throws IOException {
		String name = fileName.getText();
		BufferedWriter bw = new BufferedWriter(new FileWriter(name + ".txt"));
		
	
		
	}
	
	public void LoadData() {
		
	}
}
