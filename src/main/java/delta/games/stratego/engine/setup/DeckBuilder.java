package delta.games.stratego.engine.setup;

import java.util.ArrayList;
import java.util.List;

import delta.games.stratego.model.Side;
import delta.games.stratego.model.pawns.Pawn;
import delta.games.stratego.model.pawns.Rank;

/**
 * Builds the decks.
 * @author DAM
 */
public class DeckBuilder
{
  private static final int[] COUNTS=new int[] { 1,1,8,5,4,4,4,3,2,1,1,6 };

  /**
   * Build the pawns for a single side.
   * @param side Side to use.
   * @return A list of pawns.
   */
  public static List<Pawn> buildPawns(Side side)
  {
    List<Pawn> ret=new ArrayList<Pawn>();
    for(Rank rank : Ranks.RANKS)
    {
      int count=COUNTS[rank.getRank()];
      for(int i=0;i<count;i++)
      {
        Pawn pawn=new Pawn(side,rank);
        ret.add(pawn);
      }
    }
    return ret;
  }
}
