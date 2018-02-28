package adityajoshee.Y2K18.feb.D25;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 2/25/18.
 */
public class AnushreeChessTrials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            for (int j = 0; j < arr.length; j++) {
                int n = Integer.getInteger(arr[0]);
                int x = Integer.getInteger(arr[1]);
                int y = Integer.getInteger(arr[2]);
                System.out.println(findPercent(n, x, y));
            }
        }
    }

    private static int findPercent(int n, int x, int y) {
        int[][] visited = new int[n][n];
        //todo
        return 0;
    }
}
