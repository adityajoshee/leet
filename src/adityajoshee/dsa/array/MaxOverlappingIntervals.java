package adityajoshee.dsa.array;

/**
 * Created by aditya.joshee on 30/07/14.
 */


//incomplete
public class MaxOverlappingIntervals {
    public static void main(String args[]) {
        int[] arr = new int[]{
                1, 3,
                2, 6,
                10, 14,
                11, 14,
                16, 15,
                17, 20
        };
        int[] arrStart = new int[]{1,2,10,11,16,17};
        int[] end;

        int i = arr.length - 1;
        int count=0;
        int max=0;
        while (i-- >= 0) {
            if(i%2==0){
                count++;
                if(count>max){
                    max=count;
                }
            }
            else{
                count--;
            }
        }
        System.out.println("Overlapping Intervals : "+max);
    }
}
