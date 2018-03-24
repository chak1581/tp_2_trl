
public class Patron
{
	//patronType key: 1-student; 2-faculty/staff
	private String patronID;
	private String patronName;
	private int patronType;
	
	public Patron(String ID, String name, int type)
	{
		this.patronID = ID;
		this.patronName = name;
		this.patronType = type;
	}
}
