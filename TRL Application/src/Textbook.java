import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
<<<<<<< HEAD
=======
import java.util.HashMap;
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git

public class Textbook {
	private int textbookID;
	private String title;
	private String author;
	private int numOfCopy;
	private ArrayList<Copy> copyList = new ArrayList<Copy>();
<<<<<<< HEAD
=======
	ArrayList<RentalHistory>history = new ArrayList<RentalHistory>();

	public ArrayList<RentalHistory> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<RentalHistory> history) {
		this.history = history;
	}
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git

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
<<<<<<< HEAD
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		String dateString = "03/26/2018";
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		System.out.println(date);
=======
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		String dateString = "04/20/2018";
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		//System.out.println(date);
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git

		System.out.println(toString());
		Copy copyOne = new Copy(1234, textbookID, "Available", null, 0);
<<<<<<< HEAD
		Copy copyTwo = new Copy(4567, textbookID, "Not Available", dateString, 123);
		Copy copyThree = new Copy(8910, textbookID, "Available", null, 0);

		copyList.add(copyOne);
		copyList.add(copyTwo);
		copyList.add(copyThree);

=======
		Copy copyTwo = new Copy(4567, textbookID, "Not Available", date, 123);
		Copy copyThree = new Copy(8910, textbookID, "Available", null, 0);
		

		copyList.add(copyOne);
		copyList.add(copyTwo);
		copyList.add(copyThree);
		
		/*HashMap<Integer,Integer>historyMap = new HashMap<Integer,Integer>();

		for(int i =0; i<copyList.size(); i++) {
			
			historyMap.put(copyList.get(i).getCopyID(), 1234);
			historyMap.put(copyList.get(i).getCopyID(), 4567);
			}
		*/
		
		RentalHistory copyHistoryOne = new RentalHistory(1234,123,"Kathy",date,date);
		RentalHistory copyHistoryTwo = new RentalHistory(1234,456,"Amy",date,date);
		RentalHistory copyHistoryThree = new RentalHistory(4567,123,"Kathy",date,date);
		
		history.add(copyHistoryOne);
		history.add(copyHistoryTwo);
		history.add(copyHistoryThree);
		
		//System.out.println(history.toString());
		
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
		System.out.println(copyOne.toString());
		System.out.println(copyTwo.toString());
		System.out.println(copyThree.toString());

	}

<<<<<<< HEAD
=======
	
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
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
