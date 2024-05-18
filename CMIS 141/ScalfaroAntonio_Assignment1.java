/*
   Created by: Antonio Scalfaro
   CMIS 141 5/24/2023
   This program will take 5 user inputs (customer id, unit price, quantity, description, and discount rate) and will provide back the total
   before and after the discount is applied.  
*/
import java.util.Scanner;

public class ScalfaroAntonio_Assignment1{

   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141 5/24/2023\n");
      System.out.println("This program will ask the user for 5 inputs (customer id, unit price, quantity, description, discount rate)");
      System.out.println("And will provide the total before and after the discount is applied.\n");
   }
   
   public static void endMessage(int cust_id, double unit_price, int qty, String description, double discount_rate){
      //Reprint order details
      System.out.println("\nORDER DATA\n");
      System.out.println("Customer ID: " + cust_id);
      System.out.println("Unit price: " + unit_price);
      System.out.println("Quantity: " + qty);
      System.out.println("Description: " +description);
      System.out.println("Discount rate: " +discount_rate);
      
      //Calculate total_cost and discounted_cost
      double total_cost = unit_price * qty;
      double discounted_cost = unit_price * qty - 1 * unit_price * qty * discount_rate;
      
      //Print total_cost and discounted_cost formatted to 2 decimals
      System.out.println("Price before discount: " + String.format("%.2f", total_cost));
      System.out.println("Price after discount: " + String.format("%.2f",discounted_cost));
         
   }

   public static void main(String[] args){
      welcomeMessage();
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Provide your customer id:");
      //customer id stored from scanner
      int cust_id = scan.nextInt();
      
      System.out.println("Provide unit price eg(5.43):");
      //unit_price stored from scanner
      double unit_price = scan.nextDouble();
      
      System.out.println("Provide quantity:");
      //qty stored from scanner
      int qty = scan.nextInt();
      
      System.out.println("Provide a description:");
      //Consume new line character to allow for description to be added
      scan.nextLine();
      //description stored from scanner
      String description = scan.nextLine();
      
      System.out.println("Provide the discount rate eg(.15 for 15%)");
      //discount_rate stored from scanner
      double discount_rate = scan.nextDouble();
      
      //Call endMessage() pass all user info to display final output information
      endMessage(cust_id, unit_price, qty, description, discount_rate);
   }

}