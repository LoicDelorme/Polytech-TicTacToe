package fr.polytech.tictactoe.game;

import fr.polytech.tictactoe.players.IPlayer;

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
		this.boardGame[coordinate.getX()][coordinate.getY()] = currentPlayer.getMarkRepresentation();
		this.observer.notifyCellHasBeenMarked(coordinate, currentPlayer);

		final GameResult gameResult = getGameResult(currentPlayer);
		if (gameResult != GameResult.NOT_FINISHED)
		{
			this.players.updateNextPlayer();
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
		return (hasPlayerWonOnARow(currentPlayer) || hasPlayerWonOnAColumn(currentPlayer) || hasPlayerWonOnADiagonal(currentPlayer));
	}

	/**
	 * Check if the player has won on a row.
	 * 
	 * @param currentPlayer
	 *            The current player.
	 * @return True or False.
	 */
	private boolean hasPlayerWonOnARow(IPlayer currentPlayer)
	{
		boolean hasWon = ((this.boardGame[0][0] == currentPlayer.getMarkRepresentation()) && (this.boardGame[0][1] == currentPlayer.getMarkRepresentation()) && (this.boardGame[0][2] == currentPlayer.getMarkRepresentation()));
		hasWon &= ((this.boardGame[1][0] == currentPlayer.getMarkRepresentation()) && (this.boardGame[1][1] == currentPlayer.getMarkRepresentation()) && (this.boardGame[1][2] == currentPlayer.getMarkRepresentation()));
		hasWon &= ((this.boardGame[2][0] == currentPlayer.getMarkRepresentation()) && (this.boardGame[2][1] == currentPlayer.getMarkRepresentation()) && (this.boardGame[2][2] == currentPlayer.getMarkRepresentation()));

		return hasWon;
	}

	/**
	 * Check if the player has won on a column.
	 * 
	 * @param currentPlayer
	 *            The current player.
	 * @return True or False.
	 */
	private boolean hasPlayerWonOnAColumn(IPlayer currentPlayer)
	{
		boolean hasWon = ((this.boardGame[0][0] == currentPlayer.getMarkRepresentation()) && (this.boardGame[1][0] == currentPlayer.getMarkRepresentation()) && (this.boardGame[2][0] == currentPlayer.getMarkRepresentation()));
		hasWon &= ((this.boardGame[0][1] == currentPlayer.getMarkRepresentation()) && (this.boardGame[1][1] == currentPlayer.getMarkRepresentation()) && (this.boardGame[2][1] == currentPlayer.getMarkRepresentation()));
		hasWon &= ((this.boardGame[0][2] == currentPlayer.getMarkRepresentation()) && (this.boardGame[1][2] == currentPlayer.getMarkRepresentation()) && (this.boardGame[2][2] == currentPlayer.getMarkRepresentation()));

		return hasWon;
	}

	/**
	 * Check if the player has won on a diagonal.
	 * 
	 * @param currentPlayer
	 *            The current player.
	 * @return True or False.
	 */
	private boolean hasPlayerWonOnADiagonal(IPlayer currentPlayer)
	{
		boolean hasWon = ((this.boardGame[0][0] == currentPlayer.getMarkRepresentation()) && (this.boardGame[1][1] == currentPlayer.getMarkRepresentation()) && (this.boardGame[2][2] == currentPlayer.getMarkRepresentation()));
		hasWon &= ((this.boardGame[0][2] == currentPlayer.getMarkRepresentation()) && (this.boardGame[1][1] == currentPlayer.getMarkRepresentation()) && (this.boardGame[2][0] == currentPlayer.getMarkRepresentation()));

		return hasWon;
	}

	/**
	 * Check if all cell are marked.
	 * 
	 * @return True or False.
	 */
	private boolean allCellAreMarked()
	{
		for (int x = 0; x < NB_LINES; x++)
		{
			for (int y = 0; y < NB_COLUMNS; y++)
			{
				if (this.boardGame[x][y] == Mark.EMPTY)
				{
					return false;
				}
			}
		}

		return true;
	}
}