/*

This program finds if the two strings given as input are the rotation
of the one another.

*/

import java.io.*;
import java.util.*;

class rotationOrNot{


	public static boolean isRotatedString(String s1, String s2){

		return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
	}

	public static void main(String args[])throws IOException{

		System.out.println("Enter the string");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		System.out.println("Enter the rotated string");
		String rotatedStr = br.readLine();

		boolean isRotatedString = isRotatedString(input, rotatedStr);
		if(isRotatedString)
			System.out.println("Strings are rotated");
		else
			System.out.println("Strings are non-rotated");
	}
}