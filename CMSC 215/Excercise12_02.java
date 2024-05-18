/*
Created by: Antonio Scalfaro
CMSC 215 / 6381
9/01/2023
Week 3 Discusion - Ch 12 Programming Project 2 

This program converts an input string from binary to decimal. Throws NumberFormatException for incorrect string input
*/
import java.util.Scanner;

public class Excercise12_02{

   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMSC 215 / 6381");
      System.out.println("09/01/2023");
      System.out.println("Chapter 12 programming project 2");
      System.out.println("\nThis program accepts a binary string from the user and converts it to decimal");
   }
   
   //Prints decimal version of  binary string or throws exception for wrong format
   public static void bin2dec(String binaryString) throws NumberFormatException{
      try{
         int decimalNum = Integer.parseInt(binaryString, 2);
         System.out.println("The decimal version of " + binaryString + " is " + decimalNum);
      } catch (NumberFormatException ex){
         System.out.println("Please input a binary number for the string.");
      }
   }

   //Main method, gathers input and calls bin2dec and welcomeMessage
   public static void main(String[] args){
      welcomeMessage();
      Scanner scan = new Scanner(System.in);
      double l1 = scan.nextDouble();
      double l2 = scan.nextDouble();
      String line = scan.nextLine();
      
      System.out.println(l1 + " " + l2 + " " + line + "s");
     //  System.out.println("Please enter a binary number:");
//       
//       String binNum = scan.nextLine();
//       bin2dec(binNum);
//       
      scan.close();
   }
}