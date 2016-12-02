package adityajoshee.dsa.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String args[]){
		int[] input = {9,8,5,4,3,5,2,1,1,0,10};//new int[]{9,12,9,0,4,2,1,5,6,3,2,8,0,14};
		mergeSort(input,0,input.length-1);
		System.out.println(Arrays.toString(input));
	}
	public static void mergeSort(int[] input,int left,int right){
		if(left<right){
			int q=(left+right)/2;
			mergeSort(input,left,q);
			mergeSort(input,q+1,right);
			merge(input,left,q,right);
		}
	}
	private static void merge(int[] A,int p,int q,int r){
		System.out.print("p:"+p+" ");
		System.out.print("q:"+q+" ");
		System.out.println("r:"+r);
		int n1=q-p+1; // size of left subarray
		int n2=r-q;  // size of right subarray
		int[] L=new int[n1]; 		//Left sorted array
		int[] R=new int[n2];		//Right sorted array
		
		
		// Copy respective values from A to the newly created array L & R
		for(int i=0;i<n1;i++)
			L[i]=A[p+i];
		for(int i=0;i<n2;i++)
			R[i]=A[q+1+i];
		
		int i=0;
		int j=0;
		int k=p;
		
		// Compare L & R array's first elemets and override in A
		while(i<n1 && j<n2){
			if(L[i]<R[j]){
				A[k++]=L[i++];
			}
			else{
				A[k++]=R[j++];
			}
		}
		
		// Copy the remaining array as it is
		if(i<n1){
			while(i<n1){
				A[k++]=L[i++];
			}
		}
		else{
			while(j<n2){
				A[k++]=R[j++];
			}
		}
	}
}
