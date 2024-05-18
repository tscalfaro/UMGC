/*
   Created by: Antonio Scalfaro
   CMSM 215
   8/22/2023
   Project 1 - Project1 class
   
   This class contains a main method that will ask the user for input to create new Player objects. Input needed is name, height, and age.
   An array of Players will be stored with a default 100 spaces. Each new player will be created and added to the array and the average age
   of all players will be adjusted every time a new player is added.
   The tallest player whose age is under the average age will have their information displayed at the end of user input.
   User input is validated.
*/


package Assignment1;
import Assignment1.Player;
import Assignment1.Height;
import java.util.Scanner;

public class Project1{
   private static int avgAge = 0, runningAge = 0, token = 0, idx = 0;
   private static Height h;
   private static String name;
   private static int feet, inches, age;

   public static void main(String[] args){
      //Player array with default 100 space
      Player[] players = new Player[100];
      Scanner scan = new Scanner(System.in);
      System.out.println("Please input each Player's data, when done adding players input 1.");
      
      //Add players while token == 0
      while(token == 0){
         System.out.println("What is the Player's name?\t");
         //validate scanner has input, set to name
         if(scan.hasNext()){
            name = scan.nextLine();  
         }
         
         System.out.println("What is the players height in feet and inches? Ie, 5 10");
         //validate scanner has input, set to feet, inches. Create Height obj from feet, inches
         if(scan.hasNext()){
            String input = scan.nextLine();
            String[] temp = input.split(" ");
            //try-catch for invalid input, i.e anything not an int. If triggered, the player will not be created
            //and the user will be prompted to start again.
            try{
               feet = Integer.parseInt(temp[0]);
               inches = Integer.parseInt(temp[1]);
               h = new Height(feet, inches);
            }catch(NumberFormatException e){
               System.err.println("Invalid entry, please use the form '5 10'");
               continue;
            }
         }
         
         System.out.println("What is the players age?");
         //validate scan has an int value, set to age
         if(scan.hasNextInt()){
            age = scan.nextInt();
         }
         //Create new Player obj
         Player p = new Player(name, h, age);
         //Add to runningAge then update avgAge
         runningAge += age;
         avgAge = runningAge / (idx + 1);
         //add new Player p to players array at idx, idx incriments after the obj is saved in the array
         players[idx++] = p;

         System.out.println("Continue? 0 for yes, 1 for exit");
         if(scan.hasNextInt()){
            //set token to int input, if not valid, it will allow a second attempt to continue.
            token = scan.nextInt();
         }else{
            //clear stream
            scan.next();
            //termination warning
            System.out.println("About to terminate program, are you sure? 1 for yes, 0 for continue");
            //If input is anything other than 0, exit.
            if(scan.hasNextInt()){
               int input = scan.nextInt();
               token = input == 0 ? 0 : 1;
            } else {
               token = 1;
            }
         }
         //clear stream
         scan.nextLine();
      }
      
      //Find tallest player <= the avgAge
      Player tallest = null;
      int tallestHeight = 0;
      for (Player p : players){
         if(p == null)
            continue;
         if(p.getAge() > avgAge)
            continue;
         if(p.height.toInches() > tallestHeight)
            tallest = p;
      }
      System.out.println("The average age of all players is " + avgAge);
      System.out.println("The tallest player whose age is less than or equal to the average age is:\n" + tallest.toString());
      
      //close scanner
      scan.close();
   }
}