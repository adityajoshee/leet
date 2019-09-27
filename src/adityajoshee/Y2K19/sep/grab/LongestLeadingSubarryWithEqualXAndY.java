package adityajoshee.Y2K19.sep.grab;

/**
 * Created by aditya.joshee on 2019-09-26.
 */
public class LongestLeadingSubarryWithEqualXAndY {
    public static void main(String[] args) {
        int[] arr = {4,0,1,3,1,7,4, 7, 0};// {7, 42, 5, 6, 42, 8, 7, 5, 3, 6, 7};
        System.out.println(find(arr, 7, 4));
    }

    private static int find(int[] arr, int x, int y) {
        int xc = 0, yc = 0, j = 0, maxIdx = -1;
        while (j < arr.length){
            if (arr[j]==x){
                xc++;
            }
            else if(arr[j]==y){
                yc++;

            }
            if(xc - yc == 0 && xc != 0){
                maxIdx = j;
                xc = 0;
                yc = 0;
            }
            j++;
        }
        return maxIdx;
    }
}
