package week5_12_15May;
/*
 * why string is immutable
 * how can you check string is immutable or not
 * why string is literally faster than object
 * what will happen when you concatinate  string  with another
 * how can you make  the strings  to become mutable
 */
public class Java_Therotical {

	public static void main(String[] args) {
		/*1.why string is immutable
		    String a = "Test"  
		    String b = "Test" 
		    Here both the values are stored in heap memory.
		    If string is changable or mutable, then one value "Test" is changed to "TEST" 
		    will impact the other variable also..
		     Say if we have file name stored as string variable.,, 
		     then any one can change the file name and get the access to it. So String is Immutable
		     
		     Strings can be created using String Literals (a sequesnce of character within double quotes) 
		     or using the string objects ( using the new Keyword)
			Since string literals are created from a String Literal pool , one String literal will be refered 
			multiple times. When the string literal is upated using one reference , 
			other references will get affected too , hence Strings are kept as immutable
 		*/
		
		//2.how can you check string is immutable or not
			//String Literal-Access point is single pool memory. 
		String str1="TestLeaf";
		String str2="TestLeaf";
		//Share the Same Memory
		System.out.println(str1==str2);  //true
		System.out.println(str1.equals(str2));   //true
		
		//String obj --Has different access points to access the variable
		String str3=new String("TestLeaf");
		String str4=new String("TestLeaf");
		System.out.println(str3==str4);   //false
		System.out.println(str3.equals(str4));  //true
		
		
		String a ="Test";
		a.concat("leaf");//concat function appends two strings
		System.out.println(a);

		//output :Test
		/*Reason : appending "leaf" to "test" will create a new String literal "Testleaf" , 
		but still varraible 'a' is pointing to the literal "test" .This proves any changes to the string creates
		a new memory and does not edit existing value.*/

		
		/*
		 * 3. Why string literal is faster than string object 
		 * String str1 = "Hello World!!";     String str2 = "Hello World!!";    
		 * System.out.println(str1 == str2); // true    
		 * Here both str1 and str2 refers the same object. 
		 * means jvm ll reuse the instance from String constant pool if already "Hello world" is available.
		 * But in case of,  String str1 = new String("Hello world") String str2 = new String("Hello world")
		 * Here there are two new objects are created and both are not equal.. ie str1 == str2 //False
		 * 
		 * String Literals are faster as its easier to access them than the String objects 
		 */
		
		
		/*4. What will happen when you concatenate a string with another?  
		 * Here same object (ie string constant pool ) will be reused and the string is concatenated..
		 *  but actual value of the string remains the same 
		*/
		  String s="Test";  
		  s.concat(" Leaf");//concat() method appends the string at the end  
		  System.out.println(s);//will print Test because strings are immutable objects  
		 //it is understood that two objects are created but "s" reference variable still refers to "Test" 
		  //not to "Test Leaf".
		  
		  
		  String s1="Test";  
		  s1=s1.concat(" Leaf"); 
		 System.out.println(s1);//will print Test Leaf  
		 //Now it prints "Test LEaf". However still "Test" object is not modified
		 
		 //As given in (2) above concatinating two strings will create a new String (memory)
		 
		 /*
		  * 5. how can you make the strings to become mutable     Not posssible..
		  * Becase String is a Final class in java and  we have String Buffer to achieve this..
		  * 
		  * We can use the StringBuffer and StringBuilders when we have to manipulate Strings 
		  * .StringBuilder is faster than StringBuffer , but StringBuffer is thread safe.
		  */

	}

}
