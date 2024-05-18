/**  This program will prompt the user for how two input values
 * creates a method to take those two inputs as parameters
 * Performs a calculation with it and return the value
* Then print the result of said Calculations.
* Developer : Emmanuel Quincy Uko      # CMIS 141 6384     # Date: June, 24 2023
   Edited by: Antonio Scalfaro   CMIS 141 / 6384 Date 6/27/2023
*/

import java.util.Scanner;

public class UkoEmmanuel_Disc6 {

	public static void main(String[] args) {
		
		// Establish Scanner
		Scanner stdin = new Scanner(System.in);

		// Welcome message
		System.out.println("Welcome to the tire cost program, This program will calculate how much tires you are getting and "
				+ "give you the final cost");
		
		// Prompt the user for input values
		System.out.print("\nEnter the price per tire: $");
	    double pricePerTire = stdin.nextDouble();

	    System.out.print("\nEnter the number of tires you want to purchase: ");
	    int numOfTires = stdin.nextInt();

	    // Call the method to calculate the total cost
	    double totalCost = calculateTotalCost(pricePerTire, numOfTires);

	    // Print the result
	    System.out.println("\nThe total cost of the tires is: $" + totalCost);

	    stdin.close();
	    }
	
   //checks cost meets discount threshold or not, returns true if so.
   public static boolean discountChecker(double cost){
      final double THRESHOLD = 500.00;
      boolean token = true;
      
      if(cost >= THRESHOLD){
         return token;
      } else {
         token = false;
         return token;
      }
   }
	// Method
	public static double calculateTotalCost(double pricePerTire, int numOfTires) {
      //Discount rate for purchases above 500$
		final double DISCOUNT = .15;
		// Perform the calculation to determine the total cost
		double totalCost = pricePerTire * numOfTires;
      
      //-------------------Edit--------------------------
      //call discountChecker() passing totalCost and apply if necessary
		if(discountChecker(totalCost)){
         totalCost = totalCost - (totalCost * DISCOUNT);
      }
      //-------------------End-Edit-----------------------
		return totalCost;		// Return the value of calculation to the main()
	    }
	}
