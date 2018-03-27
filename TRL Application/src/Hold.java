
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
	


	public Hold(int patronID, String holdStatus) {
		
		this.patronID=patronID;
		this.holdStatus=holdStatus;
	}

public String toString(){
		
		
		return "Patron ID: "+patronID+" Hold Status: "+holdStatus;
		
		
	}

}
