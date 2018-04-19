package adityajoshee.Y2K18.mar.D17;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/15/18.
 */
public class EggDropping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        System.out.println(findDP(N, K));
        System.out.println(minTrialsInWorstCase(N,K));
    }

    private static int minTrialsInWorstCase(int eggs, int floors) {
        if (floors==1){
            return 1;
        }
        if (floors==0){
            return 0;
        }
        if (eggs==1){
            return floors; //in worst case the egg will break at highest floor
        }
        int min = Integer.MAX_VALUE;

        //throw from ith and if breaks....go down and trials++
        //throw from ith and doesnt break....go up trials++

        for (int i = 1; i <= floors; i++) {
            int res = Math.max(1+minTrialsInWorstCase(eggs-1, i-1), 1+minTrialsInWorstCase(eggs, floors-i));
            min = Math.min(min, res);
        }
        return min;
    }

    private static int findDP(int eggs, int floors){
        int[][] eggFloor = new int[eggs+1][floors+1];
        for (int i = 1; i <= floors; i++) {
            eggFloor[1][i] = i;
        }
        for (int i = 1; i < eggs; i++) {
            eggFloor[i][0] = 0;
            eggFloor[i][1] = 1;
        }
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    min = Math.min(min, Math.max(1+eggFloor[i-1][j-k], 1+eggFloor[i][k-1]));
                }
                eggFloor[i][j] = min;
            }
        }
        return eggFloor[eggs][floors];

    }
}
