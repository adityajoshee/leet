package algorithms;

public class BinarySearch {
	public static void main(String[] args){
		int[] list = new int[]{1,4,5,9,10,14,21,22,24,44,55};
		System.out.println(search(list,14));
	}
	private static boolean search(int[] list,int searchElement){
	
		int start=0;
		int mid;
		int end = list.length-1;
		
		while(start<=end){
			mid=start+(end-start)/2;	// For every iteration mid will be updated.
			if(searchElement>list[mid]){
				start=mid+1;
			}
			else if(searchElement==list[mid]){
				return true;
			}
			else{
				end=mid-1;
			}
		}
		return false;
	}
}