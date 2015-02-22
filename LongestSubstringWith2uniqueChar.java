/*
Given a string, find the longest substring that contains only two unique characters. 
For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb". 
*/
import java.io.*;
import java.util.*;


class LongestSubstringWith2uniqueChar{

	public String findLongestSubstringWith2uniqueChar(String s){
		if(s==null)
			return null;
		if(s.length()==1)
			return s;
		String res = s.substring(0,0);
		for(int i = 0 ; i < s.length() - 2; i++){
			String tmp = helper(s,i);
			//System.out.println(tmp);
			if(tmp.length() > res.length())
				res = tmp;
		}
		return res;
	}

	public String helper(String s, int i){

		int j = i;
		
		while(s.charAt(j)==s.charAt(j+1))
			j++;
		char b = s.charAt(j+1);
		int k = j + 1;
		while(s.charAt(k)==b || s.charAt(k)==s.charAt(i))
			k++;
		return s.substring(i, k);
	}

	public static void main(String[] args)throws IOException{
		String s = "abcbbbbcccbdddadacb"; //System.out.println(s.length());
		LongestSubstringWith2uniqueChar obj = new LongestSubstringWith2uniqueChar();
		String res = obj.findLongestSubstringWith2uniqueChar(s);
		System.out.println(res);
	}

}