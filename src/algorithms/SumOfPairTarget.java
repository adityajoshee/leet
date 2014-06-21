package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SumOfPairTarget {
	public static void main(String args[]){
		int[] input = new int[]{9,7,4,2,1,5,6,0,8};
		printPairWithSum(input,7);
		
	}
	//Let arr be the given array.
	//And T be the given sum
	 
	private static void printPairWithSum(int[] arr,int T){
		Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
		for (int i=0 ;i<arr.length - 1 ;i++)
		{
			hash.put(new Integer(arr[i]), new Integer(i))	;   //hash(arr[i]) = i  // key is the element and value is its index.
		}
		for (int i=0; i<arr.length - 1; i++)
		{
				if (hash.get(new Integer(T - arr[i]))!=null  && hash.get(new Integer(T - arr[i])).intValue() != i ) 			// if (T - element) exists and is different we found a pair
					System.out.println(arr[i] +","+ (T - arr[i])); 
		}
	}
}
