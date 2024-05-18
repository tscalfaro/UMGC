/*
   Created by: Antonio Scalfaro
   CMIS 141/6384 06/02/2023
   Assignment 2
   This program will accept input from the user for two numbers between 200-1000 and one operator and will perform the operation.
*/

import java.util.Scanner;

public class ScalfaroAntonio_Assignment2{
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141/6384 06/02/2023\n");
      System.out.println("\nThis program will perform a math operation for the user for two numbers between 200-1000.");
      System.out.println("Provide the first number, then the operator, then the second number");
      System.out.println("Operations availble to use are '+', '-', '/', '*', '%'");
   }
   
   //Function for displaying input values and final value for operation
   public static void endMessage(double firstValue, String operator, double secondValue){
      double operationValue = 0.0;
   
      System.out.printf("\nFirst Value: \t%f",firstValue);
      System.out.printf("\nSecond Value: \t%f", secondValue);
      System.out.printf("\nOperator: \t%s", operator);
      
      switch(operator){
         case "+":
         operationValue = firstValue + secondValue;
         break;
         
         case "-":
         operationValue = firstValue - secondValue;
         break;
         
         case "/":
         operationValue = firstValue / secondValue;
         break;
         
         case "*":
         operationValue = firstValue * secondValue;
         break;
         
         case "%":
         operationValue = firstValue % secondValue;
         break;
      }
      System.out.printf("\nThe value of the operation is: \t%.2f", operationValue);
   }
   
   public static void main(String[] args){
      welcomeMessage();
      //Create token for do/while loop
      boolean token;
      double firstValue = 0.0;
      double secondValue = 0.0;
      String operator = "";
      //Create scanner for input
      Scanner scan = new Scanner(System.in);
      //Do/while loop to validate user input
      do{
         //Initialize token to false, allowing escape from loop as long as all input is valid
         token = false;
         //Ensure operator string begins each loop through as empty string
         operator = "";
         //Store first number for operation in firstValue
         System.out.println("\nProvide the first number:\t");
         //Validate numeric input
         if(scan.hasNextDouble()){
            firstValue = scan.nextDouble();
            if(firstValue > 1000 || firstValue < 200){
               System.err.println("Numeric values must be between 200-1000");
               token = true;
               continue;
            }
         }else{
            System.err.println("Invalid numeric input");
            token = true;
            //Clear stream, restart loop
            scan.nextLine();
            continue;
         }
         
         //Clear stream
         scan.nextLine();
         
         System.out.println("Provide the operator:\t");
         String operatorLn = scan.next();
         char operatorChar = operatorLn.charAt(0);
         //Validate operator input
         switch(operatorChar){
            case '+':
            operator += operatorChar;
            break;
            
            case '-':
            operator += operatorChar;
            break;
            
            case '*':
            operator += operatorChar;
            break;
            
            case '/':
            operator += operatorChar;
            break;
            
            case '%':
            operator += operatorChar;
            break;
            
            //Invalid operator restart loop
            default:
            System.err.println("Invalid input, allowable operators '+, -, /, *, %'");
            token = true;
            continue;
         }
         scan.nextLine();
         //Store second number in secondValue
         System.out.println("Provide the second number:\t");
         if(scan.hasNextDouble()){
            secondValue = scan.nextDouble();
            if(secondValue > 1000 || secondValue < 200){
               System.err.println("Numeric values must be between 200-1000");
               token = true;
               continue;
            }
         }else{
            System.err.println("Invalid numeric input");
            token = true;
            continue;
         }
       }while(token); 
      
      endMessage(firstValue, operator, secondValue);
      
      
      scan.close();
   }
}