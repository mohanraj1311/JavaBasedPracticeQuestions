/*String compression
----------------------
This program shall take in a string and compress it.
For example : aaaabbbbc is compressed to a4b4c.
There is no point in writing c1 when c is more compressed.
Its because the compression itself shall fail.
For example : compress : abc , its : a1b1c1, which is much longer
than the origin string abc
*/

import java.io.*;
import java.io.*;

class stringCompression{

	public static String compressString(String original){
		int len = original.length();
		int i, j;
		//System.out.println("The length "+len);
		StringBuffer compressedStringBuffer = new StringBuffer();

		int countTheOccurences[] = new int[200];

		for (i = 0 ; i < len ; i++){
			countTheOccurences[i] = 1;
		}

		i = 0;
		j = 0;

		while(i < len && j < len ){

			if( i+1 < len && original.charAt(i)==original.charAt(i+1)){

				i++;
				countTheOccurences[j]++;
				continue;
			}

			else{
				compressedStringBuffer.append(original.charAt(j));
				if(countTheOccurences[j] > 1)
					compressedStringBuffer.append(countTheOccurences[j]);
				i++;
				j = i;
				continue;

			}

		}

		String compressedString = compressedStringBuffer.toString();
		return compressedString;

	}

	public static void main(String args[])throws IOException{
		System.out.println("Enter the original String");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String originalString = new String(bf.readLine());
		String output = compressString(originalString);
		System.out.println("The compressed String is "+output);

	}
}