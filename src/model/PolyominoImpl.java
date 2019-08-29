package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * model.Polyomino implementation.
 */
public class PolyominoImpl implements Polyomino {
  private boolean[][] board;
  // represents the solution tiles
  private List<Tiles> tiles = new ArrayList<Tiles>();
  private Random rand = new Random();
  private List<Posn> solution = new ArrayList<Posn>();
  private Map<Integer, Posn> lot = new HashMap<Integer, Posn>();

  /**
   * Initializes the board to the given x * y size. For the board, true refers to a solution tile,
   * while false refers to a blank tile.
   *
   * @param x represents the width of the board.
   * @param y represents the height of the board.
   */
  public PolyominoImpl(int x, int y) {
    initializeBoard(x, y);
  }

  /**
   * Initializes the board to the default 8 * 8 size. For the board, true refers to a solution tile,
   * * while false refers to a blank tile.
   */
  public PolyominoImpl() {
    initializeBoard(8, 8);
  }

  /**
   * Initializes the board to the given x * y size.
   *
   * @param x represents the width of the board.
   * @param y represents the height of the board.
   */
  private void initializeBoard(int x, int y) {
    this.board = new boolean[x][y];
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        this.board[i][j] = false;
      }
    }
  }

  /**
   * Produces a visual representation of the board.
   *
   * @return current state
   */
  public String getState() {
    StringBuilder gameState = new StringBuilder();
    for (int i = 0; i < this.board.length; i++) {
      if (i > 0) {
        gameState.append("\n");
      }
      for (int j = 0; j < this.board[i].length; j++) {
        if (!this.board[i][j]) {
          gameState.append("_ ");
        }
        if (new Posn(i, j).hasPosn(solution)) {
          gameState.append(String.valueOf(getTileNum(i, j)) + " ");
        }
      }
    }
    return gameState.toString();
  }

  private int getTileNum(int i, int j) {
    return new Posn(i, j).findPosn(solution) / 8;
  }

  @Override
  public void showSolution() {

  }

  /**
   * Randomly generates the solution.
   */
  @Override
  public void randGenSolution(int count) {
    int x = count;
    Posn first = genPos(8);
    List<Posn> worklist = new ArrayList<>();
    worklist.add(first);
    this.board[first.getX()][first.getY()] = true;
    while (x > 0) {
      Posn work = worklist.get(rand.nextInt(worklist.size())).randNext();
      if (work.hasPosn(worklist)) {
        x += 1;
      } else {
        this.board[work.getX()][work.getY()] = true;
        worklist.add(work);
        this.solution.add(work);
      }
      x -= 1;
    }
  }

  private Posn genPos(int max) {
    return new Posn(rand.nextInt(max), rand.nextInt(max));
  }


  /**
   * Determines if the game is over.
   *
   * @return true if all the shaded area has been covered.
   */
  @Override
  public boolean gameOver() {
    for (boolean[] row : board) {
      for (boolean each : row) {
        if (each) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Resets the current game.
   */
  void resetGame() {

  }

  /**
   * Creates and updates the timer of the game every second.
   */
  void gameTimer() {

  }

  /**
   * Generates a new puzzle of the current selected game level.
   */
  void newPuzzle() {

  }

  /**
   * Rotates the current solution tiles.
   */
  void rotateTiles() {
  }

  public boolean[][] getBoard() {
    return this.board;
  }

  public List<Tiles> getTiles() {
    return this.tiles;
  }

  public List<Posn> getSolution() {
    return this.solution;
  }
}
