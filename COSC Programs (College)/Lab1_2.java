import java.util.Scanner;

/*
 * Description: Draw an empty box of a character specified by the user using nested for loops. 
 * Box has same number of rows and columns (5 to 21) inputted by the user. 
 */ 

public class Lab1_2 {
	public static Scanner scan = new Scanner(System.in);
	
	//Input validation
	public static int getInt(Scanner input, String prompt) {
		
		System.out.print(prompt);
		//Will continue to loop until input is valid; Checks token
		
		while (!input.hasNextInt()) {
			input.next();
			System.out.print("Not an integer! Try again! " + prompt);
		}
		
		return input.nextInt();
	}
	
	
	//Sees if digit entered is in the given range (10-99)
	public static int checkRange(int rows, String prompt) {
		
		while(rows < 5 || rows > 21){
			System.out.print("ERROR! Valid range 5 - 21. ");
			rows = getInt(scan, prompt);
		}
				
		return rows; 
		}
	
	//Will print an empty box according to user input
	public static void printBox(char input, int rows) {
		
		for(int i = 0; i < rows; i++) { //First row
			System.out.print(input);
		}
		
		System.out.println();
		
		for(int i = 0; i < rows-2; i++) { //Middle rows
			System.out.print(input);
			for(int j = 0; j < rows-2; j++){
				System.out.print(" ");
			}
			System.out.print(input);
			System.out.println();
		}
		
		for(int i = 0; i < rows; i++) { //Last row
			System.out.print(input);
		}
		System.out.println();

	}
	
	public static void main(String[] args) {
		
	//Instantiations
	String prompt = "How many chars/last row? ";
	char input, play = ' ';
	int rows;
		
	
	System.out.print("Do you want to start (Y/N): ");
	play = scan.next().charAt(0);

	//While user enters Y, will continue
	while(Character.toUpperCase(play) == 'Y') {
		rows = getInt(scan, prompt);
		rows = checkRange(rows, prompt);
		
		System.out.print("What character?");
		input = scan.next().charAt(0);
		System.out.println();
		
		printBox(input, rows);
		
		System.out.print("\nDo you want to continue(Y/N): ");
		play = scan.next().charAt(0);
	}
		

	}

}
