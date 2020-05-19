package week5_12_15May;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * 1. How to remove duplicates from a list? 
List = "A,B,C,D,A,D,E,F"
2. How to retrieve a value from a Set?
Set = "1,2,3,4,5,6,7,8,9"
retrieve and print only the value - 7

 */
public class Java_RemoveDupListPrintSet {

	public static void main(String[] args) {
		//1. How to remove duplicates from a list? 
		//List = "A,B,C,D,A,D,E,F"
		
		//1st Approach
		List<String> iList=new ArrayList<>();
		iList.add("A");
		iList.add("B");
		iList.add("C");
		iList.add("D");
		iList.add("A");
		iList.add("D");
		iList.add("E");
		iList.add("F");
		Set<String> iAddList=new LinkedHashSet<>(iList);
		
		System.out.println("Remove Duplicate from List-"+iAddList);
		
		//2nd Approach
		List<String> str=new ArrayList<>();
		str.add("A");
		str.add("B");
		str.add("C");
		str.add("D");
		str.add("A");
		str.add("D");
		str.add("E");
		str.add("F");
		List<String> strDup=new LinkedList<>(str);
		for (int i = 0; i < str.size(); i++) {
			String eachChar=str.get(i);
			int count=0;
			for (int j = 0; j < strDup.size(); j++) {
				if(eachChar==strDup.get(j))
					count++;
			}
			if(count>1)
				strDup.remove(eachChar);
		}
		System.out.println("Remove Duplicate from List-"+strDup);
		
		//2. How to retrieve a value from a Set?
		//Set = "1,2,3,4,5,6,7,8,9"
		//retrieve and print only the value - 7
		
		//1st Approach
		Set<Integer> iAddSet=new LinkedHashSet<>();
		iAddSet.add(1);
		iAddSet.add(2);
		iAddSet.add(3);
		iAddSet.add(4);
		iAddSet.add(5);
		iAddSet.add(6);
		iAddSet.add(7);
		iAddSet.add(8);
		iAddSet.add(9);
		List<Integer> iRetList=new ArrayList<>(iAddSet);
		System.out.println("retrieve and print only the value - '7'-"+iRetList.get(6));
		
		//2nd Approach
		Set<Integer> iAddSet1=new LinkedHashSet<>();
		iAddSet1.add(1);
		iAddSet1.add(2);
		iAddSet1.add(3);
		iAddSet1.add(4);
		iAddSet1.add(5);
		iAddSet1.add(6);
		iAddSet1.add(7);
		iAddSet1.add(8);
		iAddSet1.add(9);
		List<Integer> iRetList1=new ArrayList<>(iAddSet);
		for (Integer integer : iRetList1) {
			if(integer==7)
				System.out.println("retrieve and print only the value - '7'-"+integer);	
		}
		
		
		//3rd Approach
		Set<Integer> iAddSet2=new LinkedHashSet<>();
		iAddSet2.add(1);
		iAddSet2.add(2);
		iAddSet2.add(3);
		iAddSet2.add(4);
		iAddSet2.add(5);
		iAddSet2.add(6);
		iAddSet2.add(7);
		iAddSet2.add(8);
		iAddSet2.add(9);
		iAddSet2.forEach((eachnum) -> {
			if(eachnum==7)
				System.out.println("retrieve and print only the value - '7'-"+eachnum);
		});
		}



	}
	
	
