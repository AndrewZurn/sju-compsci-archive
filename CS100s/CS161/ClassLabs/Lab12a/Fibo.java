import objectdraw.*;
import java.awt.*;

public class Fibo{
  public double Fibo (double n){
    if (n==1){
      return 1;
    }
    else if(n==2){
      return 1;
    }
    else {
      return Fibo(n-1) + Fibo(n-2);
    }
  }
}
