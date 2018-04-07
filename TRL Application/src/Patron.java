import java.util.ArrayList;
import java.util.Scanner;

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
		Patron patronFour = new Patron(101, "Dave", "student");
		Patron patronFive = new Patron(202, "Andy", "student");
		Patron patronSix = new Patron(303, "Kris", "student");
		Patron patronSeven = new Patron(404, "Scott", "student");
		Patron patronEight = new Patron(505, "Wendy", "student");

		patronList.add(patronOne);
		patronList.add(patronTwo);
		patronList.add(patronThree);
		patronList.add(patronFour);
		patronList.add(patronFive);
		patronList.add(patronSix);
		patronList.add(patronSeven);
		patronList.add(patronEight);

		Hold hold1 = new Hold(123, "N");
		Hold hold2 = new Hold(456, "N");
		Hold hold3 = new Hold(789, "Y");
		Hold hold4 = new Hold(101, "Y");
		Hold hold5 = new Hold(202, "N");
		Hold hold6 = new Hold(303, "Y");
		Hold hold7 = new Hold(404, "N");
		Hold hold8 = new Hold(505, "Y");

		HoldList.add(hold1);
		HoldList.add(hold2);
		HoldList.add(hold3);
		HoldList.add(hold4);
		HoldList.add(hold5);
		HoldList.add(hold6);
		HoldList.add(hold7);
		HoldList.add(hold8);

		Scanner input = new Scanner(System.in);
		System.out.println("Display Patron information? [Y or N]");
		String display = input.next();
		if(display.equalsIgnoreCase("Y")){
			System.out.println(patronOne.toString() +  " | Hold Status: " + hold1.getHoldStatus());
			System.out.println(patronTwo.toString() + " | Hold Status: " + hold2.getHoldStatus());
			System.out.println(patronThree.toString() + " | Hold Status: " + hold3.getHoldStatus());
			System.out.println(patronFour.toString() + " | Hold Status: " + hold4.getHoldStatus());
			System.out.println(patronFive.toString() + " | Hold Status: " + hold5.getHoldStatus());
			System.out.println(patronSix.toString() + " | Hold Status: " + hold6.getHoldStatus());
			System.out.println(patronSeven.toString() + " | Hold Status: " + hold7.getHoldStatus());
			System.out.println(patronEight.toString() + " | Hold Status: " + hold8.getHoldStatus());
		}
		
	}

	public String toString() {

		return "Patron ID: " + patronID + " | Patron Name: " + patronName + " | Patron Type: " + patronType;

	}

	static boolean validatePatronID(int patronID) {

		boolean patronExists = false;

		for (int i = 0; i < TRLApp.patron.getPatronList().size(); i++) {

			if (TRLApp.patron.getPatronList().get(i).getPatronID() == patronID) {

				patronExists = true;
				System.out.println("Patron Exists in the System !");
				System.out.println(TRLApp.patron.getPatronList().get(i).toString());
				TRLApp.holdStatus = TRLApp.patron.getHoldList().get(i).getHoldStatus();
				System.out.println("Hold Status: " + TRLApp.holdStatus);
				break;
			}
		}
		if (patronExists == false) {
			//System.out.println("The entered Patron ID does not exist in the system.");
		}

		return patronExists;
	}

}