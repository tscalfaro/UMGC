/*
   Created by: Antonio Scalfaro
   CMSM 215
   8/22/2023
   Project 1 - Height class
   
   This class contains a constructor accepting two ints for feet and inches, a method to return the height in only inches, and a method to return a string
   with the height in ft' in" format.
*/

package Assignment1;

public class Height{
   private int feet;
   private int inches;

   public Height(int feet, int inches){
      //account for inches entered above 11 and convert to feet
      while(inches >= 12){
         feet++;
         inches = inches - 12;
      }
      this.feet = feet;
      this.inches = inches;
   }
   
   public int toInches(){
      return this.feet * 12 + this.inches;
   }
   
   public String toString(){
      return "" + this.feet + " \'" + " " + this.inches + "\"";
   }
/* these were some of the tests used while creating the classes to ensure functionality

   public static void main(String[] args){
       Height h = new Height(6, 13);
       System.out.println(h.toInches());
    }
*/
}
