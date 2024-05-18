/*
 * * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * Project 3 - Trip Cost Estimator
 * 
 * This is the Project3_UnitTest class. 
 * There are 2 test methods of the TripCost class:
 * 							- testGasCost(): Creates TripCost obj and tests class method
 * 							- testTotalTripCost(): Creates TripCost obj and tests class method
 * 
 * */

package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class Project3_UnitTest {

	//Test gasCost() returns String
	@Test
	public void testGasCost() {
		TripCost tc = new TripCost(1000, 3.95, 30, 2, 100, 100, 30);
		
		String gc = tc.gasCost();
		assertEquals("131.67", gc);	
	}
	
	//Test totalTripCost() returns String
	@Test
	public void testTotalTripCost()
	{
		TripCost tc = new TripCost(1000, 3.95, 30, 2, 100, 100, 30);
		String ttc = tc.totalTripCost();
		assertEquals("561.67", ttc);
	}
}
