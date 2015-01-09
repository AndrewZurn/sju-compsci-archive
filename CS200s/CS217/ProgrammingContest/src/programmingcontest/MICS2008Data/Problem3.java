/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingcontest.MICS2008Data;
import java.io.*;
import java.util.*;
/**
 *
 * @author awzurn
 */
public class Problem3 {
    
    public Problem3(Integer low, Integer high){
        Integer current = low;
        while(current<=high){
        if(isPrime(current) && isPalindrome(current)){
            System.out.println(current);
            }
        current++;
        }
        
        
    }
    
    public boolean isPrime(Integer number){
        boolean value = false;
        if(number == 1){
            return true;
        }
        else if(number == 2){
            return true;
        }
        else if(number == 3){
            return true;
        }
        else if(number == 5){
            return true;
        }
        else if(number == 7){
            return true;
        }
        for(int i = 2; i<number; i++){
            if(number % i == 0){
            value = false;
            break;
            }
            else{
                value = true;
            }
        
        }
        return value;
    }
    
    public boolean isPalindrome(Integer number){
        boolean value = false;
        Stack<Character> stack = new Stack<Character>();
        Integer current = number;
        String currentString = number.toString();
           for(int i = 0; i < currentString.length(); i++){
               stack.push(currentString.charAt(i));
           }
           for(int i = 0; i < stack.size(); i++){
               if(!stack.isEmpty()){
                   Character num = stack.pop();
                   Character num1 = currentString.charAt(i);
                   if(num.equals(num1)){
                       value = true;
                   }   
                    else{
                        value = false;
                        break;
                   }
               }
           }
           return value;
        }
    
    public static void main(String arg[]) throws Exception{
        Scanner sc = new Scanner(new File("/net/home/f10/awzurn/CompSci/CS217/Labs/03_26_2012/MICS2008Data",
                "input3.txt"));
        Integer low = new Integer(sc.nextInt());
        Integer high = new Integer(sc.nextInt());
        Problem3 prob3 = new Problem3(low, high);
    }
}
