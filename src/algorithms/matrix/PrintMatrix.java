package algorithms.matrix;

/**
 * Created by adityajoshee on 05/05/16.
 */
public class PrintMatrix {
    public static void print(int[][] c){
        for (int i=0;i<c.length;i++){
            for(int j=0;j<c.length;j++){
                System.out.print(" "+c[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------");

    }
}
