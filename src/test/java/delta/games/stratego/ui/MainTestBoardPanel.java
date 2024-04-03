package delta.games.stratego.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import delta.games.stratego.model.board.Board;
import delta.games.stratego.utils.TestDataBuilder;

/**
 * Test class for the board panel.
 * @author DAM
 */
public class MainTestBoardPanel
{
  private void doIt()
  {
    JFrame f=new JFrame();
    Board board=TestDataBuilder.buildBoard();
    BoardPanel panel=new BoardPanel(board);
    f.add(panel);
    f.pack();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  /**
   * Main method for this test.
   * @param args Not used.
   */
  public static void main(String[] args)
  {
    new MainTestBoardPanel().doIt();
  }
}
