package discussion7;

import java.util.Scanner;

public class disc7 {
	public static int count(char[] chars, char ch) {
		return count(chars, ch, chars.length - 1);
	}
	
	public static int count(char[] chars, char ch, int high) {
		//base case - Array length 0 or reached end of array
		if(high < 0) {
			return 0;
		}
		
		//Recursive case - if char at index high == ch then add 1
		int curCount = (chars[high] == ch) ? 1 : 0;
		//Recursively count occurences in the rest of array
		int remainingCount = count(chars, ch, high - 1);
		
		return curCount + remainingCount;
		
	}
	public static void main(String[] args) {
		//Create scanner, gather input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = scan.nextLine();
		System.out.println("What char should be counted?");
		char ch = scan.nextLine().charAt(0);
		//Convert input to charArray
		char[] c = s.toCharArray();
		System.out.println("There are " + count(c, ch) + " " + ch + "'s in the char array: " + s);
		
		scan.close();
	}
}
