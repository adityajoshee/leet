package adityajoshee.Y2K18.apr.D07;

import java.util.*;

/**
 * Created by aditya.joshee on 4/7/18.
 */
public class PrintAllSubarraysWith0Sum {
    public static void main(String[] args) {
        int[] arr = {1, 2, -2, 4,-4, 5}; // 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7}
        printAll(arr);
    }

    //On
    private static void printAll(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList(){{add(-1);}}); //init, like for cases {0} as input or {2,-2}
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (map.containsKey(sum)){
                List<Integer> list = map.get(sum);
                for (int k : list){
                    System.out.println((k+1)+","+i);
                }
                map.get(sum).add(i);
            }
            else {
                List<Integer> aList = new ArrayList<>();
                aList.add(i);
                map.put(sum, aList);
            }
        }
    }
}
