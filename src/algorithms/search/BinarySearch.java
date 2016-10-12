package algorithms.search;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 07/08/14.
 */

public class BinarySearch {
	public static void main(String[] args){
		int[] list = new int[]{100,4,5,9,10,14,21,22,24,44,55};
		list = sort(list);
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		System. out.println("Searching for : \n"+x);
		System.out.println("Position: "+search(list,x));
	}
	private static int search(int[] list,int searchElement){
	
		int start=0;
		int mid;
		int end = list.length-1;
		
		while(start<=end){
			mid=start+(end-start)/2;	// For every iteration mid will be updated.
			if(searchElement>list[mid]){
				start=mid+1;                 // Adding 1 is req.
			}
			else if(searchElement==list[mid]){            // found the searchElement ... return true.
				return mid;
			}
			else{
				end=mid-1;                  // Sub 1 is req.
			}
		}
		return -1;
	}



	private static int[] sort(int[] arr){
		// bubble sort

		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length-1-i; j++){ // with every iteration, the next bigger will be at the correct position.
				if(arr[j+1]<arr[j]){
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}


}