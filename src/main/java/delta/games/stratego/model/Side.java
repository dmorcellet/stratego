package delta.games.stratego.model;

/**
 * Represents a side/player.
 * @author DAM
 */
public class Side
{
  private int _code;
  private String _name;

  /**
   * Constructor.
   * @param code Side code.
   * @param name Side name.
   */
  public Side(int code, String name)
  {
    _code=code;
    _name=name;
  }

  /**
   * Get the side code.
   * @return A code.
   */
  public int getCode()
  {
    return _code;
  }

  /**
   * Get the side name. 
   * @return A name.
   */
  public String getName()
  {
    return _name;
  }

  @Override
  public String toString()
  {
    return "Side "+_code+" ("+_name+")";
  }
}
