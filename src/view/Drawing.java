package view;

import java.awt.*;

import javax.swing.*;

import model.Polyomino;
import model.Posn;

/**
 *
 */
public class Drawing extends JPanel implements IDrawing {
  private Polyomino p = null;

  public Drawing() {
    super();
  }

  /**
   * Draws the board.
   *
   * @param g given graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (p != null) {
      for (int i = 0; i < this.p.getBoard().length; i++) {
        for (int j = 0; j < this.p.getBoard()[i].length; j++) {
          if (p.getBoard()[i][j]) {
            g.setColor(Color.GRAY);
            g.fillRect(50 * i + 10, 50 * j + 10, 50, 50);
            g.setColor(Color.BLACK);
            g.drawRect(50 * i + 10, 50 * j + 10, 50, 50);
          } else {
            g.drawRect(50 * i + 10, 50 * j + 10, 50, 50);
          }
        }
      }

      for (Posn tile : p.getSolution()) {
        g.setColor(Color.CYAN);
        g.fillRect(tile.getX() * 50 + 500, tile.getY() * 50 + 10, 50, 50);
      }
    }
  }


  @Override
  public void draw(Polyomino model) {
    this.p = model;
    repaint();
  }
}
