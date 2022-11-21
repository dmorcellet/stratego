package delta.games.stratego.utils;

import java.util.List;

import delta.games.stratego.engine.setup.DeckBuilder;
import delta.games.stratego.model.Location;
import delta.games.stratego.model.Side;
import delta.games.stratego.model.board.Board;
import delta.games.stratego.model.board.BoardCell;
import delta.games.stratego.model.board.BoardSide;
import delta.games.stratego.model.board.Setup;
import delta.games.stratego.model.pawns.Pawn;

/**
 * Builder for test data.
 * @author DAM
 */
public class TestDataBuilder
{
  /**
   * Build a board for tests.
   * @return A new board.
   */
  public static Board buildBoard()
  {
    int width=10;
    int height=10;
    Board board=new Board(width,height);
    Side red=new Side(0,"Red");
    Side blue=new Side(1,"Blue");
    BoardSide redPawns=initSide(red,width);
    BoardSide bluePawns=initSide(blue,width);
    initBoard(board,redPawns,bluePawns);
    return board;
  }

  private static void initBoard(Board board, BoardSide ownSide, BoardSide otherSide)
  {
    int width=board.getWidth();
    int height=board.getHeight();

    // Own
    {
      Setup setup=ownSide.getSetup();
      List<Pawn> pawns=setup.getPawns();
      for(Pawn pawn : pawns)
      {
        Location location=pawn.getLocation();
        BoardCell cell=board.getCellAt(location.getX(),location.getY());
        cell.setCurrentPawn(pawn);
      }
    }
    // Other
    {
      Setup setup=otherSide.getSetup();
      List<Pawn> pawns=setup.getPawns();
      for(Pawn pawn : pawns)
      {
        Location location=pawn.getLocation();
        BoardCell cell=board.getCellAt(width-location.getX()-1,height-location.getY()-1);
        cell.setCurrentPawn(pawn);
      }
    }
  }

  private static BoardSide initSide(Side side, int width)
  {
    BoardSide ret=new BoardSide(side);
    List<Pawn> pawns=DeckBuilder.buildPawns(side);
    int x=0;
    int y=0;
    Setup setup=ret.getSetup();
    for(Pawn pawn : pawns)
    {
      Location location=new Location(x,y);
      pawn.setLocation(location);
      x++;
      if (x==width)
      {
        x=0;
        y++;
      }
      setup.addPawn(pawn);
    }
    return ret;
  }
}
