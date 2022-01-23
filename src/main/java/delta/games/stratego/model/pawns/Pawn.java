package delta.games.stratego.model.pawns;

import delta.games.stratego.model.Location;
import delta.games.stratego.model.Side;

/**
 * Pawn.
 * @author DAM
 */
public class Pawn
{
  private Side _side;
  private Rank _rank;
  /**
   * Pawn location, relative to the lower/left corner of the board for the owner side.
   */
  private Location _location;

  /**
   * Constructor.
   * @param side Board side.
   * @param rank Rank.
   */
  public Pawn(Side side, Rank rank)
  {
    _side=side;
    _rank=rank;
  }

  /**
   * Get the location of this pawn.
   * @return A location or <code>null</code>.
   */
  public Location getLocation()
  {
    return _location;
  }

  /**
   * Set the location of this pawn.
   * @param location the location to set.
   */
  public void setLocation(Location location)
  {
    _location=location;
  }

  /**
   * Get the board side.
   * @return A side.
   */
  public Side getSide()
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
