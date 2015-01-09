import java.io.*;
import java.util.*;

public class Problem1{
  private ArrayList<String> keywordList = new ArrayList<String>();
  private ArrayList<String> excuseList = new ArrayList<String>();
  private TreeMap<Integer, ArrayList<String>> keywordMap = new TreeMap<Integer, ArrayList<String>>();
  private TreeMap<Integer, ArrayList<String>> excuseMap = new TreeMap<Integer, ArrayList<String>>();
  private int numKeywords = 0;
  private int numExcuses = 0;
  
  public Problem1(File file) throws Exception{
    Scanner sc = new Scanner(file);
    int prob = 0;
    numKeywords = sc.nextInt();
    numExcuses = sc.nextInt();
    
    while(sc.hasNext()){
      String keyword = "";
      for(int i = 0; i<numKeywords; i++){
        keyword = sc.next();
        keyword = keyword.replaceAll(", ", "");
        keywordList.add(keyword);
      }
      keywordMap.put(prob, keywordList);
      for(int i = 0; i<numExcuses+1; i++){
        excuseList.add(sc.nextLine());
      }
      excuseMap.put(prob, excuseList);
      
      System.out.println(keywordMap.get(prob));
      System.out.println(excuseMap.get(prob));
      excuseList.clear();
      keywordList.clear();
      if(sc.hasNext() == (false)){
        break;
      }
      numKeywords = sc.nextInt();
      numExcuses = sc.nextInt();
      prob++;
    }
    System.out.println(numKeywords);
    System.out.println(numExcuses);
  }
  
  public TreeMap<Integer, Integer> findExcuse(){
    ArrayList<String> keyword = new ArrayList<String>();
    ArrayList<String> excuse = new ArrayList<String>();
    ArrayList<String> answer = new ArrayList<String>();
    ArrayList<Integer> answerInt = new ArrayList<Integer>();
    TreeMap<Integer, Integer> incidenceList2 = new TreeMap<Integer, Integer>();
    int find = 0;
    for(int j = 0; j<keywordMap.size(); j++){
      keyword = keywordMap.get(j);
      excuse = excuseMap.get(j);
      for(int l = 0; l<excuse.size(); l++){   
        TreeMap<Integer, Integer> incidenceList = new TreeMap<Integer, Integer>();
        int times = 0;
        for(int k = 0; k<keyword.size(); k++){
          if (excuse.get(l).toLowerCase().contains(keyword.get(k).toLowerCase())){
            times++;
          }
        }
        incidenceList.put(l, times);
        incidenceList2 = incidenceList;
      }
      for(int z = 1; z<=incidenceList2.size(); z++){
        if(incidenceList2.get(z-1) < incidenceList2.get(z)){
          find = z-1;
        }
        else if(incidenceList2.get(z-1) > incidenceList2.get(z)){
          find = z;
        }
        answerInt.add(find);
        Integer ansInt = 0;
        for(int y = 1;y<=answerInt.size(); y++){
          if(answerInt.get(y-1) < answerInt.get(y)){
            ansInt = answerInt.get(y-1);
          }
        }
        
      }
    }
    return incidenceList;
  }
  
  
  
  
  public static void main(String args[]) throws Exception{
    new Problem1(new File("/net/home/f10/awzurn/CompSci/CS217/Labs/02_14_2012", "Excuses.in"));
  }
}