package adityajoshee.Y2K18.feb.D17;

/**
 * Created by aditya.joshee on 2/17/18.
 *
 * Given an array arr[], findMethod1 the maximum j – i such that arr[j] > arr[i]
 */
public class MaxJI {
    public static void main(String[] args) {
        int[] arr ={34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        int[] leftMin = new int[arr.length];
        int[] rightMax = new int[arr.length];
        create(arr, leftMin, rightMax);

        int i = 0, j=0;
        int maxDiff = -1;

        while (i< arr.length && j< arr.length){
            if (leftMin[i]<rightMax[j]){
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            }
            else {
                i++;
            }
        }
        return maxDiff;
    }

    private static void create(int[] arr, int[] leftMin, int[] rightMax) {
        leftMin[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMin[i] = leftMin[i-1]<arr[i] ? leftMin[i-1]: arr[i];
        }
        rightMax[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i>=0; i--) {
            rightMax[i] = rightMax[i+1]>arr[i] ? rightMax[i+1] : arr[i];
        }
    }


}
