package adityajoshee.problems;

/**
 * Created by aditya.j on 5/13/17.
 */
public class Kadane {
    public static void main(String args[]){
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(findLargestContigSum(arr));
    }
    private static int findLargestContigSum(int[] arr){
        int currMax = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currMax+arr[i] > 0){
                currMax = currMax+arr[i];
                if (currMax > max){
                    max = currMax;
                }
            }
            else{
                currMax = 0;
            }
        }
        return max;
    }
}
