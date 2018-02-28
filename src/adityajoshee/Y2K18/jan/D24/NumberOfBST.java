package adityajoshee.Y2K18.jan.D24;

/**
 * Created by aditya.joshee on 1/23/18.
 */
public class NumberOfBST {
    private static long[] C;

    public static void main(String[] args) {
        int nodes = 100;
        C = new long[nodes+1];
        System.out.println(find(nodes));
    }

    private static long find(int nodes){
        if (C[nodes]!=0){
            return C[nodes];
        }
        if (nodes==0){
            C[nodes] = 1;
            return 1;
        }
        if (nodes<3){
            C[nodes] = nodes;
            return nodes;
        }
        long count = 0;
        for (int i = 0; i < nodes; i++) {
            count = count + find(i)*find(nodes-i-1);
        }
        C[nodes] = count;
        return count;
    }
}
