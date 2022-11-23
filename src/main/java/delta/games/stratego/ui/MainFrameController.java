package delta.games.stratego.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import delta.games.stratego.model.board.Board;

/**
 * Controller for the Stratego main frame.
 * @author DAM
 */
public class MainFrameController implements ActionListener
{
  private JFrame _frame;
  private static final String NEW_GAME_CMD="NEW_GAME";
  private static final String QUIT_CMD="QUIT";

  private BoardPanel _boardPanel;
  private SidePanel _sidePanel;

  /**
   * Constructor.
   */
  public MainFrameController()
  {
    // Nothing!
  }

  /**
   * Get the managed frame (build it if necessary).
   * @return A frame.
   */
  public JFrame getFrame()
  {
    if (_frame==null)
    {
      _frame=buildFrame();
    }
    return _frame;
  }

  private JFrame buildFrame()
  {
    JFrame frame=new JFrame("Stratego");
    JMenuBar menus=buildMenus();
    frame.setJMenuBar(menus);
    JPanel mainPanel=buildMainPanel();
    frame.add(mainPanel);
    frame.pack();
    return frame;
  }

  private JMenuBar buildMenus()
  {
    // Create the menu bar
    JMenuBar menuBar=new JMenuBar();

    // Build the "Game" menu
    JMenu menu=new JMenu("Jeu");
    menu.setMnemonic(KeyEvent.VK_J);
    menuBar.add(menu);

    // New game item
    {
      JMenuItem menuItem=new JMenuItem("Nouvelle partie",KeyEvent.VK_N);
      menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.ALT_MASK));
      menuItem.setActionCommand(NEW_GAME_CMD);
      menuItem.addActionListener(this);
      menu.add(menuItem);
    }
    menu.addSeparator();
    // Quit item
    {
      JMenuItem menuItem=new JMenuItem("Quitter",KeyEvent.VK_Q);
      menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.ALT_MASK));
      menuItem.setActionCommand(QUIT_CMD);
      menuItem.addActionListener(this);
      menu.add(menuItem);
    }
    menuBar.add(menu);
    return menuBar;
  }

  private JPanel buildMainPanel()
  {
    JPanel mainPanel=new JPanel(new GridBagLayout());
    Board board=new Board(10,10);
    _boardPanel=new BoardPanel(board);
    GridBagConstraints c1=new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,5,5),0,0);
    mainPanel.add(_boardPanel,c1);
    _sidePanel=new SidePanel();
    GridBagConstraints c2=new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.NORTH,GridBagConstraints.NONE,new Insets(5,5,5,5),0,0);
    mainPanel.add(_sidePanel,c2);
    return mainPanel;
  }

  /**
   * Get the board panel.
   * @return the board panel.
   */
  public BoardPanel getBoardPanel()
  {
    return _boardPanel;
  }

  /**
   * Show the managed frame.
   */
  public void show()
  {
    JFrame frame=getFrame();
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    String cmd=e.getActionCommand();
    if (NEW_GAME_CMD.equals(cmd))
    {
      // Nothing yet!
    }
    else if (QUIT_CMD.equals(cmd))
    {
      doQuit();
    }
  }

  private void doQuit()
  {
    System.exit(0);
  }

  /**
   * Main method for the Stratego game.
   * @param args Not used.
   */
  public static void main(String[] args)
  {
    MainFrameController controller=new MainFrameController();
    controller.show();
  }
}
