package fr.polytech.tictactoe.players;

import fr.polytech.tictactoe.game.Coordinate;
import fr.polytech.tictactoe.game.Mark;

/**
 * This interface represents a player.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface IPlayer
{
	/**
	 * Get the name.
	 * 
	 * @return The name.
	 */
	public String getName();

	/**
	 * Get the mark representation.
	 * 
	 * @return The mark representation.
	 */
	public Mark getMarkRepresentation();

	/**
	 * Get the next choice.
	 * 
	 * @return The next choice.
	 */
	public Coordinate getNextChoice();
}