package adityajoshee.Y2K19.sep;

import adityajoshee.dsa.matrix.PrintMatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by aditya.joshee on 2019-09-14.
 */

// How to do it in place?
public class SortRowSorted2DMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                       { 5, 12, 17, 21, 23},
                       { 1,  2,  4,  6,  8},
                       {12, 14, 18, 19, 27},
                       { 3,  7,  9, 15, 25}};
        PrintMatrix.print(sort(mat));
    }
    
    private static int[][] sort(int[][] mat){
        PriorityQueue<ValueAndPos> pq = new PriorityQueue<ValueAndPos>((x, y) -> x.v.compareTo(y.v));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new ValueAndPos(mat[i][0], i, 0));
            map.put(i, 0);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                ValueAndPos vpos = pq.poll();
                if (map.get(i) < j){
                    //before writing to mat matrix, we need to ensure that the value at mat[i,j] is put in pq
                    pq.offer(new ValueAndPos(mat[i][j], i, j));
                    map.put(i, j);
                }
                mat[i][j] = vpos.v;
                if (vpos.c < mat[vpos.r].length-1 && map.get(vpos.r) < vpos.c+1){
                    pq.offer(new ValueAndPos(mat[vpos.r][vpos.c+1], vpos.r, vpos.c+1));
                    map.put(vpos.r, vpos.c+1);
                }
            }
        }
        return mat;
    }

    private static int[][] sort1(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        PriorityQueue<ValueAndPos> pq = new PriorityQueue<ValueAndPos>((x, y)->x.v.compareTo(y.v));
        //push leftmost element of each row to min heap
        for(int i=0; i<mat.length; i++){
            pq.offer(new ValueAndPos(mat[i][0], i, 0));
        }
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                ValueAndPos valueAndPos = pq.poll();
                if (valueAndPos.c < mat[valueAndPos.r].length-1){
                    //add next element from the same row, from which the element was polled
                    pq.offer(new ValueAndPos(mat[valueAndPos.r][valueAndPos.c+1], valueAndPos.r, valueAndPos.c +1 ));
                }
                res[i][j] = valueAndPos.v;
            }
        }
        return res;
    }
    private static class ValueAndPos {
        Integer v;
        Integer r;
        Integer c;

        public ValueAndPos(int value, int row, int col) {
            this.v = value;
            this.r = row;
            this.c = col;
        }
    }
}
