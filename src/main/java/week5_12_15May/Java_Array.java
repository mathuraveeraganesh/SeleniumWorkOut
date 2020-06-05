package week5_12_15May;

import java.util.Arrays;
import java.util.Collections;

/*
 * 1. What is an array? How to Create an array?
2. Write a java program to sort it and reverse it.
Input: int[] array = {5,1,33,79,22,11,45};
output: 
Sorted: {1,5,11,22,33,45,79}
reversed: {79,45,33,22,11,5,1}
3. Write a java program to find the average of the numbers in an arrray.
input: int[] array= {20, 30, 25, 35, -16, 60, -100};
output: Average: 7
4. Write a java program to print the common numbers in between the two arrays.
int[] array1 = { 1, 2, 5, 5, 8, 9, 7, 10 };
int[] array2 = { 1, 0, 6, 15, 6, 4, 7, 0 };
 */
public class Java_Array {

	public static void main(String[] args) {
		/* 1. What is an array? How to Create an array?
		An array consist of single or multi dimensional array
		int a[]={1,2,3};
		int b[]=new int b[2];
		*/
		
		/*2. Write a java program to sort it and reverse it.
		Input: int[] array = {5,1,33,79,22,11,45};
		output: 
		Sorted: {1,5,11,22,33,45,79}
		reversed: {79,45,33,22,11,5,1}*/
		
		//1st Approach
		int[] sarray = {5,1,33,79,22,11,45};
		int temp=0; 
		for (int k = 0; k < sarray.length; k++) {
			for (int p = k+1; p < sarray.length; p++) {
				if(sarray[k]>sarray[p]) {
					temp=sarray[k];
					sarray[k]=sarray[p];
					sarray[p]=temp;
				}
			}
		}
		
		for (int z = 0; z < sarray.length; z++) {
			System.out.print(sarray[z]+",");
		}
		System.out.println();
		
		int[] array = {5,1,33,79,22,11,45};	
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(array[i]<array[j]) {
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		for (int sort : array) {
			System.out.print(sort+",");
		}
		System.out.println("\n");
		
		//2nd Approach
		int[] sortarray = {5,1,33,79,22,11,45};
		Arrays.sort(sortarray);
		for (int i = 0; i < sortarray.length; i++) {
			System.out.print(sortarray[i]+",");
		}
		System.out.println();
		for (int i = sortarray.length-1; i >=0 ; i--) {
			System.out.print(sortarray[i]+",");
		}
		System.out.println();
		
		//3rd Approach
		Integer[] sortarray1 = {5,1,33,79,22,11,45};
		Arrays.sort(sortarray1);
		System.out.println("Sorted");
		System.out.println(Arrays.toString(sortarray1));
		System.out.println("\nReversed");
		Collections.reverse(Arrays.asList(sortarray1));
		System.out.println(Arrays.asList(sortarray1));
		
		/*3. Write a java program to find the average of the numbers in an arrray.
		input: int[] array= {20, 30, 25, 35, -16, 60, -100};
		output: Average: 7*/
		
		//1st Approach
		int[] array1= {20, 30, 25, 35, -16, 60, -100};
		int temp1=0;
		for (int i = 0; i < array1.length; i++) {
			temp1+=array1[i];
			
		}
		int avg=temp1/array1.length;
		System.out.println("The Average of the numbers in an array-"+avg);
		
		//2nd Approach
		int[] array2= {20, 30, 25, 35, -16, 60, -100};
		int temp2=0;
		for (int i : array2) {
			temp2=temp2+i;
		}
		System.out.println("The Average of the numbers in an array-"+temp2/array2.length);
		
		/*
		 * 4. Write a java program to print the common numbers in between the two arrays.
			int[] array1 = { 1, 2, 5, 5, 8, 9, 7, 10 };
			int[] array2 = { 1, 0, 6, 15, 6, 4, 7, 0 };
		 */
		
		//1st Approach
		int[] CNOarray1 = { 1, 2, 5, 5, 8, 9, 7, 10 };
		int[] CNOarray2 = { 1, 0, 6, 15, 6, 4, 7, 0 };
		for (int i = 0; i < CNOarray1.length; i++) {
			for (int j = 0; j < CNOarray2.length; j++) {
				if(CNOarray1[i]==CNOarray2[j])
					System.out.println("The Common Number:"+CNOarray1[i]);
			}
			
		}
		
		//2nd Approach
		int[] CNOarray3 = { 1, 2, 5, 5, 8, 9, 7, 10 };
		int[] CNOarray4 = { 1, 0, 6, 15, 6, 4, 7, 0 };
		for (int eachnum : CNOarray3) {
			for (int eachArrayNum : CNOarray4) {
				if(eachnum==eachArrayNum)
					System.out.println("The Common Number:"+eachnum);
			}
		}
		
		
		
		
	}

}
