package fr.polytech.tictactoe.game;

import fr.polytech.tictactoe.game.players.IPlayer;

/**
 * This interface represents a game observer.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface ITicTacToeObserver
{
	/**
	 * Notify cell has been marked.
	 * 
	 * @param coordinate
	 *            The coordinate which was marked.
	 * @param currentPlayer
	 *            The player which has marked the board game.
	 */
	public void notifyCellHasBeenMarked(Coordinate coordinate, IPlayer currentPlayer);

	/**
	 * Notify the game result.
	 * 
	 * @param gameResult
	 *            The game result.
	 * @param currentPlayer
	 *            The current player.
	 */
	public void notifyGameResult(GameResult gameResult, IPlayer currentPlayer);
}