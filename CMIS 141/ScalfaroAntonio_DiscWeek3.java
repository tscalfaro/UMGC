//Created by: Antonio Scalfaro
//CMIS 143 5/31/2023
//This program will accept user input for their name, the program will then let the user know if their name has more/less/equal characters
//in it as my name "Antonio" "7".

import java.util.Scanner;

public class ScalfaroAntonio_DiscWeek3{
   //Display welcome information
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 143 5/31/2023");
      System.out.println("\nThis program will ask input for your name then will display if the input name is");
      System.out.println("longer, shorter, or the same character length as my name.");
   }
   
   public static void nameChecker(String user_name){
      //Constant for length of my name set to 7
      int MY_NAME_LENGTH = 7;
      //IF conditional to determine if user_name is shorter, longer, or of equal length as my name
      if (user_name.length() < MY_NAME_LENGTH){
         System.out.println("Your name has less charcters than mine");
      }
      else if(user_name.length() > MY_NAME_LENGTH){
         System.out.println("Your name has more characters than mine!");
      }
      else {
         System.out.println("We have the same amount of characters in our names!");
      }
   }
   
   public static void main(String[] args){
      //Call welcome message
      welcomeMessage();
      //Create new scanner for user input
      Scanner scan = new Scanner(System.in);
      System.out.println("\nWhat is your name?");
      //Store user_name from scan
      String user_name = scan.nextLine();
      //Call nameChecker passing user_name
      nameChecker(user_name);
   }
}