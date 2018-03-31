import java.util.ArrayList;

public class Patron {
	private int patronID;
	private String patronName;
	private String patronType;
	
	ArrayList<Patron> patronList = new ArrayList<Patron>();
	ArrayList<Hold> HoldList = new ArrayList<Hold>();

	public ArrayList<Hold> getHoldList() {
		return HoldList;
	}

	public void setHoldList(ArrayList<Hold> holdList) {
		HoldList = holdList;
	}

	public ArrayList<Patron> getPatronList() {
		return patronList;
	}

	public void setPatronList(ArrayList<Patron> patronList) {
		this.patronList = patronList;
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

	public String getPatronType() {
		return patronType;
	}

	public void setPatronType(String patronType) {
		this.patronType = patronType;
	}

	public Patron() {

	}

	public Patron(int ID, String name, String type) {
		this.patronID = ID;
		this.patronName = name;
		this.patronType = type;
	}

	public void createPatronData() {

		Patron patronOne = new Patron(123, "abc", "student");
		Patron patronTwo = new Patron(456, "def", "student");

		patronList.add(patronOne);
		patronList.add(patronTwo);

		Hold hold1 = new Hold(123, "N");
		Hold hold2 = new Hold(456, "Y");

		System.out.println(hold1.toString());
		System.out.println(hold2.toString());

		HoldList.add(hold1);
		HoldList.add(hold2);

		System.out.println(patronOne.toString());
		System.out.println(patronTwo.toString());

	}

	public String toString() {

		return "Patron ID: " + patronID + " Patron Name: " + patronName + " Patron Type: " + patronType;

	}

}
