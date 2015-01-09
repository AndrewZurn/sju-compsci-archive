import java.util.*;

public class SimpleStringTester  {
  String s1, s2;
  Scanner sc;
  String[] words;
 public void run() {
   int weight;
   s2 = "";
   sc = new Scanner(System.in);
   System.out.println("Enter a string"); 
   s1 = sc.nextLine();
   words = s1.split("\\b");
   for (int i = 0; i<words.length; i++){
     System.out.println(words[i]);
   } 
 }

 public static void main(String [] args){
   SimpleStringTester app = new SimpleStringTester();
   app.run();
 }
}
  
      
      
 