/*
   Created by: Antonio Scalfaro
   CMIS 141 / 6384
   Final Project
   
   This program will prompt the user with a menu with 6 options. 1) Add multiple customers 2) Add a single customer 
   3) Display customers 4) Retreive customer by ID 5) Retreive customers in a sales range. A Customer consists of a name, a 5 digit
   ID, and an amount of total sales. Data will be input by the user and validated to be in the correct format. 
*/
import java.util.Scanner;

public class ScalfaroAntonio_Project{
   
   public static class Customer{
      String name;
      int id;
      double totalSales;
      
      public Customer(String name, int id, double totalSales){
         this.name = name;
         this.id = id;
         this.totalSales = totalSales;
      }
      
      public String toString(){
         String sb = "";
         return sb += "Name:\t" + this.name + "\nId:\t" + this.id + "\nSales:\t$" + this.totalSales + "\n";
      }
   
   }
   
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141 / 6384");
      System.out.println("Final Project");
      System.out.println("");
   }
   
   //Creates the desired amount of Customer objects and adds to the array, returns idx
   public static int addMultiCust(String name, int id, double sales, Scanner scan, Customer[] custArray, int idx){
      int count;
                  
      System.out.println("How many customers should be added?");
      if(scan.hasNextInt()){
         count = scan.nextInt();
         scan.nextLine();
         //for loop runs for amount of desired new customers to be added
         for(int i = 0; i < count; i++){
            System.out.println("Please enter customer's name");
            name = scan.nextLine();
            //get and validate id
            System.out.println("Please enter customer's 5 digit ID");
            if(scan.hasNextInt()){
               id = scan.nextInt();
               //validate id is 5 digits long
               if(id < 10000 || id > 99999){
                  System.out.println("Invalid ID, must be 5 digits");
                  scan.nextLine();
                  break;
               }
            }
            //Get and validate sales
            System.out.println("Please enter the total sales for the customer");
            if(scan.hasNextDouble()){
               sales = scan.nextDouble();
            }
            //Create customer and add to array
            Customer temp = new Customer(name, id, sales);
            custArray[idx] = temp;
            idx++;
            scan.nextLine();
         }
      } else {
         System.err.println("Invalid value.");
      }
      return idx;
   }
   
   public static int addSingleCust(String name, int id, double sales, Scanner scan, Customer[] custArray, int idx){
      System.out.println("Please enter customer's name");
      name = scan.nextLine();
      
      System.out.println("Please enter customer's 5 digit ID");
      if(scan.hasNextInt()){
         id = scan.nextInt();
         if(id < 10000 || id > 99999){
            System.out.println("Invalid ID, must be 5 digits");
            scan.nextLine();
            return idx;
         }
      }
      
      System.out.println("Please enter the total sales for the customer");
      if(scan.hasNextDouble()){
         sales = scan.nextDouble();
      }
      
      Customer temp = new Customer(name, id, sales);
      custArray[idx] = temp;
      idx++;
      scan.nextLine();
      return idx;
   }

   public static void printArray(Customer[] custArray){
      for(Customer cust : custArray){
         //only print if value is present
         if(cust != null)
            System.out.println(cust.toString());
      }
   }
   
   public static void lookUpByID(Scanner scan, Customer[] custArray){
      int thisID = 0;
      boolean token = false;
      
      System.out.println("Please provide the ID of the customer");
      if(scan.hasNextInt()){
         thisID = scan.nextInt();
         for(Customer cust : custArray){
            //only accesss class methods for customer objects
            if(cust != null){
               if(cust.id == thisID){
                  //found customer, print data and change token to true
                  System.out.println(cust.toString());
                  token = true;
                  break;
               }
            }
         }
      }
      //Did not find customer if token is false
      if(!token)
         System.out.println("\nThe customer by ID " + thisID + " can not be found");
   }
   
   public static int customersInRange(Scanner scan, Customer[] custArray){
      int low = 0;
      int high = 0;
      //Get Lower limit of range
      System.out.println("What is the lower limit of the range?");
      if(scan.hasNextInt()){
         low = scan.nextInt();
      } else {
         System.out.println("Invalid entry, please use an integer");
         return -1;
      }
      scan.nextLine();
      //Get upper limit of range
      System.out.println("What is the upper limit of the range?");
      if(scan.hasNextInt()){
         high = scan.nextInt();
      } else {
         System.out.println("Invalid entry, please use an integer");
         return -1;
      }
      scan.nextLine();
      
      for(Customer cust: custArray){
         if(cust != null){
            if(cust.totalSales >= low && cust.totalSales <= high){
               System.out.println(cust.toString());
            }
         }
      }
      return 1;
      
   }
   
   public static void main(String[] args){
      int choice = 0;
      String name = "";
      int id = 0;
      double sales = 0.00;
      int idx = 0;
      Customer[] custArray = new Customer[100];
      Scanner scan = new Scanner(System.in);
      
      welcomeMessage();
     
      //menu while choice not negative 
      while(choice >= 0){
         System.out.println("\nPlease select an option by entering an int:");
         System.out.println("1) Add multiple customers");
         System.out.println("2) Add a single customer");
         System.out.println("3) Display all customers");
         System.out.println("4) Retreive customer by ID");
         System.out.println("5) Retreive customers in a Sales range");
         System.out.println("6) Exit");
         
         //catch non-int input
         if(!(scan.hasNextInt())){
            System.err.println("Sorry, invalid input");
            choice = -1;
         } else{
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
               //Add multiple customers
               case 1:
                  idx = addMultiCust(name, id, sales, scan, custArray, idx);
                  break;
               //Add one customer
               case 2:
                  idx = addSingleCust(name, id, sales, scan, custArray, idx);
                  break;
               //print customer array
               case 3:
                  printArray(custArray);
                  break;
               //Look up customer by ID
               case 4:
                  lookUpByID(scan, custArray);
                  break;
               case 5:
                  customersInRange(scan, custArray);
                  break;
               default:
                  System.out.println("\nThank you for using the Customer Portal");
                  choice = -1;
                  break;
            }
         }
      }
      scan.close();
   }
}