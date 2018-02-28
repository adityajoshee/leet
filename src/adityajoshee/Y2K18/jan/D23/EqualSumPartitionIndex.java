package adityajoshee.Y2K18.jan.D23;

/**
 * Created by aditya.joshee on 1/23/18.
 * From an array, Need to find an index in which sum of left elements & sum of right elements are same.
 */
public class EqualSumPartitionIndex {
    public static void main(String[] args) {
        int[] arr = {2, 2, 9, 1, 4, 1};
        System.out.println(getIndex(arr));
    }

    private static int getIndex(int[] arr) {
        int l = -1;
        int r = arr.length;
        int ls = 0;
        int rs = 0;
        while (r - l != 1) {
            if (ls < rs) {
                l++;
                ls = ls + arr[l];
            } else {
                r--;
                rs = rs + arr[r];
            }
        }
        if (rs == ls) {
            return l;
        }
        return -1;
    }
}