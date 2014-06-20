package dyprog;
// 1 2 3 -4 -1 2 9 8 -5 -2 1 8

// Index i will iterate over the entire array 
// Index j will iterate over from i to the leftover array
// Using j add the array elements
// store the sum in 'sum' and check 'sum' with 'maxsum' with every addition

public class MSS {
	public static void main(String args[]){
		int[] list = {9 ,5 ,11 ,-24 ,-71 ,2, 6 ,8 ,-5 ,-42,11,28};
		System.out.println(subseqWithMaxSum(list));
	}

	static int subseqWithMaxSum(int[] list)
	{
		int maxSum=0;
		int sum=0;
		int n=list.length;
		for(int i=0;i<n;i++){
			sum=0;
			for(int j=i;j<n;j++){
				sum=sum+list[j];
				if(sum>maxSum){
					maxSum=sum;
				}			
			}
		}
		return maxSum;
	}
}
