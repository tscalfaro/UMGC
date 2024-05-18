/*
 * Created by: Antonio Scalfaro
 * CMSC 315
 * 2/20/2024
 * Project 3 - BST
 * This is the Main class in the bst program. It displays a welcome message and initiates
 * a loop for the user to input a bst. Once entered it will check that it meets the correct
 * form or it will throw an InvalidInputException. If it is correct, it will display the bst
 * in indented form and display a message stating if it is a bst, if it is balanced, and its
 * height. If not a bst or not balanced, it will restructure the bst to be so and then redisplay
 * the indented form and its new height. There are three methods in the Main class:
 * main(String[]) - The main method that initiates the program and collect user input. Loops
 * 					until the user inputs other than 'y'/'Y'.
 * welcomeMessage() - Displays welcome message with developer details and instructions for 
 * 					  program.
 * menuLoop(Scanner) - The menuLoop method takes in a scanner and asks the user for the input
 * 					   for the bst and throws InvalidInputException if not valid. If valid, it
 * 					   displays the indented for, indicates if it is a bst, if it is balanced,
 * 					   and the height. If not bst or balanced, it restructures the bst and then
 * 					   displays the new tree and its new height.
 * 
 * */

package project_3;

import java.util.*;

public class Main {

	public static void main (String[] args) {
		
		welcomeMessage();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like to create a BST? Y/N");
		String line = scan.nextLine().trim();
		line = line.toUpperCase();
		char c;

		while(!line.isEmpty()) {
			line.toUpperCase();
			c = line.charAt(0);
			
			if (c == 'Y') {
				menuLoop(scan);
				System.out.println("Add another Tree Y/N");
				line = scan.nextLine();
				line = line.toUpperCase();
			}else {
				line = "";
			}
			
		}
		scan.close();
		System.out.println("Thanks for using the BST creator program.");	
	}
	
	public static void welcomeMessage() {
		
		System.out.println("Created by: Antonio Scalfaro");
		System.out.println("CMSC 315");
		System.out.println("2/20/2024");
		System.out.println("Project 3 - BST");
		System.out.println("This is the Binary Search Tree Program");
		System.out.println("The program will ask the user for input of a bst in preorder");
		System.out.println("the form should be represented as such:");
		System.out.println("(53 (28 (11 * *) (41 * *)) (83 (67 * *) *))");
		System.out.println("If it is not in that form, an exception will be thrown");
		System.out.println("Otherwise, the tree will be displayed in indented form");
		System.out.println("The height of the tree will be given and a message will");
		System.out.println("display if it is a bst and if it is balanced.");
		System.out.println("If not a bst or balanced, it will be restructered and will be");
		System.out.println("displayed again with its new height.");
		System.out.println("Enter 'y'/'Y' to continue to enter new trees.");
		System.out.println("##############################################################\n");
	}
	
	public static void menuLoop(Scanner scan) {
		
		try {
			System.out.println("Input the BST in the form indicated above");
			String bstString = scan.nextLine().trim();
			
			InvalidInputException.validatePreOrderString(bstString);
			BinaryTree bst = new BinaryTree(bstString);
			System.out.println("Your BST:");
			bst.printIndented();
			
			if (bst.isValidBST() && bst.isBalanced()) {
				System.out.println("This is a binary search tree and is balanced");
				System.out.println("Height: " + bst.getHeight());
			}else if (bst.isValidBST() && !bst.isBalanced()) {
				System.out.println("It is a binary search tree but not balanced");
				System.out.println("Original height: " + bst.getHeight());
				bst.rebalance();
				bst.printIndented();
				System.out.println("Balanced height: " + bst.getHeight());
			}else if (!bst.isValidBST()) {
				System.out.println("It is not a binary tree");
				System.out.println("Original height: " + bst.getHeight());
				bst.rebalance();
				bst.printIndented();
				System.out.println("Balanced height: " + bst.getHeight());
			}
		} catch (InvalidInputException e) {
			System.out.println("Error " + e.getMessage());
		}
	}
}
