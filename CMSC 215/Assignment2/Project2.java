/*
Created by: Antonio Scalfaro
CMSC 215 / 6381
09/07/2023
Assignment 2 - Honor Roll

This is the Project2 class. This class contains two methods, the setGpaThreshold() method which accepts a double avgGpa
and returns the double to be stored in gpaThreshold and the main() method that reads in a file line by line and stores
data from file as Student Objects, either Graduate or Undergraduate. The new Student will be added to Student[] students. 
The gpaThreshold is set and the Honor Roll students are printed
*/
package Assignment2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project2{
   private static String name = "";
   private static double creditHours;
   private static double qualityPts;
   private static String studentYear = "";
   private static Student[] students = new Student[100];
   private static double avgGpa = 0.00;
   private static double runningGpa = 0.00;
   private static double GPA_CAP = 4.0;
   
   //Find the midpoint between avgGpa and GPA_CAP, then return that rounded to two decimals
   public static double setGpaThreshold(double avgGpa){
      double quotient = (GPA_CAP - avgGpa) / 2 + avgGpa;
      return Math.round(quotient * 100.0) / 100.0;
   }

   public static void main(String[] args){
      int idx = 0;
      try{
         String filePath = "Assignment2/studentInfo.txt";
         
         FileReader fileReader = new FileReader(filePath);
         BufferedReader bufferReader = new BufferedReader(fileReader);
         
         
         String lastName, firstName, line;
         while ((line = bufferReader.readLine()) != null){
            //Split each line on the white space
            String[] lineParts = line.split(" ");
            //set last name to the first index in lineParts, replace ',' with ''
            lastName = lineParts[0].replace(",", "");
            firstName = lineParts[1];
            //combine first and last name in First Last order
            name = firstName + " " + lastName;
            //try-catch block for number format exceptions from potential file data errors
            try{
               creditHours = Double.parseDouble(lineParts[2]);
               qualityPts = Double.parseDouble(lineParts[3]);
            }catch(NumberFormatException e){
               //handle exception and continue to next line from the file, does not add this student to students[]
               System.err.println("Invalid numeric format for credit hours or quality points for " + name);
               continue;
            }
            studentYear = lineParts[4];
            
            //Create the correct Student object, Undergraduate/Graduate, add to students[] at idx
            if (studentYear.equals("Doctorate") || studentYear.equals("Masters")){
               Graduate g = new Graduate(name, creditHours, qualityPts, studentYear);
               students[idx] = g;
            } else{
               Undergraduate s = new Undergraduate(name, creditHours, qualityPts, studentYear);
               students[idx] = s;
            }
            runningGpa += students[idx].gpa();
            idx++;
         }
      } catch (IOException e){
         e.printStackTrace();
      }
      
      avgGpa = runningGpa / idx;
      
      double gpaThreshold = setGpaThreshold(avgGpa);
      //reset idx to 0
      idx = 0;
      System.out.println("\nThe GPA Threshold for Honor Roll is " + gpaThreshold);
      System.out.println("-----------Honor Roll------------");
      //if student meets honor roll requirement, print their data
      while(students[idx] != null){
         //use eligibleForHonorSoceity() method to determine if the student meets the Honor Roll
         if(students[idx].eligibleForHonorSociety(gpaThreshold)) 
            System.out.println(students[idx].toString());
         idx++;
      }
   }
}