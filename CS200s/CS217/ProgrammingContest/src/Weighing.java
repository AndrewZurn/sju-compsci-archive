
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author awzurn
 */
public class Weighing {
public Weighing(String fileName) throws Exception{
        Scanner sc = new Scanner(new File(fileName));
    ArrayList<Integer> Base3;
    ArrayList<ArrayList<String>> results=new ArrayList<ArrayList<String>> ();
    int reps=sc.nextInt();

    for(int i =0; i<reps;i++){
        ArrayList<Double> l=new ArrayList<Double>();
        ArrayList<Double> r=new ArrayList<Double>();
        Base3=new ArrayList<Integer>();
        int p=sc.nextInt();
        while(p!=0){
            Base3.add(p%3);
            p=p/3;
        }
        Base3.add(0);
       
        for(int q=0;q<Base3.size();q++){
            if(Base3.get(q)==1){
            Double x=new Double(q);
                l.add(Math.pow(3.0,x));
            }
            else if(Base3.get(q)==2){
         Double x=new Double(q);
            r.add(Math.pow(3.0, x));
            Base3.set(q+1,Base3.get(q+1)+1);
       
}

               
            
        }
        TreeSet right=new TreeSet();
        TreeSet left=new TreeSet();
            for(int v=0;v<r.size();v++)
       {right.add(r.get(v));}
                  for(int qr=0;qr<l.size();qr++)
       {left.add(l.get(qr));}
        
        
          System.out.print("left pan: ");
            for(int v=0;v<r.size();v++)
       {System.out.print(right.pollLast()+ " ");}
        System.out.print("right pan: ");
       for(int qr=0;qr<l.size();qr++)
       {System.out.print(left.pollLast() + " ");}
       System.out.print('\n');

    }
             
    }
    
    public static void main(String[] args) throws Exception{
        new Weighing(args[0]);
    }
    
}
