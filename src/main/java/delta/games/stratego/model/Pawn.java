package delta.games.stratego.model;

/**
 * Pawn.
 * @author DAM
 */
public class Pawn
{
  private BoardSide _side;
  private Rank _rank;
  private PawnLocation _location;

  /**
   * Constructor.
   * @param side Board side.
   * @param rank Rank.
   */
  public Pawn(BoardSide side, Rank rank)
  {
    _side=side;
    _rank=rank;
  }

  /**
   * Get the location of this pawn.
   * @return A location or <code>null</code>.
   */
  public PawnLocation getLocation()
  {
    return _location;
  }

  /**
   * Set the location of this pawn.
   * @param location the location to set.
   */
  public void setLocation(PawnLocation location)
  {
    _location=location;
  }

  /**
   * Get the board side.
   * @return A side.
   */
  public BoardSide getSide()
  {
    return _side;
  }

  /**
   * Get the rank.
   * @return a rank.
   */
  public Rank getRank()
  {
    return _rank;
  }

  @Override
  public String toString()
  {
    return "Pawn: "+_side+", "+_rank+" at "+_location;
  }
}
