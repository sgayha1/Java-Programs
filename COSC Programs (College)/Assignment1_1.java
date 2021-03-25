import java.util.*;

/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 16th
 * Assignment 1, Problem 1
 * Description: Design a Java program to implement matrix arithmetic for square matrices (same number of rows and columns). 
 * You will need to use your math textbook or the Internet to review operations with matrices.
 * Make sure that your program is calling methods to perform (at least) the following operations:
 */ 

public class Assignment1_1 {

	private static Scanner scan = new Scanner (System.in);
	
	//Class constants
	private static final int MAX_RANGE = 10; 
	private static final int MIN_RANGE = 1;
	
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
	
	//prints a list of options and returns a valid option
	public static int menu() {
		int option;
		String prompt = "Please enter your option:";
				
		do {
			System.out.println("\nYour options are: ");
			System.out.println("------------------");
			System.out.println("1) Add 2 matrices");
			System.out.println("2) Subtract 2 matrices");
			System.out.println("3) Multiply 2 matrices");
			System.out.println("4) Multiply matrix by a constant");
			System.out.println("5) Transpose matrix");
			System.out.println("6) Matrix trace");
			System.out.println("0) EXIT");
			prompt = "Please enter your option:";
			
			option = getInt(scan, prompt);
			
		} while(option < 0 || option > 6);
			return option;
	}	
	
	//generates a matrix with values from 1-10
	public static void randArray(int[][] matrix, int low, int up) { 
		Random rand = new Random();
		for (int r = 0; r < matrix.length; r++)
			for (int c = 0; c < matrix[r].length; c++) 
				matrix[r][c] = rand.nextInt(up - low + 1) + low;
	}
	
	//prints the 2D array
	public static void printArray(int[][] matrix) { 
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) 
				System.out.printf("%5d", matrix[r][c]);
			
			System.out.println(); 
		}
	}
	
	//Add two matrices
	public static void addMatrices(int[][] matrix, int[][]matrix2) { 
		int[][] newMatrix = new int[matrix.length][matrix.length];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) 
				newMatrix[r][c] = matrix[r][c] + matrix2[r][c];
		}
		printArray(newMatrix);
	}
	
	
	//Subtract 2 matrices
	public static void subtactMatrices(int[][] matrix, int[][]matrix2) { 
		int[][] newMatrix = new int[matrix.length][matrix.length];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) 
				newMatrix[r][c] = matrix[r][c] - matrix2[r][c];
		}
		printArray(newMatrix);
	}
	
	//Multiply 2 matrices
	public static void multipyMatrices(int[][] matrix, int[][]matrix2) { 
		int[][] newMatrix = new int[matrix.length][matrix.length];
		int sum = 0;
		
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				for(int a = 0; a < matrix[r].length; a ++) {
					//Multiplies column index a fro matrix then row index a for matrix2
					sum += matrix[r][a] * matrix2[a][c]; 
				}
				newMatrix[r][c] = sum; //Adds sum of products to the specified space in the new Matrix
				sum = 0;
			}
		}
		printArray(newMatrix);
	}
	
	//Multipies the matrix by a constant
	public static void multConstant(int[][] matrix, int num) { 
		int[][] newMatrix = new int[matrix.length][matrix.length];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) 
				newMatrix[r][c] = matrix[r][c] * num;
		}
		printArray(newMatrix);
	}
	
	//Transpose matrix
	public static void transposeMatrix(int[][] matrix) { 
		int[][] newMatrix = new int[matrix[0].length][matrix.length];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) 
				newMatrix[r][c] = matrix[c][r];
		}
		printArray(newMatrix);
	}
	
	//Matrix trace
	public static int traceMatrix(int[][] matrix) { 
		int trace = 0;
		
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) { 
				if(r == c) //Check if a diagonal value
					trace += matrix[c][r]; //Adds to the running sum 
				}
			}
		return trace;
	}
	
	
	public static void main(String[] args) {
	
	//Variable instantiations
	int[][] matrix, matrix2;
	int option, size, counter = 0;	
	String prompt = "Enter the size of the square matrices: ";
	String prompt1 = "Enter the size of the square matrix: ";
	
	option = menu();//Display menu and prompt user
	if(option == 4 || option == 6 || option == 7){
		size = getInt(scan, prompt1);
	}
	else
		size = getInt(scan, prompt);
	
	while(option != 0) { //Loop until exited by user	
		
		matrix = new int[size][size];
		matrix2 = new int[size][size];
		
		//Switch according to menu choice
		switch(option) {
		
		case 1:
			//First matrix display
			System.out.println("\nFirst matrix is: ");
			randArray(matrix, MIN_RANGE, MAX_RANGE);
			printArray(matrix);
			
			//Second matrix display
			System.out.println("Second matrix is: ");
			randArray(matrix2, MIN_RANGE, MAX_RANGE);
			printArray(matrix2);
			
			System.out.println("The resulting matrix is: ");
			addMatrices(matrix, matrix2);
			
			break;
			
		case 2:
			//First matrix display
			System.out.println("\nFirst matrix is: ");
			randArray(matrix, MIN_RANGE, MAX_RANGE);
			printArray(matrix);
			
			//Second matrix display
			System.out.println("Second matrix is: ");
			randArray(matrix2, MIN_RANGE, MAX_RANGE);
			printArray(matrix2);
			
			System.out.println("The resulting matrix is: ");
			subtactMatrices(matrix, matrix2);
			
			break;

		case 3: 
			//First matrix display
			System.out.println("\nFirst matrix is: ");
			randArray(matrix, MIN_RANGE, MAX_RANGE);
			printArray(matrix);
			
			//Second matrix display
			System.out.println("Second matrix is: ");
			randArray(matrix2, MIN_RANGE, MAX_RANGE);
			printArray(matrix2);
			
			System.out.println("The resulting matrix is: ");
			multipyMatrices(matrix, matrix2);
			
			break;
			
		case 4:
			int num = getInt(scan, "Enter the multiplication constant: ");
			
			//Matrix display
			System.out.println("\nThe matrix is: ");
			randArray(matrix, MIN_RANGE, MAX_RANGE);
			printArray(matrix);
			
			System.out.println("The resulting matrix is: ");
			multConstant(matrix, num);
			
			break;
			
		case 5: 
			System.out.println("\nThe matrix is: ");
			randArray(matrix, MIN_RANGE, MAX_RANGE);
			printArray(matrix);
			
			System.out.println("The resulting matrix is: ");
			transposeMatrix(matrix);
			
			break;
			
		case 6:
			System.out.println("\nThe matrix is: ");
			randArray(matrix, MIN_RANGE, MAX_RANGE);
			printArray(matrix);
			
			System.out.println("The trace for this matrix is: " + traceMatrix(matrix));
			
			break;
			
		default:
			break;
				
		}
		
		counter++; //Set counter ++
		
		System.out.println("\t\t\t\tCommand number " + counter + " completed."); //Tell user what command
		
		option = menu(); //Display Menu
	}

	}

}
