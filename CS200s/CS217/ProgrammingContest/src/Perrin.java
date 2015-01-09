/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author awzurn
 */
public class Perrin {
    
    public Perrin(){
        ArrayList<Integer> prime = new ArrayList<Integer>();
        ArrayList<Integer> answers = new ArrayList<Integer>();
        prime.add(2);
        prime.add(3);
        prime.add(5);
        prime.add(7);
        prime.add(11);
        prime.add(13);
        prime.add(17);
        prime.add(19);
        prime.add(23);
        prime.add(29);
        prime.add(31);
        prime.add(37);
        prime.add(41);
        prime.add(43);
        prime.add(47);
        prime.add(53);
        prime.add(59);
        prime.add(61);
        prime.add(67);
        prime.add(71);
        prime.add(73);
        prime.add(79);
        prime.add(83);
        prime.add(89);
        prime.add(97);
        prime.add(101);
        prime.add(107);
        prime.add(109);
        prime.add(113);
        
        answers.add(3);
        answers.add(0);
        answers.add(2);
        for (int i=3; i<=113; i++){
            answers.add(answers.get(i-2) + answers.get(i-3));
        }
        for (int i=1; i<prime.size(); i++){
            int a = answers.get(prime.get(i));
            int p = answers.get(i);
            System.out.print("P(" + i + ") = " + p + "; A(P(" +i+ ")) = " +a
                    +"; " + a + " modulus " + p+ " => 0");
            System.out.println();
        }
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    public static void main (String[] args){
        new Perrin();
    }
    
}
