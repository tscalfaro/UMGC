/*
Created by: Antonio Scalfaro
CMSC 215 / 6381
09/07/2023
Assignment 2 - Honor Roll

This is the Undergraduate class, it extends the Student class. It has three methods, a constructor that accepts all the Student data plus
the String stdYr, eligibleForHonorSociety(double) that accepts a double and returns a boolean if the student meets the criteria for honor
roll, and a toString() method that prints all data. Both the eligibleForHonorRoll() and toString() methods Override the Student class methods 
*/
package Assignment2;

public class Undergraduate extends Student{
   //Student year
   private String stdYr;

   public Undergraduate(String studentName, double creditHours, double qualityPts, String stdYr){
      super(studentName, creditHours, qualityPts);
      this.stdYr = stdYr;
   }
   
   @Override
   public boolean eligibleForHonorSociety(double minimumGpa){
      boolean token = true;
      if(this.stdYr.equals("Junior") || this.stdYr.equals("Senior")){
         if(this.gpa() >= minimumGpa) return token;
      }
      token = false;
      return token;
   }
   
   @Override
   public String toString(){
      return super.toString() + " Student Year: " + this.stdYr;
   }
/*   
   public static void main(String[] args){
   
      Undergraduate s = new Undergraduate("tommy", 72, 230, "junior");
      Undergraduate b = new Undergraduate("john", 80, 230, "freshman");
      
      System.out.println(s.toString());
      
      System.out.println(b.toString());
      
      System.out.println(b.eligibleForHonorSociety(2.0));
      
      System.out.println(s.eligibleForHonorSociety(3.2));
   }
*/
}