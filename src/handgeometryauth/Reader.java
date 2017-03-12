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
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Reader{
	private static String[] fingers = {"thumb","index","middle","ring","pinkie"};
	private float[] fingerLengthArray;
	private float[] fingerWidthArray;
	private float[] fingerTipToFirstDivisionLengthArray;
	private UserProfile up;
        private BufferedReader br = null;
	private FileReader fr = null;
        private static final String FILENAME = "HandMeasurements.txt";
        private Validator v=new Validator();

	
	public Reader(){
        }
        
	public UserProfile readFromConsole(String str){
            String username;
            fingerLengthArray = new float[5];
            fingerWidthArray = new float[5];
            fingerTipToFirstDivisionLengthArray = new float[5];
            if(str.equals("1")){
                System.out.println("Enter the username:");
                username=v.validateString();
            }
            else{
                username="CheckingUser";
            }
            for(int r=0; r<5; r++){
                System.out.println("enter the "+fingers[r]+" finger length");
                fingerLengthArray[r]=v.validateFloat();
                
            }
            for(int r=0; r<5; r++){
		System.out.println("enter the "+fingers[r]+" finger width");
		fingerWidthArray[r]=v.validateFloat();
            }
            for(int r=0; r<5; r++){
		System.out.println("enter the "+fingers[r]+" finger tip to first division length");
                fingerTipToFirstDivisionLengthArray[r]=v.validateFloat();
            }
		
            up = new UserProfile(username,fingerLengthArray,fingerWidthArray,fingerTipToFirstDivisionLengthArray);
            
              
            return up;	
		
        }
        public UserProfile createUser(String line){
            fingerLengthArray = new float[5];
            fingerWidthArray = new float[5];
            fingerTipToFirstDivisionLengthArray = new float[5];
            UserProfile existingProfile;
            String[] dataStr = line.split("###");
            String username=dataStr[0];
            for(int i=0;i<5;i++){
                fingerLengthArray[i]=Float.parseFloat(dataStr[i+1]);
            }
            for(int  i=0;i<5;i++){
                fingerWidthArray[i]=Float.parseFloat(dataStr[i+6]);
            }
            for(int  i=0;i<5;i++){
                fingerTipToFirstDivisionLengthArray[i]=Float.parseFloat(dataStr[i+11]);
            }
                    
           existingProfile=new UserProfile(username,fingerLengthArray,fingerWidthArray,fingerTipToFirstDivisionLengthArray);
           return existingProfile;
        }
        public String readFromFile(UserProfile checkingProfile){
            String outputStr;
            Comparator comparator= new Comparator((float) 0.95);
            ArrayList<String> usernames = new ArrayList();
            ArrayList<Double> matVals = new ArrayList();
            try {
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);
		String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    UserProfile existingProfile=createUser(sCurrentLine);
                    usernames.add(existingProfile.getUsername());
                    double matVal = comparator.matchingProfile(checkingProfile,existingProfile);
                    matVals.add(matVal); 
                }
                int maxIndex=matVals.indexOf(Collections.max(matVals));
                double finalVal=matVals.get(maxIndex);
                String bestMatch = usernames.get(maxIndex);
                if(finalVal>=comparator.getThreshold()){
                   outputStr="Welcome "+bestMatch+"! Your measurements are accepted ! Successful Login ";
                }
                else{
                   outputStr="Invalid measurements! You are not registered! ";
                }
                
                
            } catch (FileNotFoundException ex) {
                outputStr="File not found";
            } catch (IOException ex) {
                outputStr="IO exception";
                
            }
            return outputStr;
            
        }
}
