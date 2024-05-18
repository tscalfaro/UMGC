/*
   Created by: Antonio Scalfaro
   CMIS 141/6384
   Discussion Week 6
   This program accepts two integer inputs from the user and prints the halfway number between both input ints
*/

import java.util.Scanner;

public class ScalfaroAntonio_DiscWeek6{

   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141/6384");
      System.out.println("Discussion Week 6");
      System.out.println("This program collects input from the user for two integers, and returns the number that is half way between those two numbers");
   }
   
   //print the halfpoint of the two ints provided 
   public static void halfpoint(int[] numbers){
      System.out.printf("The number half way between both input numbers is " + ((numbers[0] + numbers[1]) / 2));
   }

   public static void main(String[] args){
      int[] numbers = new int[2];
      welcomeMessage();
      
      Scanner scan = new Scanner(System.in);
      System.out.println("What is the first number?");
      //validate user input
      if(scan.hasNextInt()){
         numbers[0] = scan.nextInt();
      } else {
         System.err.println("Please input integer values");
      }
      
      System.out.println("What is the second number?");
      //validate user input
      if(scan.hasNextInt()){
         numbers[1] = scan.nextInt();
      } else {
         System.err.println("Please input integer values");
      }
      
      //Ensure both user inputs have been accepted and stored and call halfpoint passing numbers array
      if(numbers[0] != 0 & numbers[1] != 0){
         halfpoint(numbers);
      }
      
      scan.close();
      
   }

}