package week5_12_15May;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Write a java programs to print the duplicate items in the array
int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2};
What is the difference between int and Integer and for other datatypes also.
 */
public class Java_Array_Integer {

	public static void main(String[] args) {
		
		/*What is the difference between int and Integer and for other datatypes also
		 * int is a primitive type that represent an integer. whereas Integer is an Object that wraps int .
		 * The Integer object gives you more functionality, such as converting to hex, string, etc. 
		 * You can also use OOP concepts with Integer 
		 */
		
		// Write a java programs to print the duplicate items in the array
		
		//1st Approach
		int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2};
		for (int i = 0; i < my_array.length; i++) {
			for (int j = i+1; j < my_array.length; j++) {
				if(my_array[i]==my_array[j])
					
					System.out.print(my_array[i]+",");
			}
		}
		
		System.out.println();
		
		//2nd Approach
		int[] my_array1 = {1, 2, 5, 5, 6, 6, 7, 2};
		for (int i = 0; i < my_array1.length-1; i++) {
			for (int j = i+1; j < my_array1.length; j++) {
				if((my_array1[i]==my_array1[j]) && (i!=j))
					
					System.out.print(my_array1[j]+",");
			}
		}
		
			
	}

}
