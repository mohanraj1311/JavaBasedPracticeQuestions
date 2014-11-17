/*
This program reverses the words of a sentences individually.

mohan@mohans ~/javaPgms $ java WordReversalSentence 
Enter the sentence
mohan raj is good guy               
The output is : nahom jar si doog yug 
mohan@mohans ~/javaPgms $

*/

import java.io.*;
import java.util.*;

class WordReversal{

	public String reverseWord(String str){
		int strlen = str.length();
		char[] strarr = str.toCharArray();
		int i = 0;
		int j = strlen - 1;
		while(i < j){
			char s = strarr[i];
			strarr[i] = strarr[j];
			strarr[j] = s;
			i++;
			j--;
		}

		return new String(strarr);
	}
}

class WordReversalSentence{

	public static void main(String args[]) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the sentence");
		String input = br.readLine();
		StringBuffer sbf= new StringBuffer();
		WordReversal obj = new WordReversal();
		//String output = obj.reverseWord(input);
		//System.out.println("The reverse string: "+output);
		String[] strArr = input.split(" ");
		for(String s: strArr){
			String tmp = obj.reverseWord(s)+" ";
			sbf.append(tmp);
			//System.out.println("The output is : "+sbf.toString());
		}

		System.out.println("The output is : "+sbf.toString());


	}
}
