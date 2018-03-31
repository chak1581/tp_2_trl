import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Textbook {
	private int textbookID;
	private String title;
	private String author;
	private int numOfCopy;
	private ArrayList<Copy> copyList = new ArrayList<Copy>();

	public ArrayList<Copy> getCopyList() {
		return copyList;
	}

	public void setCopyList(ArrayList<Copy> copyList) {
		this.copyList = copyList;
	}

	public Textbook(int textbookID, String title, int numOfCopy) {
		this.title = title;
		this.textbookID = textbookID;
		// this.author = author;
		this.numOfCopy = numOfCopy;
	}

	public Textbook() {

	}

	public void createTextbooks(int textbookID) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		String dateString = "03/26/2018";
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		System.out.println(date);

		System.out.println(toString());
		Copy copyOne = new Copy(1234, textbookID, "Available", null, 0);
		Copy copyTwo = new Copy(4567, textbookID, "Not Available", dateString, 123);
		Copy copyThree = new Copy(8910, textbookID, "Available", null, 0);

		copyList.add(copyOne);
		copyList.add(copyTwo);
		copyList.add(copyThree);

		System.out.println(copyOne.toString());
		System.out.println(copyTwo.toString());
		System.out.println(copyThree.toString());

	}

	public int getTextbookID() {
		return textbookID;
	}

	public void setTextbookID(int textbookID) {
		this.textbookID = textbookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumOfCopy() {
		return numOfCopy;
	}

	public void setNumOfCopy(int numOfCopy) {
		this.numOfCopy = numOfCopy;
	}

	public String toString() {

		return "TextBook ID: " + textbookID + " Title: " + title + " Number of Copies: " + numOfCopy;
	}

}
