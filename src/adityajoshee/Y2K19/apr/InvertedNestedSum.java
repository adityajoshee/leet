package adityajoshee.Y2K19.apr;

import java.util.ArrayList;
import java.util.List;
//TODO
/**
 * @author Aditya Joshee
 */
public class InvertedNestedSum {
    public static void main(String[] args) {
        List<NestedInteger> input = new ArrayList<>();
        List<NestedInteger> list = new ArrayList<>();
        list.add(new NestedInteger(1));
        list.add(new NestedInteger(1));
        NestedInteger ni1 = new NestedInteger(list);

        NestedInteger ni2 = new NestedInteger(2);
        NestedInteger ni3 = new NestedInteger(list);

        input.add(ni1);
        input.add(ni2);
        input.add(ni3);

        System.out.println(wsum(input));

    }

    private static int wsum(List<NestedInteger> input) {
        return -1;
    }

    public static class NestedInteger{
        List<NestedInteger> nestedIntegers;
        Integer integer;

        public NestedInteger(Integer integer) {
            this.integer = integer;
        }

        public NestedInteger(List<NestedInteger> nestedIntegers) {
            this.nestedIntegers = nestedIntegers;
        }
    }
}
