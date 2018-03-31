
public class Overdue {
	private String patronName;
	private int patronId;
	private String dueNotice;
	// Date date;

	public void Overdue(String PatronName, int PatronId, String DueNotice) {
		this.patronName = PatronName;
		this.patronId = PatronId;
		this.dueNotice = DueNotice;
	}

	public String getPatronName() {
		return patronName;
	}

	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}

	public int getPatronId() {
		return patronId;
	}

	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}

	public String getDueNotice() {
		return dueNotice;
	}

	public void setDueNotice(String dueNotice) {
		this.dueNotice = dueNotice;
	}

	public boolean isOverDue() {
		return true;
	}

	public String toString() {
		return "Patron: " + this.patronName + " Id: " + this.patronId + " has over due notice: " + this.dueNotice;
	}
}
