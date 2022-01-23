package delta.games.stratego.model.pawns;

/**
 * Rank.
 * @author DAM
 */
public class Rank
{
  private int _rank;
  private String _name;

  /**
   * Constructor.
   * @param rank Rank value.
   * @param name Rank name.
   */
  public Rank(int rank, String name)
  {
    _rank=rank;
    _name=name;
  }

  /**
   * Get the rank value.
   * @return A rank value.
   */
  public int getRank()
  {
    return _rank;
  }

  /**
   * Get the rank name.
   * @return A name.
   */
  public String getName()
  {
    return _name;
  }

  @Override
  public String toString()
  {
    return "Rank "+_rank+" ("+_name+")";
  }
}
