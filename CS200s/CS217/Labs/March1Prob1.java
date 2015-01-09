import java.util.*;
import java.io.*;
import fileChooser.*;
import zhstructures.*;
public class March1Prob1{
  private String nextLine = "";
  private ArrayList<ZHCompPair<String, Integer>> nameList1 = new ArrayList<ZHCompPair<String, Integer>>();
  private ArrayList<ZHCompPair<String, Integer>> nameList2 = new ArrayList<ZHCompPair<String, Integer>>();
  private ZHCompPair<String, Integer> pair;
  
  public March1Prob1() throws Exception{
    Scanner sc = new Scanner(new File("/net/home/f10/awzurn/CompSci/CS217/Labs/02_22_2013/input", "erdos2.in"));
    sc.nextLine();
    while(sc.hasNext()){
      nextLine = sc.nextLine();
      if(nextLine.contains("Erdos")){
        String nameAndPaper[] = nextLine.split(":");
        String name[] = nameAndPaper[0].split(",");
        String name1 = name[1] + name[0];
        String name2 = name[3] + name[2];
        pair = new ZHCompPair((String) name2,(Integer) 1);
      }
      nameList1.add(pair);
    }
    sc.close();
    Scanner sc1 = new Scanner(new File("/net/home/f10/awzurn/CompSci/CS217/Labs/02_22_2013/input", "erdos2.in"));
    sc1.nextLine();
    while(sc1.hasNext()){
      nextLine = sc1.nextLine();
      String nameAndPaper[] = nextLine.split(":");
      String name[] = nameAndPaper[0].split(",");
      String name1 = name[1] + name[0];
      String name2 = name[3] + name[2];
      for(ZHCompPair zh: nameList1){
        if(zh.getKey().equals(name1) || zh.getKey().equals(name2)){
          pair = new ZHCompPair((String) name2,(Integer) 2);
          nameList2.add(pair);
         
        }
      }
    }
  }
    
    
    public static void main(String args[]) throws Exception{
      new March1Prob1();
    }
  }