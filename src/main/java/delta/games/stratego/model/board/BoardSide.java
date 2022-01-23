package delta.games.stratego.model.board;

import delta.games.stratego.model.Side;

/**
 * Side of the board.
 * @author DAM
 */
public class BoardSide
{
  /**
   * Side.
   */
  private Side _side;
  /**
   * Setup of side's pawns.
   */
  private Setup _setup;
  /**
   * Captured pawns.
   */
  private CapturedPawns _capturedPawns;

  /**
   * Constructor.
   * @param side Managed side.
   */
  public BoardSide(Side side)
  {
    _side=side;
    _setup=new Setup();
    _capturedPawns=new CapturedPawns(side);
  }

  /**
   * Get the managed side.
   * @return A side.
   */
  public Side getSide()
  {
    return _side;
  }

  /**
   * Get the setup for this side.
   * @return A setup.
   */
  public Setup getSetup()
  {
    return _setup;
  }

  /**
   * Get the captured pawns for this side.
   * @return captured pawns.
   */
  public CapturedPawns getCapturedPawns()
  {
    return _capturedPawns;
  }
}
