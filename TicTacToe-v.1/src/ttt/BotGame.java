package ttt;

import java.util.Scanner;

public class BotGame {
	public void botMode() {
		Board b= new Board();
		Scanner s = new Scanner(System.in);
		System.out.println("Please choose your marker. The game will start with player X");
		System.out.println("Type 1 for 'x' or 2 for 'o'");
		char human_marker ;
		char computer_marker;
		if(s.nextInt() == 1){
			human_marker = 'x' ;
			computer_marker= 'o';
		} 
		else
		{
			human_marker= 'o';
			computer_marker= 'x';
		}

		do
		{
			b.printBoard();
			Scanner sc = new Scanner(System.in);
			int row;
			int col;

			if(b.getcurrentMark() == human_marker) {
				do {
					System.out.println("Player " + b.getcurrentMark() + ": Select a location to make your move!");
					System.out.println("Row: ");
					row = sc.nextInt()-1;
					System.out.println("Column: ");
					col = sc.nextInt()-1;
				}while(!b.placeMark(row, col));
			}
			else {
				b.botTurn(human_marker,computer_marker);
			}
			b.changePlayer();

		}while(!b.checkForWin() && !b.isBoardFull());
		if (b.isBoardFull() && !b.checkForWin())
		{
			System.out.println("GAME ENDS WITH A DRAW!");
		}
		else
		{
			b.printBoard();
			b.changePlayer();
			System.out.println("PLAYER " + Character.toUpperCase(b.getcurrentMark()) + " Won!");
		}

	}	

}
