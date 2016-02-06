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

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return this.x + this.y;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}

		if (obj == null)
		{
			return false;
		}

		if (!(obj instanceof Coordinate))
		{
			return false;
		}

		Coordinate coordinate = (Coordinate) obj;

		if (this.x != coordinate.x)
		{
			return false;
		}

		if (this.y != coordinate.y)
		{
			return false;
		}

		return true;
	}
}