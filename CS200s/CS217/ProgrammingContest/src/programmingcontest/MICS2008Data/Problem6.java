

import java.io.*;
import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author awzurn
 */
public class Problem6 {
    
    public void run(){
        Scanner sc = null;
        try {
        sc = new Scanner("input6.txt"));
        }
        catch (Exception e){}
    
    
        ArrayList<ArrayList<String>> echo2 = new ArrayList<ArrayList<String>>();
        while (sc.hasNextLine()){
            String temp = sc.nextLine();
            char[] temp2 = temp.toCharArray();
            ArrayList<String> echo = new ArrayList<String>();
            for(int i=0; i<temp2.length; i++){
                char n = temp2[i];
                if (n=='h' || n=='t' || n=='H' || n=='T'){
                    String temp3 = ""+n;
                    echo.add(temp3);
                }
            }
            echo2.add(echo);
        }
        
        for (int i=0; i<echo2.size(); i++){
            int[] temp = check(echo2.get(i));
            for(int j=0; j<echo2.get(i).size(); j++){
                System.out.print(echo2.get(i).get(j));
            }
            System.out.println();
            System.out.println("longest run of heads is " + temp[0]);
            System.out.println("longest run of tails is " + temp[1]);
            System.out.println();
        }
        
        
    
    }
    
    public int[] check(ArrayList<String> temp){
        int hCount=0, hfCount=0, tCount=0 ,tfCount=0;
        int[] ans = new int[2];
        for (int i=0; i<temp.size(); i++){
            if (temp.get(i).equalsIgnoreCase("h")){
                if (tCount>tfCount){
                    tfCount=tCount;
                }
                tCount=0;
                hCount++;
            }
            else {
                if (hCount>hfCount){
                    hfCount=hCount;
                }
                hCount=0;
                tCount++;
            }
        }
        if (tCount>tfCount){
            tfCount=tCount;
        }
        if (hCount>hfCount){
            hfCount=hCount;
        }
        ans[0]=hfCount;
        ans[1]=tfCount;
        
        
        
        return ans;
    }
    
    public static void main(String[] args){
        new Problem6().run();
    }
    
    
}
