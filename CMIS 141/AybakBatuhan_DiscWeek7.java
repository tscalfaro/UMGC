/**
 * Batuhan Aybak - CMIS 141 / 6384 - 06/27/2023 <br>
 * This program, with a given array with integer values, multiplies the double of each index value.
 
   Edited by: Antonio Scalfaro 6/29/2023
   Edited to display an array of 7, also made a minor change to updateArray. To save system resources, creating an int temp instead of 
   int[] modArray will eat up less memory. Kept the original code, just commented out.
 */

public class AybakBatuhan_DiscWeek7 {
	
	private static void updateArray(int[] array) {
		//int[] modArray = new int[7]; // create an array for modified values
		//Edit - I believe it is more resource friendly to use a temporary int here instead of a second array
      int temp = 0;
		for (int i = 0; i < array.length; i++) { // for loop to calculate double values
         //
			//modArray[i] = array[i] * 2; 
			//System.out.println(array[i] + " times 2 is " + modArray[i] );
         temp = array[i] * 2;
         System.out.println(array[i] + " times 2 is " + temp);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Batuhan Aybak - CMIS 141 / 6384 - 06/27/2023\n"); // Developer information
      System.out.println("Edited by: Antonio Scalfaro 6/29/2023\n");

		int[] array = {1,2,3,4,5, 18, 28};	
		updateArray(array);
	}
}
