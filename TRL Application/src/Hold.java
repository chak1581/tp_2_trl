
public class Hold {
	
	private String holdStatus;
	private int patronID;
	
	
	public String getHoldStatus() {
		return holdStatus;
	}


	public void setHoldStatus(String holdStatus) {
		this.holdStatus = holdStatus;
	}


	public int getPatronID() {
		return patronID;
	}


	public void setPatronID(int patronID) {
		this.patronID = patronID;
	}


	public Hold()
	{

	}


	public void createHoldData(int patronID) {
		
		Hold hold = new Hold();
		
		hold.setHoldStatus("N");
		hold.setPatronID(patronID);
		System.out.println(hold.toString());
		
		
	}
	
public String toString(){
		
		
		return "Patron ID: "+patronID+" Hold Status: "+holdStatus;
		
		
	}

}
