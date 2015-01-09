import java.util.*;

public class TryCollections {
  private ArrayList<Character> charArray;
  private TreeSet<Character> treeSet;
  private HashSet<Character> hashSet;
  public void dumpIt(Collection<Character> col) {
    for(char c='Z';c>='A';c--) {
      col.add(c);
    }
    for(Character c:col) {
      System.out.print(" "+c);
    }
    System.out.println();
  }
  public static void main(String [] args) {
    new TryCollections().run();
  }
  public void run() {
    charArray=new ArrayList<Character>();
    treeSet=new TreeSet<Character>();
    hashSet=new HashSet<Character>();
    dumpIt(charArray);
    dumpIt(treeSet);
    dumpIt(hashSet);
  }
}