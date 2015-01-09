public class Combinatorics{
  
  public static double run(){
    double count = 0.0;
    String currentString ="AAAAAA";
    String endString ="ZZZZZZ";
    System.out.println(currentString.compareTo(endString));
    while((currentString.compareTo(endString))<0){ //check this later
      char[] charArray;
      charArray = currentString.toCharArray();
      int charCount1 = 0;
      int charCount2 = 0;
      Character x = 'C';
      for(int i = 0; i<charArray.length; i++){
        x = charArray[i];
        if(x.compareTo('A') == 0 ){
          charCount1++;
        }
        else if(x.compareTo('B') == 0  ){
          charCount2++;
        }
      }
      if(charCount1 == 2 && charCount2 == 2 ){
        count ++;
      }
      currentString = increment(currentString);
    }
    return count;
  }
  
  public static String increment(String string){
    int current = string.length()-1;
    char[] charArray;
    charArray = string.toCharArray();
    Character x = charArray[current];
    while(current >= 0 && x.compareTo('Z') == 0){
      charArray[current] = 'A';
      current--;
      x = charArray[current];
    }
    if(current<0){
      return ("a");
    }
    else{
      charArray[current]++;
    }
    String newString = "";
    return (newString.valueOf(charArray));
  }
  
  
  public static void main(String[] args){
    System.out.println(run());
  }
  
}