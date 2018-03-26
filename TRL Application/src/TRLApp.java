
public class TRLApp {
	
	
	
public static void main(String[] args) {
	
	loadData();
	
}

private static void loadData() {
	
	Patron patron = new Patron();	
    patron.createPatronData();
    
	Textbook textbook = new Textbook(100,"Software Development", 3);
	textbook.createTextbooks();
}

}
