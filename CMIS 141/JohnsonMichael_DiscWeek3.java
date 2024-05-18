
/**
 * 			Name: Johnson, Michael    CMIS 141/6384    Date:05/27/2023
 * A program which prompts a user for input of either 4, 8, 6, 2 or J, I, L, M
 *  and depending on that input, prints a different position of an + 
 *  inside a box to the console, using if-else statements 
 *
 */
 
 /*
     Edited by: Antonio Scalfaro
     CMIS 141/6384 6/1/2023
     Added truncation to numeric input to allow excessive inputs to validate i.e. '88888888888' to still count as 'up'.
     Edited double number to be int number to adjust for the above change.
     
 */
import java.util.*;

public class JohnsonMichael_DiscWeek3 {
public static void main(String[] arg) {
	Scanner in = new Scanner(System.in);
	
	int number;
	String letters;
	char letter; 
	boolean left=false, up=false, right=false, down=false;//initialized directions
	
	//Initial output
	System.out.println(" _______ ");
	System.out.println("|       |");
	System.out.println("|   +   |");
	System.out.println("|_______|");
	System.out.println("       I or 8");
	System.out.println("          ^");
	System.out.println("J or 4 <--|--> L or 6");
	System.out.println("          v");
	System.out.println("        M or 2");
	
	
	boolean flag1;//flag for input validation
	do {
		number=0;//user inputs initialized
		letters="";//user inputs initialized
		letter =' ';//user input initialized
		
		//prompt user for input
	System.out.print("Use your keyboard's keypad, 4, 8, 6, 2, or the letters J, I, L, M"
			+ "\nto move the + inside the box: ");
	
	//validate input
	if (in.hasNextDouble()){//value is a number
		
		double numberInput = in.nextDouble();//set number to input
      //----------------Edit-Block-------------------------------------
      //Added a truncation to get the first digit allowing for input '8888888888888' to still count as up to match the letter version
		String newNum = String.valueOf(numberInput);
      char s = newNum.charAt(0);
      number = Character.getNumericValue(s);
      //----------------------------------------------------------------------
		if (number == 4 || number == 8 || number == 6 || number == 2) {
			flag1 = false; //set flag to end loop
		}else {//number is not 4, 8, 6 or 2
			System.err.println("Needs to be either 4 for left, 8 for up, 6 for right, or 2 for down!");
			flag1 = true;
			in.nextLine();//clear stream
		}
	}else {//value is a string
		
		letters = in.nextLine();//set input to string variable
		letters = letters.toUpperCase();//change all characters to uppercase		
		letter = letters.charAt(0);//take only first character
		
		 //letter is J, I, L, or M
		if (letter == 'J' || letter == 'I' || letter == 'L' || letter == 'M') {
			flag1 = false;
		} else { //letter is not J, I, L, or M
			System.err.println("Needs to be either J for left, I for up, L for right, or M for down!");
			flag1 = true;
			//in.nextLine();//clear stream
		}
	}
	}while(flag1);
	
	//determines output value using if-else
	if (number == 4 || letter == 'J') {//Left
		left = true;
	} else if (number == 8 || letter == 'I'){
		up = true;
	} else if (number == 6 || letter == 'L') {
		right = true;
	} else if (number == 2 || letter == 'M') {
		down = true;
	} else {
		System.err.println("There was an error determining the output!");
	}
	
	//declare string values for output
	String leftPosition = " _______ \n|       |\n|+      |\n|_______|\n";
	String upPosition =" _______ \n|   +   |\n|       |\n|_______|\n";
	String rightPosition = " _______ \n|       |\n|      +|\n|_______|\n";
	String downPosition = " _______ \n|       |\n|       |\n|___+___|\n";
	
	//prints value to console
	if (left) {
		System.out.print(leftPosition);
	} else if (up) {
		System.out.print(upPosition);
	} else if (right) {
		System.out.print(rightPosition);
	} else if (down) {
		System.out.print(downPosition);
	} else {
		System.err.println("There was an error printing!");
	}

	//submission requirements
	System.out.println("\n\n\tName: Johnson, Michael    CMIS 141/6384    Date:05/27/2023");
   System.out.println("\nEdited by: Antonio Scalfaro  06/01/2023");
	
	//close scanner
	in.close();
}
}
