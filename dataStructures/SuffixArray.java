/*
The suffix array implementation naive way
*/

import java.io.*;
import java.util.*;




public class SuffixArray{
	public static void main(String args[])throws IOException{
		System.out.println("Enter the string");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();

		int i;
		TreeMap<String, Integer> mapOfSuffixes = new TreeMap<String, Integer>();
		ArrayList<String> suffixList = new ArrayList<String>();

		for (i = 0; i < s1.length(); i++){
			//System.out.println("Substrings "+s1.substring(0,i));
			mapOfSuffixes.put(s1.substring(i,(s1.length())), i+1);
			suffixList.add(s1.substring(i,(s1.length())));

		}

		Collections.sort(suffixList);
		
		for(String entry : suffixList){
			System.out.println(mapOfSuffixes.get(entry)+":"+entry);
		}

		

	}
}


/*
mohan@mohans ~/javaPgms/dataStructures $ java SuffixArray 
Enter the string
mohan
4:an
3:han
1:mohan
5:n
2:ohan
mohan@mohans ~/javaPgms/dataStructures $ 
*/