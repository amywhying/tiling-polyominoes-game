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
   * Rotates the current solution tiles.
   */
  void rotateTiles();

}