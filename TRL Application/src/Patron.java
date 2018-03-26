
public class Patron {
	
	private int patronID;
	private String patronName;
	private String patronType;
	
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
	
	
	public Patron(){
		
	}
	
	public Patron(int ID, String name, String type)
	{
		this.patronID = ID;
		this.patronName = name;
		this.patronType = type;
	}

	public void createPatronData() {
		
		Patron patronOne = new Patron(123,"abc","student");
		Patron patronTwo = new Patron(456,"def","student");
		
		Hold hold1 = new Hold();
		Hold hold2 = new Hold();
		
		hold1.createHoldData(patronOne.getPatronID());
		hold2.createHoldData(patronTwo.getPatronID());
		
		System.out.println(patronOne.toString());
		System.out.println(patronTwo.toString());
		
	}

	public String toString(){
		
		
		return "Patron ID: "+patronID+" Patron Name: "+patronName+" Patron Type: "+patronType;
		
		
	}

}
