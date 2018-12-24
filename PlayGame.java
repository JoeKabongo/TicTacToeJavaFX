package game;

import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

// class that is responsible of playing the game
public class PlayGame {

	private Grid grid;
	private int wins, losses, ties;

	public 	PlayGame()
	{
		this.grid = new Grid();
		wins = 0;
		losses = 0;
		ties = 0;
	}
	
	public  void play()
	{
	
		//initialize board, compute player and rule engine and other variable needed to play the fa,e
		Board board = new Board();
		ComputerPlayer computer = new ComputerPlayer(board);
		int computerNum = 2;
		int playerNum = 1;

		ArrayList<Sector>sectors = grid.getSectors();

		for(Sector sec : sectors)
		{
			sec.clear();
		}
		for(Sector sec : sectors)
		{
			sec.setOnMouseClicked(new EventHandler<Event>()
	        {
				@Override
				public void handle(Event event) {
					
					// if the sectors has not been clicked yet
					if(!sec.wasClicked())
					{
						grid.set(sectors.indexOf(sec), 1);
						sec.setClicked();
						board.makeMove(playerNum, sec.getRow(), sec.getColumn());
						
						// check if there is still a place to play or if the player won before computer playing
						if(!board.wasAllMoveUsed() && !board.playerWon())
						{
							int [] moves = computer.generateMove();
							board.makeMove(computerNum, moves[0], moves[1]);
							int index = getIndex(moves[0], moves[1]);
							grid.set(index, 2);
							sec.setClicked();

						}
						
						// if no more move available or if anyone won
						if(board.wasAllMoveUsed() || board.playerWon())
						{
							//make all sectors unclickable
							for(Sector sec : sectors)
							{
								sec.setOnMouseClicked(null);
							}
							
							//check if there is a winner
							if(board.playerWon())
							{
								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								
								// if the person won(player1)
								if(board.getPlayer1Won())
								{
									alert.setHeaderText("You won!!");
									wins++;
								}
								
								
								else
								{
									alert.setHeaderText("You lost!!");
									losses++;
								}
								
								alert.getDialogPane();
								alert.showAndWait();
							}
									
							// in case of tie game, increment ties games 
							else 
							{
								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.setHeaderText("Tie game!!");
								alert.getDialogPane();
								alert.showAndWait();
								ties++;

							}
							
							//update score in the window
							grid.setScores(wins, losses, ties);
						}
						
					 }
	
					// if the sector was clicked, alert the user that it is a wrong move
					else
					{
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setHeaderText("Wrong move, try again!!");
						alert.getDialogPane();
						alert.showAndWait();
					}
					
				}
				
				// get index of a sector in the array list 
				public int getIndex(int row, int column)
				{
					ArrayList<Sector> sectors = grid.getSectors();
					for(int i = 0; i < 9; i++)
					{
						if(sectors.get(i).getRow() == row && sectors.get(i).getColumn() == column)
							return i;
						
					}
					
					return 0;
				}
						
	        });
		}
		
		
	}
	
	// get the grid
	public Grid getGrid()
	{
		return grid;
	}
	
	
}
			
			

