package fr.polytech.tictactoe.game.players;

import fr.polytech.tictactoe.game.boardgame.Mark;

/**
 * This class represents a player.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class Player implements IPlayer
{
	/**
	 * The name.
	 */
	private final String name;

	/**
	 * The representation.
	 */
	private final Mark representation;

	/**
	 * Create a player.
	 * 
	 * @param name
	 *            The name.
	 * @param representation
	 *            The representation.
	 */
	public Player(String name, Mark representation)
	{
		this.name = name;
		this.representation = representation;
	}

	/**
	 * @see fr.polytech.tictactoe.game.players.IPlayer#getName()
	 */
	@Override
	public String getName()
	{
		return this.name;
	}

	/**
	 * @see fr.polytech.tictactoe.game.players.IPlayer#getRepresentation()
	 */
	@Override
	public Mark getRepresentation()
	{
		return this.representation;
	}
}