/*
   Created by: Antonio Scalfaro
   CMIS 141 / 6384
   7/7/2023
   This program creates a class Oven that has three properties, brand name, temp, and status on/off which is a boolean.
   The class has 4 methods, turnOn, turnOff, changeTemp, and toString
*/

public class ScalfaroAntonio_DiscWeek8{
   public static class Oven{
      public String brand;
      public int temp;
      public boolean isOn;
      
      public Oven(String brand, int temp, boolean isOn){
         this.brand = brand;
         this.temp = temp;
         this.isOn = isOn;
      }
      
      public void turnOn(){
         this.isOn = true;
      }
      
      public void turnOff(){
         this.isOn = false;
      }
      
      public void changeTemp(int temp){
         this.temp = temp;
      }
      
      public String toString(){
         String sb = "";
        
         sb += "Your " + this.brand + " oven is currently set to " + this.temp;
         
         if (this.isOn){
            sb += " . The oven is currently on.";
         } else {
            sb += " . The oven is currently off.";
         }
         return sb;
      }
      
   }
   
   public static void welcomeMessage(){
      System.out.println("Created by: Antonio Scalfaro");
      System.out.println("CMIS 141 / 6384");
      System.out.println("7/7/2023");
      System.out.println("This program creates a class Oven that thas three properties, brand name, temp, and status on/off which is a boolean");
      System.out.println("The class has 4 methods, turnOn, turnOff, changeTemp, and toString\n");
   }

   public static void main(String[] args){
      welcomeMessage();
   
      Oven oven = new Oven("Whirlpool", 375, true);
      //Print original oven data
      System.out.println(oven.toString());
      //Call class methods and change data
      oven.turnOff();
      oven.changeTemp(450);
      //Print new oven data
      System.out.println(oven.toString());
   }

}