import java.util.*;

/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 16th
 * Assignment 1, Problem 2
 * Description: Write a program with the methods shifting arrays left and right, first by one, then by an integer k, then by k again but perserving the original array
 */ 

public class Assignment1_2 {
	
	private static Scanner scan = new Scanner (System.in);
	
	//Class constants
	private static final int MAX_RANGE = 100; 
	private static final int MIN_RANGE = 1;
	
	//fill the array with random values between 1 and 100 (declared as class constants).
	public static void randArray(int[] list, int size, int lower, int upper) { 
		Random rand = new Random(); //Initialize rand object
		for (int i = 0; i < size; i++) 
			list[i] = rand.nextInt(upper - lower + 1) + lower; //Assign each element with a random int.
	}
		
	//Use printf to print elements
	public static void print(int[] list, int size) { 
		for (int i = 0; i < size; i++) {
			System.out.printf(list[i] + " "); }
		System.out.println();
	}
		
	//Copy a 1D array to another
	public static void copy(int[] list, int[] copy_list, int size) {
		for (int i = 0; i < size; i++)
			copy_list[i] = list[i];
	}
	
	//Input validation
	public static int getInt(Scanner input, String prompt) {
		System.out.print(prompt);
		//Will continue to loop until input is valid; Checks token
		while (!input.hasNextInt()) {
			input.next();
			System.out.print("WRONG TYPE! Not an integer! REENTER: \n");
			System.out.print(prompt);
		}
		return input.nextInt();
		
	}
		
	//prints a list of options and returns a valid option
	public static int menu() {
		int option;
		String prompt = "Please enter your option:";
				
		do {
			System.out.println("\nYour options are: ");
			System.out.println("------------------");
			System.out.println("1) Shift left");
			System.out.println("2) Shift left (k steps)/in place");
			System.out.println("3) Shift left (k steps)/second array");
			System.out.println("4) Shift right");
			System.out.println("5) Shift right (k steps)/in place");
			System.out.println("6) Shift right (k steps)/second array");
			System.out.println("0) EXIT");
			prompt = "Please enter your option:";
				
			option = getInt(scan, prompt);
							
		} while(option < 0 || option > 6);
			
			return option;
	}	
	
	
	//rotates a one-dimensional array with one position to the left in a circular way, so that the first element becomes the last element (shift left). 
	public static void shiftLeft(int[] arr, int size) {
		int temp = arr[0]; //Set a temp to store the first array element
		for(int i = 1; i < size; i++) {
			arr[i-1] = arr[i];
		}
		arr[size-1] = temp; //Add the stored first element to the end
	}
	
	//Overload the method shiftLeft so that you rotate the array left by k positions
	public static void shiftLeft(int[] arr, int size, int k) {
		for(int i = 1; i <= k; i++) {
			shiftLeft(arr, size);
		}
	}
	
	//Rotate the array left by k positions. The method should preserve the original array and save the results of the left rotation into a second array.
	public static int[] shiftLeftK(int[] arr, int size, int k) {
		int[] newArr = new int[size];
		copy(arr, newArr, size); //Copy original array contents to newArr to perserve arr

		for(int j = 1; j <= k; j++) {
			int temp = newArr[0]; //Set a temp to store the first array element
			for(int i = 1; i < size; i++) {
				newArr[i-1] = newArr[i];
			}
			newArr[size-1] = temp; //Add the stored first element to the end
		}
		
		return newArr; 
	}
	
	//rotates a one-dimensional array with one position to the right in a circular way, so that the last element becomes the first element (shift right).
	public static void shiftRight(int[] arr, int size) {
		int temp = arr[size - 1]; //Set temp to the last element
		for(int i = size - 1; i > 0 ; i--) 
		{
				arr[i] = arr[i-1];
		}
		arr[0] = temp; //Set the first element to the stored last element value
	}
	
	//Overload the method shiftRight so that you rotate the array right by k positions
	public static void shiftRight(int[] arr, int size, int k) {
		for(int i = size - 1; i >= k; i--) {
			shiftRight(arr, size);
		}
	}

	//Rotate the array left by k positions. The method should preserve the original array and save the results of the left rotation into a second array.
	public static int[] shiftRightK(int[] arr, int size, int k) {
		int[] newArr = new int[size];
		copy(arr, newArr, size); //Copy original array contents to newArr to perserve arr
		
		for(int j = 1; j <= k; j++) {
			int temp = newArr[size - 1]; //Set temp to the last element
			for(int i = size - 1; i > 0 ; i--) 
			{
				newArr[i] = newArr[i-1];
			}
			newArr[0] = temp; //Set the first element to the stored last element value
		}
		return newArr;
	}
	
	
	
	public static void main(String[] args) {
		//Declarations
		int size, option;
		int[] list;
		
		option = menu(); //Display menu then store option chosen 
		
		while(option != 0) {
			size = getInt(scan, "How many elements in list:"); //Get the size and validate it 
			
			list = new int[size]; //Initialize the array
			
			randArray(list, size, MIN_RANGE, MAX_RANGE); //Create the random array
			
			System.out.println("The original list is: "); //Print the array
			print(list, size);
			
			switch(option){ // Calls to the method corresponding to the menu
				case 1:
					shiftLeft(list, size);
					System.out.println("The list after left rotation is:");
					print(list, size);
					break;
				case 2: 
					int k = getInt(scan, "Input k (step for shift left): ");
					shiftLeft(list, size, k);
					System.out.println("The second list after left rotation with " + k + " positions is:");
					print(list, size);	
					break;
				case 3:
					int s = getInt(scan, "Input k (step for shift left): ");
					list = shiftLeftK(list, size, s);
					System.out.println("The second list after left rotation with " + s + " positions is:");
					print(list, size);
					break;
				case 4:
					shiftRight(list, size);
					System.out.println("The list after right rotation is:");
					print(list, size);
					break;
				case 5:
					int t = getInt(scan, "Input k (step for shift right): ");
					shiftRight(list, size, t);
					System.out.println("The second list after right rotation with " + t + " positions is:");
					print(list, size);
					break;
				case 6: 
					int a = getInt(scan, "Input k (step for shift right): ");
					list = shiftRightK(list, size, a);
					System.out.println("The second list after right rotation with " + a + " positions is:");
					print(list, size);
					break;
				default:
					System.out.println("Not an option, try again: ");
					break;
			}
			
			option = menu();
		
		}

	}

}
