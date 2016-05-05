package algorithms.matrix;

/**
 * Created by adityajoshee on 05/05/16.
 */
public class Spiral {

    public static void main(String args[]){
        int[][] arr = {     {1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}      };
        printSpiral(arr);
    }

    private static void printSpiral(int[][] arr){
        for(int level=0;level<arr.length/2;level++){

            for(int i=level;i<arr.length-level-1;i++){
                System.out.print(arr[level][i]+" ");
            }

            for(int i=level;i<arr.length-level-1;i++){
                System.out.print(arr[i][arr.length-level-1]+" ");
            }

            for(int i=arr.length-level-1;i>level;i--){
                System.out.print(arr[arr.length-level-1][i]+" ");
            }

            for(int i=arr.length-level-1;i>level;i--){
                System.out.print(arr[i][level]+" ");
            }


        }
    }

}
