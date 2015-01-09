
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author awzurn
 */
public class Bowling {
       public void run(){
        Scanner sc;
        try {
        sc = new Scanner(new File("/net/home/f10/awzurn/CompSci/CS217/Labs/03_26_2012/MICS2008Data",
                "input6.txt"));
         int game=0;
        int frame=0;
        ArrayList<ArrayList<Integer>> scores=new ArrayList<ArrayList<Integer>>();
        scores.add(new ArrayList<Integer>());
        while(sc.hasNext()){
            if(frame==10){
                
                frame=0;
                game++;}
                
            String a=sc.next();
            if(!a.equals("Done")){
                if(!a.equals("X")){
                    String b=sc.next();
                    if(!b.equals("/")){
                        scores.get(game).add(Integer.parseInt(a)+Integer.parseInt(b));}
                    if(b.equals("/")){
                         scores.get(game).add(10);}
                    if(a.equals("X")){
                         scores.get(game).add(20);}
                    frame++;
                    
                            
                    }
                    }
                }
        ArrayList<Integer> gameScore=new ArrayList<Integer>();
        for(int p=0;p<scores.size();p++){
          gameScore.add(0);  
        
            for(int r=0;r<scores.get(p).size();r++){
                if((scores.get(p).get(r)!=20)&&(scores.get(p).get(r)!=10)){
              try{gameScore.set(p,gameScore.get(p)+scores.get(p).get(9-r));}
                catch(Exception e){
                    gameScore.add(scores.get(p).get(r));}
              if(scores.get(p).get(r)=20){
                  try{gameScore.add(scores.get(p),scores.get(p).get(9-r)+)
              }
                
                
            }
            }
        }
        }
        catch (Exception e){
        System.out.println("failure");
        }
       
       
      
       }
}
                
       
        
        

