/* Created by: Antonio Scalfaro
   CMIS 141 5/24/2023
   This program will retrieve user input for the biweekly paycheck amount of the user and provide the
   amount of taxes the user will owe. The tax rate will be an arbitrary 33%.
*/
import java.util.Scanner;

public class ScalfaroAntonio_DiscWeek2{
   //Welcome message to give creator and program details
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141 5/24/2023\n");
      
      System.out.println("This program will ask for your biweekly paycheck amount");
      System.out.println("It will return to you, your biweekly taxed amount (33% rate) and yearly tax amount.");
   }
   
   //Calculate tax totals for biweekly and yearly based on tax rate and biweekly check amount
   public static void calcTaxes(double biweekly_check){
      //Tax rate of 33%
      double tax_rate = 0.33;
      //Calc yearly earnings, multiply by 26 checks
      double yearly_earnings = biweekly_check * 26;
      //Tax amount for biweekly and yearly
      double biweekly_taxes = biweekly_check * tax_rate;
      double yearly_taxes = yearly_earnings * tax_rate;
      //Print with 2 digits after decimal format
      System.out.println("Your biweekly taxed amount is $"+String.format("%.2f",biweekly_taxes));
      System.out.println("Your yearly taxed amount is $"+String.format("%.2f" ,yearly_taxes)); 
   }
   
   //Main
   public static void main(String[] args){
      welcomeMessage();
      //Create new scanner
      Scanner scan = new Scanner(System.in);
      System.out.println("What is your biweekly paycheck amount?");
      //Take input and parse any '$'
      String biweeklyCheck = scan.nextLine().replace("$", "");
      //Convert string to double
      double biweekly_check = Double.parseDouble(biweeklyCheck);
      //call calcTaxes sending biweekly_check double
      calcTaxes(biweekly_check);
   }

}