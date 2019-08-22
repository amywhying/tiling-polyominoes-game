package model;

import java.util.List;
import java.util.Random;

/**
 * Represents a coordinate of x and y, which are row and column respectively.
 */
public class Posn {
  private int x;
  private int y;
  private Random r = new Random();

  /**
   * Initializes a posn to the given x and y value.
   *
   * @param x represents xth row.
   * @param y represents yth column.
   */
  public Posn(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns the x value of this posn.
   *
   * @return the x value.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Returns the y value of this posn.
   *
   * @return the y value.
   */
  public int getY() {
    return this.y;
  }

  /**
   * Assign the given newX as this posn's new x value, and the given newY as this posn's new y
   * value.
   *
   * @param newX the new x value to be assigned.
   * @param newY the new y value to be assigned.
   */
  public void set(int newX, int newY) {
    this.x = newX;
    this.y = newY;
  }

  /**
   * Randomly generates the next position coordinate.
   *
   * @return the next square position on the board
   */
  public Posn randNext() {
    int[] work = new int[]{x, y};
    boolean addOrMinus = r.nextBoolean();
    if (addOrMinus) {
      int randInt = r.nextInt(2);
      work[randInt] += 1;
    } else {
      int randInt = r.nextInt(2);
      work[randInt] -= 1;
    }
    return new Posn(work[0], work[1]);
  }

  /**
   * Determines whether any of the posns in the given list is the same as this posn.
   *
   * @param ps represents a list of posns that may contain this posn.
   * @return true if the given list has this posn, false if not.
   */
  public boolean hasPosn(List<Posn> ps) {
    for (Posn p : ps) {
      if (p.sameAs(this)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determines whether the given posn is the same as this posn in terms of their x and y values.
   *
   * @param that represents another posn to be compared with this posn.
   * @return true if the given posn is the same as this posn, false if not.
   */
  public boolean sameAs(Posn that) {
    return this.getX() == that.getX()
            && this.getY() == that.getY();
  }
}
