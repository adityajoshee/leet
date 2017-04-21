package adityajoshee.dsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.j on 3/29/17.
 */
public class AllCommonElementsInMatrixRows {
    public static void main(String args[]){
        int[][] matrix = {
                {6,2,3,4},
                {6,3,4,4},
                {3,1,5,6},
                {4,3,6,3}
        };
        find(matrix);
    }
    private static void find(int[][] matrix){
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < matrix[0].length; j++) {
            map.put(matrix[0][j], 0);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (map.get(matrix[i][j])!=null && map.get(matrix[i][j])==i-1){
                    map.put(matrix[i][j],i);
                    if (i==matrix.length-1){
                        System.out.println(matrix[i][j]);
                    }
                }
            }
        }
    }
}
