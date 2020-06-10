//Program created by Skylar Gayhart Spring 2019, Senior Year of High School
//Updated June 2020

//Imitation of The Wheel of Fortune Game Show

//Main class to impliment the Game and Player class

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Game g = new Game();
		
		boolean solved = false, turn;
		int players;
		String name1, name2, name3;

		System.out.println("\n\t\t\tWelcome to the Wheel of Fortune Game! Here are some basic rules and directions: ");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("\t1: Player 1 will start first, then Player 2, then Player 3 then back to Player 1\n");
		System.out.println("\t2: There are three menu options:\n\t\t- Solve the puzzle\n\t\t- Spin the wheel and guess a character\n\t\t- Buy a vowel and guess a vowel\n");
		System.out.println("\t3: In order to buy a vowel, you need 200 points at least. Once bought, 200 will be subtracted from their total\n");
		System.out.println("\t4: The only way a player can lose their turn is if they guess a letter that isnt in the puzzle, \n\tincorreclty solve the puzzle, or buy a vowel with no money\n");
		System.out.println("\t5: Make sure you're putting the right input! \n\n \t\t\t\t\t\tEnjoy the game!\n ");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------\n");
		
		System.out.println("What are your players' names? ");
		name1 = scan.next();
		name2 = scan.next();
		name3 = scan.next();
		
		System.out.println("Welcome " + name1 + ", " + name2 + ", " + name3 + "! Best of luck!\n");
		System.out.println("Player 1: " + name1 + "\nPlayer 2: " + name2 + "\nPlayer 3: " + name3 + "\nPlayer one will start. ");
		
		g.createPuzzle();
		System.out.println();
		g.displayPuzzle();
		System.out.println();
		
		
		//Creating player objects
		Player p1 = new Player (name1);
		Player p2 = new Player (name2);
		Player p3 = new Player (name3);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());	
		
		//Create another Player object for the current player
		Player cp = new Player (" ");
		cp = p1;
		
		//While the puzzle is not solved
		while(!solved)
		{
			//Shuffles through the current player
			if(cp == p1)
				
			{
				//Selects the players turn and sets it
				//Tries the program first and if input is wrong, terminates for security
				
				try {
					p1.setTurn();
					p1.selectTurn(g);
					System.out.println();
				
					//shifts players if the turn was lost
					if(p1.getloseTurn())
					{
						cp = p2;
					}
					
					//Checks if puzzle is solved
					solved = p1.getisSolved();	
					System.out.println();
					System.out.println(p1.toString());
					System.out.println();
					g.displayPuzzle();
				}
				
				catch (InputMismatchException e)
				{
					 System.out.println(e);
					 break;
				}
			}
			
			else if(cp == p2)
			{
				try {
					p2.setTurn();
					p2.selectTurn(g);
					System.out.println();
					
					if(p2.loseTurn)
					{
						cp = p3;
					}
					
					solved = p2.getisSolved();
					System.out.println();
					System.out.println(p2.toString());
					System.out.println();
					g.displayPuzzle();
				}
				
				catch (InputMismatchException e)
				{
					 System.out.println(e);
					 break;
				}
				
			}
			
			if(cp == p3)
			{
				try {
					p3.setTurn();
					p3.selectTurn(g);
					System.out.println();
					
					if(p3.loseTurn)
					{
						cp = p1;
					}
					
					solved = p3.getisSolved();	
					System.out.println();
					System.out.println(p3.toString());
					System.out.println();
					g.displayPuzzle();
				}
				
				catch (InputMismatchException e)
				{
					 System.out.println(e);
					 break;
				}
				
			}
			
		
	}
		
		
			

		}

	}
