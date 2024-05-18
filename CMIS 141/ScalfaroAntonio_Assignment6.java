/*
   Created by: Antonio Scalfaro
   CMIS 141 / 6384
   Assignment 6 - Arrays
   This is the Robotic Competition Scoring System. This program will ask the user for the number of teams, their team name, and aggregate score
   It will output all of the teams and their scores and will identify the lowest and highest scoring team.
*/

import java.util.Scanner;

public class ScalfaroAntonio_Assignment6{
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141 / 6384");
      System.out.println("Assignment 6 - Arrays");
      System.out.println("\nThis is the Robotic Competition Scoring System");
      System.out.println("This program will ask the user for the number of teams, their team name, and aggregate score");
      System.out.println("It will output all of the teams and their scores and will identify the lowest and highest scoring team.");
   }
   
   public static void collectData(String[] names, int[] scores, Scanner scan){
      int tempScore = 0;
      int high = 0;
      int low = 0;
      
      for(int i = 0; i < names.length; i++){
         //Clear stream
         scan.nextLine();
         System.out.println("Input the team name:");
         
         if(scan.hasNext()){
            names[i] = scan.nextLine();
         }
         System.out.printf("Input %s's score (400 -1000)\n", names[i]);
         //Validate score, if valid set scores[i] else terminate program
         if(scan.hasNextInt()){
            tempScore = scan.nextInt();
            if(tempScore >= 400 && tempScore <=1000){
               scores[i] = tempScore;
            } else {
              System.err.println("Invalid input. Please restart");
              break; 
            }
         } else {
            System.err.println("Invalid input. Please restart");
            break;
         }
      }
      //Print the array
      printArray(names, scores);
      //Find index for high and low scorers
      high = findHigh(scores);
      low = findLow(scores);
      
      //Print high and low scorers
      System.out.printf("\nThe high scoring team is TEAM %s with a score of %d", names[high], scores[high]);
      System.out.printf("\nThe low scoring team is TEAM %s with a sccore of %d", names[low], scores[low]);
   }
   
   public static void printArray(String[] names, int[] scores){
      for(int i = 0; i < names.length; i++){
         System.out.printf("TEAM: %-15s \t SCORE: %d\n", names[i], scores[i]);
      }
   }
   
   //Finds and returns idx for high scorer
   public static int findHigh(int[] scores){
      int high_idx = 0;
      
      for(int i = 0; i < scores.length; i++){
         //if scores at i is higher than scores[high_idx] then switch high_idx to i
         if(scores[i] > scores[high_idx]){
            high_idx = i;
         }
      }
      return high_idx;
   }
   
   //Finds and returns idx for lowest score
   public static int findLow(int[] scores){
      int low_idx = 0;
      
      for(int i = 0; i < scores.length; i++){
         //if score at i is lower than score[low_idx] then switch low_idx to i
         if(scores[i] < scores[low_idx]){
            low_idx = i;
         }
      }
      return low_idx;
   }
   
   public static void main(String[] args){
      int num_teams = 0;
      Scanner scan = new Scanner(System.in);
      
      welcomeMessage();
      
      System.out.println("\nHow many teams were in the robotics competition, please input an integer");
      //Validate input, instantiate arrays, begin operations
      if(scan.hasNextInt()){
         num_teams = scan.nextInt();
         String[] team_names = new String[num_teams];
         int[] team_scores = new int[num_teams];
         
         collectData(team_names, team_scores, scan);
      }else{
         System.err.println("Sorry, invalid input. Please input an integer value.");
      }
   }

}  