package Discussions;

//Created by: Antonio Scalfaro
//CMIS 143 5/31/2023
//This program will accept user input for their name, the program will then let the user know if their name has more/less/equal characters
//in it as my name "Antonio" "7".
 /**
 * Name: Johnson, Michael    CMIS 141/6384    Date: (05/31/2023)
 * week 3 discussion reply to Antonio Scalfaro 
 * added a constant, close scanner line and 
 * another branch of logic in a method called letterChecker
 * which accepts two strings and compares them for matching letters, 
 * then displays the number of matches and matching letters. 
 */
import java.util.Scanner;
public class JohnsonMichael_reply2Antonio_DiscWeek3 {

	   //declare constant
	   public static final String coder = "Antonio";
	 
	   //Display welcome information
	   public static void welcomeMessage(){
	      System.out.println("Created by: Antonio Scalfaro");
	      System.out.println("CMIS 143 5/31/2023");
	      System.out.println("\nThis program will ask input for your name then will display if the input name is");
	      System.out.println("longer, shorter, or the same character length as my name.");
	   }
	   
	   public static void nameChecker(String user_name){
	      //Constant for length of my name set to 7
	      int MY_NAME_LENGTH = 7;
	      //IF conditional to determine if user_name is shorter, longer, or of equal length as my name
	      if (user_name.length() < MY_NAME_LENGTH){
	         System.out.println("Your name has less charcters than mine");
	      }
	      else if(user_name.length() > MY_NAME_LENGTH){
	         System.out.println("Your name has more characters than mine!");
	      }
	      else {
	         System.out.println("We have the same amount of characters in our names!");
	      }
	   }
	   
	   //Michael's modification method
	   public static void letterChecker(String user_name, String coder ) {
		  
		   //declare string variable to hold matching characters
		   String matches="";//initialized to nothing
		   int count=0;//counter for matches, initialized to zero
		   
		   String numMatches="";//for comparing number of letters
		   
		   String plural = "s";//initialized for displaying plural
		   
		   //set both names to upper case
		   String coderUp = coder.toUpperCase();
		   String user_nameUp = user_name.toUpperCase();
		  
		   //finding matching letters
		   //iterate through Upper case alphabet
		   for (char a = 'A'; a <= 'Z'; a++) {
			  int index = coderUp.indexOf(a);//check upper case coder name for letter, and set it to index
			  int numChar=0, numChar2=0;//counters for number of times a matching letter exists
			  
			  if (index != -1) {//if upper case coder name, DOES have that letter
				  
				  //check upper case user name for the same letter
				  int index2 = user_nameUp.indexOf(a);
				  
				  //if upper case user name also has that letter
				  if (index2 != -1) {
					  count++;//increment counter by 1
					  matches += a;//add letter to matches
					  
					  //count number of times a matching letter exists in each name
					  for (int n = 0; n < coderUp.length(); n++) {//every character in upper case coder name
						  if(coderUp.charAt(index)==coderUp.charAt(n)) {//if the matching character exists more then once
							  numChar++;//iterate numChar by one
						  }
					  }
					  for (int g = 0; g < user_nameUp.length(); g++) {//ever char in upper case user name
						  if(user_nameUp.charAt(index2)==user_nameUp.charAt(g)) {//match char also exists more times
							  numChar2++;//iterate numChar2 by one
						  }
					  }
					  
					  //compare counts of number of same letters
					  if(numChar > numChar2) {//coder has more of the matching letter then user
						  
						  //check for plural
						  if ((numChar-numChar2)==1) {//if not plural
							  numMatches += coder+" has "+(numChar - numChar2)+" more "+a+" then "+user_name+".\n";
						  }else {
						  numMatches += coder+" has "+(numChar - numChar2)+" more "+a+"'"+plural+" then "+user_name+".\n";
						  }
						  
					  }else if (numChar < numChar2) {//user name has more of the matching letter
						//check for plural
						  if ((numChar2-numChar)==1){//if not plural
							  numMatches += user_name+" has "+(numChar2 - numChar)+" more "+a+" then "+coder+".\n";
						  } else {
						  numMatches += user_name+" has "+(numChar2 - numChar)+" more "+a+"'"+plural+" then "+coder+".\n";
						  }
					  }else if (numChar == numChar2) {//both have the same amount
						  numMatches += coder+" and "+user_name+" have the same number of "+a+"'"+plural+".\n";
					  }else {
						  ;//do nothing
					  }
				  }
			  }
		   }
		   
		  
		
		   //Check to display plural 
		   if (count == 1) {//only one match
			   plural = "";//set plural to nothing
		   }
		   
		   //Display results
		   System.out.printf("Our names share %d same letter%s", count, plural);
		   
		   //iterate through matches
		   for (int i = 0; i < matches.length(); i++) {
			   
			   //set each character in matches to match
			   char match = matches.charAt(i);
			   
			  //format matches
			   if (i==0) {//first letter
				   System.out.printf(", ");
			   }
			   
			   if ((count==i+1)&&(count!=1)) {//if last letter and not only one
				   System.out.printf(" and %s", match);
			   }else if (count == i+2) {//if second to last letter
				   System.out.printf("%s", match);
			   }else if (count!=1){//not only match, 
				   System.out.printf("%s, ", match);//print with comma
			   } else {
				   System.out.printf("%s", match);
			   }
		   }
		   //end with a period
		   System.out.println(".");
		   
		   //Display letter statistics
		   System.out.println(numMatches);
		   
		   //submission requirements
		   System.out.println("\n\tName: Johnson, Michael    CMIS 141/6384    Date: (05/31/2023)");
	   }
	   
	   public static void main(String[] args){
	      //Call welcome message
	      welcomeMessage();
	      //Create new scanner for user input
	      Scanner scan = new Scanner(System.in);
	      System.out.println("\nWhat is your name?");
	      //Store user_name from scan
	      String user_name = scan.nextLine();
	      //Call nameChecker passing user_name
	      nameChecker(user_name);
	      
	      //call letterChecker passing user_name and the constant coder 
	      letterChecker(user_name, coder);
	      
	      //close scanner
	      scan.close();
	   }
}

