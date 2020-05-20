package week5_12_15May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 1. Write a Java Program to print the keys and values from the Map
map = {A=1, B=2, C=3, D=4, E=5}
output:
A->1
B->2
C->3
D->4
E->5
(Min 3 ways)
 */


public class Java_PrintMap {

	public static void main(String[] args) {
		// 1. Write a Java Program to print the keys and values from the Map
		//map = {A=1, B=2, C=3, D=4, E=5}
		
		//1st Approach
		System.out.println("1st Approach");
		HashMap<Character,Integer> map= new LinkedHashMap<Character, Integer>();
		map.put('A',1);
		map.put('B',2);
		map.put('C',3);
		map.put('D',4);
		map.put('E',5);
		for (Entry<Character,Integer>  eachmap : map.entrySet()) {
			System.out.println(eachmap.getKey()+"->"+eachmap.getValue());
		}
		
		//2nd Approach
		System.out.println("2nd Approach");
		HashMap<Character,Integer> map1= new LinkedHashMap<Character, Integer>();
		map1.put('A',1);
		map1.put('B',2);
		map1.put('C',3);
		map1.put('D',4);
		map1.put('E',5);
		map1.forEach((eachkey,eachvalue)-> System.out.println(eachkey+"->"+eachvalue));
		
		
		//3rd Approach
		System.out.println("3rd Approach");
		HashMap<Character,Integer> map2= new LinkedHashMap<Character, Integer>();
		map2.put('A',1);
		map2.put('B',2);
		map2.put('C',3);
		map2.put('D',4);
		map2.put('E',5);
		Iterator<Entry<Character,Integer>> iterator=map2.entrySet().iterator();
		iterator.forEachRemaining((eachentry)->System.out.println(eachentry.getKey()+"->"+eachentry.getValue()));
		
		//4th Approach
		System.out.println("4th Approach");
		HashMap<Character,Integer> map3= new LinkedHashMap<Character, Integer>();
		map3.put('A',1);
		map3.put('B',2);
		map3.put('C',3);
		map3.put('D',4);
		map3.put('E',5);
		Iterator<Entry<Character,Integer>> iterator1=map3.entrySet().iterator();
		while(iterator1.hasNext()) {
			Entry<Character,Integer> eachEntrySet=iterator1.next();
			System.out.println(eachEntrySet.getKey()+"->"+eachEntrySet.getValue());
		}
		
		//5th Approach
		System.out.println("5th Approach");
		HashMap<Character,Integer> map4= new LinkedHashMap<Character, Integer>();
		map4.put('A',1);
		map4.put('B',2);
		map4.put('C',3);
		map4.put('D',4);
		map4.put('E',5);
        Set<Character> set = new HashSet<>(map4.keySet());
        List<Character> lst = new ArrayList<>(set);
        for (int i = 0; i < lst.size(); i++) {       
        	System.out.println(lst.get(i) + "->" + map4.get(lst.get(i))); 
        }
        
      //6th Approach
		System.out.println("6th Approach");
		HashMap<Character,Integer> map5= new LinkedHashMap<Character, Integer>();
		map5.put('A',1);
		map5.put('B',2);
		map5.put('C',3);
		map5.put('D',4);
		map5.put('E',5);
		map5.keySet().forEach((eachEntry1)->System.out.println(eachEntry1+"->"+map5.get(eachEntry1)));
	}

}
