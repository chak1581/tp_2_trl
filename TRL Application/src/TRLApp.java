import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class TRLApp {
	static SimpleDateFormat dF = new SimpleDateFormat("MM/dd/yyyy");
	static Calendar c = Calendar.getInstance();
	static Hold hold = new Hold();
	static Patron patron = new Patron();
	//static Worker worker = new Worker();
	static Textbook textbook = new Textbook(100, "Software Development", 3);
	static String holdStatus = null;
	static boolean copyAvailable = false;
	static ArrayList<Copy> checkoutList = new ArrayList<Copy>();
<<<<<<< HEAD

=======
	static int patronID;
	
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
	public static void main(String[] args) {
		loadData();
		System.out.println("T*******************************************************************T\n"
				+ "\nR****************Welcome to TextBook Rental System******************R\n"
				+ "\nL*******************************************************************L");
		System.out.print("Start a checkout session ?[Y or N]: ");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		if (choice.equalsIgnoreCase("Y")) {
			startCheckOut();
		} else {
			System.out.println("\nT*******************************************************************T\n"
					+ "\nR************Thank you for using Textbook Rental System*************R\n"
					+ "\nL*******************************************************************L");
<<<<<<< HEAD
		}
		// updateStatus();
		// checkoutSummary();
	}

=======
	 	} 
	 //updateStatus();
	// checkoutSummary();
	 }
	 
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
	private static void startCheckOut() {

		System.out.println("Please Enter the Patron ID: ");
		Scanner input = new Scanner(System.in);
		patronID = input.nextInt();
		boolean patronExists = Patron.validatePatronID(patronID);
		if (patronExists == true && holdStatus == "N") {
<<<<<<< HEAD
			enterCopiesToCheckOut();
		} else {
			enterCopiesToCheckOut();
=======
			enterCopiesToCheckOut(patronID);
		}else {
			
			newCheckOut();
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
		}
	}

	private static void enterCopiesToCheckOut(int patronID) {
		String inputMoreCopies = "Y";
		while (inputMoreCopies.equalsIgnoreCase("Y")) {
			System.out.println("Please Enter CopyID: ");
			Scanner input = new Scanner(System.in);
			int copyID = input.nextInt();
			boolean copyExists = Copy.validateAndCheckOutCopy(copyID, patronID);
			if (copyExists == true) {
				System.out.println("Copy Exists");
				displayRentalHistory(copyID);
				if (copyAvailable == false) {
					System.out.println("The Copy is Already Checked Out!!!");
<<<<<<< HEAD
				} else {
					c.setTime(new Date());
					c.add(Calendar.DATE, 90);
					Date dueDate = c.getTime();
					Copy aCopy = new Copy(copyID, textbook.getTextbookID(), "checked out", dueDate,
							patron.getCurrentPatron().getPatronID());
					checkoutList.add(aCopy);
=======
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
				}
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
				System.out.println("More Copies to check Out[Y or N]: ");
				Scanner userInput = new Scanner(System.in);
				inputMoreCopies = userInput.next();
			}

			else {
				System.out.println("Incorrect Copy ID. Please Re-Enter Copy ID: ");
			}

		}
<<<<<<< HEAD
		if (inputMoreCopies.equalsIgnoreCase("N")) {
			// System.out.println(checkoutList.);
			System.out.println("Complete Check Out?[Y or N]:");
			Scanner input = new Scanner(System.in);
			String completeCheckOut = input.next();
			if (completeCheckOut.equalsIgnoreCase("Y")) {
				updateStatus();
				checkoutSummary();
			}

			System.out.println("==========Session end==========");
=======
		if(inputMoreCopies.equalsIgnoreCase("N")) {
			System.out.println("Complete Check Out?[Y or N]:");
			Scanner input = new Scanner(System.in);
			String completeCheckOut = input.next();
			if(completeCheckOut.equalsIgnoreCase("Y")){
				//updateStatus();
				checkoutSummary();
				newCheckOut();
			}
			
			
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
		}
	}

	private static void displayRentalHistory(int copyID) {

    System.out.println("Display Rental History? [Y or N]");
    
    Scanner input = new Scanner(System.in);
    String rentalDisplay = input.next();
    
    if(rentalDisplay.equalsIgnoreCase("Y")) {
    	
    	RentalHistory.copyRentalHistory(copyID);

<<<<<<< HEAD
		for (int i = 0; i < textbook.getCopyList().size(); i++) {

			if (textbook.getCopyList().get(i).getCopyID() == copyID) {
				copyExists = true;
				if (textbook.getCopyList().get(i).getCheckoutStatus().equalsIgnoreCase("Available")) {
					copyAvailable = true;
				} else {
					copyAvailable = false;
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
=======
    }
    else 
    	{
    	return;
    	
    	}
		
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
	}

	private static void loadData() {
		System.out.println("==========================TRL Data Record============================");

		patron.createPatronData();

		textbook.createTextbooks(100);

	}

	private static void checkoutSummary() {
		for (int i = 0; i < checkoutList.size(); i++) {
			System.out.println(checkoutList.get(i).toString());
		}
	}
<<<<<<< HEAD

	private static void updateStatus() {
		for (int i = 0; i < checkoutList.size(); i++) {
=======
	
	/*private static void updateStatus() {
		for (int i=0; i<checkoutList.size();i++) {
>>>>>>> branch 'master' of https://github.com/chak1581/tp_2_trl.git
			checkoutList.get(i).setCheckoutStatus("checked out");
		}
	}*/
	
	private static void newCheckOut() {
		
		
		System.out.println("Start a New Session Again? [Y or N]");
		
		Scanner userInput = new Scanner(System.in);
		if(userInput.next().equalsIgnoreCase("Y")) {
			checkoutList.clear();
			startCheckOut();
		}
		else {
			System.out.println("==========Session end==========");
			return;
		}
	}

}