package fr.polytech.tictactoe.game;

import fr.polytech.tictactoe.game.boardgame.BoardGameHelper;
import fr.polytech.tictactoe.game.boardgame.Coordinate;
import fr.polytech.tictactoe.game.boardgame.GameResult;
import fr.polytech.tictactoe.game.boardgame.Mark;
import fr.polytech.tictactoe.game.boardgame.Players;
import fr.polytech.tictactoe.game.players.IPlayer;

/**
 * This class represents a TicTacToe.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class TicTacToe
{
	/**
	 * The number of lines.
	 */
	public static final int NB_LINES = 3;

	/**
	 * The number of columns.
	 */
	public static final int NB_COLUMNS = 3;

	/**
	 * The board game.
	 */
	private final Mark[][] boardGame;

	/**
	 * The all players.
	 */
	private final Players players;

	/**
	 * The game observer.
	 */
	private final ITicTacToeObserver observer;

	/**
	 * Create a TicTacToe.
	 * 
	 * @param players
	 *            The all players.
	 * @param observer
	 *            The game observer.
	 */
	public TicTacToe(Players players, ITicTacToeObserver observer)
	{
		this.boardGame = new Mark[NB_LINES][NB_COLUMNS];
		this.players = players;
		this.observer = observer;

		for (int x = 0; x < NB_LINES; x++)
		{
			for (int y = 0; y < NB_COLUMNS; y++)
			{
				this.boardGame[x][y] = Mark.EMPTY;
			}
		}
	}

	/**
	 * Mark a cell.
	 * 
	 * @param coordinate
	 *            The coordinate to mark.
	 */
	public void markCell(Coordinate coordinate)
	{
		final IPlayer currentPlayer = this.players.getCurrentPlayer();
		this.boardGame[coordinate.getX()][coordinate.getY()] = currentPlayer.getRepresentation();
		this.observer.notifyCellHasBeenMarked(coordinate, currentPlayer);

		final GameResult gameResult = getGameResult(currentPlayer);
		if (gameResult == GameResult.NOT_FINISHED)
		{
			this.players.updateNextPlayer();

			final Coordinate potentialNextCoordinate = this.players.getCurrentPlayer().getNextChoice(this.boardGame);
			if (potentialNextCoordinate != null)
			{
				markCell(potentialNextCoordinate);
			}
		}
		else
		{
			this.observer.notifyGameResult(gameResult, currentPlayer);
		}
	}

	/**
	 * Get the game result.
	 * 
	 * @param currentPlayer
	 *            The current player.
	 * 
	 * @return The game result.
	 */
	private GameResult getGameResult(IPlayer currentPlayer)
	{
		if (hasPlayerWon(currentPlayer))
		{
			return GameResult.PLAYER_WON;
		}

		if (allCellAreMarked())
		{
			return GameResult.NO_PLAYER_WON;
		}

		return GameResult.NOT_FINISHED;
	}

	/**
	 * Check if the player has won.
	 * 
	 * @param currentPlayer
	 *            The current player.
	 * @return True or False.
	 */
	private boolean hasPlayerWon(IPlayer currentPlayer)
	{
		return BoardGameHelper.hasWon(currentPlayer.getRepresentation(), this.boardGame);
	}

	/**
	 * Check if all cell are marked.
	 * 
	 * @return True or False.
	 */
	private boolean allCellAreMarked()
	{
		return BoardGameHelper.allCellAreMarked(this.boardGame);
	}
}