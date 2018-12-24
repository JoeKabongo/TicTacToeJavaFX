package game;
import java.util.ArrayList;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/*This class represent the 3 by 3 board that will be used to play the game 
 * also create text field that will store the score*/


public class Grid extends GridPane{
	
	private ArrayList<Sector>  sectors;
	private Text wins, losses, ties;
	
	public Grid()
	{
		super();
		
		sectors = new ArrayList<Sector>();
		
		// add 9 centers in the lists
		for(int row = 0; row < 3; row++)
		{
			for(int column = 0; column < 3; column++)
			{
				
				sectors.add(new Sector(column, row));
			}
		} 
		
		
		//create a grid of sectors
		for(Sector sec : sectors)
		{
			super.add(sec, sec.getColumn(), sec.getRow());
		}
		
		losses = new Text("Game Lost: 0" );
	    wins = new Text("Game won: 0" );
		ties = new Text("Time games: 0");
		
		
	}
	
	
	// set change the contents of a sector, 'X' when its the player move, 'O' if it is the computer move
	public void set(int index, int playerNum)
	{
		if (playerNum == 1)
			sectors.get(index).setText("X");
		if(playerNum == 2)
			sectors.get(index).setText("O");
	
	}
	

	// get array list of the sectors
	public ArrayList<Sector> getSectors()
	{
		return sectors;
	}
	
	// reset text(scores)
	public void setScores(int wins, int losses, int ties)
	{
		this.wins.setText("Game won: " + wins );
	    this.losses.setText("Game lost: " + losses );
		this.ties.setText("Time games: " + ties);
	}
	
	// get number of wins
	public Text getWins()
	{
		return wins;
	}
	
	// get number of losses
	public Text getLosses()
	{
		return losses;
	}
	
	// get number of ties games
	public Text getTies()
	{
		return ties;
	}
	
	
	
}
