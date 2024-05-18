/*
 * Created by: Antonio Scalfaro
 * 1/25/2024
 * CMSC 315
 * Discussion Post - Week 3
 * From Text, Exercise 22.01
 * Write an O(n) program that prompts the user for a string and displays the maximum
 * consecutive increasingly ordered substring
 * */

package disc_week_3;

import java.util.Scanner;

public class Disc_Week_3 {
	
	public static void welcomeMessage() {
		System.out.println("Created by: Antonio Scalfaro");
		System.out.println("1/25/2024 - CMSC 315");
		System.out.println("Exercise 22.01");
		System.out.println("Write an O(n) program that prompts the user for a string and");
		System.out.println("displays the maximum consecutive increasingly ordered substring.");
		System.out.println("#################################################################");
	}
	
	public static void main (String[] args) {
		welcomeMessage();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please provide a string to assess: ");
		String s = scanner.nextLine();
		String result = findMaxSubstring(s);
		
		System.out.println("The max increasingly ordered substring of " + s +
				" is " + result);
		
		scanner.close();
	}
	
	public static String findMaxSubstring(String s) {
		if (s == null || s.isEmpty())
			return "";
		
		int maxLength = 1;
		int currentLength = 1;
		int startIndex = 0;
		int maxStartIndex = 0;
		
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) > s.charAt(i - 1)) { //Current char > previous char
				currentLength++;
			} else {
				if (currentLength > maxLength) { //End of increasing, check if current
					maxLength = currentLength;	//is greater than max length, replace if is
					maxStartIndex = startIndex; //set maxStartIndex to startIndex
				}
				currentLength = 1;
				startIndex = i;
			}
		}
		
		//Check last substring
		if (currentLength > maxLength) {
			maxStartIndex = startIndex;
		}
		
		return s.substring(maxStartIndex, maxStartIndex + maxLength);
	}
}
