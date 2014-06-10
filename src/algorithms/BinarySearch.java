package algorithms;

public class BinarySearch {
	public static void main(String[] args){
		int[] list = new int[]{1,4,5,9,10,14,21,22,24,44,55};
		System.out.println(search(list,55));
	}
	private static boolean search(int[] list,int x){
		int start=0;
		int mid = list.length/2;
		int end = list.length-1;
		
		while(start<=end){
			mid=start+(end-start)/2;
		if(x>list[mid]){
			start=mid+1;
		}
		else if(x==list[mid]){
			return true;
		}
		else{
			end=mid-1;
		}
		}
		return false;
	}
}