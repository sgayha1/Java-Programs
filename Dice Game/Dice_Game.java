import java.util.*;

public class Dice_Game {

	public static void main(String[] args) {
		
		//Instatiations
		
		Scanner scan = new Scanner (System.in); 
		
		int dice1 = 0, dice2 = 0, di = 0, total = 0, di2 = 0, total2 = 0;
		boolean oneturn = true, twoturn = false;
		String player1, player2;
		
		//Welcome Message
		System.out.println(" =============================");
		System.out.println(" | Welcome to the Dice Game! |");
		System.out.println(" =============================\n");
		
		System.out.println("This program simulates a game between two players. Each player rolls the di until one's total is greater than 100.");
		
		//Get the players' names 
		
		System.out.println("\n\nPlayer 1 Name: ");
		player1 = scan.next();
		
		System.out.println("Player 2 Name: ");
		player2 = scan.next();
		
		//Runs until either player 1 wins or player 2
		
		while (total < 100 && total2 < 100)
		{
			while (oneturn == true) // Each round runs until a player gets snake eyes or box
			{
				//Generate a number 1-6 for each dice then add them
				dice1 = (int)(Math.random() * 6) + 1;
				dice2 = (int)(Math.random() * 6) + 1;
				di = dice1 + dice2;
				
				//If they roll 1 and 1, score goes to 0
				if (di == 2)
					{
						System.out.println("You rolled snake eyes. Player 2's turn and your score is now 0");
						total = 0;
						oneturn = false;
						twoturn = true;
					}
				
				//Lose turn is roll a 12 all together
				else if (di == 12)
					{
						System.out.println("You rolled box. Player 2's turn.");
						oneturn = false;
						twoturn = true;
					}
				
				//Adds the di's value to total
				else 
					{
						total += di;
						System.out.println(player1 + " rolled " + di + " and has a total of " + total);
						oneturn = false;
						twoturn = true;
					}
				
				
				System.out.println("------------------------------------------------------------------------------------");								
				
			}	
			
			//Checks if the total is over 100 and breaks out if that is true
			if(total > 100)
			{
				break;
			}
			 
			//Same as before, but for the second player
			
			while (twoturn == true)
			{
				dice1 = (int)(Math.random() * 6) + 1;
				dice2 = (int)(Math.random() * 6) + 1;
				di2 = dice1 + dice2;
				
				if (di2 == 2)
					{
						System.out.println("You rolled snake eyes. Player 1's turn and your score is now 0");
						twoturn = false;
						oneturn = true;
						total2 = 0;
					}	
					
				else if (di2 == 12)
					{
						System.out.println("You rolled box. Player 1's turn.");
						oneturn = true;
						twoturn = false;
					}
				
				else 
					{
						total2 += di2;		
						System.out.println(player2 + " rolled " + di2 + " and has a total of " + total2);
						twoturn = false;
						oneturn = true;
					}
				
				System.out.println("------------------------------------------------------------------------------------");				
				
			}
			
			if(total2 > 100)
			{
				break;
			}
		}
		
			//Decides who is the winner then prints it
			if (total >= 100)
				System.out.println("\nThe winner is " + player1 + "!\n");
			else
				System.out.println("\nThe winner is " + player2 + "!\n");
			
			//Prints the scores earned by both
			
			System.out.println(player1 + "'s score: " + total);
			System.out.println(player2 + "'s score: " + total2);
			
			System.out.println("\n==============");
			System.out.println("| Game over! |");
			System.out.println("==============");

		
	}

} 
