import java.util.ArrayList;

public class Hold {
	private String holdStatus;
	private int patronID;
	ArrayList<Hold> HoldList = new ArrayList<Hold>();

	public ArrayList<Hold> getHoldList() {
		return HoldList;
	}

	public void setHoldList(ArrayList<Hold> holdList) {
		HoldList = holdList;
	}

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

	public Hold() {

	}
<<<<<<< HEAD

	public Hold(int patronID, String holdStatus) {

		this.patronID = patronID;
		this.holdStatus = holdStatus;
=======
	


	public Hold(int patronID, String holdStatus) {
		
		this.patronID=patronID;
		this.holdStatus=holdStatus;
	}

public String toString(){
		
		
		return "Patron ID: "+patronID+" Hold Status: "+holdStatus;
		
		
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
	}

	public String toString() {

		return "Patron ID: " + patronID + " Hold Status: " + holdStatus;

	}

	public void createHoldData() {

		Hold hold1 = new Hold(123, "N");
		Hold hold2 = new Hold(456, "Y");

		System.out.println(hold1.toString());
		System.out.println(hold2.toString());

		HoldList.add(hold1);
		HoldList.add(hold2);
	}

	public boolean hasHold(Hold PatronID) {
		if (this.patronID == PatronID.patronID)
			;
		return true;
	}

}
