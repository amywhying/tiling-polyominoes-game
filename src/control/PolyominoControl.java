package control;

/**
 * The control interface of the game.
 */
public interface PolyominoControl {

  /**
   * The method that will render the text, draw the shapes, or write a SVG file.
   */
  void run();

  /**
   * Resets the current game.
   */
  void resetGame();

  /**
   * Generates a new puzzle of the current selected game level.
   */
  void newPuzzle();

  /**
   * Rotates the current solution tiles.
   */
  void rotateTiles();

}