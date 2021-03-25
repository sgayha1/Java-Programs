import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * Lab2_2
 * Description: Rewrite the previous program and make it work when the list is populated with values found in an input file.
 */ 

public class Lab2_2 {

	private static Scanner scan;
	
	//used to test for type errors in input
		public static int getInt(Scanner input, String prompt) {
			System.out.print(prompt);
			//Will continue to loop until input is valid; Checks token
			while (!input.hasNextInt()) {
				input.next();
				System.out.print("Not an integer, try again: \n");
				System.out.print(prompt);
			}
			return input.nextInt();
		}
		
		public static int initArray(Scanner inputFile, int[] list) {
			int count = 0;
			while(inputFile.hasNext()) //Reads the file
				{
					if(inputFile.hasNextInt()) //Checks if next token is an int
					{
						while(inputFile.hasNextInt()){
						   list[count++] = inputFile.nextInt();
						}
					}
				
					else
					{
						inputFile.next(); //Skips token if not an int
					}
				}
			
			return count;
		}
		
		
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
		
		
		//returns a boolean value indicating whether or not all of the values are even numbers
		public static boolean isAllEven(int[] list, int size) {
			for (int i = 0; i < size; i++)	
				if(list[i]%2 != 0) 
					return false;
			return true;
		}
		
		
		//returns a boolean value indicating whether or not the values in the array are unique (no pairs)
		public static boolean isUnique(int[] list, int size) {
			list = bubbleSort(list, size);
			for(int i = 1; i < size; i++) {
				if(list[i] == list[i-1]) {
					return false;
				}
			}
			
			return true;
		}

		
		
		//returns the minimum 'gap' between adjacent values in the array (second value - first)
		public static int minGap(int[] list, int size) {
			
			int min_gap = list[1] - list[0];
			
			for(int i = 1; i < size-1; i++) {
				if((list[i+1]-list[i]) < min_gap)
					min_gap = list[i+1]-list[i];
				}
			
			return min_gap;
		}

		
		//prints a list of options and returns a valid option
		public static int menu() {
			int option;
			String prompt = "Please enter your option:";
			
			do {
				System.out.println("\nYour options are: ");
				System.out.println("------------------");
				System.out.println("1) All even values? ");
				System.out.println("2) All unique values?");
				System.out.println("3) Print min gap between values");
				System.out.println("4) Statistics");
				System.out.println("5) Print 80% percentile");
				System.out.println("0) EXIT");
				prompt = "Please enter your option:";
				option = getInt(scan, prompt);
			} while(option < 0 || option > 5);
			return option;
		}
		
		
		//sorts the array in ascending order
		public static int[] bubbleSort(int[] list, int size) {
			int[] sortedList = new int[size];
			copy(list, sortedList, size);
			
			int i, j, temp = 0;
			for (i = 0; i < size-1; i++) {
				for (j = 0; j < size - 1 - i; j++) {
					if (sortedList[j] > sortedList[j + 1]) {
						temp = sortedList[j];
						sortedList[j] = sortedList[j + 1];
						sortedList[j + 1] = temp;
					}
				}
			}
			return sortedList;
		}

		
		//makes a copy of a 1-dim array into another 1-dim array
		public static void copy(int[] list, int[] copy_list, int size) {
			for (int i = 0; i < size; i++)
				copy_list[i] = list[i];
		}
		
		
		//prints the values in the 80%-percentile (top 20%)
		public static void top_20(int[] list){
		     bubbleSort(list, list.length);

		     int size = list.length * 20/100; //20% of array
		     int count = 0;
		    
		     for(int i = list.length-1; i >= 0; i--){
		    	 if(count < size) {
		    	 System.out.print(list[i] + " ");
		    	 count++;
		    	 }
		    	 else
		    		 break;
		     }
		     System.out.println();
		}


		
		//returns the average value/array
		public static double getMean(int[] list, int size) {
			int sum = 0;
			
			for (int i = 0; i < size; i++) { 
				sum += list[i];
			}
			return (double) sum / size; 
		}

		
		
		//returns the variance of a list of integers
		public static double getVariance(int[] list, int size, double mean) {
			double variance = 0;
			for (int i = 0; i < size; i++) {
			    variance += Math.pow(list[i] - mean, 2);
			}
			return variance /= size;
		}

	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in); //Scanner for input
		Scanner inputFile = null; //Declares another Scanner object for later
		boolean fileOpened = true; //To later check if it is closed when error
		int option, size;
		
		System.out.println("Please input the name of the file to be opened: "); //User input for the file name
		String file = scan.nextLine();
		
		try 
		{
			inputFile = new Scanner(new File(file)); //Tries to find the file in the directory
		}
		
		catch (FileNotFoundException e) //If cannot find the file or any other error
		{
		    System.out.println("--- File Not Found! Exit program! ---");
		    fileOpened = false; //closes so the rest of the code does not run
		}
		
		if(fileOpened) //Executes if file was found
		{
			int [] list = new int [100];
			size = initArray(inputFile, list);
			
			//An array was created and the file had integers
			if(size > 0) {
				System.out.println("The list is size: ");
				System.out.println(size);
				
				System.out.println("The list is: ");
				print(list, size);
				
				option = menu();
				
				while(option != 0) {
					switch(option) {
					case 1:
						if(isAllEven(list, size) == false)
							System.out.println("Some values/list are odd.");
						else
							System.out.println("All values are even.");
						break;
					case 2:
						if(isUnique(list,size)== false)
							System.out.println("Some values/list appear multiple times");
						else
							System.out.println("The values in the list are unique");
						break;
					case 3: 
						System.out.println("The minimum gap between 2 adjacent values is " + minGap(list, size));
						break;
					case 4:
						double mean = getMean(list, size);
						System.out.println("The mean for this list is: " + mean);
						System.out.println("The variance for this list is: " + getVariance(list, size, mean));
						break;
					case 5: 
						int[] newList = bubbleSort(list, size);
						System.out.println("\nThe list sorted: ");
						print(newList, size);
						System.out.println("80%-percentile from this list: ");
						top_20(newList);
						break;
					default:
						break;
							
					}
					option = menu();
				}
	
				System.out.println("Testing Completed.");	
			}
			
			else
				System.out.println("--- The file doesn't contain any integers. Exit program! ---");
			
			inputFile.close();
		}
		
	
	}

}
