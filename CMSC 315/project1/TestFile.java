/* Date: 1/23/2024
 * Created by: Antonio Scalfaro
 * CMSC 315 - Project 1
 * This is the Test File for project 1, this will test if mismatched delimiters are
 * caught. This code is not intended to be run.
 * */
package project1;

public class TestFile {

	public static void main(String[] args) {
        // This is a sample Java source code file with matching and mismatched delimiters

        int x = 10;
        int y = 20;
        int] z = [20, 30];
        if (x > y) {
            System.out.println("x is greater than y.");
        } else {
            System.out.println("y is greater than x.");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration " + i);
        }

        // Mismatched delimiters
        public static void displayMessage() {
            System.out.println("Hello, world!");
        }
    }
}
