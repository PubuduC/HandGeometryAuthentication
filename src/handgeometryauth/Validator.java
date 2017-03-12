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
public class Validator {
    public float validateFloat(){
        Scanner Sc= new Scanner(System.in);
        float i;
        try{
            i = Sc.nextFloat();
        }catch(Exception e){
            System.out.println("Invalid Input re-enter the value:");
            i=0;
        }
        if(i==0){
            i=validateFloat();
        }
        return i;
    }
    public String validateString(){
        Scanner sc=new Scanner(System.in);
        String i="";
        i = sc.nextLine();
        if(!(i.chars().allMatch(Character::isLetter))){
            System.out.println("Invalid Input re-enter the value:");
            i=validateString();
        }
        return i;
    }
    
    
}

