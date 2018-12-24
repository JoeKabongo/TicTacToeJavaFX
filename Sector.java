package game;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

// Sector class represent each square that makes up the board
public class Sector extends StackPane{

	private Rectangle rec;
	private Text fill;
	private int row;
	private int column;
	private boolean clicked = false;

	// stackpane that is composed of a rectangle and a text field
	public Sector(int row, int column)
	{
		super();
		rec = new Rectangle(50, 50, Color.BLACK);
		fill = new Text("");
		rec.setStroke(Color.AQUA);
		fill.setFill(Color.WHITE);
		super.getChildren().add(rec);
		super.getChildren().add(fill);
		this.row = row;
		this.column = column;

	}

	// check if the square was clicked
	public boolean wasClicked()
	{
		return fill.getText() != "";
	}

	//check set clicked to true when it is clicked
	public void setClicked()
	{
		clicked = true;
	}

	// return row
	public int getRow()
	{
		return row;
	}

	// return column
	public int getColumn()
	{
		return column;
	}

	public boolean getClicked()
	{
		return clicked;
	}

	//set text in sector
	public void setText(String text)
	{
		fill.setText(text);;
	}

	// clear sector
	public void clear()
	{
		fill.setText("");
		clicked = false;

	}
}
