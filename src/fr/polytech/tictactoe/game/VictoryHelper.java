package fr.polytech.tictactoe.game;

/**
 * This class represents
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class VictoryHelper
{
	/**
	 * Check if the player has won.
	 * 
	 * @param representation
	 *            The player's representation.
	 * @param boardGame
	 *            The board game.
	 * @return True or False.
	 */
	public static boolean hasWon(Mark representation, Mark[][] boardGame)
	{
		return (hasPlayerWonOnARow(representation, boardGame) || hasPlayerWonOnAColumn(representation, boardGame) || hasPlayerWonOnADiagonal(representation, boardGame));
	}

	/**
	 * Check if the player has won on a row.
	 * 
	 * @param representation
	 *            The player's representation.
	 * @param boardGame
	 *            The board game.
	 * @return True or False.
	 */
	private static boolean hasPlayerWonOnARow(Mark representation, Mark[][] boardGame)
	{
		boolean hasWon = ((boardGame[0][0] == representation) && (boardGame[0][1] == representation) && (boardGame[0][2] == representation));
		hasWon |= ((boardGame[1][0] == representation) && (boardGame[1][1] == representation) && (boardGame[1][2] == representation));
		hasWon |= ((boardGame[2][0] == representation) && (boardGame[2][1] == representation) && (boardGame[2][2] == representation));

		return hasWon;
	}

	/**
	 * Check if the player has won on a column.
	 * 
	 * @param representation
	 *            The player's representation.
	 * @param boardGame
	 *            The board game.
	 * @return True or False.
	 */
	private static boolean hasPlayerWonOnAColumn(Mark representation, Mark[][] boardGame)
	{
		boolean hasWon = ((boardGame[0][0] == representation) && (boardGame[1][0] == representation) && (boardGame[2][0] == representation));
		hasWon |= ((boardGame[0][1] == representation) && (boardGame[1][1] == representation) && (boardGame[2][1] == representation));
		hasWon |= ((boardGame[0][2] == representation) && (boardGame[1][2] == representation) && (boardGame[2][2] == representation));

		return hasWon;
	}

	/**
	 * Check if the player has won on a diagonal.
	 * 
	 * @param representation
	 *            The player's representation.
	 * @param boardGame
	 *            The board game.
	 * @return True or False.
	 */
	private static boolean hasPlayerWonOnADiagonal(Mark representation, Mark[][] boardGame)
	{
		boolean hasWon = ((boardGame[0][0] == representation) && (boardGame[1][1] == representation) && (boardGame[2][2] == representation));
		hasWon |= ((boardGame[0][2] == representation) && (boardGame[1][1] == representation) && (boardGame[2][0] == representation));

		return hasWon;
	}
}