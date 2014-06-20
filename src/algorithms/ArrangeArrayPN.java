package algorithms;

// Arrange array such that all -ves are on left of all +ves
// O(n) solution.

public class ArrangeArrayPN {
	public static void main(String args[]){
		int[] input = new int[]{-1,2,-4,6,3,-3,1,0,-5,-7,-1,9,-2};
		arrangeArray(input);
		int i=0;
		while(i<input.length)
			System.out.print(input[i++]+" ");
	}
	private static void arrangeArray(int[] A){
		int r = A.length-1;
		int l = 0;
		while(l<=r){
			if(A[l]>=0 && A[r]<0){
				swap(A,r,l);
			}
			else if(A[l]<0 && A[r]>=0){
				l++; r--;
			}
			else if(A[l]>=0 && A[r]>=0){
				r--;
			}
			else if(A[l]<0 && A[r]<0){
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
