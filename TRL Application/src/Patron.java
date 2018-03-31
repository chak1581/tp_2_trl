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

		Patron patronOne = new Patron(123, "Kathy", "student");
		Patron patronTwo = new Patron(456, "Amy", "student");
		Patron patronThree = new Patron(789, "Ryan", "student");
		Patron patronFour = new Patron(1001, "Dave", "student");

		patronList.add(patronOne);
		patronList.add(patronTwo);
		patronList.add(patronThree);
		patronList.add(patronFour);

		Hold hold1 = new Hold(123, "N");
		Hold hold2 = new Hold(456, "Y");
		Hold hold3 = new Hold(789, "Y");
		Hold hold4 = new Hold(1001, "Y");

		System.out.println(hold1.toString());
		System.out.println(hold2.toString());
		System.out.println(hold3.toString());
		System.out.println(hold4.toString());

		HoldList.add(hold1);
		HoldList.add(hold2);
		HoldList.add(hold3);
		HoldList.add(hold4);

		System.out.println(patronOne.toString());
		System.out.println(patronTwo.toString());
		System.out.println(patronThree.toString());
		System.out.println(patronFour.toString());
	}

	public String toString() {

		return "Patron ID: " + patronID + " Patron Name: " + patronName + " Patron Type: " + patronType;

	}

	public Patron getCurrentPatron() 
	{
		Patron current_patron = patronList.get(getPatronID());
		return current_patron;
	}

}
