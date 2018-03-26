import java.util.Scanner;

public class TRLApp {
	
	static Patron patron = new Patron();
	static Textbook textbook = new Textbook(100,"Software Development", 3);
	static String holdStatus = null;
	
public static void main(String[] args) {
	
	loadData();
	System.out.println("***Textbook Rental Application***");
	System.out.println("Start a checkout session ?");
	Scanner input = new Scanner(System.in);
	String choice = input.next();
	if(choice.equalsIgnoreCase("Y")) {
		
		startCheckOut();
	}
	
	else {
		
		
		
	}
}

private static void startCheckOut() {
	
	System.out.println("Please Enter the Patron ID");
	Scanner input = new Scanner(System.in);
	int patronID = input.nextInt();
	boolean patronExists = validatePatronID(patronID);
	if(patronExists==true && holdStatus =="N" ) {
		
		System.out.println("***Enter Copies to be Checked Out***");
		enterCopiesToCheckOut();
	}
}

private static void enterCopiesToCheckOut() {
	
	String inputMoreCopies = "Y";
	while(inputMoreCopies=="Y") {
	System.out.println("Enter CopyID to check out");
	Scanner input = new Scanner(System.in);
	int copyID = input.nextInt();
	boolean copyExists = validateCopy(copyID);
	
	if(copyExists==true) {
		System.out.println("Copy Exists");		
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
	
     for(int i =0; i<textbook.getCopyList().size(); i++) {
		
		if(textbook.getCopyList().get(i).getCopyID()== copyID){
			copyExists = true;
			break;
		}
   }
	
  return copyExists;
}

private static boolean validatePatronID(int patronID) {
	
	boolean patronExists = false;
	
	for(int i =0; i<patron.getPatronList().size(); i++) {
		
		if(patron.getPatronList().get(i).getPatronID()== patronID){
			
			patronExists = true;
			System.out.println("Patron Exists");
			System.out.println(patron.getPatronList().get(i).toString());
			holdStatus = patron.getHoldList().get(i).getHoldStatus();
			System.out.println("Hold Status: "+holdStatus);		
			break;
		}
	}	
	if(patronExists == false) {		
		System.out.println("The entered Patron ID does not exist in the system.");
	}
	
	return patronExists;
}


private static void loadData() {
	
		
    patron.createPatronData();   
	
	textbook.createTextbooks(100);
}

}
