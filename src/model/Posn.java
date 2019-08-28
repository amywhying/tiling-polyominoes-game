package model;

import java.util.List;
import java.util.Random;

public class Posn {
  private int x;
  private int y;
  private Random r = new Random();

  public Posn(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

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
      if (work[randInt] < 0 || work[randInt] > 7) {
        work[randInt] -= 1;
      }
    } else {
      int randInt = r.nextInt(2);
      work[randInt] -= 1;
      if (work[randInt] < 0 || work[randInt] > 7) {
        work[randInt] += 1;
      }
    }
    return new Posn(work[0], work[1]);
  }

  public boolean hasPosn(List<Posn> ps) {
    for (Posn p : ps) {
      if (p.sameAs(this)) {
        return true;
      }
    }
    return false;
  }

  public boolean sameAs(Posn that) {
    return this.getX() == that.getX()
            && this.getY() == that.getY();
  }
}
