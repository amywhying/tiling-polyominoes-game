package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the solution tiles of the game.
 */
public class Tiles {
  private List<Posn> shape = new ArrayList<Posn>();
  private Color color;

  /**
   * Initializes tiles to the given color.
   *
   * @param color represents the color of the tiles (RGB value).
   */
  public Tiles(Color color) {
    this.color = color;
  }

  /**
   * Adds the given list of posns to the shape of this tiles.
   *
   * @param posns represents the list of posns that belong to this tiles.
   */
  protected void addPosns(List<Posn> posns) {
    this.shape.addAll(posns);
  }

  /**
   * Produces the color of this tiles.
   *
   * @return the color of this tiles.
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Produces the shape (represented by a list of posns) of this tiles.
   *
   * @return the shape of this tiles.
   */
  public List<Posn> getShape() {
    return this.shape;
  }
}
