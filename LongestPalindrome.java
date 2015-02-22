import java.io.*;
import java.util.*;


class LongestPalindrome{

	//int count = 0;

	public String findLongestPalindrome(String s){

		if(s==null)
			return null;
		if(s.length()==1)
			return null;
		String longest = s.substring(0,1);
		for(int i = 0; i < s.length(); i++){

			String tmp = helper(s,i,i);
			if(tmp.length() > longest.length())
				longest = tmp;

			tmp = helper(s,i,i+1);
			if(tmp.length() > longest.length())
				{longest = tmp;}
		}
		return longest;
	}


	public String helper(String s, int begin, int end){

		while (begin >= 0 && end < s.length() && s.charAt(begin)==s.charAt(end)) {
			begin--;
			end++;
		}

		return s.substring(begin+1,end);
	}


	public static void main(String[] args)throws IOException{
		LongestPalindrome obj = new LongestPalindrome();
		String s = "12121";
		String res = obj.findLongestPalindrome(s);
		System.out.println(res);
		//System.out.println(obj.count);

	}
}