/*
 * Created by: Antonio Scalfaro
 * CMSC 315 - Project 1
 * Date: 1/23/24
 * 
 * This is the DelimeterCheckerMain class. It contains 4 methods.
 * main() - Initiates program, asks user to input a fileName until valid fileName is found.
 * 			Then it creates an instance of a DelimeterChecker. A stack is created to push all
 * 			delimeters into. While the character returned is not the end of file null character
 * 			it checks if each character is a delimeter. If it is, it is checked to see if it is a
 * 			right or left delimeter and pushes the left delimeters into the stack. If right delimeter
 * 			then the stack is popped and then both delimeters are checked to ensure they match.
 * 			If not a match, message to console lets the user know and the program terminates.
 * isLeftDelimeter() - Checks to see if char passed is a left sided delimeter, returns boolean.
 * isRightDelimeter() - Checks to see if char passed is a right sided delimeter, returns boolean.
 * isMatchingPair() - Checks to see if current char and last char pushed to stack are matching
 * 					  left and right delimeters. Returns boolean.
 * */

package project1;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
public class DelimeterCheckerMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Keep asking for valid file name
		String fileName;
		DelimeterChecker delimeterChecker = null;
		do {
			System.out.println("Enter the file name: ");
			fileName = scanner.nextLine();
			
			try {
				delimeterChecker = new DelimeterChecker(fileName);
			} catch (IOException e) {
				System.out.println("Error opening file: " + e.getMessage());
			}
		} while (delimeterChecker == null);
		
		//Handle delimiters
		Stack<Character> delimeterStack = new Stack<>();
		char currentChar;
		try {
			while ((currentChar = delimeterChecker.getNextCharacter()) != '\0') {
				if (isRightDelimeter(currentChar)) {
				    // If right delimiter, check for matching left delimiter
				    if (delimeterStack.isEmpty() || !isMatchingPair(delimeterStack.pop(), currentChar)) {
				        // Mismatched delimiters
				        System.out.println("Mismatched delimiter at position " + delimeterChecker.getCurrentPosition() +
				                " - Character: " + currentChar);
				        return; // Terminate after mismatch
				    }
				} else if (isLeftDelimeter(currentChar)) {
				    delimeterStack.push(currentChar);
				}
			}
			
			//Check for unmatched left delimiter
			if (!delimeterStack.isEmpty()) {
				System.out.println("Unmatched left delimeters found.");
			} else {
				System.out.println("Delimeters are balanced.");
			}
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
	
	private static boolean isLeftDelimeter(char ch) {
		return ch == '(' || ch == '{' || ch == '[';
	}
	
	private static boolean isRightDelimeter(char ch) {
		return ch == ')' || ch == '}' || ch == ']';
	}
	
	private static boolean isMatchingPair(char left, char right) {
		return (left == '(' && right == ')' ||
				left == '{' && right == '}' ||
				left == '[' && right == ']');
	}
}
