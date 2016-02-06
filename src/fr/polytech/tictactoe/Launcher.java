package fr.polytech.tictactoe;

import fr.polytech.tictactoe.game.Mark;
import fr.polytech.tictactoe.players.HumanPlayer;
import fr.polytech.tictactoe.players.IterativeAIPlayer;
import fr.polytech.tictactoe.view.JavaFXTicTacToeViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class represents the launcher of the application.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Launcher extends Application
{
	/**
	 * The entry of the application.
	 * 
	 * @param args
	 *            Some arguments.
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

	/**
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		final FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fr/polytech/tictactoe/view/JavaFXTicTacToeView.fxml"));
		final Parent root = loader.load();

		final JavaFXTicTacToeViewController controller = loader.getController();
		controller.initializeContent(new HumanPlayer("Human", Mark.O), new IterativeAIPlayer("AI", Mark.X));

		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}