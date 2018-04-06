import java.util.Date;

public class RentalHistory {
	
	int copyID;
	int patronID;
	String patronName;
	Date dueDate;
	Date returnedDate;
	
	
	public int getCopyID() {
		return copyID;
	}
	public void setCopyID(int copyID) {
		this.copyID = copyID;
	}
	public int getPatronID() {
		return patronID;
	}
	public void setPatronID(int patronID) {
		this.patronID = patronID;
	}
	public String getPatronName() {
		return patronName;
	}
	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	

static void copyRentalHistory(int copyID) {
		boolean historyFound = false;
		System.out.println("Rental History for Copy ID "+copyID);
		
		for(int i =0; i<TRLApp.textbook.getHistory().size();i++) {
			
			
			if(TRLApp.textbook.getHistory().get(i).getCopyID()==copyID) {
				
		        System.out.println("Patron ID: " +TRLApp.textbook.getHistory().get(i).getPatronID()+" | Patron Name: "
		        +TRLApp.textbook.getHistory().get(i).getPatronName()+" | Due Date: "+TRLApp.textbook.getHistory().get(i).getDueDate()+
		        " | Returned On: "+TRLApp.textbook.getHistory().get(i).getReturnedDate());
		        historyFound = true;
				
			}
		}
		
		if(historyFound==false) {
			
			System.out.println("No History Found !");
		}
	}
public RentalHistory(int copyID,int patronID,String patronName, Date dueDate, Date returnedDate) {
	
	this.copyID=copyID;
	this.patronID=patronID;
	this.patronName=patronName;
	this.dueDate=dueDate;
	this.returnedDate=returnedDate;
		
	}
}
