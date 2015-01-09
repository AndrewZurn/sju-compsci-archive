package SixDegrees.graph;
import java.io.*;
/**
 * BaconQuad contains the information necessary for doing
 * Djikstra's algorithm. BaconQuad consists of four
 * pieces of data:
 * <OL>
 * <LI><B>actor:</B> A String containing the name of the 
 * actor for whom we want to know the "distance" from Kevin 
 * Bacon.
 * <LI><B>lastActor:</B> A String containing the name of 
 * the last actor on the "path" from Kevin Bacon to this
 * <B>actor</B>.
 * <LI><B>movie:</B> A String containing the name of the
 * movie that <B>actor</B> and <B>lastActor</B> were in.
 * <LI><B>distanceFromBacon:</B> the current length of
 * the path from Kevin Bacon to <B>actor</B>.
 * </OL>
 */
public class BaconQuad implements Comparable<BaconQuad>,Serializable {
  private String actor,lastActor,movie;
  private Integer distanceFromBacon;
  
  /**
   * The only constructor is one where we pass all four
   * values - actor, lastActor, movie, and distanceFromBacon.
   */
  public BaconQuad(String actor,String lastActor,
                   String movie, Integer distanceFromBacon) {
    this.actor=actor;
    this.lastActor=lastActor;
    this.movie=movie;
    this.distanceFromBacon=distanceFromBacon;
  }
  
  /**
   * getActor() returns the value of the <B>actor</B>.
   */
  public String getActor() {
    return(actor);
  }
  
  /**
   * getLastActor() returns the value of the <B>lastActor</B>.
   */
  public String getLastActor() {
    return(lastActor);
  }
  
  /**
   * getMovie() returns the value of the <B>movie</B>.
   */
  public String getMovie() {
    return(movie);
  }
  
  /**
   * getDistance() returns the <B>distanceFromBacon</B>.
   */
  public Integer getDistance() {
    return distanceFromBacon;
  }
  
  /**
   * setDistance(newDistance) is used by Djikstra's
   * algorithm to set a distance to a new, smaller, value.
   */
  public void setDistance(Integer newDistance) {
    distanceFromBacon=newDistance;
  }
  
  /**
   * setLastActor(String actor) sets the lastActor to actor.
   */
  public void setLastActor(String actor) {
    lastActor=actor;
  }
  
  /**
   * setMovie(String movie) sets the movie to movie
   */
  public void setMovie(String movie) {
    this.movie=movie;
  }
  
  /**
   * compareTo(otherQuad) compares this BaconQuad to
   * otherQuad.
   * 
   * compareTo(otherQuad) returns:
   * <UL>
   * <LI>a negative value if this BaconQuad is closer to Bacon than
   * otherQuad or both are equidistant from Bacon and
   * the name of the actor for this BaconQuad comes
   * before the name of the actor in otherQuad in 
   * alphabetical order.
   * <LI>zero if this BaconQuad is the same "distance" from
   * Bacon as otherQuad and the actor for this BaconQuad is
   * the same.
   * <LI>a positive value if this BaconQuad is "further" 
   * from Bacon than otherQuad or both are equidistant from
   * Bacon and the name of the actor for this BaconQuad
   * comes after the name of the actor in otherQuad in 
   * alphabetical order.
   * </UL>
   */
  public int compareTo(BaconQuad otherQuad) {
    if(distanceFromBacon.compareTo(otherQuad.getDistance())<0) {
      return(-1);
    }
    else if(distanceFromBacon.compareTo(otherQuad.getDistance())>0) {
      return(1);
    }
    else {
      return(actor.compareTo(otherQuad.getActor()));
    }
  }
  
  /**
   * boolean equals(Object otherQuad) returns true if otherQuad
   * is a BaconQuad and is equally distant from Bacon and
   * contains the same actor as this BaconQuad. (Note this should
   * never happen in Djikstra's algorithm since we should always
   * have only one BaconQuad for a given actor.)
   */
  public boolean equals(Object otherQuad) {
    if(otherQuad instanceof BaconQuad) {
      return(compareTo((BaconQuad)otherQuad)==0);
    }
    else return(false);
  }
  
  /**
   * toString() returns a string representing the BaconQuad
   * in the form <actor,lastActor,movie,distance>
   */
  public String toString() {
    return("<"+actor+","+lastActor+","+movie+","+distanceFromBacon+">");
  }
}