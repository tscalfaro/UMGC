/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 3 - Traffic Light GUI
 * 
 * This is the TrafficLight class with one class field, enum TrafficLightState state. It has 3
 * class methods:
 * public TrafficLight() - Constructor sets state to TrafficLightState.GREEN.
 * public TrafficLightState getTrafficLightState() - returns state
 * public setTrafficLightState(TrafficLightState) - Sets state
 * */

package application;

public class TrafficLight {
	private TrafficLightState state;
	
	public TrafficLight() {
		this.state = TrafficLightState.GREEN;
	}
	
	public TrafficLightState getTrafficLightState() {
		return state;
	}
	
	public void setTrafficLightState(TrafficLightState state) {
		this.state = state;
	}
}
