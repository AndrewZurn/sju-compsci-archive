public class Candidate 
{
  private String name = "";
  private double vote = 0;
  
  public Candidate(String name, double vote)
  {
    this.name=name;
    this.vote=vote;
  }
  
  public String getName()
  {
    return name;
  }
  
  public double getVote()
  {
    return vote;
  }
  
  public void setName(String name)
  {
    this.name=name;
  }
  
  public void setVote(double vote)
  {
    this.vote=vote;
  }
  
  public String toString()
  {
    return name+"     "+vote+"     ";
  }
}
