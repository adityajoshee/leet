package adityajoshee.dsa.array.sortedRotated;

/**
 * Created by aditya.j on 5/3/17.
 */
public class FindInSortedRotatedArrayRecur {
    public static void main(String args[]){
        int[] arr = {4,5,6,7,8,9,1,2,3};
        System.out.println(find(arr, 7));
    }

    //returns index or -1 if not found.
    private static int find(int[] arr, int x){
        return findHelper(x, arr, 0, arr.length-1);
    }

    private static int findHelper(int x, int[] arr, int l, int r){
        if (l<=r){
            int mid = l + (r-l)/2;

            if (arr[mid]==x){
                return mid;
            }

            if (arr[mid]>=arr[l] && x < arr[mid] && x >= arr[l]) {
                return findHelper(x, arr, l, mid-1);
            }
            if (arr[mid]>=arr[l]){
                return findHelper(x, arr, mid+1, r);
            }
            if (arr[mid]<=arr[l] && x > arr[mid] && x <= arr[r]){
                return findHelper(x, arr, mid+1, r);
            }
            return findHelper(x, arr, l, mid-1);

        }
        return -1;
    }
}
