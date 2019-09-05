package control;

import java.util.ArrayList;
import java.util.List;

import model.Polyomino;
import model.PolyominoImpl;
import model.Tiles;
import view.IViewFeatures;
import view.PolyominoView;
import view.PolyominoViewImpl;

/**
 * Control implementation.
 */
public class PolyominoControlImpl implements PolyominoControl, IViewFeatures {
  private final Polyomino model;
  private final PolyominoView view;
  private final List<Tiles> tiles = new ArrayList<Tiles>();

  /**
   * Initializes a control implementation to the default model and view.
   */
  public PolyominoControlImpl() {
    this.model = new PolyominoImpl();
    this.view = new PolyominoViewImpl();
  }

  /**
   * Initializes a control implementation to the given model and view.
   */
  public PolyominoControlImpl(Polyomino model, PolyominoView view) {
    this.model = model;
    this.view = view;
    try {
      view.addListener(this);
    } catch (UnsupportedOperationException e) {
      // do nothing
    }
  }

  @Override
  public void run() {
    tiles.addAll(model.getTiles());
    model.getTiles().clear();
    view.render(model);
  }

  @Override
  public void resetGame() {

  }

  @Override
  public void newPuzzle() {
    model.newPuzzle();
    tiles.clear();
    run();
  }

  @Override
  public void rotateTiles() {

  }

  @Override
  public void showSolution() {
    if (model.getTiles().size() == 0) {
      model.getTiles().addAll(tiles);
    }
    view.render(model);
  }

  @Override
  public void hideSolution() {
    if (model.getTiles().size() != 0) {
      model.getTiles().clear();
    }
    view.render(model);
  }

}