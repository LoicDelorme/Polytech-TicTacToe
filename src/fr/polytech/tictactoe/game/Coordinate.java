package fr.polytech.tictactoe.game;

/**
 * This class represents a coordinate.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Coordinate
{
	/**
	 * The x.
	 */
	private final int x;

	/**
	 * The y.
	 */
	private final int y;

	/**
	 * Create a coordinate.
	 * 
	 * @param x
	 *            The x.
	 * @param y
	 *            The y.
	 */
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Get the x.
	 * 
	 * @return The x.
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * Get the y.
	 * 
	 * @return The y.
	 */
	public int getY()
	{
		return this.y;
	}
}