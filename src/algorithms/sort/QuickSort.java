package algorithms.sort;

// Select the last element as the pivot. After every call to partition pivot will be shfited to its correct position
// in the final sorted array. Then reursively sort the two subarrays before and after pivot.

public class QuickSort {
	public static void main(String args[]){
		int[] input = new int[]{9,12,9,0,4,2,1,5,6,3,2,8};
		quickSort(input,0,input.length-1);
		int i=0;
		while(i<input.length)
			System.out.print(input[i++]+" ");
	}
	public static void quickSort(int[] A,int p,int r){
		if(p<r){
			int q = partition(A,p,r);						// q will become the correct position of pivot after this call
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}
	private static int partition(int[] A, int m, int n) {
		int x=n;
		int i=m;
		for(int j=m;j<x;j++){
			if(A[j]<A[x]){
				swap(A,i,j);	
				i++;
			}
		}
		swap(A,i,x);
		return i;
	}
	private static void swap(int[] A, int i, int x) {
		int temp = A[i];
		A[i]=A[x];
		A[x]=temp;
	}
}
