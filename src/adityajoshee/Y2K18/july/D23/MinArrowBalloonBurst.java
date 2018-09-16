package adityajoshee.Y2K18.july.D23;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aditya.joshee on 7/23/18.
 */
public class MinArrowBalloonBurst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] start = new int[num];
        int[] end = new int[num];

        for (int i = 0; i < num; i++) {
            start[i]=scanner.nextInt();
            end[i]=scanner.nextInt();
        }
        System.out.println(find(start, end));
    }

    private static int find(int[] start, int[] end) {
        sortByEnds(start, end);
        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(end));
        int p = 0;
        for (int i = 0; i < end.length;) {
            int currEnd = end[i];
            while (i<end.length && start[i]<=currEnd){
                i++;
            }
            p++;
        }
        return p;
    }

    private static void sortByEnds(int[] start, int[] end) {
        int len = end.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (end[j]>end[j+1]){
                    int t = end[j];
                    end[j] = end[j+1];
                    end[j+1] = t;

                    t = start[j];
                    start[j] = start[j+1];
                    start[j+1] = t;
                }
            }
        }
    }
}
