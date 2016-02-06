package fr.polytech.tictactoe.game.boardgame;

/**
 * This enumeration represents all marks.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public enum Mark
{
    /**
     * The case is empty.
     */
	EMPTY(""),

	/**
	 * The case is a cross.
	 */
	X("/fr/polytech/tictactoe/view/resources/cross.png"),

	/**
	 * The case is a circle.
	 */
	O("/fr/polytech/tictactoe/view/resources/round.png");

	/**
	 * The image path.
	 */
	private final String imagePath;

	/**
	 * Private constructor.
	 * 
	 * @param imagePath
	 *            The image path.
	 */
	private Mark(String imagePath)
	{
		this.imagePath = imagePath;
	}

	/**
	 * Get the image path.
	 * 
	 * @return The image path.
	 */
	public String getImagePath()
	{
		return this.imagePath;
	}
}