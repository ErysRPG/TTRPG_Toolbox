package RandomTables;

import java.util.ArrayList;
import java.util.Random;
import java.util.Spliterator;

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
			
			// create an array list of strings. It must be flexible because the length is unknown
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
			}
			
			
		} catch (Exception e) {
			tableResult.setText("Title and content must not be empty");
		}
		
	}
	
	public void editTable() {
		
	}
	
	public void deleteTable() {
		
	}
	
	public void rollTable() {
		
		try {
			// get title and content from field
			String title = tableTitle.getText();
			String itemAreaContent = tableItems.getText();
			
			
			// check if content is empty. If not, proceed with the else block
			
			if (title == null || title.isEmpty() || itemAreaContent == null || itemAreaContent.isEmpty() || tableList == null) {
				tableResult.setText("Select a table from the list");
			} else {
				// store a chosen table from the List
				RandomTable chosenTable = tableList.getSelectionModel().getSelectedItem();
				
				// gets chosen table's items and converts them to string
				String chosenTableItems = chosenTable.getItemList().toString();
				// removes array brackets
				String removedBrackets = chosenTableItems.replaceAll("\\[\\]", "");
				
				
				// splits the created array by commas
				String [] splitArray = removedBrackets.split(", ");
				
				
				// random number that will choose an index from the array
				Random rand = new Random();
				// chooses a random item from the table's items
				int randomItemFromTable = rand.nextInt(0, splitArray.length);
				
				String chosenItem = splitArray[randomItemFromTable];
				
				
				System.out.println(chosenItem);
				
				
				
				tableResult.setText(String.valueOf(chosenItem));
			}
			
			
		} catch (Exception e) {
			tableResult.setText("Select a table from the list");
		}
		
		
		
	}
	
	public void searchTable() {
		
	}
}
