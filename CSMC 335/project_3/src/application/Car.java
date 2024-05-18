/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 3 - Traffic Light GUI
 * 
 * This is the Car class that extends the javafx Rectangle class. It contains 3 class variables and 
 * 1 constant. It has int speed, xPos, and yPos. Constant double conversionFactor to convert from KM to meters.
 * There are 8 class methods:
 * public Car(int, int, int) - Constructor that receives ints for width and height, uses super to create the 
 * 							   Rectangle using those values, and sets the last int for the speed of the car.
 * public int getSpeed() - Returns speed
 * public setSpeed(int) - Sets speed
 * public int getXPos() - Returns xPos
 * public setXPos() - Sets xPos
 * public int getYPos() - Returns yPos.
 * public setYPos(int) - Sets yPos
 * public int getMoveDistance(double) - Returns the distance the car will move in the time given. Speed is given 
 * 										in KM/hr, so the conversion factor is used to convert to meters and the final
 * 										value is casted to an int before return.
 * */

package application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Car extends Rectangle{
	private int speed;
	private int xPos;
	private int yPos;
	private double conversionFactor = 1000.0 / 3600.0;
	
	public Car(int width, int height, int speed) {
		super(width, height, Color.DEEPSKYBLUE);
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	public int getMoveDistance(double timeInSeconds) {
		return (int) ((getSpeed() * timeInSeconds) * conversionFactor);
	}
}
