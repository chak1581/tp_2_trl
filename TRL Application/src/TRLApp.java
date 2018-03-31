import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TRLApp {
	static Date date = new Date();
	static Hold hold = new Hold();
	static Patron patron = new Patron();
	static Worker worker = new Worker();
	static Textbook textbook = new Textbook(100, "Software Development", 3);
	static String holdStatus = null;
	static boolean copyAvailable = false;
	static ArrayList<Copy> checkoutList = new ArrayList<Copy>();
	
	public static void main(String[] args) {
	loadData();	
	System.out.println("T*******************************************************************T\n"
				+ "\nR****************Welcome to TextBook Rental System******************R\n"
				+ "\nL*******************************************************************L");
	 System.out.print("Start a checkout session ?[Y or N]: "); 
	 Scanner input = new Scanner(System.in); 
	 String choice = input.next();
	 if(choice.equalsIgnoreCase("Y")) {
	 startCheckOut(); 
	 }else {
		 System.out.println("\nT*******************************************************************T\n"
					+ "\nR************Thank you for using Textbook Rental System*************R\n"
					+ "\nL*******************************************************************L");
	 	} 
	 updateStatus();
	 checkoutSummary();
	 }
	 
	private static void startCheckOut() {

		System.out.println("Please Enter the Patron ID: ");
		Scanner input = new Scanner(System.in);
		int patronID = input.nextInt();
		boolean patronExists = validatePatronID(patronID);
		if (patronExists == true && holdStatus == "N") {
			enterCopiesToCheckOut();
		}else {
			enterCopiesToCheckOut();
		}
	}

	private static void enterCopiesToCheckOut() {
		String inputMoreCopies = "Y";
		while (inputMoreCopies.equalsIgnoreCase("Y")) {
			System.out.println("Please Enter CopyID: ");
			Scanner input = new Scanner(System.in);
			int copyID = input.nextInt();
			boolean copyExists = validateCopy(copyID);
			if (copyExists == true) {
				System.out.println("Copy Exists");
				Copy aCopy = new Copy(copyID, textbook.getTextbookID(), "checked out", date, patron.getCurrentPatron().getPatronID());
				checkoutList.add(aCopy);
				if (copyAvailable == false) {
					System.out.println("The Copy is Already Checked Out!!!");
				}
				System.out.println("More Copies to check Out[Y or N]: ");
				Scanner userInput = new Scanner(System.in);
				inputMoreCopies = userInput.next();
			}

			else {
				System.out.println("Incorrect Copy ID. Please Re-Enter Copy ID: ");
			}

		}
		if(inputMoreCopies.equalsIgnoreCase("N")) {
			System.out.println("Session end");
		}
	}

	private static boolean validateCopy(int copyID) {

		boolean copyExists = false;

		for (int i = 0; i < textbook.getCopyList().size(); i++) {

			if (textbook.getCopyList().get(i).getCopyID() == copyID) {
				copyExists = true;
				if (textbook.getCopyList().get(i).getCheckoutStatus().equalsIgnoreCase("Available")) {
					copyAvailable = true;
				}
				break;
			}
		}

		return copyExists;
	}

	private static boolean validatePatronID(int patronID) {

		boolean patronExists = false;

		for (int i = 0; i < patron.getPatronList().size(); i++) {

			if (patron.getPatronList().get(i).getPatronID() == patronID) {

				patronExists = true;
				System.out.println("Patron Exists");
				System.out.println(patron.getPatronList().get(i).toString());
				holdStatus = patron.getHoldList().get(i).getHoldStatus();
				System.out.println("Hold Status: " + holdStatus);
				break;
			}
		}
		if (patronExists == false) {
			System.out.println("The entered Patron ID does not exist in the system.");
		}

		return patronExists;
	}

	private static void loadData() {
		System.out.println("==========================TRL Data Record============================");
		
		patron.createPatronData();
		
		textbook.createTextbooks(100);
		
	}
	
	private static void checkoutSummary() {
		for(int i=0; i<checkoutList.size(); i++)
		{
			System.out.println(checkoutList.get(i).toString());
		}
	}
	
	private static void updateStatus() {
		for (int i=0; i<checkoutList.size();i++) {
			checkoutList.get(i).setCheckoutStatus("checked out");
		}
	}

}