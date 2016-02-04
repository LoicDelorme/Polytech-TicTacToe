package fr.polytech.tictactoe.players;

import fr.polytech.tictactoe.game.Coordinate;
import fr.polytech.tictactoe.game.Mark;

/**
 * This class represents a human player.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class HumanPlayer extends Player
{
	/**
	 * Create a human player.
	 * 
	 * @param name
	 *            The name.
	 * @param representation
	 *            The representation.
	 */
	public HumanPlayer(String name, Mark representation)
	{
		super(name, representation);
	}

	/**
	 * @see fr.polytech.tictactoe.players.IPlayer#getNextChoice()
	 */
	@Override
	public Coordinate getNextChoice()
	{
		return null;
	}
}