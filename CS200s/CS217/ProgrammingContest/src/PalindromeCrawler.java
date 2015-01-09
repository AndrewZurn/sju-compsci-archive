import java.util.*;
import java.io.*;
/**
 *
 * @author awzurn
 */
public class PalindromeCrawler {
    
    public PalindromeCrawler(ArrayList<String> stringList, int num){
        ArrayList<String> originalWords = new ArrayList<String>();
        ArrayList<String> palindromes = new ArrayList<String>();
        originalWords = stringList;
        System.out.println(subList(originalWords));
    }
    
    public ArrayList<String> subList(ArrayList<String> originalList){
        boolean tr = true;
        int cheat = 3;
        ArrayList<String> newList = new ArrayList<String>();
        for(String str: originalList){
           int num = str.length();
           int place = 3;
           int where = 3;
           while(place<=num){
               tr = true;
               where = place;
               for(int i = 0; i<num; i++){
                   if(where>num){
                   newList.add(str.substring(i, where-2));
                   }
                   else if(num>where){
                   newList.add(str.substring(i, where));
                   where++;
                   }
               }
               place++;
               if(tr == true && cheat >= 0){
               newList.add(str.substring(str.length()-cheat, str.length()));
               cheat++;
               tr = false;
               }
           }
        }
        return newList;
    }
    
    public static void main(String args[]) throws Exception{
        ArrayList<String> stringList = new ArrayList<String>();
        int num = 0;
        Scanner sc = new Scanner(new File("/net/home/f10/awzurn/CompSci/CS217/ProgrammingContest/build/classes",
                "inputP.txt"));
        num = sc.nextInt();
        while(sc.hasNext()){
            stringList.add(sc.next());
        }
        new PalindromeCrawler(stringList, num);
        System.out.println(stringList);
        System.out.println(num);
    }
}
