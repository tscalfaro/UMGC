/*
Created by: Antonio Scalfaro
CMSC 215 / 6381
09/07/2023
Assignment 2 - Honor Roll

This is the Student class, it has four methods, a constructor that accepts String studentName, double creditHours, and double qualityPts, a gpa() method
that returns the student gpa (qualityPts / creditHours), an eligibleForHonorRollSociety() method that returns a boolean if the student meets the standards
for the honor roll, and a toString() method that returns a String of the student data. 
*/
package Assignment2;

public class Student {
   private String studentName;
   private double creditHours;
   private double qualityPts;
   
   public Student(String studentName, double creditHours, double qualityPts){
   
      this.studentName = studentName;
      this.creditHours = creditHours;
      this.qualityPts = qualityPts;
   }
   
   public double gpa(){
      double quotient = this.qualityPts / this.creditHours;
      return Math.round(quotient * 100.0) / 100.0;
   }
   
   public boolean eligibleForHonorSociety(double minimumGpa){
      boolean token = true;
      if (this.gpa() >= minimumGpa) return token;
      token = false;
      return token;
   }
   
   public String toString(){
      return "Name: " + this.studentName + " GPA: " + this.gpa();
   }
/*
   public static void main(String[] args){
      Student s = new Student("tommy", 90.0, 330.0);
      
      System.out.println(s.toString());
      System.out.println(s.eligibleForHonorSociety(3.9));
   }
*/
}