//Program that plays a simple game of hangman

import java.util.*;

public class Hangman_Game {

	public static void main(String[] args) {
		
		//Initializations
		Scanner scan = new Scanner (System.in);
		
		List<Character> used_letters = new ArrayList<Character>(); 
		
		int count = 0; 
		char guess = ' ';
		boolean isTrue = false;
		String word, name;
		
		//Array of words that the game will chose from
		String [] words = {"dog", "avocado", "project", "robot", "coyote", "jacket"}; 
		
		//Generates a random int in the range of 0 and the length of the array (6)
		word = words[(int)(Math.random() * words.length)]; 
		
		//Changing the word chosen to an array of char variables
		char[] wordtochar = word.toCharArray();
		
		System.out.println("What is your name? ");
		name = scan.nextLine();
		
		System.out.println("Welcome to the game " + name + "!");
		System.out.println("Here are the rules and directions: ");
		System.out.println("");
		
		//Creating an array to display dashes on screen to symbolize the word
		char[] dashes = new char [wordtochar.length];
			for(int i = 0; i < wordtochar.length; i++)
				dashes[i] = '-';
		
		System.out.println(" ");
		
		//User only gets 8 wrong guesses
		while (count < 8)
		{
			//Prints the dashes 
			for(char i: dashes)
					System.out.print(i + " ");	
			
			isTrue = false;
			
			System.out.println("\n" + "Guess a letter in the word");
			guess = scan.next().charAt(0);
	
			//Adds the guess to an array list
			used_letters.add(guess); 
			
			//Checks to see if the guess is present anywhere in the word
			for(int i = 0; i < wordtochar.length; i++)
			{
				if (guess == wordtochar[i])
				{
					isTrue = true; 
					dashes[i] = guess; //Changes the dash to the guess if it is correct
				}
			}
			
		
			//Adds to count if user was wrong
			if(isTrue == false)
			{
				count++;
				System.out.println("Nope! Try again.");
			}
			
			System.out.println("\n-------------------------------------------------------------\n");
			
			System.out.println("These letters have been used: ");
			
			//Prints the used letters
			for(int i = 0; i < used_letters.size(); i++)
			{
				System.out.print(used_letters.get(i) + ", ");
			}
			
			System.out.println();
			
			//Checks if the arrays are equal, meaning the user has won
			if (Arrays.equals(dashes, wordtochar))
			{
				System.out.println("\n" + "You won! The word was " + "\"" + word + "\"");	
				break;
			}
		}
		
		//Prints if the user uses too many rounds
		if(count > 7)
			System.out.println("You lost!");
		
		System.out.println("\n=========");
		System.out.println("Game over");
		System.out.println("=========");
	}

}