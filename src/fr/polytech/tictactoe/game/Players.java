package fr.polytech.tictactoe.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.polytech.tictactoe.game.players.IPlayer;

/**
 * This class represents a set of players.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Players
{
	/**
	 * The all players.
	 */
	private final List<IPlayer> players;

	/**
	 * The current player offset.
	 */
	private int currentPlayerOffset;

	/**
	 * Create a set of players.
	 * 
	 * @param players
	 *            The players.
	 */
	public Players(IPlayer... players)
	{
		this.players = new ArrayList<IPlayer>(Arrays.asList(players));
		this.currentPlayerOffset = 0;
	}

	/**
	 * Get the current player.
	 * 
	 * @return The current player.
	 */
	public IPlayer getCurrentPlayer()
	{
		return this.players.get(this.currentPlayerOffset);
	}

	/**
	 * Update the next player.
	 */
	public void updateNextPlayer()
	{
		this.currentPlayerOffset++;

		if (this.currentPlayerOffset == this.players.size())
		{
			this.currentPlayerOffset = 0;
		}
	}
}