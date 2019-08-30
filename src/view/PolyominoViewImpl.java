package view;

import java.awt.*;

import javax.swing.*;

import model.Polyomino;

/**
 * View implementation.
 */
public class PolyominoViewImpl extends JFrame implements PolyominoView {

  private final Drawing panel;

  public PolyominoViewImpl() {
    super();
    panel = new Drawing();
    panel.setBackground(Color.WHITE);

    setSize(1000, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);

    add(panel);

    setVisible(true);
  }

  @Override
  public void render(Polyomino model) {
    panel.draw(model);
  }

  /*@Override
  public void showPuzzle() {

  }

  @Override
  public void showSolution() {

  }

  @Override
  public void showTiles() {

  }*/
}