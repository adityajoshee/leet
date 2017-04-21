package adityajoshee.hackerrank.dynamic;

/**
 * Created by aditya.j on 4/14/17.
 */
//Multiple transactions allowed, can hold multiple stocks
public class StockMaximize {
    public static void main(String args[]){
        int[] scrip = {1,3,4,2,1,1,1,1,1};
        System.out.println(find(scrip));
    }
    private static long find(int[] scrip){
        //traverse from right end, current element as x.
        // keep adding the diff will the elements on left are smaller then current.
        // when a larger element comes, replace x with that.
        int x = scrip.length-1;
        int i = x-1;
        long profit = 0;

        while (i>=0){
            while (i>=0 && scrip[i]<scrip[x]){
                profit+=scrip[x]-scrip[i--];
            }
            if (i>0){
                x = i--;
            }
            else {
                break;
            }
        }
        return profit;
    }
}
