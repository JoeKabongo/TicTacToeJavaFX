package game;

public class Board {
	
	// empty space on board is represented with int 0, symbol is space
	// 1 represent player number 1, symbol = "X"
	// 2 represent player number 2, symbole = "O"
	private int [][] boardGame = {{0,0,0}, {0,0,0}, {0,0,0}};
	private boolean player1Won = false;
	private boolean player2Won = false;
	private int validMoves = 9;

	
	// Constructor, when the Board is created, make all moves valids
	public Board()
	{
		//player1Won = false;
		//player2Won = false;
	}
	
	// return array representing the board
	public int [][] getBoard()
	{
		return boardGame;
	}
	
	
	//Make a moves, and remove it from valid move
	public void makeMove(int n , int row, int column)
	{
		validMoves --;
		boardGame[row][column] = n;
	}
	
	
	//check if all moves have been used by checking the length of valid move
	public boolean wasAllMoveUsed()
	{
		return validMoves == 0;
	}
	
	//check if a player won
	public boolean playerWon()
	{
		for(int i = 0; i < 3; i++)
		{
			if(boardGame[i][0] != 0)
			{
				if(boardGame[i][0] == boardGame[i][1] && boardGame[i][2] == boardGame[i][1])
				{
					//Player 1 or 2 won
					if(boardGame[i][0] == 1)
					{
						player1Won = true;
					}
					else
					{
						player2Won = true;
					}
					return true;
				}
				
			}
			
			if(boardGame[0][i] != 0)
			{
				if(boardGame[0][i] == boardGame[1][i] && boardGame[2][i] == boardGame[1][i])
				{

					//Player 1 or 2 won
					if(boardGame[0][i] == 1)
					{
						player1Won = true;
					}
					else
					{
						player2Won = true;
					}
						
					return true;
					
				}
			}
		}
		
		if(boardGame[1][1] != 0)
		{
			if(boardGame[0][0] == boardGame[1][1] && boardGame[1][1] == boardGame[2][2]) 
			{

				//check if Player 1 or 2 won
				if(boardGame[0][0] == 1)
				{
					player1Won = true;

				}
				else
				{
					player2Won = true;	
				}
					
				return true;
			}
			if(boardGame[2][0] == boardGame[1][1] && boardGame[1][1] == boardGame[0][2])
			{

				//check if Player 1 or 2 won
				if(boardGame[2][0] == 1)
				{
					player1Won = true;

				}
				else
				{
					player2Won = true;
				}
				return true;
			}
		}
		
		return false;

	}
	
	// return true if player 1 won
	public boolean getPlayer1Won()
	{
		return player1Won;
	}
	
	// return true if player 2 won
	public boolean getPlayer2Won()
	{
		return player2Won;
	}
	
}