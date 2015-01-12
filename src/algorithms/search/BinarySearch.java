package algorithms.search;

/**
 * Created by aditya.joshee on 07/08/14.
 */

public class BinarySearch {
	public static void main(String[] args){
		int[] list = new int[]{1,4,5,9,10,14,21,22,24,44,55};
		System.out.println("Position: "+search(list,14));
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
}