package Journal;

import java.time.LocalDate;

public class JournalEntry {
private String title;
private String content;
private LocalDate date;

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

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public JournalEntry(String title, String content, LocalDate date) {
	super();
	this.title = title;
	this.content = content;
	this.date = date;
}

@Override
public String toString() {
	return date + " - " + title;
}


}
