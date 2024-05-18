/*
   Created by: Antonio Scalfaro
   CMIS 141 / 6384
   6/27/2023
   Discussion 7
   This program populates an array of 5 names, send the array to a method called capitalize() and capitalizes all the names in the array for output.
*/

public class ScalfaroAntonio_DiscWeek7{
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141 / 6384");
      System.out.println("6/27/2023");
      System.out.println("\nThis program takes an array of 5 names and capatilizes each name and outputs to console.\n");
   }
   
   public static void capitalize(String[] names){
      System.out.println("\nThe new list is:\n");
      for(int i = 0; i < names.length; i++){
         names[i] = names[i].substring(0,1).toUpperCase() + names[i].substring(1);
         System.out.println(names[i]);
      }
   }

   public static void main(String[] args){
      String[] names = {"john", "amanda", "keith", "gabby", "bruce"};
      
      welcomeMessage();
      
      System.out.println("The original list is:\n");
      
      for(int i = 0; i < names.length; i++){
         System.out.println(names[i]);
      }
      
      capitalize(names);
   }
}