package week5_12_15May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Write a java program to find the count the characters in the given string
String str = "Karma is powerful than God"
{K=1, a=3, r=2, m=1,  =4, i=1, s=1, p=1, o=2, w=1, e=1, f=1, u=1, l=1, t=1, h=1, n=1, G=1, d=1}
 */
public class Java_CountCharacter {

	public static void main(String[] args) {
		
		//1st Approach
		String str = "Karma is powerful than God";
		HashMap<Character,Integer> map=new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i)))
				map.put(str.charAt(i),map.get(str.charAt(i))+1);
			else
				map.put(str.charAt(i),1);
		}
		System.out.println(map);
		
		//2nd Approach
		String str1 = "Karma is powerful than God";
		char[] charArray=str1.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < charArray.length; i++) {
			int length = str.replaceAll("[^" +charArray[i] +"]", "").length();
			boolean add = set.add(charArray[i]);
			if(add)
			System.out.print(charArray[i] + "=" + length + " ");
		}
		
		
		//3rd Approach
		String str2 = "Karma is powerful than God";
		char[] charArray1=str1.toCharArray();
		for (int j = 0; j < charArray.length; j++) {
			char c = charArray1[j];
			set.add(c);
		}
		System.out.println();
		
		List<Character> list=new ArrayList<>(set);
		for (int j = 0; j < list.size(); j++) {
			Character character = list.get(j);
			System.out.print(list.get(j) + "-> " + str2.chars().filter(i -> i == character).count() + " ");	
		}
		System.out.println();
		
		//4th Approach
		String str3="Karma is powerful than God";
		Hashtable<Character, Integer> charCount= new Hashtable<Character, Integer>();
		int i=0;
		while(i<str3.length()) {
			Integer ifPresent =charCount.computeIfPresent(str3.charAt(i), (k,v)->v+1);
			if(ifPresent==null)
			 charCount.computeIfAbsent(str3.charAt(i),k->1);			
			i++;
		}
		System.out.println(charCount);
		
		//5th Approach
		String str4="Karma is powerful than God";
		LinkedHashMap<Character, Integer> map1=new LinkedHashMap<Character,Integer>();
		int m=0;
		while(m<str4.length()) {
			if(map1.containsKey(str4.charAt(m))) {
			Integer val = (Integer) map.get(str4.charAt(m));
			map1.replace(str4.charAt(m),val+1);
			}
			else
				map1.put(str4.charAt(m),1);
			m++;
		}
		System.out.println(map1);
		
		//6th Approach
		String str5 = "Karma is powerful than God";
		//{K=1, a=3, r=2, m=1,  =4, i=1, s=1, p=1, o=2, w=1, e=1, f=1, u=1, l=1, t=1, h=1, n=1, G=1, d=1}
		Map<Character,Integer> map2 = new LinkedHashMap<Character,Integer>();
		
		for (int k = 0; k < str5.length(); k++) {
			int count=0;
		 
			for (int j = 0; j < str5.length(); j++) {
				
				if(str5.charAt(k)==str5.charAt(j)) {
					
					count++;					
				}
	
				map2.put(str5.charAt(k), count);
			}
		}
		
		System.out.println(map2);
					
	}
}