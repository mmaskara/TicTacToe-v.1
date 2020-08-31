package ttt;

import java.util.Scanner;

public class HumanGame {
	
	public void humanMode() {
		Board b= new Board();
		System.out.println("Game Board Creation...");
		System.out.println("The game will start with player X");

		do
		{
			b.printBoard();
			Scanner sc = new Scanner(System.in);
			int row;
			int col;
			do
			{
				System.out.println("Player " + b.getcurrentMark() + ": Select a location to make your move!");
				System.out.println("Row: ");
				row = sc.nextInt()-1;
				System.out.println("Column: ");
				col = sc.nextInt()-1;
			}
			while (!b.placeMark(row, col));
			b.changePlayer();
		}
		while(!b.checkForWin() && !b.isBoardFull()); 
		if (b.isBoardFull() && !b.checkForWin())
		{
			System.out.println("GAME ENDS WITH A DRAW!");
		}
		else
		{
			b.printBoard();
			b.changePlayer();
			System.out.println("PLAYER " + Character.toUpperCase(b.getcurrentMark()) + " WON!");
		}
	}

}
