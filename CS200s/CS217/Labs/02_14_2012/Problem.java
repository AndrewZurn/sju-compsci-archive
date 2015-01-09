import java.util.*;



public class Problem {
  
  Scanner sc = new Scanner(System.in);
  ArrayList<String> b,i,n,g,o;
  ArrayList<Integer> numbers, calls, called;
  Random generator = new Random();
  int x, y;
  
  public Problem() {
    
    for (int k=0; k<5; k++) {
      
      ArrayList<String> b = new ArrayList<String>();
      b.add("16");
      b.add("5");
      b.add("20");
      b.add("2");
      b.add("11");
      ArrayList<String> i = new ArrayList<String>();
      b.add("37");
      b.add("40");
      b.add("39");
      b.add("25");
      b.add("22");
      ArrayList<String> n = new ArrayList<String>();
      b.add("44");
      b.add("55");
      b.add("51");
      b.add("60");
      b.add("47");
      ArrayList<String> g = new ArrayList<String>();
      b.add("61");
      b.add("63");
      b.add("73");
      b.add("71");
      b.add("79");
      ArrayList<String> o = new ArrayList<String>();
      b.add("90");
      b.add("100");
      b.add("94");
      b.add("86");
      b.add("82");
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      ArrayList<Integer> calls = new ArrayList<Integer>();
      
      for (int j=1; j<101; j++){
        numbers.add(j); 
      }
      for (int j=0; j<100; j++){
        x=generator.nextInt(100-j);
        calls.add(numbers.get(x));
        numbers.remove(x);
      }
      for (int j=0; j<100; j++) {
        System.out.println(calls.get(j));
      }
      
      ArrayList<Integer> called = new ArrayList<Integer>();
      for (int j=0; j<100; j++){
        
        x=calls.get(j);
        called.add(x);
        if (x>0 && x<21) {
          if (b.contains(x)) {
            for (int l=0; l<5; l++){
              if (b.get(l)==x){
                y=l; 
              }
            }
            b.set(y, ""+x+"*");
          }
        }
        else if (x>20 && x<41){
          if (i.contains(x)) {
            for (int l=0; l<5; l++){
              if (i.get(l)==x){
                y=l; 
              }
            }
            i.set(y, ""+x+"*");
          }
        }
        else if (x>40 && x<61){
          if (n.contains(x)) {
            for (int l=0; l<5; l++){
              if (n.get(l)==x){
                y=l; 
              }
            }
            n.set(y, ""+x+"*");
          }
        }
        else if (x>60 && x<81){
          if (g.contains(x)) {
            for (int l=0; l<5; l++){
              if (g.get(l)==x){
                y=l; 
              }
            }
            g.set(y, ""+x+"*");
          }
        }
        else {
          if (o.contains(x)) {
            for (int l=0; l<5; l++){
              if (o.get(l)==x){
                y=l; 
              }
            }
            o.set(y, ""+x+"*");
          }
        }
        
        if (cornerCheck()) {
          break;
        }
        if (diag1Check()) {
          break;
        }
        if (diag2Check()) {
          break;
        }
        if (horzCheck()) {
          break;
        }
        if (vert1Check()) {
          break;
        }
        if (vert2Check()) {
          break;
        }
        if (vert3Check()) {
          break;
        }
        if (vert4Check()) {
          break;
        }
        if (vert5Check()) {
          break;
        }
        
        
        
      }
      
      
      
      //Print stuff!
      
      
      
    }
    
    
    
  }
  
  public boolean cornerCheck (){
    if (b.get(0).contains('*') && b.get(4).contains('*') && o.get(0).contains('*') && o.get(4).contains('*')){
      return true;
    }
    else { return false;}
  }
  
  public boolean diag1Check (){
    if (b.get(0).contains('*') && i.get(1).contains('*') && 
        n.get(2).contains('*') && g.get(3).contains('*') && o.get(4).contains('*')){
      return true;
    }
    else { return false;}
    
  }
  
  public boolean diag2Check (){
    if (b.get(4).contains('*') && i.get(3).contains('*') && 
        n.get(2).contains('*') && g.get(1).contains('*') && o.get(0).contains('*')){
      return true;
    }
    else { return false;}
    
  }
  
  public boolean horzCheck(){
    for (int p=0; p<5; p++){
      if (b.get(p).contains('*') && i.get(p).contains('*') && 
          n.get(p).contains('*') && g.get(p).contains('*') && o.get(p).contains('*')){
        return true;
      }
      else {return false;}
    }
  }
  
  public boolean vert1Check(){
      if (b.get(0).contains('*') && b.get(1).contains('*') && 
          b.get(2).contains('*') && b.get(3).contains('*') && b.get(4).contains('*')){
        return true;
      }
      else {return false;}
  }
  
  public boolean vert2Check(){
      if (i.get(0).contains('*') && i.get(1).contains('*') && 
          i.get(2).contains('*') && i.get(3).contains('*') && i.get(4).contains('*')){
        return true;
      }
      else {return false;}
  }
  
  public boolean vert3Check(){
      if (n.get(0).contains('*') && n.get(1).contains('*') && 
          n.get(2).contains('*') && n.get(3).contains('*') && n.get(4).contains('*')){
        return true;
      }
      else {return false;}
  }
  
  public boolean vert4Check(){
      if (g.get(0).contains('*') && g.get(1).contains('*') && 
          g.get(2).contains('*') && g.get(3).contains('*') && g.get(4).contains('*')){
        return true;
      }
      else {return false;}
  }
  
  public boolean vert5Check(){
      if (o.get(0).contains('*') && o.get(1).contains('*') && 
          o.get(2).contains('*') && o.get(3).contains('*') && o.get(4).contains('*')){
        return true;
      }
      else {return false;}
  }
  
  public static void main (String args[]){
    new Problem();
  }
  
  
  
}