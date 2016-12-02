package adityajoshee.dsa.array;

/**
 * Created by aditya on 8/13/16.
 */
// contiguous subarray sum
public class ContiguousSubarraySum {
    public static void main(String args[]){
        int[] arr = {1, 2, 9, 3, 5, 8};
        int contiguousSubarraySum = 17;
        IndexPair ip = getLeftAndRightIndexHavingSum(arr,contiguousSubarraySum);
        System.out.println(ip);
    }

    private static IndexPair getLeftAndRightIndexHavingSum(int[] arr, int sum){

        int l=0,r=0;
        int curr=0;

        while(l<=r && r<arr.length){
            if(curr==sum){
                return new IndexPair(l,r-1);
            }
            if(curr<sum){
                curr+=arr[r];
                r++;
            }
            else{
                curr-=arr[l];
                l++;
                if(l>r){
                    r++;
                }
            }
        }
        if(r==arr.length){
            if(curr<sum){
                return new IndexPair(-1,-1);
            }
            if(curr==sum){
                return new IndexPair(l,r-1);
            }
        }
        while(l<arr.length){
            curr-=arr[l];
            l++;
            if(curr==sum){
                return new IndexPair(l,r-1);
            }
        }

        return new IndexPair(-1,-1);
    }

    private static class IndexPair{
        int left;
        int right;

        public IndexPair(int l, int r){
            left=l;
            right=r;
        }
        public String toString(){
            return ("left:"+left+", right:"+right);
        }
    }
}
