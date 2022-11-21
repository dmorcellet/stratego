package delta.games.stratego.model;

/**
 * Location.
 * @author DAM
 */
public class Location
{
  private int _x;
  private int _y;

  /**
   * Constructor.
   * @param x X position.
   * @param y Y position.
   */
  public Location(int x, int y)
  {
    _x=x;
    _y=y;
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
