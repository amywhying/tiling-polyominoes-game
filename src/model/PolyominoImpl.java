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
        } else {
          gameState.append("O ");
        }

        /** This part plainly to check if all the
         polynomioes are correctly positioned. */

//        if (new Posn(i, j).hasPosn(solution)) {
//          gameState.append(getTileNum(i, j) + " ");
//        }
      }
    }
    return gameState.toString();
  }

<<<<<<< HEAD:src/model/PolyominoImpl.java
=======

  /**
   * This method generates number according to all the tiles in the solution. So the first to the
   * eighth tile in the solution will be marked as 0, the ninth to 16th will be marked as 1 and so
   * on.
   */
  private int getTileNum(int i, int j) {
    return new Posn(i, j).findPosn(solution) / 8;
  }

  @Override
  public void showSolution() {

  }

  /**
   * The algorithm picks a random block from the worklist and the next one goes to one of the four
   * corners. If the next block already exists, then it will pick another random block from the
   * worklist again and get another block until the count is exhausted.
   *
   * @param count is how many tiles you want to make a polyomino
   */
>>>>>>> a3e0692397b13bcc0b6fdb5e02db2881fd284562:src/model/PolyominoImpl.java
  @Override
  public void randGenSolution(int count) {
    int x = count;
    Posn first = genPos(8);
    List<Posn> worklist = new ArrayList<>();
//    List<Posn> oneTile = new ArrayList<>();
//    oneTile.add(first);
    worklist.add(first);
    this.solution.add(first);
    this.board[first.getX()][first.getY()] = true;
    while (x > 0) {
<<<<<<< HEAD:src/model/PolyominoImpl.java
      Posn work = worklist.get(0).randNext();
=======
      Posn work = worklist.get(rand.nextInt(worklist.size())).randNext();
>>>>>>> a3e0692397b13bcc0b6fdb5e02db2881fd284562:src/model/PolyominoImpl.java
      if (work.hasPosn(worklist)) {
        x += 1;
      } else {
        this.board[work.getX()][work.getY()] = true;
        worklist.add(work);
<<<<<<< HEAD:src/model/PolyominoImpl.java
=======
        this.solution.add(work);
>>>>>>> a3e0692397b13bcc0b6fdb5e02db2881fd284562:src/model/PolyominoImpl.java
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

  @Override
  public boolean[][] getBoard() {
    return this.board;
  }

  @Override
  public List<Tiles> getTiles() {
    return this.tiles;
  }

  @Override
  public List<Posn> getSolution() {
    return this.solution;
  }
}
