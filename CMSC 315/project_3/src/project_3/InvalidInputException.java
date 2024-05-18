/*
 * Created by: Antonio Scalfaro
 * CMSC 315
 * 2/20/2024
 * Project 3 - BST
 * This is the InvalidInputException class that extends Exception which is designed
 * to throw an exception if the user input for the bst is in incorrect form. There is
 * one class variable String preOrderString and it has three methods:
 * InvalidInputException(String) - Constructor
 * String getPreOrderString() - Returns preOrderString
 * validatePreOrderString(String) - Checks that there are no other characters than digits, *, or
 * 									parens and that each paren has a matching paren. It checks that
 * 									no more than two * are found in any given set of parens. Throws
 * 									InvalidInputException if string does not pass the checks.
 * */

package project_3;

public class InvalidInputException extends Exception{
	private String preOrderString;
	
	public InvalidInputException(String preOrderString) {
		super("Invalid preorder string input: " + preOrderString);
		this.preOrderString = preOrderString;
	}
	
	public String getPreOrderString() {
		return preOrderString;
	}
	
	public static void validatePreOrderString(String preOrderString) throws InvalidInputException {
		boolean validString = true;
		
		int openParenCount = 0;
		int asteriskCount = 0;
		boolean firstDigitEnclosed = false;
		
		for (char c : preOrderString.toCharArray()) {
			if (c == '(') {
				if (openParenCount == 0 && firstDigitEnclosed) {
					validString = false;
				}
					
				openParenCount++;
			} else if (c == ')') {
				if (openParenCount == 0) {
					validString = false;
				}
					
				openParenCount--;
				if (asteriskCount > 2) {
					validString = false;
				}
					
				asteriskCount = 0;
			} else if (c == '*') {
				asteriskCount++;
				if (openParenCount == 0) {
					validString = false;
				}
					
			} else if (Character.isDigit(c)) {
				if((openParenCount > 1 && !firstDigitEnclosed) || openParenCount == 0) {
					validString = false;
				}
				firstDigitEnclosed = true;
			} else if (c != ' ') {
				validString = false;
			}
		}
		
		if (openParenCount != 0 || asteriskCount > 2) {
			validString = false;
		}
		if (!validString) {
			throw new InvalidInputException(preOrderString);
		}
	}
}