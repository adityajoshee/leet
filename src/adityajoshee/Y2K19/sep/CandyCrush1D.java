package adityajoshee.Y2K19.sep;

import java.util.Arrays;

/**
 * Created by aditya.joshee on 2019-09-14.
 */
//https://leetcode.com/discuss/interview-question/380650/bloomberg-phone-screen-candy-crush-1d

/*Given a string, reduce the string by removing 3 or more consecutive identical characters.
You should greedily remove characters from left to right. So output may not be the smallest array.

Input: "aaabbbacd"
Output: "acd"

Input: "aabbbacd"
Output: "cd"
 */
public class CandyCrush1D {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(candyCrush(new int[]{1,1,2,2,2,1,3,4})));
    }

    private static int[] candyCrush(int[] arr) {
        int i=0;
        while (i<arr.length && arr[i]!=Integer.MAX_VALUE){
            int l = getLeftWidthOfChar(arr, i);
            int r = getRightWidthOfChar(arr, i);
            int dLen = l+1+r;
            if (dLen>=3){
                //remove / push all to left, starting from i+r+1 th pos to i-l
                int j = i+r+1;

                while (j<arr.length){
                    arr[j-dLen] = arr[j];
                    arr[j] = Integer.MAX_VALUE;
                    j++;
                }
            }
            else {
                i++;
            }
        }
        return arr;
    }

    private static int getLeftWidthOfChar(int[] arr, int i){
        int w = 0;
        while (i-1>=0 && arr[i]==arr[i-1]){
            w++;i--;
        }
        return w;
    }
    private static int getRightWidthOfChar(int[] arr, int i){
        int w = 0;
        while (i+1 <arr.length && arr[i+1]==arr[i]){
            w++;i++;
        }
        return w;
    }
}
