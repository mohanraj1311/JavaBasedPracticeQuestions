/*

Question : Merge two sorted Integer array to form a sorted array.
Complexity : O(m + n) where m & n are the lengths of arrays given.

Solution : Traverse through the first array completely by comparing
			at each step. After that the second array is copied from the
			point where the comparison stops.

*/


import java.io.*;
import java.util.*;

class arrayMerge{

	public static int[] arrayMergefunc(int[] array1, int[] array2){

		
		

		if(array2==null){
			return array1;
		}

		else if(array1==null){
			return array2;
		}

		else {

			int length1 = array1.length;
			int length2 = array2.length;
			int i=0, j=0, k =0;
			int mergeLength = length1 + length2;

			int[] mergedArr = new int[mergeLength];
			// Traversing through the first array completely
			for ( i = 0 , j = 0 , k = 0; i < length1 ; ){

				if(array1[i] < array2[j]){
					mergedArr[k++] = array1[i++];
				}
				else if(array1[i] > array2[j]){
					mergedArr[k++] = array2[j++];

				}
				else{
					mergedArr[k++] = array1[i++];
					mergedArr[k++] = array2[j++];
				}



			}

			//System.out.println("i:"+i+" j:"+j+" k:"+k);
			
			while(j < length2){
				mergedArr[k++] = array2[j++];
			}

			return mergedArr;
		}
	}


			
	public static void main(String args[]) throws IOException{

		int array1[] = { 1, 2, 3, 4,10};
		int array2[] = { 5,6,7,9,10,10};
		int i;



		int[] arrayMerge = arrayMergefunc(array1,array2);
		for (i = 0 ; i < arrayMerge.length ; i++){
			System.out.print(arrayMerge[i]+" ");
		}



	}

}