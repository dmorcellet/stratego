package delta.games.stratego.engine.setup;

import delta.games.stratego.model.pawns.Rank;

/**
 * Known ranks.
 * @author DAM
 */
public class Ranks
{
  /**
   * Bomb.
   * Immovable; is captured by Miner.
   */
  public static final Rank BOMB=new Rank(11, "Bomb"); // Bombe
  /**
   * Marshal.
   * Can be captured by the Spy if the Spy attacks first.
   */
  public static final Rank MARSHAL=new Rank(10, "Marshal"); // Maréchal
  /**
   * General.
   */
  public static final Rank GENERAL=new Rank(9, "General"); // Général
  /**
   * Colonel.
   */
  public static final Rank COLONEL=new Rank(8, "Colonel"); // Colonel
  /**
   * Major.
   */
  public static final Rank MAJOR=new Rank(7, "Major"); // Commandant
  /**
   * Captain.
   */
  public static final Rank CAPTAIN=new Rank(6, "Captain"); // Capitaine
  /**
   * Lieutenant.
   */
  public static final Rank LIEUTENANT=new Rank(5, "Lieutenant"); // Lieutenant
  /**
   * Sergeant.
   */
  public static final Rank SERGEANT=new Rank(4, "Sergeant"); // Sergent
  /**
   * Miner.
   * Can defuse (i. e. capture) bombs.
   */
  public static final Rank MINER=new Rank(3, "Miner"); // Démineur
  /**
   * Scout.
   * Moves any distance in a horizontal or vertical straight line, without leaping over pieces/lakes.
   */
  public static final Rank SCOUT=new Rank(2, "Scout"); // Eclaireur
  /**
   * Spy.
   * Defeats the Marshal, but only if the Spy makes the attack.
   */
  public static final Rank SPY=new Rank(1, "Spy"); // Espion
  /**
   * Flag.
   * Immovable; capturing the opponent's Flag wins the game.
   */
  public static final Rank FLAG=new Rank(0, "Flag"); // Drapeau

  /**
   * All ranks.
   */
  public static final Rank[] RANKS={BOMB,MARSHAL,GENERAL,COLONEL,MAJOR,CAPTAIN,LIEUTENANT,SERGEANT,MINER,SCOUT,SPY,FLAG};
}
