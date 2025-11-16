package Journal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import RandomTables.RandomTable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
	private ListView<JournalEntry> entryList;
	
	@FXML
	private Label infoLabel;

	public void addEntry() {
		try {
			
			// get title, content and date from field
			String title = journalEntryTitle.getText();
			String content = journalTextArea.getText();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formattedDate = date.getValue().format(format);
			
			// create an array list of strings. It must be flexible because the length is unknown
			ArrayList<JournalEntry> entries = new ArrayList<>();
			
			if (title == null || title.isEmpty() || content == null || content.isEmpty() || formattedDate == null || formattedDate.isEmpty()) {
				infoLabel.setText("Title, date and content must not be empty");
			} else {
				// create a new entry object
				JournalEntry je = new JournalEntry(title, content, formattedDate);

				
				// add the entry to the list
				entries.add(je);
				entryList.getItems().addAll(entries);

				// clear title and table content
				journalEntryTitle.clear();
				journalTextArea.clear();
			}

		} catch (Exception e) {
			infoLabel.setText("Title, date and content must not be empty");
		}
}
	

	public void editEntry() {

	}

	public void deleteEntry() {

	}

	public void searchEntry() {

	}
}
