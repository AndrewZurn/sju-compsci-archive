public class Area{
  private boolean northOpen = true;
  private boolean southOpen = true;
  private boolean westOpen = true;
  private boolean eastOpen = true;
  
  public Area(){
    
  }
  
    public boolean getNorth(){
      return northOpen;
    }
    
    public void setNorth(boolean bool){
      northOpen = bool;
    }
    
    public boolean getSouth(){
      return southOpen;
    }
    
    public void setSouth(boolean bool){
      southOpen = bool;
    }
    
    public boolean getWest(){
      return westOpen;
    }
    
    public void setWest(boolean bool){
      westOpen = bool;
    }
    
    public boolean getEast(){
      return eastOpen;
    }
    
    public void setEast(boolean bool){
      eastOpen = bool;
    }
  
  public static void main(String[] args){
    
  }
}