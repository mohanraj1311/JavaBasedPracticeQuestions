/*
This program removes the vowels from the given string.

*/

import java.io.*;
import java.util.*;

class removeVowels{


	public static String removeVowelsMethod(String input, String remove){

		char[] inArray = input.toCharArray();
		char[] removeArray = remove.toCharArray();
		int src, dst = 0;

		//initialize all flags to false
		boolean[] flags = new boolean[128];


		// Set the flags to be removed
		for(src = 0; src < removeArray.length; ++src){
			flags[removeArray[src]] = true;

		}

		// Loop through the input string,
		//Copying only if they aren't flagged
		for(src = 0; src < inArray.length; ++src){
			if(!flags[inArray[src]]){
				inArray[dst++] = inArray[src];
			}
		}

		return new String(inArray, 0, dst);


	}


	public static void main(String args[])throws IOException{

	System.out.println("Enter the input string ");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String input = br.readLine();
	input = input.toLowerCase();
	//System.out.println("Entered String "+input);

	System.out.println("Enter the characters to be removed in string format ");
	String remove = br.readLine();

	String output = removeVowelsMethod(input, remove);

	System.out.println("After removal of vowels: "+output);


}

}

/*
mohan@mohans ~/javaPgms $ java removeVowels 
Enter the input string 
Mohan Raj University of Florida
Enter the characters to be removed in string format 
aeiou
After removal of vowels: Mhn Rj Unvrsty f Flrd
mohan@mohans ~/javaPgms $ 
*/
