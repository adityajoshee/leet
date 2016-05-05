package algorithms.arrays;

// Easy

// Given an array of binary 0/1 input, arrange such that
// all 0s are left to 1s. ( in some other problem 0s can represent -ves and 1s can represent +ves)
// O(n)

public class ArrangeArray01 {
	public static void main(String args[]){
		int[] input = new int[]{1,0,0,1,1,0,1,0,1,1,1,0};
		arrangeArray(input);
		int i=0;
		while(i<input.length)
			System.out.print(input[i++]+" ");
	}
	private static void arrangeArray(int[] A){
		int r = A.length-1;
		int l = 0;
		while(l<=r){
			if(A[l]==1 && A[r]==0){
				swap(A,r,l);
			}
			else if(A[l]==0 && A[r]==1){
				l++; r--;
			}
			else if(A[l]==1 && A[r]==1){
				r--;
			}
			else if(A[l]==0 && A[r]==0){
				l++;
			}
		}
	}
	
	private static void swap(int[] A, int i, int x) {
		int temp = A[i];
		A[i]=A[x];
		A[x]=temp;
	}
}
