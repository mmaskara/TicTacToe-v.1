package ttt;
import java.util.Scanner;

public class Board {

	public char[][] board;
	private char currentMark;
	int Grid;

	public Board() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the board: ");
		Grid = sc.nextInt();
		board = new char[Grid][Grid];
		currentMark = 'x';
		createBoard();
	}

	// This is to create new board with blank values in each field.

	public void createBoard() {
		for (int i = 0; i < Grid; i++) {
			for (int j = 0; j < Grid; j++) {
				board[i][j] = ' ';
			}
		}
	}


	// This is to print the board layout after each move.
	public void printBoard() {
		int i, j;
		for (i = 0; i < Grid; i++) {
			System.out.println();
			for (j = 0; j < Grid; j++) {
				if (j < Grid - 1) {
					System.out.print(board[i][j] + "|");
				} else {
					System.out.print(board[i][j]);
				}
			}
			System.out.println();
			if (i < Grid - 1) {
				for (j = 0; j < Grid; j++) {
					if (j < Grid - 1) {
						System.out.print("-+");
					} else {
						System.out.print("-");
					}
				}
			}
		}
		System.out.println("Board Created.");
	}

	// This gives the currentMark of the game.
	public char getcurrentMark() {
		return currentMark;
	}

	// This is to place a mark at the cell specified by row and col with the mark of
	// the current player.
	public boolean placeMark(int row, int col) {

		// Make sure that row and column are in bounds of the board.
		if ((row >= 0) && (row < Grid)) {
			if ((col >= 0) && (col < Grid)) {
				if (board[row][col] == ' ') {
					board[row][col] = currentMark;
					return true;
				}
			}
		}
		return false;
	}

	// Change player marks back and forth.
	public void changePlayer() {
		if (currentMark == 'x') {
			currentMark = 'o';
		} else {
			currentMark = 'x';
		}
	}

	public boolean isBoardFull() {
		boolean isFull = true;

		for (int i = 0; i < Grid; i++) {
			for (int j = 0; j < Grid; j++) {
				if (board[i][j] == ' ') {
					isFull = false;
				}
			}
		}

		return isFull;
	}

	// Returns true if there is a win, false otherwise.
	// This calls our other win check functions to check the entire board.
	public boolean checkForWin() {
		return (checkIfVerticalWin() || checkIfHorizontalWin() || checkIfDiagWin() || checkIfoppDiagWin());
			}

	public boolean checkIfVerticalWin() {
	boolean outerwin = false;
	int i=0;
	while(i<Grid && outerwin==false)
		{
			int j=0;
			boolean innerwin = true;
			while(j<(Grid-1) && innerwin == true){
					if (board[j][i] != ' '){
						if (board[j][i] != board[j+1][i])
						{
						innerwin=false;
						}
					}
					else {
					innerwin=false;
					}
					j++;
				}
			if (innerwin==true)
				{
					outerwin=true;}
			i++;
		}
	return outerwin;
	}

	public boolean checkIfHorizontalWin()
	{
	boolean outerwin = false;
	int i=0;
	while(i<Grid && outerwin==false)
		{
			int j=0;
			boolean innerwin = true;
			while(j<(Grid-1) && innerwin == true){
					if (board[i][j] != ' '){
						if (board[i][j] != board[i][j+1])
						{
						innerwin=false;
						}
					}
					else {
					innerwin=false;
					}
					j++;
				}
			if (innerwin==true)
				{
					outerwin=true;}
			i++;
		}
	return outerwin;
	}


	public boolean checkIfDiagWin() {
	boolean isdiagwin = true;
	for (int i=0;i<Grid-1;i++)
		{
			if (board[i][i]==' ' || board[i][i] != board[i+1][i+1])
				{
					isdiagwin = false;
				}
	    }
	return isdiagwin;
	}


	public boolean checkIfoppDiagWin()
	{
	boolean isoppdiagwin = true;
	for (int i=0;i<Grid-1;i++)
		{
			int j = Grid-1-i;
			if (board[i][j]==' ' || board[i][j] != board[i+1][j-1])
				{
					isoppdiagwin = false;
				}
	    }
	return isoppdiagwin;
	}
	
	
	
//--------------------------------------------------------------------------------------------	

public void botTurn(char humanmarker, char botmarker) {
	
		boolean win = botMove(botmarker, botmarker); //win
		
		if (win == false)
		{
		boolean block = botMove(humanmarker, botmarker);//block
		
			if (block==false){
			randomMove(botmarker);
		}
	}
}	
	
	// Bot mode :
	public boolean botMove(char marktocompare, char marktoplace) {
	
		boolean mademove = false;
		
		//check if Bot can take a vertical win
		if(mademove == false) {
		for (int i = 0; i < Grid; i++) {
			for (int j = 0; j < Grid; j++) {
				if (board[j][i] == ' ') {
					if (checkVertical(i, j, Grid, marktocompare) == true) {
						board[j][i] = marktoplace;
						mademove = true;
					}
				}
			}
		}
		}

		//check if Bot can take a horizontal win
		if(mademove == false) {
		for (int i = 0; i < Grid; i++) {
			for (int j = 0; j < Grid; j++) {
				if (board[i][j] == ' ') {
					if (checkHorizontal(i, j, Grid, marktocompare) == true) {
						board[i][j] = marktoplace;
						mademove = true;
					}
				}
			}
		}
	}	
		//check if Bot can take a Diagonal Win -1
		
		if(mademove == false) {
		for (int i = 0; i < Grid; i++) {
			for (int j = 0; j < Grid; j++) {
				if (board[i][j] == ' ' && i == j) {
					if (checkDiagonal(i, j, Grid, marktocompare) == true) {
						board[i][j] = marktoplace;
						mademove = true;
					}
				}
			}
		}
		}
		//check if Bot can take a Diagonal Win - 2
		
		if(mademove == false) {
		for (int i = 0; i < Grid; i++) {
			for (int j = 0; j < Grid; j++) {
				if (board[j][i] == ' ' && (i + j) == (Grid - 1)) {
					if (checkOppDiagonal(i, j, Grid, marktocompare) == true) {
						board[j][i] = marktoplace;
						mademove = true;
					}
				}
			}
		}
		}
		return mademove;
	}
	
	public void randomMove(char marktoplace) {
		
	int rand1 = 0;
	int rand2 = 0;
	boolean randommovemade = false;
	while (!randommovemade) {

		rand1 = (int) (Math.random() * Grid);
		rand2 = (int) (Math.random() * Grid);

		if (board[rand1][rand2] != 'x' && board[rand1][rand2] != 'o') {
			//System.out.println("random move");
			board[rand1][rand2] = marktoplace;
			randommovemade = true;

		}

	}
	}

	public boolean checkVertical(int i, int j, int Grid, char mark) {
		
		int x = 0;
		boolean isequal = true;
		while (x < (Grid - 1) && isequal == true) {
			if (x != j) { 
				if (board[x][i] == mark) {
					if (x == (j - 1)) {
						if (j < (Grid - 1)) {
							if (board[x][i] != board[x + 2][i]) {
								isequal = false;
							}
						}
					} else {

						if (board[x][i] != board[x + 1][i]) {
							isequal = false;
						}
					}
				} else {
					isequal = false;
				}
			}
			x++;
		}
		return isequal;
	}

	public boolean checkHorizontal(int i, int j, int Grid, char mark) {
		
		int x = 0;
		boolean isequal = true;
		while (x < (Grid - 1) && isequal == true) {
			if (x != j) { 
				if (board[i][x] == mark) {
					if (x == (j - 1)) {
						if (j < (Grid - 1)) {
							if (board[i][x] != board[i][x + 2]) {
								isequal = false;
							}
						}
					} else {

						if (board[i][x] != board[i][x + 1]) {
							isequal = false;
						}

					}

				} else {
					isequal = false;
				}
			}
			x++;
		}
		return isequal;
	}

	public boolean checkDiagonal(int i, int j, int Grid, char mark) {

		int x = 0;
		boolean isequal = true;
		while (x < (Grid - 1) && isequal == true) {
			if (x != j) { 
				if (board[x][x] == mark) {
					if (x == (j - 1)) {
						if (j < (Grid - 1)) {
							if (board[x][x] != board[x + 2][x + 2]) {
								isequal = false;
							}
						}
					} else {
						if (board[x][x] != board[x + 1][x + 1]) {
							isequal = false;
						}
					}
				} else {
					isequal = false;
				}
			}
			x++;
		}
		return isequal;
	}

	public boolean checkOppDiagonal(int i, int j, int Grid, char mark) {

		int x = 0;
		boolean isequal = true;
		while (x < (Grid - 1) && isequal == true) {
			int y = Grid - 1 - x;
			if (x != j) { 
				if (board[x][y] == mark) {
					if (x == (j - 1)) {
						if (j < (Grid - 1)) {
							if (board[x][y] != board[x + 2][y - 2]) {
								isequal = false;
							}
						}
					} else {
						if (board[x][y] != board[x + 1][y - 1]) {
							isequal = false;
						}
					}
				}
				else {
					isequal = false;
				}
			}
			x++;
		}
		return isequal;
	}

}
