/*
Fundamental algorithm for computer Science.
Important points to remember:
1. After taking the taking the checking the middle element.
remeber to set the changing the mid+1 and mid-1
2. Each call should check start<=end
*/

import java.io.*;

class BinarySearch{


public int binarySearch(int[] arr, int x){
	return binarySearch(arr, 0 , arr.length-1, x);
}

public int binarySearch(int[] arr, int start, int end, int findElement){
	while(start<=end){

			int mid = (start + end)/2;
	if(arr[mid]==findElement)
		return mid;
	else if (arr[mid] < findElement)
		return binarySearch(arr, mid+1, end, findElement);
	else if (arr[mid] > findElement)
		return binarySearch(arr, start, mid-1, findElement);

	}
	System.out.println("Element not found");
	return -1;

	
}
	public static void main(String args[])throws IOException{
	int[] arr = {9,5,4,0,1,2,2,3,4};
	BinarySearch binarySearchObj = new BinarySearch();
	int index = binarySearchObj.binarySearch(arr, 9);
	System.out.println(index);

	}
}


