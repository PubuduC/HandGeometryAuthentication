/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handgeometryauth;

import java.util.Scanner;

/**
 *
 * @author PubuduC
 */
public class HandGeometryAuth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        /*
        System.out.println("Welcome to Hand Authentication Logging System");
        System.out.println("If you want to register enter (1)");
        System.out.println("If you want to log in enter (2)");
        while(true){
            Reader rd = new Reader();
            Validator v = new Validator();
            Scanner sc = new Scanner(System.in);
            String str =sc.nextLine();
            if(str.equals("1")){
                UserProfile newProfile = rd.readFromConsole(str);
                Writer wr = new Writer();
                wr.writeToTheFile(newProfile);
                System.out.println("you are registered!");
                break;
              
            }
            else if(str.equals("2")){
                UserProfile checkingProfile = rd.readFromConsole(str);
                rd.readFromFile(checkingProfile);
                break;
 
            }else{
                System.out.println("Enter 1 or 2!");
            }
        
        }
     */
        new SelectionForm().setVisible(true);
        
        
    }
    
}
