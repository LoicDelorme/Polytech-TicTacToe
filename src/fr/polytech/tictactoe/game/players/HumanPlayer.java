package fr.polytech.tictactoe.game.players;

import fr.polytech.tictactoe.game.boardgame.Coordinate;
import fr.polytech.tictactoe.game.boardgame.Mark;

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
	 * @see fr.polytech.tictactoe.game.players.IPlayer#getNextChoice(fr.polytech.tictactoe.game.boardgame.Mark[][])
	 */
	@Override
	public Coordinate getNextChoice(Mark[][] boardGame)
	{
		return null;
	}
}