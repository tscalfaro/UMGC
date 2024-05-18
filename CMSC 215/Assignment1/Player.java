/*
   Created by: Antonio Scalfaro
   CMSM 215
   8/22/2023
   Project 1 - Player class
   
   The Player class contains a constructor accepting a string name, Height height, and int age. It contains getter methods for all class properties
   and a toString method to print the data.
*/

package Assignment1;
import Assignment1.Height;

public class Player{
   private String name;
   //Height height is made public to allow the 
   public Height height;
   private int age;
   
   //Constructor for Player obj
   public Player(String name, Height height, int age){
      this.name = name;
      this.height = height;
      this.age = age;
   }
   
   //Getter methods
   public String getName(){
      return this.name;
   }
   
   public Height getHeight(){
      return this.height;
   }
   
   public int getAge(){
      return this.age;
   }
   
   //Concat string s with Player name, height, and age and return s
   public String toString(){
      String s = "Name: " + this.name + "\n";
      s += "Height: " + this.height + "\n";//I found that this.height works the same as this.height.toString(), but am unsure of the difference
      s += "Age: " + this.age;     
      return s;
   }
   
   
}