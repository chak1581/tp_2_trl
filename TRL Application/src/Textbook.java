import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Textbook {
	private int textbookID;
	private String title;
	private String author;
	private int numOfCopy;
	private ArrayList<Copy> copyList = new ArrayList<Copy>();
	ArrayList<RentalHistory> history = new ArrayList<RentalHistory>();

	public ArrayList<RentalHistory> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<RentalHistory> history) {
		this.history = history;
	}

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
		String dateString = "04/20/2018";
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		// System.out.println(date);

		Copy copyOne = new Copy(1001, textbookID, "Available", null, 0);
		Copy copyTwo = new Copy(1002, textbookID, "Not Available", date, 123);
		Copy copyThree = new Copy(2001, textbookID, "Available", null, 0);
		Copy copyFour = new Copy(2002, textbookID, "Available", null, 0);
		Copy copyFive = new Copy(3001, textbookID, "Not Available", date, 303);
		Copy copySix = new Copy(3002, textbookID, "Available", null, 0);
		Copy copySeven = new Copy(4001, textbookID, "Not Available", date, 505);
		Copy copyEight = new Copy(4002, textbookID, "Available", null, 0);
		Copy copyNine = new Copy(5001, textbookID, "Not Available", date, 789);
		Copy copyTen = new Copy(5002, textbookID, "Available", null, 0);

		copyList.add(copyOne);
		copyList.add(copyTwo);
		copyList.add(copyThree);
		copyList.add(copyFour);
		copyList.add(copyFive);
		copyList.add(copySix);
		copyList.add(copySeven);
		copyList.add(copyEight);
		copyList.add(copyNine);
		copyList.add(copyTen);

		/*
		 * HashMap<Integer,Integer>historyMap = new HashMap<Integer,Integer>(); for(int
		 * i =0; i<copyList.size(); i++) {
		 * 
		 * historyMap.put(copyList.get(i).getCopyID(), 1234);
		 * historyMap.put(copyList.get(i).getCopyID(), 4567); }
		 */

		RentalHistory copyHistoryOne = new RentalHistory(1002, 123, "Kathy", date, date);
		RentalHistory copyHistoryTwo = new RentalHistory(3001, 456, "Amy", date, date);
		RentalHistory copyHistoryThree = new RentalHistory(4001, 123, "Kathy", date, date);
		RentalHistory copyHistoryFour = new RentalHistory(5002, 456, "Amy", date, date);
		RentalHistory copyHistoryFive = new RentalHistory(5002, 123, "Kathy", date, date);
		

		history.add(copyHistoryOne);
		history.add(copyHistoryTwo);
		history.add(copyHistoryThree);
		history.add(copyHistoryFour);
		history.add(copyHistoryFive);


		// System.out.println(history.toString());
		
		Scanner input = new Scanner(System.in);
		System.out.print("\r\nDisplay Textbook information? [Y or N]: ");
		String display = input.next();
		if(display.equalsIgnoreCase("Y")) {
			System.out.println(toString());
			System.out.println(copyOne.toString());
			System.out.println(copyTwo.toString());
			System.out.println(copyThree.toString());
			System.out.println(copyFour.toString());
			System.out.println(copyFive.toString());
			System.out.println(copySix.toString());
			System.out.println(copySeven.toString());
			System.out.println(copyEight.toString());
			System.out.println(copyNine.toString());
			System.out.println(copyTen.toString());
		}
		
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

		return "TextBook ID: " + textbookID + " | Title: " + title + " | Number of Copies: " + copyList.size();
	}

}