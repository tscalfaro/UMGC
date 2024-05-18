/*
   Created by: Antonio Scalfaro
   CMIS 141/6384
   06/13/2023
   Assignment 3 - Loops
   This program asks for user input for a gamer's name, Level 1 xp, Level 2 xp, Level 3 xp, and Engagemnet Score xp. It will
   calculate the totals for the xp and display the  information to the user. XP input must be between 10-100 in increments of 5.
   Enter as many gamers' information as desired.
*/


import java.util.Scanner;

public class ScalfaroAntonio_Assignment3{

   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141/6384");
      System.out.println("06/13/2023");
      System.out.println("Assignment 3");
      System.out.println("\nThis program will collect a gamer's xp totals and calculate the total xp for that gamer.");
      System.out.println("The user will input the gamer's name, and xp gained for L1, L2, L3, and Engagement Score XP.");
      System.out.println("XP input should be between 10-100 in increments of 5");
   }
   
   //returns boolean, true if xp input is valid, false if invalid
   public static boolean checkXP(int xp){
      if(xp >= 10 && xp <= 100 && xp % 5 == 0){
         return true;
      }else {
         System.err.println("Incorrect XP increment amount, must be 10-100 increments of 5");
         return false;
      }
   }
   
   //Totals xp for gamer and outputs information to console
   public static void gamerTotalXP(String name, int l1XP, int l2XP, int l3XP, int eScore){
      //L1 bonus multiplier = .2, L2 bonus multiplier = .3, L3 bonus multiplier = .5, eScore bonus multiplier = .6
      double totalXP = (l1XP * 2 * .2) + (l2XP * 2 * .3) + (l3XP * 2 * .5) + (eScore * 2 * .6);
      
      System.out.printf("\nGamer %s's" + " total XP is %.2f \n", name, totalXP);
   }
   
   //Gathers information for gamer and xp gained
   public static void xpTotaler(int continueToken, Scanner scan){
      // do/while loop to initiate information gathering, continue while continueToken == 1
      do{
         System.out.println("Please input Gamer's name: \t");
         String gamerName = scan.nextLine();
         
         //Gather level 1 XP and validate input
         System.out.println("Please input gamer's Level 1 XP: \t");
         int level1XP = scan.nextInt();
         if(checkXP(level1XP)){
         
         }else{
            break;
         }
         
         //Gather level 2 XP and validate input
         System.out.println("Please input gamer's Level 2 XP: \t");
         int level2XP = scan.nextInt();
         if(checkXP(level2XP)){
         
         }else{
            break;
         }
         
         //Gather level 3 XP and validate input
         System.out.println("Please input gamer's Level 3 XP: \t");
         int level3XP = scan.nextInt();
         if(checkXP(level3XP)){
         
         }else{
            break;
         }
         
         //Gather engagement score XP and validate input
         System.out.println("Please input gamer's Engagement Score: \t");
         int eScore = scan.nextInt();
         if(checkXP(eScore)){
         
         }else{
            break;
         }
         
         //Call gamerTotalXP to display output data, passing all input data
         gamerTotalXP(gamerName, level1XP, level2XP, level3XP, eScore);
         
         
         System.out.println("Would you like to continue? (1 for yes, 2 for no)");
         continueToken = scan.nextInt();
         //clear stream
         scan.nextLine();
      }while(continueToken == 1);
   }
   
   public static void main(String[] args){
      welcomeMessage();
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("\nWould you like to calculate a gamer's XP? (1 for yes, 2 for Exit) \t");
      //Set a token to user input to determine if continue is desired
      int continueToken = scan.nextInt();
      //clear stream
      scan.nextLine();
      
      if (continueToken == 1){
         xpTotaler(continueToken, scan);
      }
      
      System.out.println("Thanks for using the gamer xp totaler program");
      //close scanner
      scan.close();
   }

}