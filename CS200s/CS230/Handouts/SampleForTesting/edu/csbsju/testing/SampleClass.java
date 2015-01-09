/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csbsju.testing;

import java.util.Arrays;

/**
 *
 * @author irahal
 */
public class SampleClass {
    private int classSize;
    private double[] classScores;

    public SampleClass(int classSize) {
        this.classSize = classSize;
        this.classScores = new double[classSize];
    }

    /**
     * @return the classSize
     */
    public int getClassSize() {
        return classSize;
    }

    /**
     * @param classSize the classSize to set
     */
    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    /**
     * @return the classScores
     */
    public double[] getClassScores() {
        return classScores;
    }

    /**
     * @param classScores the classScores to set
     */
    public void setClassScores(double[] classScores) {
        this.classScores = classScores;
    }
    
    public double getAverage(){
        double sum=0;
        for(int i=0;i<this.classSize;i++)
            sum += this.classScores[i];
        return sum/this.classSize;
    }
    
    public double getMedian(){
        double[] copy = new double[this.classSize];
        System.arraycopy(this.classScores, 0, copy, 0, copy.length);
        Arrays.sort(copy);
        if (copy.length % 2 == 0) {
            return (copy[(copy.length / 2) - 1] + copy[copy.length / 2]) / 2.0;
        } 
        else {
            return copy[copy.length / 2];
        }
    }

}
