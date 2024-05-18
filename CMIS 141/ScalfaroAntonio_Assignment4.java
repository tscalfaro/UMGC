/*
   Created by: Antonio Scalfaro
   CMIS 141/6384
   Assignment 4 - Nested Loops
   This program will collect user input for the size of the right triangle to be created and the size of the rectangle to be created
   Integer input only, both must be greater than 1.
*/
import java.util.Scanner;

public class ScalfaroAntonio_Assignment4{
   
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141/ 6384");
      System.out.println("Assignment4 - Nested For Loops");
      System.out.println("This program will collect user input for a number of lines in a right triangle with each row");
      System.out.println("being a single number i.e \n1\n2 2\n3 3 3.");
      System.out.println("The second function will create a triangle where every layer of the triangle will be one digit less down to 1");
      System.out.println("The user will supply the input for the size of the rectangle");
   }
   
   public static void createTriangle(int rows){
      //Print each row
      for(int i = 1; i <= rows; i++ ){
         //Print correct count for each row
         for(int count = 0; count < i; count++){
            System.out.printf("%d ", i);
         }
         System.out.println("");
      }
   }
   
   public static void createRectangle(int n){
   
      int size = n * 2 - 1;
      
      //Upper half
      for(int i = 0; i < (size/2) + 1; i++){
         int x = n;
         
         //Decreasing
         for(int a = 0; a < i; a++){
            System.out.print(x + " ");
            x--;
         }
         
         //Constant
         for(int b = 0; b < size - 2 * i; b++){
            System.out.print(n - i + " ");
         }
         
         //Increasing
         x = n - i + 1;
         for(int c = 0; c < i; c++){
            System.out.print(x + " ");
            x++;
         }
         System.out.println("");
      }
      
      //Lower Half
      for(int i = size / 2 - 1; i >= 0; i--){
         int x = n;
         //Decreasing
         for(int a = 0; a < i; a++){
            System.out.print(x + " ");
            x--;
         }
         
         //Constant
         for(int b = 0; b < size - 2 * i; b++){
            System.out.print(n - i + " ");
         }
         
         //Increasing
         x = n - i + 1;
         for(int c = 0; c < i; c++){
            System.out.print(x + " ");
            x++;
         }
         System.out.println();
      }
   }
   
   
   public static void main(String[] args){
      int triRows, recRows;
      welcomeMessage();
      
      Scanner scan = new Scanner(System.in);
      System.out.println("\nPlease provide the number of rows for the triangle:");
      //Validate input and call createTriangle() passing the input
      if(scan.hasNextInt()){
         triRows = scan.nextInt();
         if(triRows > 1){
            createTriangle(triRows);
         } else {
            System.err.println("Invalid input, the input must be an integer greater than 1");
         }
      }else{
         System.err.println("The input number of rows must be an integer at least 2 or greater.");
      }
      
      System.out.println("\nPlease provide the rows for the rectangle:");
      //Validate input and call createRectangle() passing the input
      if(scan.hasNextInt()){
         recRows = scan.nextInt();
         if(recRows > 1){
            createRectangle(recRows);
         }else{
            System.err.println("Invalid input, the input must be an integer greater than 1");
         }
         
      }else{
         System.err.println("Invalid input, the input must be an integer greater than 1");
      }
      
      scan.close();
   }
}