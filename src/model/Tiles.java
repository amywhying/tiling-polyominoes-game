package model;

import java.awt.Color;
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
}
