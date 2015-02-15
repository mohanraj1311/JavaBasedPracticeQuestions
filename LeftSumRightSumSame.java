/*
Given an array.
The array contains an element such that the 
sum of the elements on the left of this element is 
equal to the sum of the elements on the right of this element.
Find the element.

*/

import java.io.*;
import java.util.*;

class LeftSumRightSumSame{

	public void betterMethod(int[] arr){
		int sumTotal = 0;
		int previousSum = 0;
		
		for(int i = 0; i < arr.length; i++)
			sumTotal+=arr[i];


		for(int i = 0 ; i < arr.length; i++){
			previousSum+=arr[i];
			
			if(previousSum==sumTotal-previousSum){
				System.out.println(arr[i]);
				break;
			}
		}
	}
	public static void main(String args[])throws IOException{
		int arr[]={7, 1, 2, 5,-1};

		LeftSumRightSumSame obj = new LeftSumRightSumSame();
		obj.betterMethod(arr);
	}
}

/*
mohan@mohans ~/javaPgms $ javac LeftSumRightSumSame.java 
mohan@mohans ~/javaPgms $ java LeftSumRightSumSame 
7
mohan@mohans ~/javaPgms $ 
*/