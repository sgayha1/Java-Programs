//Program created by Skylar Gayhart Spring 2019, Senior Year of High School
//Updated June 2020

//Imitation of The Wheel of Fortune Game Show

//Game class which controls the puzzle, it's display, the used letters, and checking the puzzle

import java.util.*;

public class Game {
	private String[] puzzles = {"Hollywood tourist", "Space jam", "Scooby Doo", "Michael Jordan", "The Lion King"};
	private String puzzle;
	private ArrayList<Character> letboard = new ArrayList<Character>();
	private char g;
	private int count;
	private char[] wordtochar, dashes;
	private boolean isSolved, loseTurn;

	Scanner scan = new Scanner(System.in);

	
	public Game()
	{
		puzzle = puzzles[(int)(Math.random() * 5)];
		wordtochar = puzzle.toCharArray();
		count = 0;
		loseTurn = false;
	}
	
	public void createPuzzle()
	{
		dashes = new char [wordtochar.length];
		for(int i = 0; i < wordtochar.length; i++)
			if(wordtochar[i] == ' ')
				dashes[i] = ' ';
			else	
				dashes[i] = '-';
	}
	
	public void displayPuzzle()
	{
		System.out.println("The Puzzle to Solve");  
		System.out.println("=====================\n");
		for(char i: dashes)
			System.out.print(i);
		System.out.println("\n\n=====================");
		  System.out.println();
	}
	
	public void usedLetters(char letter)
	{
		letboard.add(letter);
		System.out.println(letboard);
	}
	
	public boolean checkPuzzle(char guess)
	{
		boolean isRight = false;
		
		for(int a = 0; a < wordtochar.length; a++) {
			if(wordtochar[a] == Character.toUpperCase(guess) || wordtochar[a] == Character.toLowerCase(guess))
			{
				isRight = true;
				count ++;
				dashes[a] = guess; 
			}
		}
		
		if(isRight == true) {
			System.out.println("Correct! There were " + count + " " + guess + "'s in the puzzle");
			loseTurn = false;
		}
		
		else
		{
			System.out.print("Wrong! There were no " + guess);
			System.out.println();
			System.out.print("Turn lost");
			loseTurn = true;
		}
	
		return loseTurn;
	}
	
	public boolean checkSolve(String guess, String player)
	{
		if(guess.equalsIgnoreCase(puzzle)) {
			 System.out.println(player + " wins!");
			 isSolved = true;
		}
		 else
		 {
			 System.out.println(player + " looses a turn");
			 loseTurn = true;
		 }
		return isSolved;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean getloseTurn()
	{
		return loseTurn;
	}
	
	
}

