package model;

import java.util.List;

/**
 * The main interface of the game.
 */
public interface Polyomino {
  /**
   * Randomly generates the solution. The given count refers to the number of solution tiles to the
   * game.
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
   * @return current state.
   */
  String getState();

  /**
   * Returns the 2D boolean array representation of the board. True represents a grey area of
   * existing tile, false represents a plain (white) area of non-existing tile.
   *
   * @return the board of 2D boolean array type.
   */
  boolean[][] getBoard();

  /**
   * Returns a list of solution tiles of the game, where each tile represents a part of the
   * solution.
   *
   * @return the tiles solution.
   */
  List<Tiles> getTiles();

  /**
   * Returns the solution of the game, represented by a list of posns.
   *
   * @return the posns solution.
   */
  List<Posn> getSolution();
}
