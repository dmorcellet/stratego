package delta.games.stratego.model.board;

import delta.games.stratego.model.Location;

/**
 * Represents the game board.
 * @author DAM
 */
public class Board
{
  private BoardCell[][] _cells;

  /**
   * Constructor.
   * @param width Width.
   * @param height Height.
   */
  public Board(int width, int height)
  {
    init(width,height);
  }

  private void init(int width, int height)
  {
    BoardCell[][] cells=new BoardCell[width][height];
    for(int i=0;i<width;i++)
    {
      for(int j=0;j<height;j++)
      {
        BoardCell cell=new BoardCell(true,new Location(i,j));
        cells[i][j]=cell;
      }
    }
    _cells=cells;
  }

  /**
   * Get the width of the board.
   * @return A width (cells count).
   */
  public int getWidth()
  {
    return _cells.length;
  }

  /**
   * Get the height of the board.
   * @return A height (cells count).
   */
  public int getHeight()
  {
    return _cells[0].length;
  }

  /**
   * Get a cell.
   * @param x X position of the cell to get.
   * @param y Y position of the cell to get.
   * @return A cell or <code>null</code> if not set.
   */
  public BoardCell getCellAt(int x, int y)
  {
    if ((x>=0) && (x<_cells.length))
    {
      BoardCell[] column=_cells[x];
      if ((y>=0) && (y<column.length))
      {
        return column[y];
      }
    }
    return null;
  }
}
