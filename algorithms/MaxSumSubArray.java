/*
The programs shows the famous algorithm of finding
the maximum sub-array problem.
I attempt to solve the problem in O(n).
The algorithm uses dynamic programming method

Algorithm: 

Declare two variables : max_curr & max_so_far.
Max_so_far will store the result in any given point of time.
Loop through all the elements of the array in the following manner.
1. max_curr gets updated with the max of [previous max_curr+currelement, current element]
2. max_so_far gets updated with the max of [max_curr , previous max_so_far]

NOTE : This algo shall work even when all the elements of array are negative as well.
*/

import java.io.*;


class MaxSumSubArray{
	
	public static int max(int x, int y){
		return (x > y)? x:y;
	}

	public static int findMaxSumSubArray(int[] arr){

		int max_curr = arr[0];
		int max_so_far = arr[0];

		for(int i = 0; i < arr.length; i++){
			max_curr = max(arr[i], arr[i] + max_curr);
			max_so_far = max(max_curr, max_so_far);
		}
		return max_so_far;

	}

	public static void main(String args[])throws IOException{
		int[] arr = {-1,9,-3,-3,-1,-1,-2,-1};
		int result = findMaxSumSubArray(arr);

		System.out.println("The max sum of the sub-array:"+result);

	}

}