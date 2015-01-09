public class NewTelephoneCompany{
  private int hours;
  private int length;
  private double charge;
  private static final double tax=0.04;
  private static final double cost=40;
  private static final double hoursDiscount=0.5;
  private static final double lengthDiscount=0.15;
  
  public int getHours(){
    return this.hours;
  }
  
  public void setHours(int hours){
    this.hours=hours;
  }
  
  public int getLength(){
    return this.length;
  }
  
  public void setLength(int length){
    this.length = length;
  }
  
  public double computeCharge() throws Exception{
    if (hours<0 || hours>=2400){
      throw new Exception("Invalid HOURS");
    }
    else if(length<0){
      throw new Exception("Invalid LENGTH");
    }
    else if ((hours<800) || (hours>=1800)){
      if (length>60){
        charge=length*cost*hoursDiscount*(1-lengthDiscount);
      }
      else{
        charge=length*cost*hoursDiscount;
      }
    }
    else{
       if (length>60){
        charge=length*cost*(1-lengthDiscount);
      }
      else{
        charge=length*cost;
      }
    }
     return charge;
  }
  
 /* public static void main(String args[]){
    NewTelephoneCompany ntc = new NewTelephoneCompany();
    ntc.setHours(1000);
    ntc.setLength(10);
    try{
      System.out.println("Hours=" + ntc.getHours()+ " and Length=" + ntc.getLength() + " ==> charge=" + ntc.computeCharge() + " cents");
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }*/
  
}
