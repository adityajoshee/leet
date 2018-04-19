package adityajoshee.Y2K18.mar.D18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/18/18.
 */
public class ActivitySelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] startTime = new int[N];
        int[] endTime = new int[N];
        for (int i = 0; i < N; i++) {
            startTime[i] = scanner.nextInt();
            endTime[i] = scanner.nextInt();
        }
        findMaxNum(startTime, endTime);
    }

    private static void  findMaxNum(int[] startTime, int[] endTime) {
        for (int i = 0; i < startTime.length; i++) {
            int max = 0;
            for (int j = 0; j < startTime.length-i; j++) {
                if (endTime[j]>endTime[max]){
                    max = j;
                }
            }
            swap(endTime, startTime, max, startTime.length-1-i);
        }
//        for (int i = 0; i < startTime.length; i++) {
//            System.out.print(startTime[i]+":");
//            System.out.println(endTime[i]);
//        }

        System.out.println(startTime[0]+":"+endTime[0]);// take first
        int lastEnd = endTime[0];
        for (int i = 1; i < startTime.length; i++) {
            if (startTime[i]>=lastEnd){
                System.out.println(startTime[i]+":"+endTime[i]);
                lastEnd = endTime[i];
            }
        }
    }

    private static void swap(int[] endTime, int[] startTime, int max, int last) {
        int i = endTime[last];
        int j = startTime[last];
        endTime[last] = endTime[max];
        startTime[last] = startTime[max];
        endTime[max] = i;
        startTime[max] = j;
    }
}
