package algorithms.arrays;

// Find an element in a rotated array
// Need log(N) approach


public class FindInRotatedArray {
	public static void main(String[] args){
		int[] list = new int[50];
		for(int i=0;i<list.length;i++){
			list[i]=i;
		}
		rotateArray(list,10);
		for(int i=0;i<list.length;i++)
			System.out.print(list[i]+" ");
		
		// UNFINISHED
		
	}
	private static boolean rotateArray(int[] list,int r){
		while(r-->0){
			int tmp = list[list.length-1];
			for(int i=list.length-1;i>0;i--){
				list[i]=list[i-1];
			}
			list[0]=tmp;
		}
		return true;
	}
	
}
