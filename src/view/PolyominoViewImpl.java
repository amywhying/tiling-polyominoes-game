package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import model.Polyomino;

/**
 * View implementation.
 */
public class PolyominoViewImpl extends JFrame implements PolyominoView, ActionListener {

  private final Drawing panel;
  private final List<IViewFeatures> listeners = new ArrayList<>();

  public PolyominoViewImpl() {
    super();
    panel = new Drawing();
    panel.setBackground(Color.WHITE);
    JButton showSolution = new JButton("Show Solution");

    showSolution.setActionCommand("solution");
    showSolution.addActionListener(this);

    JButton hideSolution = new JButton("Hide Solution");

    hideSolution.setActionCommand("hide");
    hideSolution.addActionListener(this);

    JButton newPuzzle = new JButton("New Puzzle");

    newPuzzle.setActionCommand("new");
    newPuzzle.addActionListener(this);

    JPanel botPanel = new JPanel();
    setSize(1000, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    botPanel.add(showSolution);
    botPanel.add(hideSolution);
    botPanel.add(newPuzzle);
    add(botPanel, BorderLayout.SOUTH);
    add(panel);
    setVisible(true);
  }

  @Override
  public void render(Polyomino model) {
    panel.draw(model);
  }

//  @Override
//  public void showPuzzle() {
//
//  }
//
//  @Override
//  public void showSolution() {
//
//  }
//
//  @Override
//  public void showTiles() {
//
//  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (IViewFeatures feat : listeners) {
      switch (e.getActionCommand()) {
        case "solution":
          feat.showSolution();
          break;
        case "hide":
          feat.hideSolution();
          break;
        case "new":
          feat.newPuzzle();
          break;
      }
    }
  }

  @Override
  public void addListener(IViewFeatures vf) throws UnsupportedOperationException {
    this.listeners.add(vf);
  }
}