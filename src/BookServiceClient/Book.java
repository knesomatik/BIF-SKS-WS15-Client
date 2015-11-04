package BookServiceClient;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

	@XmlAttribute(name="title")
	private String title = null;
	@XmlAttribute(name="pubYear")
	private Date pubYear = null;
	

	public Book() {

	}

	public Book(String first, Date sec) {
		title = first;
		pubYear = sec;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public Date getDate() {
		return pubYear;
	}

	public void setDate(Date newText) {
		pubYear = newText;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", pubYear=" + pubYear + "]";
	}

}
