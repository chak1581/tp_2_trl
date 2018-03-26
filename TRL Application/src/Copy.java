import java.util.ArrayList;

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

	public Copy(int copyID,int textBookID,String checkoutStatus,String dueDate,int patronID ) 
	{
		this.copyID = copyID;
		this.textBookID = textBookID;
		this.checkoutStatus = checkoutStatus;
		this.dueDate = dueDate;
		this.patronID = patronID;
	}

	public String toString(){
		
		
		return "Textbook ID: "+textBookID+" CopyID: "+copyID+" CheckOut Status: "+checkoutStatus+ " Patron ID: "+patronID;
		
		
	}
	
}
