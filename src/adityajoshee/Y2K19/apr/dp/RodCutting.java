package adityajoshee.Y2K19.apr.dp;

/**
 * @author Aditya Joshee
 */
public class RodCutting {
    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println(maxProfit(arr, arr.length-1, size));
        System.out.println(maxProfitLoopSolution(arr, size)); }

    private static int maxProfit(int[] arr, int i, int size) {
        if (i<0){
            return 0;
        }

        if (size>=i+1){
            return Math.max(arr[i]+maxProfit(arr, i-1, size-i-1),
                    maxProfit(arr, i-1, size));
        }
        return maxProfit(arr, i-1, size);
    }

    private static int maxProfitLoopSolution(int[] arr, int size){
        if (size<=0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < size; i++){
            // for each cut size
            max = Math.max(max, arr[i]+maxProfitLoopSolution(arr, size-i-1));
        }
        return max;

    }
}
