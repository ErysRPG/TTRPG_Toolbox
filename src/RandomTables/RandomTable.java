package RandomTables;

import java.util.ArrayList;

public class RandomTable {
private String title;
private ArrayList<String> ItemList;


public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public ArrayList<String> getItemList() {
	return ItemList;
}
public void setItemList(ArrayList<String> itemList) {
	ItemList = itemList;
}
public RandomTable(String title, ArrayList<String> items) {
	super();
	this.title = title;
	this.ItemList = items;
	
	
}

@Override
public String toString() {
	return title;
}
}
