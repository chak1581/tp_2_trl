import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// add method
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
		System.out.println(
				"\r\nT***************************************************************************************T\n"
						+ "\nR**************************Welcome to TextBook Rental System****************************R\n"
						+ "\nL***************************************************************************************L");
		System.out.print("Start a checkout session? [Y or N]: ");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		if (choice.equalsIgnoreCase("Y")) {
			PatronRules patronRules = new PatronRules();
			patronDisplayRules(input, patronRules);
			startCheckOut();
		} else {
			System.out.println(
					"\nT***************************************************************************************T\n"
							+ "\nR**********************Thank you for using Textbook Rental System***********************R\n"
							+ "\nL***************************************************************************************L\n"
							+ "\n*****************************************Creators: Brett && Ipshita && Veronica && Shanqi");
		}
		System.out
				.println("\nT***************************************************************************************T\n"
						+ "\nR**********************Thank you for using Textbook Rental System***********************R\n"
						+ "\nL***************************************************************************************L\n"
						+ "\n*****************************************Creators: Brett && Ipshita && Veronica && Shanqi");
	}

	private static void patronDisplayRules(Scanner input, PatronRules patronRules) {
		System.out.print("\nDo you want to see the patron check out instruction? [Y or N]:");
		if ("Y".equalsIgnoreCase(input.next())) {
			patronRules.displayRules();
			startCheckOut();
		} else {
			System.out.println("\nAll right!!! Let's begin your check out.");
		}
	}

	private static void startCheckOut() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please Enter the Patron ID: ");
		int patronID = input.nextInt();
		boolean patronExists = Patron.validatePatronID(patronID);
		if (patronExists == true && holdStatus == "N") {
			enterCopiesToCheckOut(patronID);
		} else if (patronExists == true && holdStatus == "Y") {
			System.out.println("There is a hold in patron's account. Checkout is prohibited.");
			newCheckOut();
		} else if (patronExists == false) {
			System.out.println("The entered Patron ID does not exist in the system.");
			newCheckOut();

		}
	}

	private static void enterCopiesToCheckOut(int patronID) {
		String inputMoreCopies = "Y";
		while (inputMoreCopies.equalsIgnoreCase("Y")) {
			Scanner input = new Scanner(System.in);
			System.out.print("\nPlease Enter CopyID: ");
			int copyID = input.nextInt();

			boolean copyExists = Copy.validateAndCheckOutCopy(copyID, patronID);
			if (copyExists == true) {
				System.out.println("Copy Validated in the System !");

				if (copyAvailable == false) {
					System.out.println("The Copy is Already Checked Out!!!");
				} else {
					displayRentalHistory(copyID);
				}
				System.out.print("\nMore Copies to check Out[Y or N]: ");
				Scanner userInput = new Scanner(System.in);
				inputMoreCopies = userInput.next();
			}

			else {
				System.out.println("Incorrect Copy ID. Please Re-Enter Copy ID: ");
			}

		}
		if (inputMoreCopies.equalsIgnoreCase("N")) {
			System.out.print("\nComplete Check Out?[Y or N]: ");
			Scanner input = new Scanner(System.in);
			String completeCheckOut = input.next();
			if (completeCheckOut.equalsIgnoreCase("Y")) {
				checkoutSummary();
				newCheckOut();
			}
		}
	}

	private static void displayRentalHistory(int copyID) {

		System.out.print("\nDisplay Rental History? [Y or N]: ");

		Scanner input = new Scanner(System.in);
		String rentalDisplay = input.next();

		if (rentalDisplay.equalsIgnoreCase("Y")) {

			RentalHistory.copyRentalHistory(copyID);

		} else {
			return;

		}

	}

	private static void loadData() {
		System.out.println("Creating Patron data & Textbook Data...");

		patron.createPatronData();

		textbook.createTextbooks(100);

		System.out.println("TRL Data loaded succesfully!");
	}

	private static void checkoutSummary() {
		for (int i = 0; i < checkoutList.size(); i++) {
			System.out.println(checkoutList.get(i).toString());
		}
	}

	private static void newCheckOut() {

		System.out.print("\r\nStart a New Session Again? [Y or N]: ");

		Scanner userInput = new Scanner(System.in);
		if (userInput.next().equalsIgnoreCase("Y")) {
			checkoutList.clear();
			startCheckOut();
		} else {
			System.out.println("==============Session end==============");
			return;
		}
	}

}