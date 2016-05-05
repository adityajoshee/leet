package algorithms.arrays;

/**
 * Created by adityajoshee on 05/05/16.
 */

// 100(p),4,6,1,7,3,9,10,0,5,101
// start                   end
public class KthSmallest {
    public static void main(String args[]){
        int[] arr = {100,4,6,1,7,3,9,10,0,5,101};
        System.out.println(kthSmallest(12, arr, 0, arr.length - 1));
    }

    private static int kthSmallest(int k, int[] arr, int left, int right){

        if(k-1>arr.length-1){ // required index > max index of array
            return -1;
        }

        int p = left; // take pivot as left most in current array (for better avg, take randomized pivot)

        int start = left;
        int end = right;

        while(left<right){
            while(left<=right && arr[left]<=arr[p]){
                left++;
            }
            while(left<=right && arr[right]>=arr[p]){
                right--;
            }
            if(left<right){
                swap(arr,left,right);
            }
        }
        swap(arr,p,right);
        printArray(arr,start,end);
        System.out.println("left:"+left+", right:"+right);
        if(right==k-1){
            System.out.println("FOUND");
            return arr[k-1];
        }
        if(right<k-1){
            // consider right partition only
            return kthSmallest(k, arr, right+1, end);
        }
        else{
            // consider left partition only
            return kthSmallest(k, arr, start, right-1);
        }

    }
    private static void swap(int[] arr,int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    private static void printArray(int[] arr, int start, int end){
        System.out.println("start:"+start+", end:"+end);
        for (int i= start ; i<=end; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
