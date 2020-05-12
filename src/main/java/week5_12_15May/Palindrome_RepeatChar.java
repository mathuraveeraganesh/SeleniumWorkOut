package week5_12_15May;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
 * 1. Write a Java Program to find the occurance of the character 'o' in the following String.
Input: "You have no choice other than following me!"
output: Occurance of o is: 6

count = count+1;

 Unary Operator
++count; count+=1;  count++; 

2. Check for the palindrome of the given string:
Input: "malayalam"
output: Yes, Palindrome
Input: "testleaf"
output: No, not a palindrome

Unary
a++  a--  ++a  --a

binary
+,-,*,/,%, <,>,<=,>=,==,!=,=

short hand operator
a= a+5; a+=5; a = a*3; a*=3;

Ternary Operator
Condition ? True Statement : False Statement
str.equals(rev)?"Yes, Palindrome":"No, Not a Palindrome"-

String & StrBuffer is class but Strbuf is different class
Cannot compare both so need to convert strbuf to str
String Buffer & String Builder
String is called as Immutable
Immutable - String in lowercase and gives new memory location 

 */
public class Palindrome_RepeatChar {

	public static void main(String[] args) {
		
		//1.First Method Java Program to find the occurance of the character 'o'
		String sText="You have no choice other than following me!";
		char[] ch=sText.toCharArray();
		HashMap<Character,Integer> map=new LinkedHashMap<>();
		for (int i = 0; i < ch.length; i++) {
			if(map.containsKey(ch[i]))
				map.put(ch[i],map.get(ch[i])+1);
			else
				map.put(ch[i],1);
			
			
		}
		System.out.println("Occurance of o is:"+map.get('o'));
		
		
		//2.Second Method Java Program to find the occurance of the character 'o'
		String sText1="You have no choice other than following me!";
		String replaceAll = sText1.replaceAll("[^o]","");
		System.out.println("Occurance of o is:"+replaceAll.length()); 
		
		//3.Third Method Java Program to find the occurance of the character 'o'
		String sText2="You have no choice other than following me!";
		int count=0;
		for (int i = 0; i < sText2.length(); i++) {
			if(sText2.charAt(i)=='o')
				count+=1;
		}
		System.out.println("Occurance of o is:"+count);
		
		// 1.First Method Check for the palindrome of the given string:
		String sPalindrome="testleaf";
		String sConcat="";
		for (int i = sPalindrome.length()-1; i >=0 ; i--) {
			char c = sPalindrome.charAt(i);
			sConcat=sConcat+c;
		}
		System.out.println(sPalindrome.equals(sConcat)?"Yes, Palindrome":"No, Not a Palindrome");
		
		
		// 2.Second Method Check for the palindrome of the given string:
		String sPalindrome1="malayalam";
		StringBuffer str=new StringBuffer(sPalindrome1);
		//Cannot compare both so need tosPalindrome1 convert strbuf to str
		String reverse = str.reverse().toString();
				
		if(sPalindrome1.equals(reverse))
			System.out.println("Yes, Palindrome-"+sPalindrome1);
		else
			System.out.println("No, Not a Palindrome-"+sPalindrome1);
	}
}
