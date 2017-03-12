/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handgeometryauth;

/**
 *
 * @author PubuduC
 */

public class Comparator {
    private float threshold;
    
    public Comparator(float threshold){
        this.threshold=threshold;
    }
    
    public float getThreshold(){
        return threshold;
    }
    public double matchingProfile(UserProfile up1,UserProfile up2){
        double matchingVal=0;
        for(int i=0;i<5;i++){
            float ratioOfLengths = up1.getFingerLength()[i]/up2.getFingerLength()[i];
            matchingVal=matchingVal+(ratioOfLengths<=1 ? ratioOfLengths: 1/ratioOfLengths);
            
            float ratioOfWidths = up1.getFingerLength()[i]/up2.getFingerLength()[i];
            matchingVal=matchingVal+(ratioOfWidths<=1 ? ratioOfWidths: 1/ratioOfWidths);
           
            float ratioOfFirstDivisionLengths = up1.getFingerTipToFirstDivisionLength()[i]/up2.getFingerTipToFirstDivisionLength()[i];
            matchingVal=matchingVal+(ratioOfFirstDivisionLengths<=1 ? ratioOfFirstDivisionLengths: 1/ratioOfFirstDivisionLengths);
            
                    
        }
        return matchingVal/15;
    }
    
}

