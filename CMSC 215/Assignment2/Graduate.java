/*
Created by: Antonio Scalfaro
CMSC 215 / 6381
09/07/2023
Assignment 2 - Honor Roll

This is the Graduate class that extend the Student class. It has three methods, a constructor that accepts all the Student class data plus 
String stdProgram, an eligibleForHonorRollSociety() method, and a toString() method. Both the eligibleForHonorRollSociety() and toString()
methods Override the Student class methods.
*/
package Assignment2;

public class Graduate extends Student{
   private String stdProgram;
   
   public Graduate(String studentName, double creditHours, double qualityPts, String stdProgram){
      super(studentName, creditHours, qualityPts);
      this.stdProgram = stdProgram;
   }
   
   @Override
   public boolean eligibleForHonorSociety(double minimumGpa){
      boolean token = true;
      
      if(this.stdProgram.equals("Masters")){
         if(this.gpa() >= minimumGpa) return token;
      }
      token = false;
      return token;
   }
   
   @Override
   public String toString(){
    return super.toString() + " Degree Type: " + this.stdProgram;
   }
   
//    public static void main(String[] args){
//       Graduate g = new Graduate("tommy", 21, 77, "masters");
//       Graduate h = new Graduate("matt", 21, 77, "doctorate");
//       
//       System.out.println(g.toString());
//       System.out.println(g.eligibleForHonorSociety(2.9));
//       
//       System.out.println(h.toString());
//       System.out.println(h.eligibleForHonorSociety(2.9));
//    }
}