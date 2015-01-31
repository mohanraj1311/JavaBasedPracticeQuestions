// Check if the two given strings are anagrams
import java.io.*;
import java.util.*;
import java.util.Arrays;


class anagramCheck{

	// The below method involves the use of sort() method.
	// Its slighty inefficient method.
	public static boolean isAnagram(String s1, String s2){

		if(s1.length()!=s2.length())
			return false;

		char[] strCharArr1 = s1.toCharArray();
		char[] strCharArr2 = s2.toCharArray();

		

		java.util.Arrays.sort(strCharArr1);
		java.util.Arrays.sort(strCharArr2);

		String str1 = new String(strCharArr1);
		String str2 = new String(strCharArr2);
		

		if(str1.equals(str2))
			return true;
		else
			return false;

	}

	// The below method is more efficient way of doing 
	public static boolean isAnagram2(String s1, String s2){

		if(s1.length()!=s2.length())
			return false;

		int[] letters = new int[256];

		char[] strArray1 = s1.toCharArray();
		

		for (char c : strArray1){
			letters[c]++;
		}

		for (int i = 0; i < s2.length(); i++){
			int c = (int) s2.charAt(i);
			if(--letters[c] < 0)
				return false;

		}

		return true;
	}

	public static void main(String args[]) throws IOException{
		System.out.println("Enter original string ");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String original = new String(bf.readLine());

		System.out.println("Enter anagram string ");
		String anagram = new String(bf.readLine());
		Boolean isAnagramStr = isAnagram2(original, anagram);
		if(isAnagramStr)
			System.out.println("Strings are anagrams");
		else
			System.out.println("Strings are NOT anagrams");



	}
}
