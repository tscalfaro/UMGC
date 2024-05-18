/** This program will print several variables as an introduction.
 *  CMIS 141 week 1 discussion
 */
public class JohnsonTeresa_DiscWK1 {

   public static void editorMessage(){
      System.out.println("\nEdited by: Antonio Scalfaro 5/19/2023");
   }
   
   public static void editorInfo(){
      String first_dog = "Zeus";
      String second_dog = "Callie";
      int numPets = 2;
      
      System.out.println("I have "+numPets+" dogs and they are the best!");
      System.out.println("Their names are "+first_dog+" & "+second_dog);
   }
   
    public static void main(String[] args) {

        // Display header
        System.out.println("Teresa Johnson. CMIS 141/6384. 5/19/2023");

        /*Initialize variables*/
        String name = "Teresa";
        String petName = "Liara";
        int pets = 1;

        //Display output
        System.out.print("Hello, class! My name is " + name + ".");
        System.out.println(" I have " + pets + " pet named " + petName + ".");
        System.out.println("She snores very loudly! \nNice to meet you all!");
        
        //Editor message
        editorMessage();
        
        editorInfo();
    }
}
