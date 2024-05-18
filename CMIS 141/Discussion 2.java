import java.util.Scanner;

class discussion_two{
    public static void main(String args[]){
        // Initilize the variables (two floating point numbers)
        double input_one;
        double input_two;
        // Create the initial scanner
        Scanner user_inputs = new Scanner(System.in);
        // Print out that I need a number from the user as well as a greeting message.
        System.out.println("Good afternoon,\nToday we're going to be getting the square footage of a room.\nPlease enter the length (in feet) of the room.");
        // Assign the user's first number into the variable.
        input_one=user_inputs.nextDouble();
        // Print out that I need a second number from the user.
        System.out.println("Alright, now please enter the width of the room in feet.");
        // Assign the user's second number into the variable.
        input_two=user_inputs.nextDouble();
        // Assign a third variable to host the calculated value.
        double final_output=(input_one*input_two);
        System.out.println(final_output);

        if (final_output < 250){
            System.out.println("Your room is less than 250sqft...This might not be adequate space.");
        }
        else{
            System.out.println("Your room is more than 250 sqft...This is adequate space.");
        }
        //Below is edited by Antonio Scalfaro 5/24/2023
        System.out.println("\nEdited by: Antonio Scalfaro\n");
        System.out.println("What is the height of the room?");
        double height = user_inputs.nextDouble();
        double volume = height * input_one *input_two;
        System.out.println("The volume of the room is " + String.format("%.2f", volume)+ " ft cubed");

    }
}