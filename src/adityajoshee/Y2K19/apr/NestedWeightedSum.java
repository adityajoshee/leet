package adityajoshee.Y2K19.apr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aditya Joshee
 */
public class NestedWeightedSum {


    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        list.add(integers);
        list.add(2);
        list.add(integers);
        System.out.println(wsum(list,1));
    }

    private static int wsum(List<Object> list, int d) {
        int sum = 0;
        for (Object nn: list) {
            if (nn.getClass()==Integer.class){
                sum+=(Integer)nn*d;
            }
            else {
                sum = sum + wsum((List<Object>)nn,d+1);
            }
        }
        return sum;
    }
}
