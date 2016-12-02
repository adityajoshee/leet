package adityajoshee.dsa.sort;

// Classic Insertion Sort
// O(n*n)
// Works better than merge sort only for very small input size 

public class InsertionSort {
	public static void main(String args[]){
		int[] input = new int[]{9,0,9,0,4,2,1,5,6,0,2,8};
		sort(input);
		int i=0;
		while(i<input.length)
			System.out.print(input[i++]+" ");
	}
	private static void sort(int[] input){
		int j,temp;
		for(int i=1;i<input.length;i++){
			j=i;
			while(j>0 && ((input[j]<input[j-1]))){
					temp=input[j];
					input[j]=input[j-1];
					input[j-1]=temp;
					j--;
			}
		}
	}
}
