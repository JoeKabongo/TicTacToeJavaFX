package game;


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Driver extends Application{

	private PlayGame game = new PlayGame();


	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage primaryStage)
	{

	    BorderPane pane = new BorderPane();

	    // hbox to contains buttons
		HBox buttons = new HBox(4);
		Button restart = new Button("Restart");
		Button end = new Button("End Game");
		buttons.getChildren().add(restart);
		buttons.getChildren().add(end);

		// add buttons to the main pane
		buttons.setAlignment(Pos.BASELINE_CENTER);
		pane.setBottom(buttons);

		// End the game by closing the window
		end.setOnMouseClicked(new EventHandler<Event>()
        {

			@Override
			public void handle(Event event) {
				primaryStage.close();

			}

        });

		//game symbols
		VBox symbols = new VBox(4);
		Text player = new Text("  You:  X     ");
		Text computer = new Text("The computer: O  ");
		symbols.setAlignment(Pos.BASELINE_RIGHT);
		symbols.getChildren().add(player);
		symbols.getChildren().add(computer);
		pane.setRight(symbols);


		//tell user how to play
		VBox inst = new VBox(4);
		Text instructions = new Text("Click the spot you want to play");
		Text c  = new Text("The computer will play automatically after you");
		inst.setAlignment(Pos.BASELINE_CENTER);
		inst.getChildren().add(instructions);
		inst.getChildren().add(c);
		pane.setTop(inst);


		// Display score
		VBox score = new VBox(4);
		score.setAlignment(Pos.BASELINE_LEFT);
		score.getChildren().add(game.getGrid().getWins());
		score.getChildren().add(game.getGrid().getLosses());
		score.getChildren().add(game.getGrid().getTies());

		pane.setLeft(score);



		// set the scene and the color of the scene
		Scene scene = new Scene(pane, 500, 500);
		scene.setFill(Color.ANTIQUEWHITE);

		// add the grid in the pane and start game
		game.getGrid().setAlignment(Pos.CENTER);
		pane.setCenter(game.getGrid());
		game.play();


		//Restart game every time the restart button is clicked
		restart.setOnMouseClicked(new EventHandler<Event>()
        {
			@Override
			public void handle(Event event) {
				game.getGrid().setAlignment(Pos.CENTER);
				pane.setCenter(game.getGrid());
				game.play();
			}
        });


		primaryStage.setTitle("Tic Tac toe Game");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
