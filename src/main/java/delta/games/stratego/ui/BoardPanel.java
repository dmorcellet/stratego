package delta.games.stratego.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import delta.games.stratego.model.Side;
import delta.games.stratego.model.board.Board;
import delta.games.stratego.model.board.BoardCell;
import delta.games.stratego.model.pawns.Pawn;
import delta.games.stratego.model.pawns.Rank;

/**
 * Panel to display a game board.
 * @author DAM
 */
public class BoardPanel extends JPanel
{
  private static final int LINE_WIDTH=5;
  private static final int CELL_WIDTH=80;
  private static final int CELL_HEIGHT=80;
  private Board _board;
  private Dimension _size;

  /**
   * Constructor.
   * @param board
   */
  public BoardPanel(Board board)
  {
    super();
    _board=board;
    _size=computeSize();
    setPreferredSize(_size);
    setBackground(Color.WHITE);
  }

  /**
   * Compute the size of the GUI panel.
   * @return the size of the GUI panel.
   */
  private Dimension computeSize()
  {
    int cellsCountX=_board.getWidth();
    int totalWidth=cellsCountX*(CELL_WIDTH+LINE_WIDTH)+LINE_WIDTH;
    int cellsCountY=_board.getHeight();
    int totalHeight=cellsCountY*(CELL_HEIGHT+LINE_WIDTH)+LINE_WIDTH;
    Dimension ret=new Dimension(totalWidth,totalHeight);
    return ret;
  }

  /**
   * Paint the panel.
   * @param g Graphics to paint to.
   */
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    paintGrid(g);
    paintCells(g);
  }

  private void paintGrid(Graphics g)
  {
    int cellsCountX=_board.getWidth();
    int cellsCountY=_board.getHeight();
    // Horizontal lines
    int y=0;
    int maxX=_size.width;
    for(int i=0;i<=cellsCountY;i++)
    {
      g.setColor(Color.YELLOW);
      g.fillRect(0,y,maxX,LINE_WIDTH);
      y+=(CELL_HEIGHT+LINE_WIDTH);
    }
    // Vertical lines
    int x=0;
    int maxY=_size.height;
    for(int i=0;i<=cellsCountX;i++)
    {
      g.setColor(Color.YELLOW);
      g.fillRect(x,0,LINE_WIDTH,maxY);
      x+=(CELL_WIDTH+LINE_WIDTH);
    }
  }

  private void paintCells(Graphics g)
  {
    int cellsCountX=_board.getWidth();
    int cellsCountY=_board.getHeight();
    for(int i=0;i<cellsCountX;i++)
    {
      for(int j=0;j<cellsCountY;j++)
      {
        paintCell(g,i,j);
      }
    }
  }

  /**
   * Paint a single cell.
   * @param g Graphics to paint to.
   * @param cellX Cell horizontal position.
   * @param cellY Cell vertical position.
   */
  private void paintCell(Graphics g, int cellX, int cellY)
  {
    BoardCell cell=_board.getCellAt(cellX,cellY);
    boolean passable=cell.isPassable();
    int x=LINE_WIDTH+cellX*(LINE_WIDTH+CELL_WIDTH);
    int height=_size.height;
    int y=height-((cellY+1)*(LINE_WIDTH+CELL_HEIGHT));
    if (passable)
    {
      Pawn pawn=cell.getCurrentPawn();
      if (pawn!=null)
      {
        //System.out.println("Paint pawn: "+pawn+" at x="+x+", y="+y);
        Rank rank=pawn.getRank();
        Side side=pawn.getSide();
        int code=side.getCode();
        Color color=(code==0)?Color.RED:Color.BLUE;
        String name=rank.getName();
        int rankValue=rank.getRank();
        String label=name+" ("+rankValue+")";
        g.setColor(color);
        g.drawString(label,x+10,y+20);
      }
    }
    else
    {
      g.setColor(Color.RED);
      g.fillRect(x,y,CELL_WIDTH,CELL_HEIGHT);
    }
  }
}
