package control;

import model.Polyomino;
import model.PolyominoImpl;
import view.PolyominoView;
import view.PolyominoViewImpl;

/**
 * Control implementation.
 */
public class PolyominoControlImpl implements PolyominoControl {
  Polyomino model = new PolyominoImpl();
  PolyominoView view = new PolyominoViewImpl();

  /**
   * Initializes a control implementation to the default model and view.
   */
  public PolyominoControlImpl() {

  }

  /**
   * Initializes a control implementation to the given model and view.
   */
  public PolyominoControlImpl(Polyomino model, PolyominoView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void resetGame() {

  }

  @Override
  public void newPuzzle() {

  }

  @Override
  public void rotateTiles() {

  }
}