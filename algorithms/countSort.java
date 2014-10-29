/*
The program implements counting sort.
A : Input array
B: Output array
C: Temp Array

Suppose there are n elements, then this sort
assumes that all the n elements are in the range k.
for example : the numbers to be sorted be :
4 4 3 2 1 0 4 3 3 2 1 0 1
Here the k = 4 and n = 10
*/

import java.io.*;
import java.util.*;

class countSort{

	public static int[] sortCount(int A[], int B[], int k){
		int n = A.length;
		int[] C = new int[k+1];
		int i, j;

		for (i= 0; i < k+1 ; i++)
			C[i] = 0;

		// This loop gives the count of each of the elements. How many 1s , 2s etc present?

		for(j= 0; j < n; j++){
			C[A[j]] = C[A[j]] + 1;     
		}

		//for(i = 0 ; i < C.length ; i++)
				//System.out.println(C[i]);

		// This loop gives how many elements greater than each of the present element. 
		//How many elements greater than or eqaul to 1? How many elements greater than or equal to 2?

		for(i = 1 ; i < C.length  ; i++){
			C[i] = C[i] + C[i - 1];   
		}

		//System.out.println("----------------------------");

		//for(i = 0 ; i < C.length ; i++)
				//System.out.println(C[i]);

		// This loop places the elements sorted into the output array


		for(j = n - 1; j> -1 ; j--){
			
			B[C[A[j]]] = A[j];      // Place correctly the elements using the array C.
			C[A[j]] = C[A[j]] - 1; // decrease the count of the elements already placed in the sorted array B.
			
		}
		
		//System.out.println("!!!!!!!!!");
				//for(i = 1 ; i < B.length ; i++)
					//System.out.println(B[i]);

		return B;
	}

	public static void main(String args[])throws IOException{
		
		int[] inputArr = {2,3,4,1,2,1,0,5};
		int n = inputArr.length;

		int[] outputArr = new int[n+1];
		int i;

		int[] output = sortCount(inputArr, outputArr, 5);
		System.out.println("========SORTED ORDER=============");
		for(i = 1 ; i < n + 1 ; i++)
			System.out.println(output[i]);
	}
}

