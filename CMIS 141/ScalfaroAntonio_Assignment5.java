/*
   Created by: Antonio Scalfaro
   CMIS 141 / 6384 6/26/2023
   This program will provide the user with 4 options of functionality: 1)Convert cubic feet to US bushels 
   2)Convert miles to kilometers 3)Determine graduation with honors 4)Exit Program
*/

import java.util.Scanner;
import java.util.InputMismatchException;


public class ScalfaroAntonio_Assignment5{
   
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141 / 6384 6/26/2023\n");
      System.out.println("This program will provide the user with 4 options of functionality: 1)Convert cubic feet to US bushels ");
      System.out.println("2)Convert miles to kilometers 3)Determine graduation with honors 4)Exit Program");
   }
   
   //Gathers input for functionality selecetion and validates input
   public static int functionChoice(Scanner scan){
      int input;
      
      System.out.println("\nPlease select an option:\n");
      System.out.println("1)Convert cubic feet to US bushels\n");
      System.out.println("2)Convert miles to kilometers\n");
      System.out.println("3)Determine graduation with honors\n");
      System.out.println("4)Exit\n");
      
      
      //Validate input, invalid returns functionChoice() to reselect, valid returns int value of input
      try{
         if(scan.hasNextInt()){
            input = scan.nextInt(); 
            if(input > 0 && input < 5){
               //Valid input clear stream, return input
               return input;
            }
         }
         
         System.out.println("Invalid input, please input an integer 1, 2, 3, or 4");
         //clear stream
         scan.next();
         //return functionChoice() with scanner to reinput valid integer value
         return functionChoice(scan);
         
      }catch(InputMismatchException e){
         System.out.println("Invalid input, please input an integer 1, 2, 3, or 4");
         //clear stream
         scan.next();
         //return functionChoice() with scanner to reinput valid integer value
         return functionChoice(scan);
      }
   }

   //Gathers user input for cubic feet to be converted and validates and outputs conversion
   public static void convertCubicFeet(Scanner scan){
   //constant for bushels in a cubic foot
      final double BUSHEL = .803564; 
      double cubicFeet = 0.0;
      
      System.out.println("\nHow many cubic feet should be converted to US bushels?");
      
      if(scan.hasNextDouble()){
         cubicFeet = scan.nextDouble();
         System.out.printf("\n%f cubic feet = %.3f bushels\n", cubicFeet, (cubicFeet * BUSHEL));
      }else{
         System.err.println("Invalid input, please input a numeric value.");
         //clear stream
         scan.next();
      }
      
   }
   
   public static void convertMiles(Scanner scan){
   //Constant for km in a mile
      final double KILOMETERS = 1.60934;
      double miles = 0.0;
      
      System.out.println("\nHow many miles should be converted to Kilometers?");
      
      if(scan.hasNextDouble()){
         miles = scan.nextDouble();
         System.out.printf("%f miles = %.2f kilometers\n", miles, (miles * KILOMETERS));
      }else{
         System.err.println("Invalid input, please input a numeric value.");
         //clear stream
         scan.next();
      }
   }
   
   public static void graduationHonors(Scanner scan){
      double gpa = 0.0;
      
      System.out.println("\nWhat was the student's GPA?");
      
      if(scan.hasNextDouble()){
         gpa = scan.nextDouble();
         //Modify gpa to int to easily do switch/case statement
         int modifiedGpa = (int) (gpa * 10);
   
         switch (modifiedGpa) {
            case 35:
            case 36:
            case 37:
               System.out.println("This student graduates with Cum Laude Honors\n");
               break;
            case 38:
            case 39:
               System.out.println("This student graduates with Magna Cum Laude Honors\n");
               break;
            case 40:
               System.out.println("This student graduates with Summa Cum Laude Honors\n");
               break;
            default:
               System.out.println("This student graduates with no Honors");
               break;
         }  
      } else { 
         //clear stream if not numeric input4
         scan.nextLine();
      }
      //clear stream
      scan.nextLine();
   }

/*-----------------------------------------------------------Main-------------------------------------------------------*/
   public static void main(String[] args){
      welcomeMessage();
      Scanner scan = new Scanner(System.in);
      //call functionChoice() passing scanner and set the return int to choice
      int choice = functionChoice(scan);
      
      //Loop menu while choice != to 4 (Exit)
      while(choice != 4){
         switch(choice){
            case 1:
               convertCubicFeet(scan);
               break;
            case 2:
               convertMiles(scan);
               break;
            case 3:
               graduationHonors(scan);
               break;
         }
      
         choice = functionChoice(scan);
      }
      
      System.out.println("\nThanks for using this program, Goodbye!");
      //close scanner
      scan.close();
   }
}