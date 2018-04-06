import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Copy {

	//checkoutStatus indicated by 1-inLibrary; 2-checkedOut; 3-overdue
	private int textBookID;
	private int copyID;
	private String checkoutStatus;
	private Date dueDate;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
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

	public Copy(int copyID,int textBookID,String checkoutStatus,Date dueDate,int patronID ) 
	{
		this.copyID = copyID;
		this.textBookID = textBookID;
		this.checkoutStatus = checkoutStatus;
		this.dueDate = dueDate;
		this.patronID = patronID;
	}

	
	public String toString(){
		
		
		return "Textbook ID: "+textBookID+" CopyID: "+copyID+" CheckOut Status: "+checkoutStatus+ " Due Date: "+dueDate+ " Patron ID: "+patronID;
		
		
	}

	static boolean copyExists = false;
	static boolean validateAndCheckOutCopy(int copyID, int patronID) {
	
		TRLApp.c.setTime(new Date());
		TRLApp.c.add(Calendar.DATE, 90);
		Date dueDate = TRLApp.c.getTime();
	
		for (int i = 0; i < TRLApp.textbook.getCopyList().size(); i++) {
	
			if (TRLApp.textbook.getCopyList().get(i).getCopyID() == copyID) {
				copyExists = true;
				
				if (TRLApp.textbook.getCopyList().get(i).getCheckoutStatus().equalsIgnoreCase("Available")) {
					TRLApp.copyAvailable = true;
					TRLApp.textbook.getCopyList().get(i).setCheckoutStatus("Checked Out");
					TRLApp.textbook.getCopyList().get(i).setDueDate(dueDate);
					TRLApp.textbook.getCopyList().get(i).setPatronID(patronID);
					TRLApp.checkoutList.add(TRLApp.textbook.getCopyList().get(i));
					break;
				}
				else{
					TRLApp.copyAvailable = false;
				}
				
			}
			
			else {
				copyExists = false;
			}
		}
	
		return copyExists;
	}
	
}