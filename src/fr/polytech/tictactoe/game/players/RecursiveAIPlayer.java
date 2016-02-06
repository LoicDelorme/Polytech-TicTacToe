package fr.polytech.tictactoe.game.players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.polytech.tictactoe.game.TicTacToe;
import fr.polytech.tictactoe.game.boardgame.BoardGameHelper;
import fr.polytech.tictactoe.game.boardgame.Coordinate;
import fr.polytech.tictactoe.game.boardgame.Mark;

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
	 * @see fr.polytech.tictactoe.game.players.IPlayer#getNextChoice(fr.polytech.tictactoe.game.boardgame.Mark[][])
	 */
	@Override
	public Coordinate getNextChoice(Mark[][] boardGame)
	{
		final Mark[][] clonedBoardGame = boardGame.clone();

		int maxValue = Integer.MIN_VALUE;
		int tmpValue;
		int bestX = 0;
		int bestY = 0;

		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				if (clonedBoardGame[x][y] == Mark.EMPTY)
				{
					clonedBoardGame[x][y] = getRepresentation();
					tmpValue = min(clonedBoardGame, DEPTH);

					if (tmpValue > maxValue)
					{
						maxValue = tmpValue;
						bestX = x;
						bestY = y;
					}

					clonedBoardGame[x][y] = Mark.EMPTY;
				}
			}
		}

		return new Coordinate(bestX, bestY);
	}

	/**
	 * Minimize.
	 * 
	 * @param boardGame
	 *            The board game.
	 * @param depth
	 *            The depth.
	 * @return The minimize value.
	 */
	private int min(Mark[][] boardGame, int depth)
	{
		if ((depth == 0) || BoardGameHelper.allCellAreMarked(boardGame) || BoardGameHelper.hasWon(getRepresentation(), boardGame) || BoardGameHelper.hasWon(getOpponentMark(), boardGame))
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
					tmpValue = max(boardGame, depth - 1);

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

	/**
	 * Maximize.
	 * 
	 * @param boardGame
	 *            The board game.
	 * @param depth
	 *            The depth.
	 * @return The maximize value.
	 */
	private int max(Mark[][] boardGame, int depth)
	{
		if ((depth == 0) || BoardGameHelper.allCellAreMarked(boardGame) || BoardGameHelper.hasWon(getRepresentation(), boardGame) || BoardGameHelper.hasWon(getOpponentMark(), boardGame))
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
					boardGame[x][y] = getRepresentation();
					tmpValue = min(boardGame, depth - 1);

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
	 * Evaluate the board game.
	 * 
	 * @param boardGame
	 *            The board game.
	 * @return The evaluation of the board game.
	 */
	private int evaluate(Mark[][] boardGame)
	{
		int nbMarks = 0;
		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				if (boardGame[x][y] != Mark.EMPTY)
				{
					nbMarks++;
				}
			}
		}

		if (BoardGameHelper.hasWon(getRepresentation(), boardGame))
		{
			return 1000 - nbMarks;
		}

		if (BoardGameHelper.hasWon(getOpponentMark(), boardGame))
		{
			return -1000 + nbMarks;
		}

		if (BoardGameHelper.allCellAreMarked(boardGame))
		{
			return 0;
		}

		return numberOfSeries(getRepresentation(), boardGame, 2) - numberOfSeries(getOpponentMark(), boardGame, 2);
	}

	/**
	 * Counter the number of series.
	 * 
	 * @param representation
	 *            The representation.
	 * @param boardGame
	 *            The board game.
	 * @param n
	 *            The number of marks.
	 * @return The number of series.
	 */
	private int numberOfSeries(Mark representation, Mark[][] boardGame, int n)
	{
		// int counter = 0;https://openclassrooms.com/courses/l-algorithme-min-max
		// for (int x = 0; x < TicTacToe.NB_LINES; x++)
		// {
		// if (boardGame[x][x] == representation)
		// {
		// counter++;
		// }
		// }
		return 0;
	}

	/**
	 * Get the opponent mark.
	 * 
	 * @return The opponent mark.
	 */
	private Mark getOpponentMark()
	{
		final List<Mark> marks = new ArrayList<Mark>(Arrays.asList(Mark.values()));
		marks.remove(Mark.EMPTY);
		marks.remove(getRepresentation());

		return marks.get(0);
	}
}