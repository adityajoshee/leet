package algorithms.arrays;

/**
 * Created by aditya on 8/13/16.
 */
public class SubsetSum {
    public static void main(String args[]){
        int[] arr = new int[]{1, 2, 9, 3, 5, 8};
        int subsetSum = 4;
        IndexPair ip = getLeftAndRightIndexHavingSetSum(arr,subsetSum);
        System.out.println(ip);
    }

    private static IndexPair getLeftAndRightIndexHavingSetSum(int[] arr, int sum){

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
