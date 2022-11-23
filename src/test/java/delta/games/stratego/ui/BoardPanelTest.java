package delta.games.stratego.ui;

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
    f.add(panel);
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
