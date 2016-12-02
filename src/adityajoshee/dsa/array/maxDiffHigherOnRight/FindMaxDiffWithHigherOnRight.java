package adityajoshee.dsa.array.maxDiffHigherOnRight;

/**
 * Created by aditya on 11/23/16.
 */
//http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
public class FindMaxDiffWithHigherOnRight {
    public static void main(String args[]){
        int[] arr =  {2, 3, 1, 6, 10, 8, 1};
        System.out.println(findMaxDifference(arr));
    }
    private static int findMaxDifference(int[] arr){
        int tempMinIndex = 0;
        int tempMaxDiff = 0;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[tempMinIndex];
            if (diff>tempMaxDiff){
                tempMaxDiff = diff;
            }
            if (arr[i]<arr[tempMinIndex]){
                tempMinIndex = i;
            }
        }
        return tempMaxDiff;
    }
}
