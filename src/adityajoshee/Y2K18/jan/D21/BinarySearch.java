package adityajoshee.Y2K18.jan.D21;

/**
 * Created by aditya.joshee on 1/21/18.
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(find(new int[]{1,3,3,5,6,9,10,20,24}, 10));
    }

    private static int find(int[] num, int x) {

        int h = num.length-1;
        int l = 0;
        int mid;
        while (h>=l){
            mid = l + (h-l)/2;
            if (num[mid]==x){
                return mid;
            }
            if (num[mid]>x){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}
