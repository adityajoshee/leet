package adityajoshee.dsa.recursion;

/**
 * Created by aditya.j on 5/7/17.
 */
public class CombinationsConsistingZeroOneWildcard {
    public static void main(String args[]) {
        char[] arr = {'1', '?', '0', '1', '?'};//, '?', '0', '?'};
        printAll(arr, 0, "");
    }

    private static void printAll(char[] arr, int i, String current) {
        if (i < arr.length && arr[i] == '?') {
            printAll(arr, i + 1, current + '0');
            printAll(arr, i + 1, current + '1');
        } else if (i < arr.length) {
            printAll(arr, i + 1, current + arr[i]);
        } else {
            System.out.println(current);
        }
    }

    private static void printAllIterative(char[] arr, int i, String current) {
        //TODO
    }
}
