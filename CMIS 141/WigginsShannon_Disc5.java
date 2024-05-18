// Name: Wiggins Shannon   Class: CMIS 141/6384   Date:06/18/2023
// Edited by: Antonio Scalfaro 6/20/2023

import java.util.*; 

public class WigginsShannon_Disc5{

   public static void main(String[] args){
      Scanner k = new Scanner(System.in); 
       
      // ask teh user for inputs 
      System.out.println("Hello how many imputs do you have?"); 
      int in = k.nextInt(); 
      int[] numbers= new int[in]; 
      //make aloop to accept the information in the aray 
      for(int i=0; i<in; i++){
         System.out.println("What number would you like to add to the array?");
         
         numbers[i]= k.nextInt(); 
      }
      
      System.out.print("Here are your numbers! you placed in the array all multiplied by 2\n"); 
      
      //print the array
      //Edited by Antonio Scalfaro 6/20/2023
      for(int i =0 ; i <numbers.length; i++){
         //Even numbers multiplied by 2, odds by 3
         if(i % 2 == 0){
            System.out.println(numbers[i]+"*2 = "+numbers[i]*2); 
         }else{
            System.out.println(numbers[i] + " * 3 = " + numbers[i] * 3);
         }
      }
   
   }

}