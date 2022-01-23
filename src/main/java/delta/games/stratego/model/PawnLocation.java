package delta.games.stratego.model;

/**
 * Pawn location, relative to the lower/left corner of the board
 * for the owner player.
 * @author DAM
 */
public class PawnLocation
{
  private int _x;
  private int _y;

  /**
   * Constructor.
   * @param x X position.
   * @param y Y position.
   */
  public PawnLocation(int x, int y)
  {
    _x=x;
    _y=x;
  }

  /**
   * Get the X position.
   * @return a X position.
   */
  public int getX()
  {
    return _x;
  }

  /**
   * Get the Y position.
   * @return a Y position.
   */
  public int getY()
  {
    return _y;
  }

  @Override
  public String toString()
  {
    return "X="+_x+", Y="+_y;
  }
}
