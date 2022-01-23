package delta.games.stratego.model.board;

import java.util.ArrayList;
import java.util.List;

import delta.games.stratego.model.pawns.Pawn;

/**
 * Setup for a single side.
 * @author DAM
 */
public class Setup
{
  private List<Pawn> _pawns;

  /**
   * Constructor.
   */
  public Setup()
  {
    _pawns=new ArrayList<Pawn>();
  }

  /**
   * Add a pawn.
   * @param pawn Pawn to add.
   */
  public void addPawn(Pawn pawn)
  {
    _pawns.add(pawn);
  }
}
