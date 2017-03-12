/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handgeometryauth;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PubuduC
 */
public class Writer {
    private static final String FILENAME = "HandMeasurements.txt";
    PrintWriter out = null;
    
    private String writeLineToTheFile="";
    private String delimiter = "###";
    
    public Writer(){
    }
    
    public void writeToTheFile(UserProfile up){
        try {
            out=new PrintWriter(new FileWriter(FILENAME,true));
            writeLineToTheFile=writeLineToTheFile+up.getUsername()+delimiter;
            for(int i=0; i<5;i++){
                writeLineToTheFile=writeLineToTheFile+up.getFingerLength()[i]+delimiter;
            }
            for(int i=0; i<5;i++){
                writeLineToTheFile=writeLineToTheFile+up.getFingerWidth()[i]+delimiter;
            }
            for(int i=0; i<5;i++){
                writeLineToTheFile=writeLineToTheFile+up.getFingerTipToFirstDivisionLength()[i]+delimiter;
            }
            out.println(writeLineToTheFile);
            out.close();
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
