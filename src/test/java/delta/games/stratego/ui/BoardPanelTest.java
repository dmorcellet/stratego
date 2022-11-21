package delta.games.stratego.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import delta.games.stratego.model.board.Board;
import delta.games.stratego.utils.TestDataBuilder;

/**
 * Test class for the board panel.
 * @author DAM
 */
public class BoardPanelTest
{
  private void doIt()
  {
    JFrame f=new JFrame();
    Board board=TestDataBuilder.buildBoard();
    BoardPanel panel=new BoardPanel(board);
    f.getContentPane().add(panel,BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);
  }

  /**
   * Main method for this test.
   * @param args Not used.
   */
  public static void main(String[] args)
  {
    new BoardPanelTest().doIt();
  }
}
