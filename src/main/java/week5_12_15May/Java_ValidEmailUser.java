package week5_12_15May;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 1. Write a java program to verify whether the given String is valid email address.
Input: "balaji.chandrasekaran@testleaf.com"
output: true
Input: "balaji.c@tunatap.co.uk"
output: true
Input: "naveen e@tl.com"
output: false
Note: Spl characters like . _ are only allowed
2. Write a java program to validate the given username is valid or not
Input: "Balaji_1"
output: false
Input: "Testleaf$123"
output: false
Note: 
1. It should contain minimum 8 characters.
2. It allows alpha numeric characters and spl characters like . _ @ $
 */
public class Java_ValidEmailUser {

	public static void main(String[] args) {
		//Write a java program to verify whether the given String is valid email address.
		String sText="balaji.chandrasekaran@testleaf.com";
		//String sText="balaji.c@tunatap.co.uk";
		//String sText="naveen e@tl.com";
		String sPattern="[A-Za-z0-9._]+@[a-z0-9]+.[a-z.]{2,}";
		Pattern compile = Pattern.compile(sPattern);
		Matcher matcher = compile.matcher(sText);
		System.out.println(matcher.matches());
		
		
		// Write a java program to validate the given username is valid or not
		//String sUsername="Balaji_1";
		String sUsername="Testleaf$123";
		String sUserPattern="[a-zA-z0-9._@$]{8,}";
		//another pattern String regex ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
		Pattern Usercompile = Pattern.compile(sUserPattern);
		Matcher Usermatcher = Usercompile.matcher(sUsername);
		System.out.println(Usermatcher.matches());

	}

}
