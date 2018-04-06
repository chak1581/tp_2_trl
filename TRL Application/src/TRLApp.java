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
	static Textbook textbook = new Textbook(100, "Software Development", 3);
	static String holdStatus = null;
	static boolean copyAvailable = false;
	static ArrayList<Copy> checkoutList = new ArrayList<Copy>();
	static int patronID;
	
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
	 }
	 
	private static void startCheckOut() {

		System.out.println("Please Enter the Patron ID: ");
		Scanner input = new Scanner(System.in);
		patronID = input.nextInt();
		boolean patronExists = Patron.validatePatronID(patronID);
		if (patronExists == true && holdStatus == "N") {
			enterCopiesToCheckOut(patronID);
		}else {
			
			newCheckOut();
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
			System.out.println("Complete Check Out?[Y or N]:");
			Scanner input = new Scanner(System.in);
			String completeCheckOut = input.next();
			if(completeCheckOut.equalsIgnoreCase("Y")){
				checkoutSummary();
				newCheckOut();
			}
			
			
		}
	}

	private static void displayRentalHistory(int copyID) {

    System.out.println("Display Rental History? [Y or N]");
    
    Scanner input = new Scanner(System.in);
    String rentalDisplay = input.next();
    
    if(rentalDisplay.equalsIgnoreCase("Y")) {
    	
    	RentalHistory.copyRentalHistory(copyID);

    }
    else 
    	{
    	return;
    	
    	}
		
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