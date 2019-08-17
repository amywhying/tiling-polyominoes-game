import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The main interface of the game.
 */
public interface Polyomino {
  /**
   * Randomly generates the solution.
   */
  void randGenSolution(int count);

  /**
   * Determines if the game is over.
   *
   * @return true if all of the shaded area has been covered.
   */
  boolean gameOver();

  /**
   * Shows the solution of the game.
   */
  void showSolution();

  /**
   * Produces a visual representation of the board.
   *
   * @return current state
   */
  String getState();

  boolean[][] getBoard();

  List<Tiles> getTiles();

  List<Posn> getSolution();
}
