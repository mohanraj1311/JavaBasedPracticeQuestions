/*
This program finds the first non-repeated character in the string 
given as input

*/

import java.io.*;
import java.util.*;

class nonRepeatedCharacter{

	public static Character firstNonRepeated(String str){

		HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();

		int i, length;
		Character c;

		length = str.length();

		//build hash table by scanning the input string
		for(i = 0; i < length; i++){
			c = str.charAt(i);
			if(charHash.containsKey(c)){
				charHash.put(c,charHash.get(c)+1);
			} else {
				charHash.put(c,1);
			}
		}

		// Search the hash table in the order of the input string

		for(i = 0; i < length ; i++){
			c = str.charAt(i);
			if(charHash.get(c)==1)
				return c;
		}

		return null;

	}

	public static void main(String args[])throws IOException{

		System.out.println("Enter the string ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		char c = firstNonRepeated(input);

		
			System.out.println("The first non-repeated character : "+c);
		
			
	}
}


/*
mohan@mohans ~/javaPgms $ java nonRepeatedCharacter 
Enter the string 
oooooooopkkkkkkkkkkkkkk
The first non-repeated character : p
mohan@mohans ~/javaPgms $ 

*/