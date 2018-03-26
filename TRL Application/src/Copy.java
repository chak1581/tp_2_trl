
public class Copy {

	//checkoutStatus indicated by 1-inLibrary; 2-checkedOut; 3-overdue
	private int textBookID;
	private int copyID;
	private String checkoutStatus;
	private String dueDate;
	private int patronID;
	
	public int getCopyID() {
		return copyID;
	}

	public void setCopyID(int copyID) {
		this.copyID = copyID;
	}

	public String getCheckoutStatus() {
		return checkoutStatus;
	}

	public void setCheckoutStatus(String checkoutStatus) {
		this.checkoutStatus = checkoutStatus;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getPatronID() {
		return patronID;
	}

	public void setPatronID(int patronID) {
		this.patronID = patronID;
	}
	
	public int getTextBookID() {
		return textBookID;
	}

	public void setTextBookID(int textBookID) {
		this.textBookID = textBookID;
	}

	public Copy(){
		
	}

/*	public Copy(String ID) 
	{
		this.copyID = ID;
		checkoutStatus = 1;
		dueDate = "";
	}
*/
	public void createCopies(int textBookID) {
		
		
		Copy copyOne = new Copy();		
		copyOne.setCopyID(1234);
		copyOne.setCheckoutStatus("Available");
		copyOne.setTextBookID(textBookID);
		System.out.println(copyOne.toString());
		
		Copy copyTwo = new Copy();		
		copyTwo.setCopyID(4567);
		copyTwo.setCheckoutStatus("Checked Out");
		copyTwo.setPatronID(123);
		copyTwo.setDueDate("3/28/2018");
		copyTwo.setTextBookID(textBookID);
		System.out.println(copyTwo.toString());
		
		
		Copy copyThree = new Copy();		
		copyThree.setCopyID(7890);
		copyThree.setCheckoutStatus("Available");
		copyThree.setTextBookID(textBookID);
		System.out.println(copyThree.toString());
	}
	
	public String toString(){
		
		
		return "Textbook ID: "+textBookID+" CopyID: "+copyID+" CheckOut Status: "+checkoutStatus+ " Patron ID: "+patronID;
		
		
	}
	
}
