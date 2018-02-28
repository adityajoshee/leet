package adityajoshee.Y2K18.jan.D21;

/**
 * Created by aditya.joshee on 1/21/18.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {3,2,1,3,4,3};

        System.out.println(remove(arr,3));
    }

    private static int remove(int[] arr, int x) {
        int c=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=x){
                arr[c]=arr[i];
                c++;
            }
        }
        return c;
    }
}
