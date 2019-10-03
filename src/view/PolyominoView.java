package view;

import model.Polyomino;

/**
 * The visual representation interface of the game.
 */
public interface PolyominoView {

  void render(Polyomino model);

  /**
   * Adds all the IViewFeatures to the listeners to execute.
   *
   * @param vf given IViewFeatures
   * @throws UnsupportedOperationException if the given view doesn't support the listeners
   */
  void addListener(IViewFeatures vf) throws UnsupportedOperationException;

}