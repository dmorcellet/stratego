package delta.games.stratego.io.xml;

import java.io.File;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import delta.common.utils.xml.DOMParsingTools;
import delta.games.stratego.engine.setup.Ranks;
import delta.games.stratego.model.Location;
import delta.games.stratego.model.board.Setup;
import delta.games.stratego.model.pawns.Pawn;
import delta.games.stratego.model.pawns.Rank;

/**
 * Parser for setups stored in XML.
 * @author DAM
 */
public class SetupXMLParser
{
  /**
   * Parse the XML file.
   * @param source Source file.
   * @return Parsed setup.
   */
  public Setup parseXML(File source)
  {
    Setup setup=new Setup();
    Element root=DOMParsingTools.parse(source);
    if (root!=null)
    {
      // Pawns
      List<Element> pawnTags=DOMParsingTools.getChildTagsByName(root,SetupXMLConstants.PAWN_TAG);
      for(Element pawnTag : pawnTags)
      {
        Pawn pawn=parsePawn(pawnTag);
        setup.addPawn(pawn);
      }
    }
    return setup;
  }

  private Pawn parsePawn(Element pawnTag)
  {
    NamedNodeMap attrs=pawnTag.getAttributes();

    Pawn ret=null;
    // Rank
    int rankCode=DOMParsingTools.getIntAttribute(attrs,SetupXMLConstants.PAWN_RANK_ATTR,0);
    Rank rank=Ranks.getRankByCode(rankCode);
    // Location
    int x=DOMParsingTools.getIntAttribute(attrs,SetupXMLConstants.PAWN_X_ATTR,-1);
    int y=DOMParsingTools.getIntAttribute(attrs,SetupXMLConstants.PAWN_Y_ATTR,-1);
    if (rank!=null)
    {
      ret=new Pawn(null,rank);
      if ((x>=0) && (y>=0))
      {
        Location location=new Location(x,y);
        ret.setLocation(location);
      }
    }
    return ret;
  }
}
