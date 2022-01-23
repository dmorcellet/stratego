package delta.games.stratego.model.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import delta.games.stratego.model.Side;
import delta.games.stratego.model.pawns.Pawn;
import delta.games.stratego.model.pawns.PawnRankComparator;

/**
 * Storage for captured pawns.
 * @author DAM
 */
public class CapturedPawns
{
  private Side _side;
  private List<Pawn> _capturedPawns;

  /**
   * Constructor.
   * @param side Managed side.
   */
  public CapturedPawns(Side side)
  {
    _side=side;
    _capturedPawns=new ArrayList<Pawn>();
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
   * Add a pawn.
   * @param pawn Pawn to add.
   */
  public void addPawn(Pawn pawn)
  {
    _capturedPawns.add(pawn);
  }

  /**
   * Get the captured pawns, sorted by rank.
   * @return A possibly empty but never <code>null</code> list of pawns.
   */
  public List<Pawn> getCapturedPawns()
  {
    List<Pawn> ret=new ArrayList<Pawn>(_capturedPawns);
    Collections.sort(ret,new PawnRankComparator());
    return ret;
  }
}
