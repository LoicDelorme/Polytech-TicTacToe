package fr.polytech.tictactoe.view;

import java.util.HashMap;
import java.util.Map;

import fr.polytech.tictactoe.game.Coordinate;
import fr.polytech.tictactoe.game.GameResult;
import fr.polytech.tictactoe.game.ITicTacToeObserver;
import fr.polytech.tictactoe.game.Players;
import fr.polytech.tictactoe.game.TicTacToe;
import fr.polytech.tictactoe.game.players.IPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * This class represents the JavaFX view controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class JavaFXTicTacToeViewController implements ITicTacToeObserver, EventHandler<ActionEvent>
{
	/**
	 * The game result label.
	 */
	@FXML
	private Label gameResult;

	/**
	 * The player one label.
	 */
	@FXML
	private Label playerOne;

	/**
	 * The player two label.
	 */
	@FXML
	private Label playerTwo;

	/**
	 * The grid pane.
	 */
	@FXML
	private GridPane gridPane;

	/**
	 * The cells by coordinate.
	 */
	private Map<Coordinate, Button> cellsByCoordinate;

	/**
	 * The cells by buttons.
	 */
	private Map<Button, Coordinate> cellsByButtons;

	/**
	 * The TicTacToe.
	 */
	private TicTacToe ticTacToe;

	/**
	 * Initialize the content.
	 * 
	 * @param players
	 *            The players.
	 */
	public void initializeContent(IPlayer... players)
	{
		this.ticTacToe = new TicTacToe(new Players(players), this);

		this.gameResult.setText("Game in progress!");
		this.playerOne.setText(players[0].getName() + " : " + players[0].getRepresentation().toString());
		this.playerTwo.setText(players[1].getName() + " : " + players[1].getRepresentation().toString());

		this.cellsByCoordinate = new HashMap<Coordinate, Button>();
		this.cellsByButtons = new HashMap<Button, Coordinate>();

		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				final Coordinate coordinate = new Coordinate(x, y);
				final Button cell = new Button();
				cell.setOnAction(this);
				cell.setPrefSize(128, 128);

				this.cellsByCoordinate.put(coordinate, cell);
				this.cellsByButtons.put(cell, coordinate);
				this.gridPane.add(cell, y, x);
				GridPane.setValignment(cell, VPos.CENTER);
				GridPane.setHalignment(cell, HPos.CENTER);
			}
		}
	}

	/**
	 * @see fr.polytech.tictactoe.game.ITicTacToeObserver#notifyCellHasBeenMarked(fr.polytech.tictactoe.game.Coordinate, fr.polytech.tictactoe.game.players.IPlayer)
	 */
	@Override
	public void notifyCellHasBeenMarked(Coordinate coordinate, IPlayer currentPlayer)
	{
		final Button selectedCell = this.cellsByCoordinate.get(coordinate);
		final Image representation = new Image(this.getClass().getResourceAsStream(currentPlayer.getRepresentation().getImagePath()));

		selectedCell.setGraphic(new ImageView(representation));
		selectedCell.setDisable(true);
	}

	/**
	 * @see fr.polytech.tictactoe.game.ITicTacToeObserver#notifyGameResult(fr.polytech.tictactoe.game.GameResult, fr.polytech.tictactoe.game.players.IPlayer)
	 */
	@Override
	public void notifyGameResult(GameResult gameResult, IPlayer currentPlayer)
	{
		if (gameResult == GameResult.NO_PLAYER_WON)
		{
			this.gameResult.setText("No player won...");
		}
		else
		{
			this.gameResult.setText(currentPlayer.getName() + " won!");
		}
	}

	/**
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		this.ticTacToe.markCell(this.cellsByButtons.get(event.getSource()));
	}
}