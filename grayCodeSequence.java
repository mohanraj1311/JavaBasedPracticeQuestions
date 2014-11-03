/*

This program generates a gray code sequence 
when an integer is given as an input

*/

import java.io.*;
import java.util.*;

class grayCodeSequence{

	public static ArrayList<Integer> grayCode(int n){

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);

		for(int i = 0; i<n ; i++){
			int inc = 1 << i;

			for(int j = arr.size()-1;j>=0;j--){
				arr.add(arr.get(j)+inc);
			}
		}

		return arr;
	}


	public static void main(String args[])throws IOException{

		System.out.println("Enter the Integer");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		//System.out.println(n);
		
		// Below is for the case , when the input is alphabet, we convert it to string
		//char[] c = br.readLine().toCharArray();
		//int n = (int) c[0];
		//System.out.println(n);

		System.out.println("---GRAY CODE BELOW---");
		ArrayList<Integer> output = grayCode(n);
		for(int i : output)
			System.out.println(i);

	}
}