package adityajoshee.dsa.recursion;

/**
 * Created by adityajoshee on 25/04/16.
 *
 *
 * 1. Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array. Elements should be removed either end of the array.
 http://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/


 Time Complexity of this solution is exponential.


 */
public class TrimArray2MinGreaterThanMax {

    public static void main(String args[]){
        int[] arr ={4, 5, 100, 9, 10, 11, 12, 15, 200};
        System.out.println(helper(arr, 0, arr.length - 1));
    }

    private static int helper(int[] input,int start,int end){

        if(start>=end){
            // base case
            System.out.println("start:"+start+", end:"+end);
            return 0 ;
        }

        if(2*findMin(input,start,end)>findMax(input,start,end)){
            // done
            System.out.println("start:"+start+", end:"+end);
            return 0;
        }

        int x = 1+helper(input,start+1,end); // 1 removal i.e. removing start element
        int y = 1+helper(input,start,end-1);  // 1 removal i.e. removing end element

        return x>y?y:x; // take min no. of removals from many possible solutions
    }

    private static int findMin(int[] ip, int start, int end){
        int minval = ip[start];
        for(int i=start;i<=end;i++){
            if (minval>ip[i]) {
                minval = ip[i];
            }
        }
        return minval;
    }

    private static int findMax(int[] ip,int start, int end){
        int maxval = ip[start];
        for(int i=start;i<=end;i++){
            if(maxval<ip[i]){
                maxval=ip[i];
            }
        }
        return maxval;
    }

}
