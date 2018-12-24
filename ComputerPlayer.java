package game;

public class ComputerPlayer
{
   private int[][] preferredMoves = {
         {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
         {0, 1}, {1, 0}, {1, 2}, {2, 1}};

   private Board board;
   private int symbol;
   //----- YOUR CODE GOES HERE:
   // ADDED INSTANCE VARIABLE THAT STORES THE GAME SYMBOL ASSIGNED TO THE COMPUTER PLAYER

   /** Constructor with reference to game board */
   public ComputerPlayer(Board board) 
   {
      this.board = board;
   }
 
 	//----- YOUR CODE GOES HERE:
 	// ADD A SETTTER METHOD FOR THE INSTANCE VARIABLE THAT 
    // STORES THE GAME SYMBOL ASSIGNED TO THE COMPUTER PLAYER
   public void setSymbol(int symbol)
   {
	   this.symbol = symbol; 
   }
   
   /** Search for the first empty cell, according to the preferences
    *  @return int array of two values [row, col]
    */
   public int[] generateMove() 
   {
   		 for (int[] move : preferredMoves) 
   		 {
   		 	 // checks for empty space on board 
   		 	 // (i.e. checks if this "move" is available, if the space is empty its available)
	         if (this.board.getBoard()[move[0]][move[1]] == 0) 
	         {
	            return move;
	         }
         }

         return null;
   }
   
   public int getSymbol()
   {
	   return symbol;
   }
}