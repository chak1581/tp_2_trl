import java.util.Scanner;

public class TRLApp {
	static Hold hold = new Hold();
	static Patron patron = new Patron();
	static Worker worker = new Worker();
	static Textbook textbook = new Textbook(100, "Software Development", 3);
	static String holdStatus = null;
	static boolean copyAvailable = false;
	
	public static void main(String[] args) {
		// loadData();
		Scanner input = new Scanner(System.in);
		System.out.println("T*******************************************************************T\n"
				+ "\nR****************Welcome to TextBook Rental System******************R\n"
				+ "\nL*******************************************************************L");
		int option;
		a: while (true) {
			System.out.println("\n=====TRL Main Menu=====");
			System.out.println("1. Start CheckOut.");
			System.out.println("2. Exit Session. ");
			System.out.print("Please enter option: ");
			option = input.nextInt();
			if (option == 1) {
				System.out.println("\n===========Start CheckOut============");
				System.out.print("Please enter Worker ID: ");
				int workerIDstart = input.nextInt();
				System.out.println("WorkID: " + workerIDstart + " is running the transations.");
				System.out.print("Please enter Patron ID: ");
				int patronID = input.nextInt();
				System.out.print("[worker:" + workerIDstart + "]Did you want to check current Hold record?[Y or N]: ");
				String choice = input.next();
				if (choice.equalsIgnoreCase("Y")) {
					hold.createHoldData();
					if (patronID != hold.getPatronID()) {
						System.out.println("[PatronID:" + patronID + "] has no holds.");
						b: while (true) {
							System.out.print("\nStart CheckOut[Y or N]: ");
							String selection = input.next();
							if (selection.equalsIgnoreCase("Y")) {
								System.out.print("Please enter the Copy ID: ");
								int copyID = input.nextInt();
								System.out.println("[" + copyID + "] CheckOut successfully.");
							} else {
								d: while (true) {
									System.out.println("Please enter WorkerID to complete the session: ");
									int workerIDend = input.nextInt();
									if (workerIDstart == workerIDend) {
										System.out.println("Session completed.");
										break b;
									} else if (workerIDstart != workerIDend) {
										System.out.println("WorkID is not correct. Please re-enter the WorkerID: ");
										int workerIDend2 = input.nextInt();
										if (workerIDstart == workerIDend2) {
											System.out.println("Session completed.");
											break d;
										}
									}
									break b;
								}
							}
						}
					} else {
						System.out.println(
								"[PatronID:" + patronID + "] has hold. Please pay the fine before proceeding.");
					}
				} else if (choice.equalsIgnoreCase("N")) {
					c: while (true) {
						System.out.print("\nStart CheckOut[Y or N]: ");
						String selection = input.next();
						if (selection.equalsIgnoreCase("Y")) {
							System.out.print("Please enter the Copy ID: ");
							int copyID = input.nextInt();
							System.out.println("[" + copyID + "] CheckOut successfully.");
						} else {
							d: while (true) {
								System.out.println("Please enter WorkerID to complete the session: ");
								int workerIDend = input.nextInt();
								if (workerIDstart == workerIDend) {
									System.out.println("Session completed.");
									break c;
								} else if (workerIDstart != workerIDend) {
									System.out.println("WorkID is not correct!!!" + "Please re-enter the WorkerID: ");
									int workerIDend2 = input.nextInt();
									if (workerIDstart == workerIDend2) {
										System.out.println("Session completed.");
										break d;
									}
								}
							}
							break c;
						}
					}
				}
				
				}if (option == 2) {
					System.out.println("\nT*******************************************************************T\n"
							+ "\nR************Thank you for using Textbook Rental System*************R\n"
							+ "\nL*******************************************************************L");
					break a;
			}
		}
	}
	/*
	 * System.out.println("Start a checkout session ?"); Scanner input = new
	 * Scanner(System.in); String choice = input.next();
	 * if(choice.equalsIgnoreCase("Y")) {
	 * 
	 * 
	 * startCheckOut(); }
	 * 
	 * else {
	 * 
	 * 
	 * 
	 * } }
	 */

	private static void startCheckOut() {

		System.out.println("Please Enter the Patron ID");
		Scanner input = new Scanner(System.in);
		int patronID = input.nextInt();
		boolean patronExists = validatePatronID(patronID);
		if (patronExists == true && holdStatus == "N") {

			System.out.println("***Enter Copies to be Checked Out***");
			enterCopiesToCheckOut();
		}
	}

	private static void enterCopiesToCheckOut() {

		String inputMoreCopies = "Y";
		while (inputMoreCopies.equalsIgnoreCase("Y")) {
			System.out.println("Enter CopyID to check out");
			Scanner input = new Scanner(System.in);
			int copyID = input.nextInt();
			boolean copyExists = validateCopy(copyID);

			if (copyExists == true) {
				System.out.println("Copy Exists");
				if (copyAvailable == false) {
					System.out.println("The Copy is Already Checked Out");
				}
				System.out.println("More Copies to check Out?");
				Scanner userInput = new Scanner(System.in);
				inputMoreCopies = userInput.next();
			}

			else {
				System.out.println("Incorrect Copy ID. Re-Enter Copy ID");
			}

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

		patron.createPatronData();

		textbook.createTextbooks(100);
	}
	
	private static void checkoutSummary() {
		
		for(int i=0; i<textbook.getCopyList().size(); i++)
		{
			textbook.getCopyList().get(i).toString();
		}
	}

}