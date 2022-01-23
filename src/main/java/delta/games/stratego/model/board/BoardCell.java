package delta.games.stratego.model.board;

import delta.games.stratego.model.Location;
import delta.games.stratego.model.pawns.Pawn;

/**
 * Represents a cell of the board.
 * @author DAM
 */
public class BoardCell
{
  private Location _location;
  private boolean _passable;
  private Pawn _pawn;

  /**
   * Constructor.
   * @param passable Indicates if this cell is passable for pawns or not.
   * @param location Cell location.
   */
  public BoardCell(boolean passable, Location location)
  {
    _passable=passable;
    _location=location;
  }

  /**
   * Indicates if this cell is passable or not.
   * @return <code>true</code> if it is, <code>false</code> otherwise.
   */
  public boolean isPassable()
  {
    return _passable;
  }

  /**
   * Get the current pawn.
   * @return A pawn or <code>null</code>.
   */
  public Pawn getCurrentPawn()
  {
    return _pawn;
  }

  /**
   * Set the current pawn.
   * @param pawn Pawn to set (may be <code>null</code>).
   */
  public void setCurrentPawn(Pawn pawn)
  {
    _pawn=pawn;
  }

  @Override
  public String toString()
  {
    return "Cell: "+_location+", passable="+_passable+", pawn="+_pawn;
  }
}
