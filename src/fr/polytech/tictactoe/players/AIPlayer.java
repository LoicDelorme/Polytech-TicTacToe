package fr.polytech.tictactoe.players;

import fr.polytech.tictactoe.game.Coordinate;
import fr.polytech.tictactoe.game.Mark;

/**
 * This class represents an artificial intelligence player.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class AIPlayer extends Player
{
	/**
	 * Create an artificial intelligence player.
	 * 
	 * @param name
	 *            The name.
	 * @param representation
	 *            The representation.
	 */
	public AIPlayer(String name, Mark representation)
	{
		super(name, representation);
	}

	/**
	 * @see fr.polytech.tictactoe.players.IPlayer#getNextChoice()
	 */
	@Override
	public Coordinate getNextChoice()
	{
		// TODO ADD ALGORITHM HERE.
		return null;
	}
}