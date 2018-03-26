
public class Textbook {

	
	private int textbookID;
	private String title;
//	private String author;
	private int numOfCopy;
	
	public Textbook(int textbookID, String title, int numOfCopy )
	{
		this.title = title; 
		this.textbookID = textbookID;
		//this.author = author;
		this.numOfCopy = numOfCopy;
	}

	public void createTextbooks() {
		
		System.out.println(toString());
		Copy copy = new Copy();				
		copy.createCopies(textbookID);
		
		
		
	}
	
	public String toString(){
		
		return "TextBook ID: "+textbookID+" Title: "+title+" Number of Copies: "+numOfCopy;
	}
	
}
