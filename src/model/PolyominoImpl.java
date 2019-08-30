package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static model.GameMode.*;

/**
 * Polyomino implementation.
 */
public class PolyominoImpl implements Polyomino {
  private boolean[][] board;
  // represents the solution tiles
  private List<Tiles> tiles = new ArrayList<Tiles>();
  private Random rand = new Random();
  private List<Posn> solution = new ArrayList<Posn>();
  private Map<Integer, Posn> lot = new HashMap<Integer, Posn>();
  // The difficulty will always be defaulted to easy. It can be changed later by "newPuzzle" after
  // selecting a new level;
  private GameMode difficulty = EASY;
  private int x;
  private int y;

  /**
   * Initializes the board to the given x * y size. For the board, true refers to a solution tile,
   * while false refers to a blank tile.
   *
   * @param x represents the width of the board.
   * @param y represents the height of the board.
   */
  public PolyominoImpl(int x, int y) {
    initializeBoard(x, y);
    this.x = x;
    this.y = y;
    randGenSolution();
  }

  /**
   * Initializes the board to the default 8 * 8 size. For the board, true refers to a solution tile,
   * * while false refers to a blank tile.
   */
  public PolyominoImpl() {
    initializeBoard(8, 8);
    this.x = 8;
    this.y = 8;
    randGenSolution();
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
   * corners. If the next block already exists, continue finding another viable block. The number of
   * blocks for each tile and the number of tiles for each game (the polyomino) is represented by
   * the value x and y respectively. They are varied depending on the game difficulty and the size
   * of the game board.
   */
  // @param count is how many tiles you want to make a polyomino
  @Override
  public void randGenSolution() {
    int x = getBlocksCount();
    int y = getTilesCount(x);
    Posn posn = genPos(this.x, this.y);
    while (y > 0) {

      Posn latestPosn = posn;
      List<Posn> worklist = new ArrayList<>();
      worklist.add(latestPosn);
      this.solution.add(latestPosn);
      this.board[latestPosn.getX()][latestPosn.getY()] = true;

      while (x > 1) {
        Posn work = worklist.get(rand.nextInt(worklist.size())).randNext(this.x, this.y);
        if (work.hasPosn(this.solution)) {
          x += 1;
        } else {
          this.board[work.getX()][work.getY()] = true;
          worklist.add(work);
          this.solution.add(work);
        }
        x -= 1;
      }
      x = getBlocksCount();
      Color color = randColor();
      Tiles tile = new Tiles(color);
      tile.addPosns(worklist);
      this.tiles.add(tile);
      posn = worklist.get(worklist.size() - 1);
      y -= 1;
    }
  }

  private int getBlocksCount() throws IllegalArgumentException {
    int max = this.x * this.y;
    switch (this.difficulty) {
      case EASY:
        return (int) Math.round(max * 0.10);
      case MEDIUM:
        return (int) Math.round(max * 0.20);
      case HARD:
        return (int) Math.round(max * 0.30);
      default:
        throw new IllegalArgumentException("Difficulty cannot be identified");
    }
  }

  private int getTilesCount(int blocks) throws IllegalArgumentException {
    int max = this.x * this.y;
    switch (this.difficulty) {
      case EASY:
        return (int) Math.round(max * 0.40 / blocks);
      case MEDIUM:
        return (int) Math.round(max * 0.50 / blocks);
      case HARD:
        return (int) Math.round(max * 0.60 / blocks);
      default:
        throw new IllegalArgumentException("Difficulty cannot be identified");
    }
  }


  private Posn genPos(int maxX, int maxY) {
    return new Posn(rand.nextInt(maxX), rand.nextInt(maxY));
  }

  private Color randColor() {
    return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
  }

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

  @Override
  public void newPuzzle() {
    initializeBoard(x, y);
    randGenSolution();
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
