package week5_12_15May;

/*
https://github.com/Bobpie/PractiseJavaPrograms

 * Difficulty level: Medium
1. Write a java code to find the sum of the given numbers
Input: "asdf1qwer9as8d7"
output: 1+9+8+7 = 25
2. Write a java program to do the following.
Input: "When the world realise its own mistake, corona will dissolve automatically"
output: "When eht world esilaer its nwo mistake, anoroc will evlossid automatically"
3. Write a java program to find the number of Uppercase, lowercase, numbers and spaces in the following String.
Input: "1. It is Work from Home  not Work for Home"
 */
public class Java_RegEXCharASCII {

	public static void main(String[] args) {
		//1.Write a java code to find the sum of the given numbers  
		
		//1st Approach Using RegEx
		String sText="asdf1qwer9as8d7";
		String replaceAll = sText.replaceAll("[^0-9]","");
		int Increament=0;
		
		for (int i = 0; i < replaceAll.length(); i++) {
			char ch=replaceAll.charAt(i);
			int numericValue = Character.getNumericValue(ch);
			Increament=Increament+numericValue;
			
		}
		System.out.println("sum of the given numbers-"+Increament);
		
		//Alternate Approach
		String str3="asdf1qwer9as8d7";
		String number_str = str3.replaceAll("[^0-9]","");
		int num = Integer.parseInt(number_str);
		int sol=0;
		while(num>0) {
			sol+=num%10;
			num/=10;
		}
		System.out.println("sum of the given numbers-"+sol);
		
		
		//2nd Approach Using Character.isDigit
		String sCharcter1="asdf1qwer9as8d7";
		int increament1=0;
		for (int i = 0; i < sCharcter1.length(); i++) {
			char ch1=sCharcter1.charAt(i);
			if(Character.isDigit(ch1)) {
				int numericValue1 = Character.getNumericValue(ch1);
				increament1+=numericValue1;
			}
		}
		System.out.println("sum of the given numbers-"+increament1);
		
		//Alternate Approach
		String str1="asdf1qwer9as8d7";
		int sol1=0;
		for (int i = 0; i < str1.length(); i++) {
			
			if(Character.isDigit(str1.charAt(i))) {
				sol1+=Integer.parseInt(String.valueOf(str1.charAt(i)));
			}
		}
		System.out.println("sum of the given numbers-"+sol1);
		
		//3rd Approach Using ASCII
		String str2="asdf1qwer9as8d7";
		int sol2=0;
		for (int i = 0; i < str2.length(); i++) {
			int temp = str2.charAt(i);
			if(temp >=48 && temp <= 57) {
				sol2=Integer.parseInt(String.valueOf(str2.charAt(i)));
			}
		}
		System.out.println("sum of the given numbers-"+sol2);
		
		/*2.Write a java program to do the following.  iterate and even digit will be Reversed
		Input: "When the world realise its own mistake, corona will dissolve automatically"
		output: "When eht world esilaer its nwo mistake, anoroc will evlossid automatically"*/
		String sText1="When the world realise its own mistake, corona will dissolve automatically";
		String[] split = sText1.split(" ");
		String sConcat="";
		for (int i = 0; i < split.length; i++) {
			if(i%2==0)
				sConcat=sConcat+split[i]+" ";
			else if(i==0)
				sConcat=sConcat+split[i];
			else
			{
			StringBuffer str=new StringBuffer(split[i]);
			String rev=str.reverse().toString();
			sConcat=sConcat+rev+" ";
			}
		}
		System.out.println(sConcat);
		
		
		//Alternate Approach
		String str5="When the world realise its own mistake, corona will dissolve automatically";
		String[] array = str5.split(" ");
		for (int i = 0; i < array.length; i++) {
			if(i%2!=0) {
				for (int j = array[i].length()-1; j >=0; j--) 
					System.out.print(array[i].charAt(j));
			}
			else {
				System.out.println(array[i]);
			}
			System.out.println(" ");
				
		}
		//3.Write a java program to find the number of Uppercase, lowercase, numbers and spaces in the following String.

		//1st Aproach using Character
		String sText2="It is Work from Home  not Work for Home";
		int UpperCase=0;
		int lowecase=0;
		int number=0;
		int spaces=0;
		for (int i = 0; i < sText2.length(); i++) {
			char ch=sText2.charAt(i);
			if(Character.isUpperCase(ch))
				UpperCase++;
			else if(Character.isLowerCase(ch))
				lowecase++;
			else if(Character.isDigit(ch))
				number++;
			else if(Character.isSpaceChar(ch))
				spaces++;
			}
		System.out.println("number of Uppercase-"+UpperCase);
		System.out.println("number of lowecase-"+lowecase);
		System.out.println("number of number-"+number);
		System.out.println("number of spaces-"+spaces);

		//2nd Approach Using RegEx
		String sRegEX2="It is Work from Home  not Work for Home";
		String sUpperCase = sRegEX2.replaceAll("[^A-Z]","");
		int UpperCase1=sUpperCase.length();
		String slowecase1 = sRegEX2.replaceAll("[^a-z]","");
		int lowecase1=slowecase1.length();
		String snumber1 = sRegEX2.replaceAll("[^0-9]","");
		int number1 = snumber1.length();
		String sspaces1 = sRegEX2.replaceAll("\\S","");
		int spaces1 = sspaces1.length();
		
		System.out.println("number of Uppercase-"+UpperCase1);
		System.out.println("number of lowecase-"+lowecase1);
		System.out.println("number of number-"+number1);
		System.out.println("number of spaces-"+spaces1);

		//3 Approach Using ASCII
		String str4="It is Work from Home  not Work for Home";
		int Upper=0,lower=0,numbers=0,space=0;
		for (int i = 0; i < str4.length(); i++) {
			if ((int)str4.charAt(i) >= 48 && (int)str4.charAt(i) <=57)
				numbers++;
			else if((int)str4.charAt(i) >= 65 && (int)str4.charAt(i) <=90)
				Upper++;
			else if((int)str4.charAt(i) >= 97 && (int)str4.charAt(i) <=122)
				lower++;
			else if((int)str4.charAt(i) ==32)
				space++;
			System.out.println("number of Uppercase-"+Upper);
			System.out.println("number of lowecase-"+lower);
			System.out.println("number of number-"+numbers);
			System.out.println("number of spaces-"+space);
				
			
		}
		
		
		
		

	}

}
