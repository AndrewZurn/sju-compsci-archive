/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingcontest.MICS2008Data;

import java.io.File;
import java.util.Scanner;
import java.util.*;
//import zhstructures.ZHTreeMap;

/**
 *
 * @author awzurn
 */
public class Problem8 {
    private ArrayList<String> stringList = new ArrayList<String>();
    private TreeMap<Double, ArrayList<String>> treeMap = new TreeMap<Double, ArrayList<String>>();
    
    public Problem8(ArrayList<Integer> front, ArrayList<Integer> back){
        Double num;
        for(Integer fr: front){
            for(Integer ba: back){
                num = new Double((double) fr/ba);
                /*ArrayList<String>*/ stringList = new ArrayList<String>();
                stringList.add(fr.toString() + ":" + ba.toString());
                if(treeMap.containsKey(num)){
                    stringList = treeMap.get(num);
                    if(stringList.contains(fr.toString() + ":" + ba.toString())){
                        treeMap.put(num,stringList);
                    }
                    else{
                        stringList.add(fr.toString() + ":" + ba.toString());
                        treeMap.put(num, stringList);
                    }
                }
                else{
                    treeMap.put(num, stringList);
                }
            }
        }
        
        for(Double numb: treeMap.keySet()){
            for(String str: treeMap.get(numb)){
            System.out.println(str);
            }
        }
    }
    
    
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(new File("input8.txt"));
        ArrayList<Integer> front = new ArrayList<Integer>();
        ArrayList<Integer> back = new ArrayList<Integer>();
        front.add(sc.nextInt());
        front.add(sc.nextInt());
        front.add(sc.nextInt());
        back.add(sc.nextInt());
        back.add(sc.nextInt());
        back.add(sc.nextInt());
        back.add(sc.nextInt());
        back.add(sc.nextInt());
        back.add(sc.nextInt());
        back.add(sc.nextInt());
        back.add(sc.nextInt());
        back.add(sc.nextInt());
        Problem8 problem8 = new Problem8(front, back);
    }
}
