package algorithms.sort;

// Select the last element as the pivot. After every call to partition the array,  pivot will be shfited to its correct position
// in the final sorted array. Then reursively sort the two subarrays before and after pivot.

public class QuickSort {
	public static void main(String args[]){
		int[] input = new int[]{1,9,12,9,0,4,2,1,5,6,3,2,8};
		quickSort(input,0,input.length-1); // pass the input array and scope
		for (int x: input) {
			System.out.print(x +" ");
		}
	}
	public static void quickSort(int[] A,int p,int r){
		if(p<r){
			int q = partition(A,p,r);						// q will become the correct position of pivot after this call
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}
	private static int partition(int[] A, int start, int end) {
		int i=start;
		int j=end-1;
		while(i<j){
			while(A[i]<A[end]){
				i++;
			}
			while(A[j]>A[end]){
				j--;
			}
			if(i<=j){
				swap(A,i,j);
			}
		}
		swap(A,i,end);
		return i;
	}
	private static void swap(int[] A, int i, int x) {
		int temp = A[i];
		A[i]=A[x];
		A[x]=temp;
	}
}
