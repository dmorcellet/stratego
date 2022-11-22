package delta.games.stratego.io.xml;

import java.io.File;
import java.util.List;

import javax.xml.transform.sax.TransformerHandler;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import delta.common.utils.io.xml.XmlFileWriterHelper;
import delta.common.utils.io.xml.XmlWriter;
import delta.common.utils.text.EncodingNames;
import delta.games.stratego.model.Location;
import delta.games.stratego.model.board.Setup;
import delta.games.stratego.model.pawns.Pawn;
import delta.games.stratego.model.pawns.Rank;

/**
 * Writes setups to XML files.
 * @author DAM
 */
public class SetupXMLWriter
{
  /**
   * Write a file with factions.
   * @param toFile Output file.
   * @param setup Setup to write.
   * @return <code>true</code> if it succeeds, <code>false</code> otherwise.
   */
  public static boolean writeFactionsFile(File toFile, Setup setup)
  {
    SetupXMLWriter writer=new SetupXMLWriter();
    boolean ok=writer.writeSetup(toFile,setup,EncodingNames.UTF_8);
    return ok;
  }

  /**
   * Write a setup to a XML file.
   * @param outFile Output file.
   * @param setup Setup to write.
   * @param encoding Encoding to use.
   * @return <code>true</code> if it succeeds, <code>false</code> otherwise.
   */
  public boolean writeSetup(File outFile, final Setup setup, String encoding)
  {
    XmlFileWriterHelper helper=new XmlFileWriterHelper();
    XmlWriter writer=new XmlWriter()
    {
      @Override
      public void writeXml(TransformerHandler hd) throws Exception
      {
        writeSetup(hd,setup);
      }
    };
    boolean ret=helper.write(outFile,encoding,writer);
    return ret;
  }

  private void writeSetup(TransformerHandler hd, Setup setup) throws SAXException
  {
    AttributesImpl emptyAttrs=new AttributesImpl();
    hd.startElement("","",SetupXMLConstants.SETUP_TAG,emptyAttrs);
    // Pawns
    List<Pawn> pawns=setup.getPawns();
    for(Pawn pawn : pawns)
    {
      writePawn(hd,pawn);
    }
    hd.endElement("","",SetupXMLConstants.SETUP_TAG);
  }

  private void writePawn(TransformerHandler hd, Pawn pawn) throws SAXException
  {
    AttributesImpl pawnAttrs=new AttributesImpl();
    // Rank
    Rank rank=pawn.getRank();
    int rankCode=rank.getRank();
    pawnAttrs.addAttribute("","",SetupXMLConstants.PAWN_RANK_ATTR,XmlWriter.CDATA,String.valueOf(rankCode));
    // Location
    Location location=pawn.getLocation();
    if (location!=null)
    {
      int x=location.getX();
      pawnAttrs.addAttribute("","",SetupXMLConstants.PAWN_X_ATTR,XmlWriter.CDATA,String.valueOf(x));
      int y=location.getY();
      pawnAttrs.addAttribute("","",SetupXMLConstants.PAWN_Y_ATTR,XmlWriter.CDATA,String.valueOf(y));
    }
    hd.startElement("","",SetupXMLConstants.PAWN_TAG,pawnAttrs);
    hd.endElement("","",SetupXMLConstants.PAWN_TAG);
  }
}
