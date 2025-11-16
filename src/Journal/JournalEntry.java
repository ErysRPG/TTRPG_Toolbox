package Journal;

import java.time.LocalDate;

public class JournalEntry {
private String title;
private String content;
private String date;

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public JournalEntry(String title, String content, String formattedDate) {
	super();
	this.title = title;
	this.content = content;
	this.date = formattedDate;
}

@Override
public String toString() {
	return date + " - " + title;
}


}
