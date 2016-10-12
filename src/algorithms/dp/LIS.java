package algorithms.dp;

/*
Longest Increasing Subsequence
 */
public class LIS {

    public static void main(String args[]){
        int[]	 input = {3, 4, 1, 5};//{1,2,3,0,4,6,11,7,12,2,3,1};
        System.out.println(findLIS(input));
    }

    public static int findLIS(int[] seq){
        int[] LIS=new int[seq.length]; // LIS[p] mean the LIS till index p and also containing seq[p]

        for(int k=0; k<seq.length; k++){
            LIS[k]=1; // since LIS[k] will atleast have the element k
        }
        for(int i=1;i<LIS.length;i++){
            int maxn=1;
            for(int j=0;j<i;j++){
                if(seq[j]<seq[i] && LIS[j]>maxn)
                {
                    maxn=LIS[j];
                }
            }
            LIS[i]=maxn+1; // +1 for adding seq[i] to LIS(i)
        }
        return maxElement(LIS);
    }


    // find max element from an array
    private static int maxElement(int[] arr){
        int maxOfAll=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxOfAll){
                maxOfAll=arr[i];
            }
        }
        return maxOfAll;
    }

}
