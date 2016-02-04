package fr.polytech.tictactoe.players;

import fr.polytech.tictactoe.game.Mark;

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
	 * @see fr.polytech.tictactoe.players.IPlayer#getName()
	 */
	@Override
	public String getName()
	{
		return this.name;
	}

	/**
	 * @see fr.polytech.tictactoe.players.IPlayer#getMarkRepresentation()
	 */
	@Override
	public Mark getMarkRepresentation()
	{
		return this.representation;
	}
}