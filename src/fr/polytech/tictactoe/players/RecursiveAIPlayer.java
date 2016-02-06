package fr.polytech.tictactoe.players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.polytech.tictactoe.game.Coordinate;
import fr.polytech.tictactoe.game.Mark;
import fr.polytech.tictactoe.game.TicTacToe;
import fr.polytech.tictactoe.game.VictoryHelper;

/**
 * This class represents an artificial intelligence player.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class RecursiveAIPlayer extends Player
{
	/**
	 * The depth.
	 */
	public static final int DEPTH = 3;

	/**
	 * Create an artificial intelligence player.
	 * 
	 * @param name
	 *            The name.
	 * @param representation
	 *            The representation.
	 */
	public RecursiveAIPlayer(String name, Mark representation)
	{
		super(name, representation);
	}

	/**
	 * @see fr.polytech.tictactoe.players.IPlayer#getNextChoice(fr.polytech.tictactoe.game.Mark[][])
	 */
	@Override
	public Coordinate getNextChoice(Mark[][] boardGame)
	{
		return computedCoordinate(boardGame, DEPTH);
	}

	/**
	 * Get the coordinate to play.
	 * 
	 * @param boardGame
	 *            The board game.
	 * @param depth
	 *            The depth.
	 * @return The coordinate to play.
	 */
	private Coordinate computedCoordinate(Mark[][] boardGame, int depth)
	{
		final Mark[][] clonedBoardGame = boardGame.clone();
		int maxValue = Integer.MIN_VALUE;
		int maxX = -1;
		int maxY = -1;
		int tmpValue;

		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				if (clonedBoardGame[x][y] == Mark.EMPTY)
				{
					clonedBoardGame[x][y] = getRepresentation();
					tmpValue = min(clonedBoardGame, DEPTH - 1);

					if (tmpValue > maxValue)
					{
						maxValue = tmpValue;
						maxX = x;
						maxY = y;
					}

					clonedBoardGame[x][y] = Mark.EMPTY;
				}
			}
		}

		return new Coordinate(maxX, maxY);
	}

	private int min(Mark[][] boardGame, int depth)
	{
		if (depth == 0 || VictoryHelper.hasWon(getRepresentation(), boardGame))
		{
			return evaluate(boardGame);
		}

		int minValue = Integer.MAX_VALUE;
		int tmpValue;

		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				if (boardGame[x][y] == Mark.EMPTY)
				{
					boardGame[x][y] = getRepresentation();
					tmpValue = max(boardGame, DEPTH - 1);

					if (tmpValue < minValue)
					{
						minValue = tmpValue;
					}

					boardGame[x][y] = Mark.EMPTY;
				}
			}
		}

		return minValue;
	}

	private int max(Mark[][] boardGame, int depth)
	{
		if (depth == 0 || VictoryHelper.hasWon(getRepresentation(), boardGame))
		{
			return evaluate(boardGame);
		}

		int maxValue = Integer.MIN_VALUE;
		int tmpValue;

		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				if (boardGame[x][y] == Mark.EMPTY)
				{
					List<Mark> marks = new ArrayList<Mark>(Arrays.asList(Mark.values()));
					marks.remove(Mark.EMPTY);
					marks.remove(getRepresentation());

					boardGame[x][y] = marks.get(0);
					tmpValue = min(boardGame, DEPTH - 1);

					if (tmpValue > maxValue)
					{
						maxValue = tmpValue;
					}

					boardGame[x][y] = Mark.EMPTY;
				}
			}
		}

		return maxValue;
	}

	/**
	 * @param boardGame
	 * @return
	 */
	private int evaluate(Mark[][] boardGame)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}