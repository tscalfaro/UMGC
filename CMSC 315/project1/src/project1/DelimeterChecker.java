/*
 * Created by: Antonio Scalfaro
 * CMSC 315 - Project 1
 * Date: 1/23/24
 * 
 * This is the DelimeterChecker Class. It includes 7 class variables, one constructor,
 * and 2 class methods. To instantiate and instance of a DelimeterChecker, a file must be
 * passed to the constructor. The two class methods are:
 * getCurrentPosition() - Returns the current Line and Character counts as a String
 * getNextCharacter() - This method returns the next character in the file as long as
 * 						it is not a part of a comment (either single line or multi line), 
 * 						or a literal. It increments the lineNumber if the newly read character
 * 						is a newline character and increments the charNumber with every character
 * 						read in.
 * */

package project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class DelimeterChecker {

	private BufferedReader reader;
	private int lineNumber;
	private int charNumber;
	private boolean insideSingleLineComment;
	private boolean insideMultiLineComment;
	private boolean insideLiteral;
	
	//Constructor
	public DelimeterChecker(String fileName) throws FileNotFoundException {
		try {
			reader = new BufferedReader(new FileReader(fileName));
			lineNumber = 1;
			charNumber = 0;
			insideSingleLineComment = false;
			insideMultiLineComment = false;
			insideLiteral = false;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found: " + e.getMessage());
		}
	}
	
	//Method to return current position
	public String getCurrentPosition() {
		return "Line number: " + lineNumber +
				" Character number: " + charNumber;
	}
	
	//Method to return the next character excluding comments and literals
	public char getNextCharacter() throws IOException {
		int readChar = reader.read();
		
		//Handle end of file
		if (readChar == -1) {
			return '\0'; // Return null char to signal end of file
		}
		
		char currentChar = (char) readChar;
		charNumber++;
		if (currentChar == '\n') {
			lineNumber++;
			charNumber = 0;
		}
		
		//Exclude chars in comments and literals
		if(insideSingleLineComment) {
			if (currentChar == '\n') {
				insideSingleLineComment = false;
			}
		}else if(insideMultiLineComment) {
			if (currentChar == '*' && reader.read() == '/') {
				insideMultiLineComment = false;
			}
		}else if(insideLiteral) {
			if (currentChar == '\'' || currentChar == '\"') {
				insideLiteral = false;
			}
		}else {
			//Checking for start of comments or literals
			if (currentChar == '/') {
				int nextChar = reader.read();
				if (nextChar == '/') {
					insideSingleLineComment = true;
				} else if (nextChar == '*') {
					insideMultiLineComment = true;
				}
			} else if (currentChar == '\'' || currentChar == '\"') {
				insideLiteral = true;
			}
		}
		
		return currentChar;
	}
	
}
