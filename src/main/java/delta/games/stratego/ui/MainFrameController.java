package delta.games.stratego.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import delta.common.ui.swing.windows.DefaultWindowController;
import delta.games.stratego.model.board.Board;

/**
 * Controller for the Stratego main frame.
 * @author DAM
 */
public class MainFrameController extends DefaultWindowController implements ActionListener
{
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

  @Override
  protected JFrame build()
  {
    JFrame frame=super.build();
    frame.setTitle("Stratego");
    // Default size
    frame.pack();
    return frame;
  }

  @Override
  protected JComponent buildContents()
  {
    JPanel mainPanel=buildMainPanel();
    return mainPanel; 
  }

  @Override
  protected JMenuBar buildMenuBar()
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
    dispose();
  }

  @Override
  public void dispose()
  {
    super.dispose();
    _boardPanel=null;
    _sidePanel=null;
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
