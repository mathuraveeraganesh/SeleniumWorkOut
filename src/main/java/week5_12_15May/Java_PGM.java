package week5_12_15May;
/*
 * 1. Write a java program to swap two numbers
Input: a = 5, b= 10
output: a = 10, b = 5
(Note: Try without the third variable)
2. Print the first 10 fibonacci numbers in reverse order
output: 34,21,13,8,5,3,2,1,1,0
3. Print the armstrong numbers between 1 and 1000.
 */
public class Java_PGM {

	public static void main(String[] args) {
		/*1. Write a java program to swap two numbers
		Input: a = 5, b= 10
		output: a = 10, b = 5
		 * 
		 */
		
		//1st Approach
		int a=5;
		int b=10;
		System.out.println("Before Swap a="+a+" b="+b);
		a=a+b;  //a=15,	b=10;
		b=a-b;  //b=a-b	15-10=5	->b=5;
		a=a-b;	//a=a-b	15-5=10	->a=10;
		System.out.println("After Swap a="+a+" b="+b);
		
		//2nd Approach with Third Variable
		int a2=5;
		int b2=10;
		int c2=0;
		System.out.println("Before Swap with Third Variable a="+a2+" b="+b2);
		c2=a2;
		a2=b2;
		b2=c2;
		System.out.println("After Swap with Third Variable a="+a2+" b="+b2);
		
		
		/*2. Print the first 10 fibonacci numbers in reverse order
		output: 34,21,13,8,5,3,2,1,1,0
	 * 
	 */
		//1st Approach Fibonacci Series
		int a1=0;
		int b1=1;
		int c1=0;
		System.out.print(a1+","+b1);
		for (int i = 0; i < 10; i++) {
			c1=a1+b1;
			b1=a1;
			a1=c1;
			System.out.print(","+c1);
		}
		System.out.println();
		
		//2nd Approach Reverse Fibonacci Series
		int range=10;
		int a3=-1;
		int b3=1;
		int [] array1=new int[range];
		for (int j = 0; j < range; j++) {
			array1[j]=a3+b3;
			a3=b3;
			b3=array1[j];
		}
		for (int k = array1.length-1; k >=0; k--) {
			System.out.print(array1[k]+",");
			
		}
		System.out.println("\n");
		
		//3. Print the armstrong numbers between 1 and 1000.
		int sum=0;
		int r=0;
		for (int i = 0; i < 1000; i++) {
			sum=0;
			int temp=i;
			while(temp>0) {
				r=temp%10;
				sum+=Math.pow(r,3);
				temp/=10;
			}
			if(sum==i)
				System.out.println("ArmStrong Number:"+sum);
					
		}
		
	}
		
		
}
