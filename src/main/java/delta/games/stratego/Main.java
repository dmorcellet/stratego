package delta.games.stratego;

import delta.games.stratego.ui.MainFrameController;

/**
 * Entry point of the Stratego application.
 * @author DAM
 */
public class Main
{
  /**
   * Main method for this application.
   * @param args Not used.
   */
  public static final void main(String[] args)
  {
    MainFrameController ctrl=new MainFrameController();
    ctrl.show();
  }
}
