package week5_12_15May;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

/*
 * 1. Write a java program to print the duplicate character using Collections Framework.
Input: "When life gives you lemons, make lemonade"
2. Write a java program to print the list (Need 3 different answers)
Input: [B,u,g,a,t,t,i, ,C,h,i,r,o,n]
 */
public class Java_PrintListSet {

	public static void main(String[] args) {
		//1. Write a java program to print the duplicate character using Collections Framework.
		//Input: "When life gives you lemons, make lemonade"
		
		//1st Approach
		String sText="When life gives you lemons, make lemonade";
		Set<Character> iList=new LinkedHashSet<>();
		
		for(int i=0;i<sText.length();i++) {
			if(!iList.add(sText.charAt(i)))
				System.out.print(sText.charAt(i)+",");
							
		}
		
		System.out.println();
		//2nd Approach
		
		String sText1="When life gives you lemons, make lemonade";
		List<Character> iLists1=new LinkedList<>();
		
		for(int i=0;i<sText1.length();i++) {
			if(!iLists1.contains(sText1.charAt(i)))
				iLists1.add(sText1.charAt(i));
			else
				System.out.print(sText1.charAt(i)+",");
										
		}
		System.out.println();
		
		
		//2. Write a java program to print the list (Need 3 different answers)
		//Input: [B,u,g,a,t,t,i, ,C,h,i,r,o,n]
		
		//First Approach
		String sList1="Bugatti Chiron";
		List<Character> iList1=new LinkedList<>();
		for(int i=0;i<sList1.length();i++) {
			iList1.add(sList1.charAt(i));
		}
		for (int i = 0; i < iList1.size(); i++) {
			System.out.print(iList1.get(i));
		}
		System.out.println();
		
		//Second Approach
		String sList2="Bugatti Chiron";
		List<Character> iList2=new LinkedList<>();
		for (int i = 0; i < sList2.length(); i++) {
			iList2.add(sList2.charAt(i));
		}
		int j=0;
		while (iList2.size()>j) {
			System.out.print(iList2.get(j));
			j++;
					
		}
		System.out.println();
		
		//Third Approach
		String sList3="Bugatti Chiron";
		List<Character> iList3=new LinkedList<>();
		for (int i = 0; i < sList3.length(); i++) {
			iList3.add(sList3.charAt(i));
			
		}
		Iterator<Character> iteartor=iList3.iterator();
		while(iteartor.hasNext()) {
			System.out.print(iteartor.next());
		}
		
		System.out.println();
		
		//Forth Approach
		String sList4="Bugatti Chiron";
		List<Character> iList4=new LinkedList<>();
		for (int i = 0; i < sList4.length(); i++) {
			iList4.add(sList4.charAt(i));
			
		}
		for (Character character : iList4) {
			System.out.print(character);
		}

	}
	
	

}
