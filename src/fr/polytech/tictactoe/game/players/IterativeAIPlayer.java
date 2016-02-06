package fr.polytech.tictactoe.game.players;

import fr.polytech.tictactoe.game.Coordinate;
import fr.polytech.tictactoe.game.Mark;
import fr.polytech.tictactoe.game.TicTacToe;

/**
 * This class represents an artificial intelligence player.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class IterativeAIPlayer extends Player
{
	/**
	 * Create an artificial intelligence player.
	 * 
	 * @param name
	 *            The name.
	 * @param representation
	 *            The representation.
	 */
	public IterativeAIPlayer(String name, Mark representation)
	{
		super(name, representation);
	}

	/**
	 * @see fr.polytech.tictactoe.game.players.IPlayer#getNextChoice(fr.polytech.tictactoe.game.Mark[][])
	 */
	@Override
	public Coordinate getNextChoice(Mark[][] boardGame)
	{
		// TODO ADD ALGORITHM
		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				if (boardGame[x][y] == Mark.EMPTY)
				{
					return new Coordinate(x, y);
				}
			}
		}

		return null;
	}
}