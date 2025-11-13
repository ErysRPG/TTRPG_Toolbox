package RandomTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class tablesController {

	@FXML
	private TextArea tableItems;
	@FXML
	private TextField tableTitle;
	@FXML
	private Label tableResult;
	@FXML
	private Button tableAddButton, tableEditButton, tableDeleteButton, deleteTableButton, tableRollButton;
	@FXML
	private ListView<RandomTable> tableList;

	public void addTable() {
		try {
			// get title and content from field
			String title = tableTitle.getText();
			String itemAreaContent = tableItems.getText();

			// create an array list of strings. It must be flexible because the length is
			// unknown
			ArrayList<String> items = new ArrayList<>();

			// check if content is empty. If not, proceed with the else block

			if (title == null || title.isEmpty() || itemAreaContent == null || itemAreaContent.isEmpty()) {
				tableResult.setText("Title and content must not be empty");
			} else {
				// adds array to arraylist
				items.add(itemAreaContent);
				// create a new random table object
				RandomTable rt = new RandomTable(title, items);

				// add the table to the list
				tableList.getItems().add(rt);
				
				//clear title and table content
				tableTitle.clear();
				tableItems.clear();
			}

		} catch (Exception e) {
			tableResult.setText("Title and content must not be empty");
		}

	}

	public void editTable() {
		try {
			if (tableList == null) {
				tableResult.setText("Add a table first");
			} else {
				// get selected item
				RandomTable item = tableList.getSelectionModel().getSelectedItem();
				//load the fields
				tableTitle.setText(item.getTitle());
				// removes array brackets and load the text area
				tableItems.setText(String.valueOf(item.getItemList()).replaceAll("[\\[\\]]", ""));
			}
		} catch (Exception e) {
			tableResult.setText("Add a table first");
		}
		
		
	}
	
	public void saveTable() {
		try {
			if (tableList == null) {
				tableResult.setText("Add a table first");
			} else {
				String getNewTitle = tableTitle.getText();
				ArrayList<String> getNewItems = new ArrayList<String>();
				getNewItems.add(String.valueOf(tableItems.getText()));
				
				tableList.getSelectionModel().getSelectedItem().setTitle(getNewTitle);
				tableList.getSelectionModel().getSelectedItem().setItemList(getNewItems);
				}
			} catch (Exception e) {
				tableResult.setText("Add a table first");
			}	
		
				
	}

	public void deleteTable() {
		
		try {
			if (tableList == null) {
				tableResult.setText("Select a table from the list");
			} else {
				// select the item from the list
				RandomTable item = tableList.getSelectionModel().getSelectedItem();
				// remove the selected item
				tableList.getItems().remove(item);
			} 
		} catch (Exception e) {
			tableResult.setText("Select a table from the list");
		}
	}	

	public void rollTable() {

		try {
			// get title and content from field
			String title = tableTitle.getText();
			String itemAreaContent = tableItems.getText();

			// check if content is empty. If not, proceed with the else block

			if (title == null || title.isEmpty() || itemAreaContent == null || itemAreaContent.isEmpty()
					|| tableList == null) {
				tableResult.setText("Select a table from the list");
			} else {
				// store a chosen table from the List
				RandomTable chosenTable = tableList.getSelectionModel().getSelectedItem();

				// gets chosen table's items and converts them to string
				String chosenTableItems = chosenTable.getItemList().toString();
				// removes array brackets
				String removedBrackets = chosenTableItems.replaceAll("[\\[\\]]", "");

				// splits the created array by commas
				String[] splitArray = removedBrackets.split(", ");
				System.out.println(Arrays.toString(splitArray));

				// random number that will choose an index from the array
				Random rand = new Random();
				// chooses a random index from the table's items
				int randomItemFromTable = rand.nextInt(0, splitArray.length);
				// chooses the value of the array based in the selected index
				String chosenItem = splitArray[randomItemFromTable];

				// sets the chosen item in the label
				tableResult.setText(String.valueOf(chosenItem));
			}

		} catch (Exception e) {
			tableResult.setText("Select a table from the list");
		}

	}

	public void searchTable() {
		String title = tableTitle.getText();

		// check if content is empty. If not, proceed with the else block

		if (title == null || title.isEmpty() || tableList == null) {
			tableResult.setText("Introduce a title to search for tables");
		} else {
			// iterate through the table list. If the list contains the title, selects it and clears the rest.
			ObservableList<RandomTable> list = tableList.getItems();
			for (RandomTable table : list) {
			     if(list.contains(table.getTitle())) {
			    	 tableList.getSelectionModel().selectFirst();
			    	
			     }
			 }
		}
	}
	
}
