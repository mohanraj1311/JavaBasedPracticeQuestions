/*
Print all the combinations of a array.
Its same as print all the subsets of an array/set.
*/

import java.io.*;
import java.util.*;

class AllSubSets{

	public void generateAllSubets(int[] arr, int k, int n,char[] originalArray){
		if(k==n){
			arr[k]=0;
			printfn(arr,n,originalArray);
			arr[k]=1;
			printfn(arr,n,originalArray);
			return;

		}
		arr[k]=0;
		generateAllSubets(arr,k+1,n,originalArray);
		arr[k]=1;
		generateAllSubets(arr,k+1,n,originalArray);
	}

	public void printfn(int[] arr, int n, char[] originalArray){
		int sum = 0;
		for(int i = 0; i <= n; i++){
			if(arr[i]==1){
				System.out.print(originalArray[i]);
				sum++;
			}

		}
		if(sum==0){
			System.out.print("Null Set");
		}
		System.out.println("");
	}

	public static void main(String args[])throws IOException{
		String myString = "abcd";
		char[] myCharArr = myString.toCharArray();
		int[] arr = new int[myCharArr.length];
		AllSubSets obj = new AllSubSets();
		obj.generateAllSubets(arr,0,myCharArr.length - 1,myCharArr);
	}
}