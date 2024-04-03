package delta.games.stratego.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Panel that displays the game status (player name,...).
 * @author DAM
 */
public class SidePanel extends JPanel
{
  private static final boolean DEBUG=false;
  private JLabel _playerName;

  /**
   * Constructor.
   */
  public SidePanel()
  {
    super(new GridBagLayout());
    buildGUI();
  }

  private void buildGUI()
  {
    GridBagConstraints constraints;
    int x=0;
    int y=0;
    // Stratego main label
    {
      JLabel gameNameLabel=new JLabel("Stratego",SwingConstants.CENTER);
      setLabelSize(gameNameLabel,72f);
      if (DEBUG)
      {
        gameNameLabel.setOpaque(true);
        gameNameLabel.setBackground(Color.RED);
      }
      constraints=new GridBagConstraints(x,y,1,1,1.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0);
      add(gameNameLabel,constraints);
    }
    y++;
    // Player name
    {
      _playerName=new JLabel("Joe",SwingConstants.CENTER);
      setLabelSize(_playerName,36f);
      if (DEBUG)
      {
        _playerName.setOpaque(true);
        _playerName.setBackground(Color.GREEN);
      }
      constraints=new GridBagConstraints(x,y,1,1,1.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0);
      add(_playerName,constraints);
    }
  }

  /**
   * Set the player name.
   * @param playerName Name to set.
   */
  public void setPLayerName(String playerName)
  {
    _playerName.setText(playerName);
  }

  private void setLabelSize(JLabel label, float size)
  {
    Font font=label.getFont();
    font=font.deriveFont(size);
    label.setFont(font);
  }
}
