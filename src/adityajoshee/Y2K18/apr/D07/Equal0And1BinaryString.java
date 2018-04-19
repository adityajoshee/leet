package adityajoshee.Y2K18.apr.D07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by aditya.joshee on 4/7/18.
 * Given binary string find largest subarray having equal 0s and 1s.
 */
public class Equal0And1BinaryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findMaxLen(arr));
        System.out.println(maxLenOpt(arr));

    }

    // On2 solution
    private static int findMaxLen(int[] arr) {

        int maxl = 0;
        for (int i = 0; i < arr.length; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j]==0){
                    count0++;
                }
                else{
                    count1++;
                }
                if (count0==count1){
                    maxl = maxl>j-i+1?maxl:j-i+1;
                }
            }
        }
        return maxl;
    }
    private static int maxLenOpt(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(0, -1);  // superb
        for (int i = 0; i < arr.length; i++) {
            sum = sum + (arr[i]==0?-1:1);

            if (map.containsKey(sum)){
                int preIdx = map.get(sum);
                max = max < i - preIdx  ? i - preIdx : max;
            }
            else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
