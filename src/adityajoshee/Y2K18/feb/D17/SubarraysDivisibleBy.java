package adityajoshee.Y2K18.feb.D17;

/**
 * Created by aditya.joshee on 2/17/18.
 */
public class SubarraysDivisibleBy {
    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        System.out.println(count(arr, 5));
    }

    private static int count(int[] arr, int x) {
        int[] mod = createMod(arr, x);
        int count = 0;
        for (int i = 0; i < mod.length; i++) {
            if (mod[i]>1){
                count = count + (mod[i]*(mod[i]-1))/2;
            }
        }
        return count;
    }

    private static int[] createMod(int[] arr, int x){
        int sum = 0;
        int[] mod = new int[x];
        mod[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            mod[sum%x] = mod[sum%x] + 1;
        }
        return mod;
    }
}
