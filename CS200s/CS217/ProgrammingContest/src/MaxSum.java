/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 *
 * @author awzurn
 */
public class MaxSum {
    
    public MaxSum(String fileName) throws Exception{
        Scanner sc = new Scanner(new File(fileName));
        int temp=0, inputCount = 0;
        int input = sc.nextInt();
        
        while (inputCount<input){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int length = sc.nextInt();
            for (int k=0; k<length; k++){
                list.add(sc.nextInt());
            }
            int max=0, count=1;
            while (count<=list.size()){
                for (int i=0; i<list.size(); i++){
                    for (int j=0; j<count; j++){
                        if (i+j>=list.size()){
                            break;
                        }
                        else {
                            temp+=list.get(i+j);
                        }
                    }
                    if (temp>max){
                        max=temp;
                    }
                    temp=0;
                }
                count++;
            }
            System.out.println(max);
            inputCount++;
            
        }
        
    }
    
    
    public static void main(String[] args) throws Exception{
        new MaxSum(args[0]);
    }
    
    
}
