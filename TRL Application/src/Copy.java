
public class Copy {

	//checkoutStatus indicated by 1-inLibrary; 2-checkedOut; 3-overdue
	private String copyID;
	private int checkoutStatus;
	private String dueDate;

	public Copy(String ID) 
	{
		this.copyID = ID;
		checkoutStatus = 1;
		dueDate = "";
	}
	
}
