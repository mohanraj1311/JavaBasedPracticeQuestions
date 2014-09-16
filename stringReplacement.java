import java.io.*;
import java.util.*;

/*

Question: Replace the blanks in the input sentence
with '%20'

Complexity is : O(n)

we start traversing the string from the back and 
already keep the extra spaces required.

Very important function to use : toCharArray().
It returns a character array.

Since strings are immutable in Java, this 
character array method comes in very handy

*/


class stringReplacement{

	public static void main(String args[]) throws IOException{
		System.out.println("Enter the string");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String original = new String(br.readLine());
		System.out.println("Entered String is : "+original);

		//System.out.println("The length: "+original.length());
		

		int originalLength = original.length();
		char origCharArray[] = original.toCharArray();
		int count = 0;
		int i = 0;
		int j = 0;
		for (i = 0 ; i < original.length() ; i++){
			if(original.charAt(i)==' ')
				count++;

		}
		int additionalSpaceRequired = count * 2;
		StringBuffer bf = new StringBuffer(original);
		for (i = 0 ; i < additionalSpaceRequired ; i++)
			bf = bf.append(" ");
		int modiLength = bf.length();
		System.out.println("The length of modified String: "+bf.length());
		//System.out.println("The modified string : "+bf.toString());
		String modifiedString = bf.toString();
		char charModiString[] = modifiedString.toCharArray();
		//System.out.println("Length "+charModiString.length());

		for (i = modiLength - 1 , j = originalLength - 1 ; j >=0 ; ){
			if(charModiString[j]!=' ')
				charModiString[i--] = charModiString[j--];
			else{
				charModiString[i--] = '0';
				charModiString[i--] = '2';
				charModiString[i--] = '%';
				j--;
			}
			//System.out.println("The modi String "+charModiString;
		}
		System.out.println("The modified String is :");
		for(i = 0 ; i < modiLength; i++)
			System.out.print(charModiString[i]);

		System.out.println("");
		

	}


}
