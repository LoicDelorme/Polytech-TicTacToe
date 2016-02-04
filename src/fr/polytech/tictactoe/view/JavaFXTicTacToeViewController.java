package fr.polytech.tictactoe.view;

import fr.polytech.tictactoe.game.Coordinate;
import fr.polytech.tictactoe.game.GameResult;
import fr.polytech.tictactoe.game.ITicTacToeObserver;
import fr.polytech.tictactoe.game.Players;
import fr.polytech.tictactoe.game.TicTacToe;
import fr.polytech.tictactoe.players.IPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * This class represents the JavaFX view controller.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class JavaFXTicTacToeViewController implements ITicTacToeObserver
{
	@FXML
	/**
	 * The buttons.
	 */
	private final Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonHeight, buttonNine;

	@FXML
	/**
	 * The labels.
	 */
	private final Label gameResult, playerOne, playerTwo;

	/**
	 * The TicTacToe.
	 */
	private TicTacToe ticTacToe;

	/**
	 * Create a JavaFX TicTacToe controller.
	 */
	public JavaFXTicTacToeViewController()
	{
		this.buttonOne = new Button();
		this.buttonTwo = new Button();
		this.buttonThree = new Button();
		this.buttonFour = new Button();
		this.buttonFive = new Button();
		this.buttonSix = new Button();
		this.buttonSeven = new Button();
		this.buttonHeight = new Button();
		this.buttonNine = new Button();
		this.gameResult = new Label();
		this.playerOne = new Label();
		this.playerTwo = new Label();
	}

	/**
	 * Initialize the content.
	 * 
	 * @param players
	 *            The players.
	 */
	public void initializeContent(IPlayer... players)
	{
		this.ticTacToe = new TicTacToe(new Players(players), this);
		this.playerOne.setText(players[0].getName() + " : " + players[0].getMarkRepresentation().toString());
		this.playerTwo.setText(players[1].getName() + " : " + players[1].getMarkRepresentation().toString());
	}

	/**
	 * @see fr.polytech.tictactoe.game.ITicTacToeObserver#notifyCellHasBeenMarked(fr.polytech.tictactoe.game.Coordinate, fr.polytech.tictactoe.players.IPlayer)
	 */
	@Override
	public void notifyCellHasBeenMarked(Coordinate coordinate, IPlayer currentPlayer)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * @see fr.polytech.tictactoe.game.ITicTacToeObserver#notifyGameResult(fr.polytech.tictactoe.game.GameResult, fr.polytech.tictactoe.players.IPlayer)
	 */
	@Override
	public void notifyGameResult(GameResult gameResult, IPlayer currentPlayer)
	{
		// TODO Auto-generated method stub

	}
}