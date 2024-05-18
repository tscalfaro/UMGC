/*
   Created by: Antonio Scalfaro
   CMIS 141 6384
   06/15/2023
   Discussion Week 5 - For Loops
   This program will accept input from the user for loop iteration length and will output a color to the console
   based on ther iteration count % 5. I.e. 6 iterations would output 'red, blue, yellow, green, purple, red.'
*/
import java.util.Scanner;

public class ScalfaroAntonio_DiscWeek5{

   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141 6384");
      System.out.println("06/15/2023");
      System.out.println("Discussion Week 5");
      System.out.println("\nThis program will accept input from the user for loop iteration length and will output a color to the console");
      System.out.println("based on ther iteration count % 5. I.e. 6 iterations would output 'red, blue, yellow, green, purple, red'");
   }
   
   public static void main(String[] args){
      int count = 0;
      welcomeMessage();
      //Open scanner
      Scanner scan = new Scanner(System.in);
      
      System.out.println("How many iterations should the program run the for loop?");
      //If valid input, complete task, else end program
      if(scan.hasNextInt()){
         //count for iterator set to user input
         count = scan.nextInt();
         
         for(int i = 0; i < count; i++){
            // if/elseif chain to determine color to be printed to console.
            if(i % 5 == 0)
               System.out.println("\nRed");
            else if(i % 5 == 1)
               System.out.println("Blue");
            else if(i % 5 == 2)
               System.out.println("Yellow");
            else if(i % 5 == 3)
               System.out.println("Green");
            else if(i % 5 == 4)
               System.out.println("Purple");
         }
      }else{
         System.err.println("Invalid input, please input a whole number");
      }
      scan.close();
   }

}