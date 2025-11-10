package SaveLoad;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class saveLoadController {

	@FXML
	Button loadData, saveData;
	
	public void saveData() {
		
		FileChooser fc = new FileChooser();
		fc.setTitle("Save file");
		fc.showSaveDialog(null);
		fc.setInitialFileName("Unnamed file");
		fc.setSelectedExtensionFilter(null);
	}
}
