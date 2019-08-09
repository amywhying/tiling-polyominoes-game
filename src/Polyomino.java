/**
 * The main class of the game.
 */
public interface Polyomino {
  /**
   * Randomly generates the solution
   */
  void randGenSolution();

  /**
   * Determines if the game is over
   *
   * @return true if all the shaded area has been covered
   */
  boolean gameOver();
}
