import java.util.ArrayList;

public class Textbook {

	
	private int textbookID;
	private String title;
//	private String author;
	private int numOfCopy;
	private ArrayList<Copy>copyList = new ArrayList<Copy>();

	
	public ArrayList<Copy> getCopyList() {
		return copyList;
	}

	public void setCopyList(ArrayList<Copy> copyList) {
		this.copyList = copyList;
	}

	public Textbook(int textbookID, String title, int numOfCopy )
	{
		this.title = title; 
		this.textbookID = textbookID;
		//this.author = author;
		this.numOfCopy = numOfCopy;
	}
	
	public Textbook() {
		
	}

	public void createTextbooks(int textbookID) {
		
		System.out.println(toString());
		Copy copyOne = new Copy(1234,textbookID,"Available",null,0);
		Copy copyTwo = new Copy(4567,textbookID,"Available",null,0);		
		Copy copyThree = new Copy(8910,textbookID,"Available",null,0);		
		
		copyList.add(copyOne);
		copyList.add(copyTwo);
		copyList.add(copyThree);
		
		System.out.println(copyOne.toString());
		System.out.println(copyTwo.toString());
		System.out.println(copyThree.toString());
		
	}
	
	public String toString(){
		
		return "TextBook ID: "+textbookID+" Title: "+title+" Number of Copies: "+numOfCopy;
	}
	
}
