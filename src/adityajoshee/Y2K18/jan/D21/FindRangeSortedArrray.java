package adityajoshee.Y2K18.jan.D21;

/**
 * Created by aditya.joshee on 1/21/18.
 */
public class FindRangeSortedArrray {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 4, 7 ,8 };
        int x = 2;
        int k = binary(arr, x, 0, arr.length-1);
        System.out.println(k);
        if (k==-1){
            return;
        }
        System.out.println(leftRange(arr, k, x));
        System.out.println(rightRange(arr, k, x));
    }

    private static int rightRange(int[] arr, int k, int x) {
        int p = binary(arr, x, k+1, arr.length-1);
        int r = p;
        while (p!=-1){
            r = p;
            p =  binary(arr, x, p+1, arr.length-1);
        }
        return r;
    }

    private static int leftRange(int[] arr, int k, int x) {
        int p = binary(arr, x, 0, k-1);
        int r = p;
        while (p!=-1){
            r=p;
            p =  binary(arr, x, 0, p-1);
        }
        return r;
    }

    private static int binary(int[] arr, int x, int firstIndex, int lastIndex){
        int h = lastIndex;
        int l = firstIndex;
        int mid;
        while(h >= l){
            mid = l + (h-l)/2;
            if (arr[mid]==x){
                return mid;
            }
            if (arr[mid]>x){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }

}
