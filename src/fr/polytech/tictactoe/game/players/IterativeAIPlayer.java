package fr.polytech.tictactoe.game.players;

import fr.polytech.tictactoe.game.TicTacToe;
import fr.polytech.tictactoe.game.boardgame.Coordinate;
import fr.polytech.tictactoe.game.boardgame.Mark;

/**
 * This class represents an artificial intelligence player.
 *
 * @author DELORME Lo√Øc
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
        int best_i = 0;
        int best_j = 0;
        
        // VÈrifie qu'une ligne peut gagner, ou perdre
        int counter;
        for (int i = 0; i < 3; i++)
        {
            counter = 0;
            for (int j = 0; j < 3; j++)
            {
            	if(boardGame[i][j] == Mark.O)
            		counter++;
            	else if(boardGame[i][j] == Mark.X)
            		counter--;
            }
            if (counter == -2 || counter == 2)
            {
                found = true;
                for (int j = 0; j < 3; j++)
                {
                    if (boardGame[i][j] == Mark.EMPTY)
                    	return new Coordinate(i,j); //Point dÈcisif donc return pour ne pas avoir ‡ finir l'algo
                }
            }
        }
        // VÈrifie qu'une colonne peut gagner, ou perdre
        for (int j = 0; j < 3; j++)
        {
            counter = 0;
            for (int i = 0; i < 3; i++)
            {
            	if(boardGame[i][j] == Mark.O)
            		counter++;
            	else if(boardGame[i][j] == Mark.X)
            		counter--;
            }
            if (counter == -2 || counter == 2)
            {
                found = true;
                for (int i = 0; i < 3; i++)
                {
                    if (boardGame[i][j] == Mark.EMPTY)
                    	return new Coordinate(i,j); //Point dÈcisif donc return pour ne pas avoir ‡ finir l'algo
                }
            }
        }
        // Teste la diagonale de gauche ‡ droite
        counter = 0;
        for (int i = 0; i < 3; i++)
        {
            int j = i;
        	if(boardGame[i][j] == Mark.O)
        		counter++;
        	else if(boardGame[i][j] == Mark.X)
        		counter--;
        }
        if (counter == -2 || counter == 2)
        {
            found = true;
            for (int i = 0; i < 3; i++)
            {
                int j = i;
                if (boardGame[i][j] == Mark.EMPTY)
                	return new Coordinate(i,j); //Point dÈcisif donc return pour ne pas avoir ‡ finir l'algo
            }
        }
        // Teste la diagonale de droite ‡ gauche
        counter = 0;
        int decreaser = 2; // decreaser est ici l'Èquivalent de j
        for (int i = 0; i < 3; i++)
        {
        	if(boardGame[i][decreaser] == Mark.O)
        		counter++;
        	else if(boardGame[i][decreaser] == Mark.X)
        		counter--;
        	decreaser--;
        }
        if (counter == -2 || counter == 2)
        {
            found = true;
            decreaser = 2;
            for (int i = 0; i < 3; i++)
            {
                if (boardGame[i][decreaser] == Mark.EMPTY)
                    best_i = i; best_j = decreaser;
                decreaser--;
            }
        }
        // Choisis la case centrale si vide et pas d'autre meilleur choix
        if (!found && boardGame[1][1] == Mark.EMPTY)
        	return new Coordinate(1,1);
        else if (!found) {
            // VÈrifie les cas particuliers
            int nbCasesUsed = nbCasesUsed(boardGame);
            if (nbCasesUsed == 3)
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
        return new Coordinate(best_i, best_j);
	}
	
    private int nbCasesUsed(Mark[][] boardGame)
    {
        int nbCases = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (boardGame[i][j] == Mark.O || boardGame[i][j] == Mark.X)
                   ++ nbCases;
            }
        }
        return nbCases;
    }
}