package fr.polytech.tictactoe.game.players;

import fr.polytech.tictactoe.game.TicTacToe;
import fr.polytech.tictactoe.game.boardgame.Coordinate;
import fr.polytech.tictactoe.game.boardgame.Mark;

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
	 * @see fr.polytech.tictactoe.game.players.IPlayer#getNextChoice(fr.polytech.tictactoe.game.boardgame.Mark[][])
	 */
	@Override
	public Coordinate getNextChoice(Mark[][] boardGame)
	{
		boolean found = false;
		int bestX = 0;
		int bestY = 0;
		int counter = 0;

		// Check lines
		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			counter = 0;
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				if (boardGame[x][y] == Mark.O)
				{
					counter++;
				}
				else
				{
					if (boardGame[x][y] == Mark.X)
					{
						counter--;
					}
				}
			}

			if (Math.abs(counter) == 2)
			{
				found = true;
				for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
				{
					if (boardGame[x][y] == Mark.EMPTY)
					{
						return new Coordinate(x, y);
					}
				}
			}
		}

		// Check columns
		for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
		{
			counter = 0;
			for (int x = 0; x < TicTacToe.NB_LINES; x++)
			{
				if (boardGame[x][y] == Mark.O)
				{
					counter++;
				}
				else
				{
					if (boardGame[x][y] == Mark.X)
					{
						counter--;
					}
				}
			}

			if (Math.abs(counter) == 2)
			{
				found = true;
				for (int x = 0; x < TicTacToe.NB_LINES; x++)
				{
					if (boardGame[x][y] == Mark.EMPTY)
					{
						return new Coordinate(x, y);
					}
				}
			}
		}

		// Check first diagonal
		counter = 0;
		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			if (boardGame[x][x] == Mark.O)
			{
				counter++;
			}
			else
			{
				if (boardGame[x][x] == Mark.X)
				{
					counter--;
				}
			}
		}

		if (Math.abs(counter) == 2)
		{
			found = true;
			for (int x = 0; x < TicTacToe.NB_LINES; x++)
			{
				if (boardGame[x][x] == Mark.EMPTY)
				{
					return new Coordinate(x, x);
				}
			}
		}

		// Check second diagonal
		counter = 0;
		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			if (boardGame[x][2 - x] == Mark.O)
			{
				counter++;
			}
			else
			{
				if (boardGame[x][2 - x] == Mark.X)
				{
					counter--;
				}
			}
		}

		if (Math.abs(counter) == 2)
		{
			found = true;
			for (int x = 0; x < TicTacToe.NB_LINES; x++)
			{
				if (boardGame[x][2 - x] == Mark.EMPTY)
				{
					bestX = x;
					bestY = 2 - x;
				}
			}
		}

		if ((!found) && (boardGame[1][1] == Mark.EMPTY))
		{
			return new Coordinate(1, 1);
		}

		if (!found)
		{
			if (nbCasesUsed(boardGame) == 3)
			{
				if (boardGame[0][0] == Mark.O && boardGame[2][2] == Mark.O)
                	return new Coordinate(0,1);
                else if (boardGame[0][2] == Mark.O && boardGame[2][0] == Mark.O)
                	return new Coordinate(0,1);
                else if (boardGame[1][2] == Mark.O && boardGame[2][0] == Mark.O)
                	return new Coordinate(2,1);
                else if (boardGame[0][0] == Mark.O && boardGame[1][2] == Mark.O)
                	return new Coordinate(0,1);
                else if (boardGame[1][0] == Mark.O && boardGame[2][2] == Mark.O)
                	return new Coordinate(2,1);
                else if (boardGame[0][2] == Mark.O && boardGame[1][0] == Mark.O)
                	return new Coordinate(0,1);
                else if (boardGame[1][0] == Mark.O && boardGame[2][1] == Mark.O)
                	return new Coordinate(2,0);
                else if (boardGame[1][2] == Mark.O && boardGame[2][1] == Mark.O)
                	return new Coordinate(2,2);
                else if (boardGame[1][0] == Mark.O && boardGame[0][1] == Mark.O)
                	return new Coordinate(0,0);
                else if (boardGame[0][1] == Mark.O && boardGame[1][2] == Mark.O)
                	return new Coordinate(0,2);
			}
			else
			{
				if (boardGame[0][2] == Mark.EMPTY)
                	return new Coordinate(0,2);
                else if (boardGame[2][0] == Mark.EMPTY)
                	return new Coordinate(2,0);
                else if (boardGame[2][2] == Mark.EMPTY)
                	return new Coordinate(2,2);
                else if (boardGame[0][1] == Mark.EMPTY)
                	return new Coordinate(0,1);
                else if (boardGame[1][0] == Mark.EMPTY)
                	return new Coordinate(1,0);
                else if (boardGame[1][2] == Mark.EMPTY)
                	return new Coordinate(1,2);
                else if (boardGame[2][1] == Mark.EMPTY)
                	return new Coordinate(1,1);
			}
		}

		return new Coordinate(bestX, bestY);
	}

	/**
	 * Count the number of cases used.
	 * 
	 * @param boardGame
	 *            The board game.
	 * @return The number of cases used.
	 */
	private int nbCasesUsed(Mark[][] boardGame)
	{
		int nbCasesUsed = 0;
		for (int x = 0; x < TicTacToe.NB_LINES; x++)
		{
			for (int y = 0; y < TicTacToe.NB_COLUMNS; y++)
			{
				if (boardGame[x][y] != Mark.EMPTY)
				{
					nbCasesUsed++;
				}
			}
		}

		return nbCasesUsed;
	}
}