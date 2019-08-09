import java.util.ArrayList;
import java.util.List;

/**
 * Polyomino implementation.
 */
public class PolyominoImpl implements Polyomino {
  private boolean[][] board;
  private List<Tiles> tiles = new ArrayList<Tiles>();
  private List<Posn> solutio = new ArrayList<Posn>();

  public PolyominoImpl() {
  }


  /**
   * Randomly generates the solution
   */
  @Override
  public void randGenSolution() {

  }

  /**
   * Determines if the game is over
   *
   * @return true if all the shaded area has been covered
   */
  @Override
  public boolean gameOver() {
    return false;
  }
}
