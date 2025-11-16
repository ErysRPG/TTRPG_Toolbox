package Journal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class JournalController {
	@FXML
	private TextArea journalTextArea;
	@FXML
	private TextField journalEntryTitle;
	@FXML
	private DatePicker date;
	@FXML
	private Button tableAddButton, tableEditButton, tableDeleteButton, deleteTableButton, tableRollButton;
	@FXML
	private ListView<String> entryList;
}
