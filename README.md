# TicTacToe

Welcome to TicTacToe game!!

Game has an option to run in 2 separate modes:
1. Human v/s Human
2. Human v/s Computer

Player receives a choice on first screen to select the game mode. On selecting any of the mode, game first initializes the board of 3X3 matrix with blank values.

If Human vs Human mode is selected:
1. Player X always make the first move.
2. Player X is asked to choose the location on the board for his move.
3. Then player O gets to choose the location for his move.
4. On each move, game performs a check to see if selected location is within the board range and empty. if not, player is asked to choose the correct location.
5. Player who succeeds in filling 3 adjacent locations with his mark either horizontally, vertically or diagonally wins the game.
6. If none of the player could fill 3 adjacent locations with his mark either horizontally, vertically or diagonally, game is declared as a tie.


Human vs Computer:
1. Player is asked to choose his mark (Either X or O). Player X always make the first move.
2. If Player selects X, he is asked to choose the location on the board for his move. If player selects O, computer makes the first move.
3. On each move of the player, game performs a check to see if selected location is within the board range and empty. if not, player is asked to choose the correct location.
4. Bot chooses its location for the move based on below condition in that order:
    1. Winning condition - Bot checks if there are any 2 locations in straight line already filled with its mark either horizontally, vertically or diagonally and third location          in same line is blank. If yes, Bot fills the third  location with its mark. If not, Bot checks for 2nd condition.
    2. Blocking condition - Bot checks if there are any 2 locations in straight line  already filled with human player mark either horizontally, vertically or diagonally and third        location in same line is blank. If yes, Bot fills the third adjacent location with its mark. If not, Bot checks for 3rd condition.
    3. Random condition - Bot checks any blank location and fill it with its mark.
5. Either human player or bot who succeeds in filling 3 adjacent locations with his mark either horizontally, vertically or diagonally wins the game.
6. If neither human player not Bot could fill 3 adjacent locations with his mark either horizontally, vertically or diagonally, game is declared as a tie.


Hope you enjoy the game !!! :)
