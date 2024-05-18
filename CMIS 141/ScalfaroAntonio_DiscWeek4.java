import java.util.Scanner;

public class ScalfaroAntonio_DiscWeek4{

   public static final String[] baseballPlayers = {"Mike Trout", "Bryce Harper", "Shohei Ohtani", "Jacob deGrom", "Ronald Acuna Jr."};
   public static final String[] footballPlayers = {"Jalen Hurts", "Joe Burrow", "Travis Kelce", "Jason Kelce", "A.J Brown"};
   public static final String[] golfPlayers = {"Tiger Woods", "Rory McIlroy", "Scotty Scheffler", "John Rahm", "Viktor Hovland"};
   public static final String[] sports = {"Baseball", "Football", "Golf"};
   
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141/6384 06/08/2023");
      System.out.println("This program displays my top 1-5 players I like to watch for baseball, football, or golf depending on the user input.");
      System.out.println("The user will select which sport, and how many of the top 5 they wish to see.");
      
   }
   
   public static void main(String[] args){
      welcomeMessage();
      //Create ints to hold user inputs
      int sportChoice = 0;
      int numChoice = 0;
      
      Scanner sport = new Scanner(System.in);
      System.out.println("Which sport list would you like to see? Please input a numeric value.");
      System.out.println("1. Baseball\n2. Football\n3. Golf\n4. Exit");
      //Check that user input is int and store in sportChoice
      if(sport.hasNextInt()){
         sportChoice = sport.nextInt();
      }else{
         System.err.println("Invalid input");
      }
      
      //While not sentinel value, iterate and display correct list
      while(sportChoice != 4){
         System.out.println("How many of the top 5 do you want to see? Please input a numeric value 1-5");
         //If user input is int, store it in numChoice to determine list length
         if(sport.hasNextInt()){
            numChoice = sport.nextInt();
         }else{
            System.err.println("Invalid input");
         }
         
         int count = 0;
         System.out.printf("\n%s\n", sports[sportChoice-1]);
         //do while loop to print value from array until the selected list length is reached
         do{
            //switch statement to select the correct array and display that list
            switch(sportChoice){
               case 1:
               System.out.printf("%d. %s\n", count+1, baseballPlayers[count]);
               break;
               case 2:
               System.out.printf("%d. %s\n", count+1, footballPlayers[count]);
               break;
               case 3:
               System.out.printf("%d. %s\n", count+1, golfPlayers[count]);
               break;
            }
            count++;
         }while(count < numChoice);
         
         System.out.println("\nWhich sport list would you like to see? Please input a numeric value.");
         System.out.println("1. Baseball\n2. Football\n3. Golf\n4. Exit");
         //if value is int, store in sportChoice
         if(sport.hasNextInt()){
            sportChoice = sport.nextInt();
         }else{
            sportChoice = 4;
            System.err.println("Invalid input");
         }
      }
      //close scanner   
      sport.close();
 
   }

}