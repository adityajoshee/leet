package adityajoshee.Y2K19.sep.grab;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aditya.joshee on 2019-09-26.
 */
//https://github.com/rishabh115/Interview-Questions/tree/master/Grab#coding

public class FindPerfectSquaresBetween {
    public static void main(String[] args) {
        int a = 5, b = 100;
        find( a, b);
        findOpt(a, b);
    }

    private static void findOpt(int a, int b){
        System.out.println(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
    }

    private static void find(int a, int b) {
        // for nums greater than 4 sq root is always less than half of the number.
        List<Integer> res = new LinkedList<>();

        int start = 3;
        int sq = start*start;
        while(sq <= b){
            if (sq >= a)
                System.out.println(sq);
            start++;
            sq = start*start;
        }
    }
}
