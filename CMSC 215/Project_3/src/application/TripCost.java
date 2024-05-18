/*
 * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * Project 3 - Trip Cost Estimator
 * 
 * This is the TripCost class, its constructor accepts 7 parameters (int, double, double, int, double, double, double). 
 * There are 2 methods:
 * 		gasCost() - Calculates cost of gas for the trip determined by distance and gasMileage
 * 		totalTripCost() - Calculates total cost of the trip, determined by gas cost, house and food cost * days of trip, and 
 * 						  attraction cost
 * */

package application;

import java.text.DecimalFormat;

public class TripCost {
	private int days;
	private double gasolineCost, gasMileage, hotelCost, foodCost, attractions, distance;
	//Rounding doubles to 0.00
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	//TripCost Constructor
	public TripCost(double distance, double gasolineCost, double gasMileage,
			int days, double hotelCost, double foodCost, double attractions) {
		this.distance = distance;
		this.gasolineCost = gasolineCost;
		this.gasMileage = gasMileage;
		this.days = days;
		this.hotelCost = hotelCost;
		this.foodCost = foodCost;
		this.attractions = attractions;
		
		
	}
	//Calculates gas cost for the trip, returns as a rounded String
	public String gasCost() {
		return df.format((distance / gasMileage) * gasolineCost);
	}
	
	//Calculates total cost of the trip, returns as a rounded String
	public String totalTripCost() {
		double total = Double.parseDouble(this.gasCost()) + (hotelCost + foodCost)
				* days + attractions;
		return df.format(total);
	}
}
