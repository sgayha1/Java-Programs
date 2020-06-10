//Program created by Skylar Gayhart Spring 2019, Senior Year of High School
//Updated June 2020

//Imitation of The Wheel of Fortune Game Show

//Player class which controls all actions of the player like changing turns, selecting what they wnat to do, and guessing

import java.util.*;
import java.lang.*;

public class Player {
	
	private String player, guess;
	private int[] points = {1032, 220, 0, 430, 650, 0, 4650, 40, 540, 1};
	private int point, choice, score, count;
	private char letter;
	public boolean isSolved, loseTurn, vowel_True = false;
	
	
	Scanner scan = new Scanner (System.in);
	
	public Player(String p)
	{
		player = p;
		score = 0;
		count = 0;
		guess = " ";
		isSolved = false;
		loseTurn = false;
	}
	
	public void selectTurn(Game g)
	{
		System.out.println();
		System.out.println("0 - Solve the puzzle");
		System.out.println("1 - Spin the wheel");
		System.out.println("2 - Buy a vowel");
		System.out.println("\nWhat would you like to do " + player);
		choice = scan.nextInt();
		scan.nextLine();
		turn(g);
	}
	
	
	public void turn(Game g)
	{
		switch(choice)
		{
		case 0: 
			solve(g);
			break;
		case 1:
		{
			boolean x = spinWheel();
			if(x)
				{
					break;
				}
			guessLetter(g);
			updateScore(g);
			break;
		}
		case 2:
		{
			buyVowel(letter, g);
			spinWheel();
			guessLetter(g);
			updateScore(g);
			break;
		}
		default:
			System.out.println("Please choice from menu");
		}
	}
		
	public boolean spinWheel()
	{
		point = points[(int)(Math.random() * 10)];
		System.out.println("You spun " + point);
		
		if(point == 0) 
		{
			loseTurn = true;
			score = 0;
			System.out.println("Bankrupt! Turn over");
		}
		
		return loseTurn;
	}
	
	public void guessLetter(Game g)
	{
		char l;
		System.out.println("What is your guess " + player);
		guess = scan.next();
		l = guess.charAt(0);
		char vowel = Character.toUpperCase(l);
		
		while(vowel == 'A' || vowel == 'I' || vowel == 'O' || vowel == 'E' || vowel == 'U')
		{
			if(vowel_True)
				break;
			System.out.println("Pick another letter that is not a vowel! (You need to pick a vowel by selecting 2 when the menu appear)");
			guess = scan.next();
			l = guess.charAt(0);
			vowel = Character.toUpperCase(l);
		}
		loseTurn = g.checkPuzzle(l);
		System.out.println();
		
		System.out.print("Used Letter Board: ");
		g.usedLetters(l);
		
	}
	
	public void solve(Game g)
	{
		System.out.println("What is your guess?");
		guess = scan.nextLine();
		isSolved = g.checkSolve(guess, player);
		loseTurn = g.getloseTurn();
	}
	
	public void buyVowel(char letter, Game g)
	{
		if(score < 200) 
		{
			System.out.println("Not enough money");
			loseTurn = true;
		}
		
		if(score > 200) 
		{
			vowel_True = true;
			score -= 200;
		}
	}
	
	public void updateScore(Game g)
	{
			System.out.println(score);
			int total = (point * g.getCount());
			System.out.println(score);
			score += total;
			System.out.println(score);
	}
	
	public boolean getisSolved()
	{
		return isSolved;
	}
	
	public boolean getloseTurn()
	{
		return loseTurn;
	}
	
	public void setTurn()
	{
		loseTurn = false;
	}
	
	public String toString()
	{
		return(player + ": \t" + score);
	}
	
	
	
}
