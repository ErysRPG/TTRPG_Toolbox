package Journal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import RandomTables.RandomTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

			// create an array list of strings. It must be flexible because the length is
			// unknown
			ArrayList<JournalEntry> entries = new ArrayList<>();

			if (title == null || title.isEmpty() || content == null || content.isEmpty() || formattedDate == null
					|| formattedDate.isEmpty()) {
				infoLabel.setText("Title, date and content must not be empty");
			} else {
				// create a new entry object
				JournalEntry je = new JournalEntry(title, content, formattedDate);

				// add the entry to the list
				entries.add(je);
				entryList.getItems().addAll(entries);

				// clear title, content 
				journalEntryTitle.clear();
				journalTextArea.clear();
				
			}

		} catch (Exception e) {
			infoLabel.setText("Title, date and content must not be empty");
		}
	}

	public void editEntry() {
		try {
			if (entryList == null) {
				infoLabel.setText("Add an entry first");
			} else {
				// get selected item
				JournalEntry item = entryList.getSelectionModel().getSelectedItem();
				// load the fields
				journalEntryTitle.setText(item.getTitle());
				// removes array brackets and load the text area
				journalTextArea.setText(String.valueOf(item.getContent()));
			}
		} catch (Exception e) {
			infoLabel.setText("Add an entry first");
		}

	}

	public void saveEntry() {
		try {
			// if no content is present or no entry is selected, notify the user. Else,
			// proceed with the else block
			if (entryList == null || entryList.getSelectionModel().getSelectedItem() == null) {
				infoLabel.setText("Add or select an entry first");
			} else {
				// gets the content
				String getNewContent = journalTextArea.getText();

				// adds the new title and items to the list
				entryList.getSelectionModel().getSelectedItem().setTitle(journalEntryTitle.getText());
				entryList.getSelectionModel().getSelectedItem().setContent(getNewContent);
				// updates the list content
				entryList.refresh();
			}
		} catch (Exception e) {
			infoLabel.setText("Add or select a table first");
		}

	}

	public void deleteEntry() {
		try {
			// check if content is empty. If not, proceed with the else block
			if (entryList == null || entryList.getSelectionModel().getSelectedItem() == null) {
				infoLabel.setText("Select an entry from the list");
			} else {
				// select the item from the list
				JournalEntry item = entryList.getSelectionModel().getSelectedItem();
				// remove the selected item
				entryList.getItems().remove(item);
			}
		} catch (Exception e) {
			infoLabel.setText("Select a table from the list");
		}
	}

	public void searchEntry() {
	    try {
	    	
	    	// if list is null notify the user
	        if (entryList == null || entryList.getItems() == null) {
	            infoLabel.setText("Add content before searching");
	            return;
	        }
	        // gets title, content and date
	        String title = journalEntryTitle.getText();
	        LocalDate selectedDate = date.getValue();
	        String formattedDate = null;
	        // formats the date if it's not null
	        if (selectedDate != null) {
	            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            formattedDate = selectedDate.format(format);
	        }
	        // onle list is the original list, the other one will store the results
	        ObservableList<JournalEntry> list = entryList.getItems();
	        ObservableList<JournalEntry> filteredList = FXCollections.observableArrayList();
	        
	        // iterates through the original list
	        for (JournalEntry entry : list) {
	        	
	        	//for each entry, if the title and date aren't null store them, or leave empty if null
	            String entryTitle = entry.getTitle() != null ? entry.getTitle().toLowerCase() : "";
	            String entryDate = entry.getDate() != null ? entry.getDate() : "";
	            
	            // if they're not null or empty and the list's data match usser input, store that in a variable
	            boolean matchesTitle = title != null && !title.isEmpty() && entryTitle.contains(title.toLowerCase());
	            boolean matchesDate = formattedDate != null && entryDate.contains(formattedDate);
	            
	            // if there are coincidences the filter list gets populated
	            if (matchesTitle || matchesDate) {
	                filteredList.add(entry);
	            }
	        }
	        	// is the filtered list is empty, notify the user
	        if (filteredList.isEmpty()) {
	            infoLabel.setText("No coincidences found");
	        } else {
	            entryList.setItems(filteredList);
	            infoLabel.setText("Matching entries found");
	        }

	        // Restore original list if title or date is cleared
	        journalEntryTitle.textProperty().addListener((obs, oldVal, newVal) -> {
	            if (newVal.isEmpty() && date.getValue() == null) {
	                entryList.setItems(list);
	                infoLabel.setText("Showing all entries");
	            }
	        });

	        date.valueProperty().addListener((obs, oldVal, newVal) -> {
	            if (newVal == null && (title == null || title.isEmpty())) {
	                entryList.setItems(list);
	                infoLabel.setText("Showing all entries");
	            }
	        });

	    } catch (Exception e) {
	        infoLabel.setText("Introduce title/date to search for entries");
	    }
	}
	

    public ObservableList<JournalEntry> getEntries() {
        return entryList.getItems();
    }
	}