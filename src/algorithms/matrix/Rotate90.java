package algorithms.matrix;

/**
 * Created by adityajoshee on 05/05/16.
 */


// take transpose and swap left right column pairs


public class Rotate90 {

    public static void main(String args[]){
        int[][] arr = {     {1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}      };
        PrintMatrix.print(arr);
        rotate(arr);
    }

    private static void rotate(int[][] arr){
        // transpose
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(i!=j){
                    trans(arr, i, j);
                }
            }
        }
        System.out.println("After transpose...");
        PrintMatrix.print(arr);


        // swap whole column pair from left to right
        for( int c=0; c<arr.length/2;c++){
            for(int row=0; row<arr.length; row++){
                swap(arr,row,c,row,arr.length-1-c);
            }
        }
        PrintMatrix.print(arr);


    }
    private static void trans(int[][] arr,int a, int z){
        int t= arr[a][z];
        arr[a][z] = arr[z][a];
        arr[z][a] = t;
    }

    private static void swap(int[][] arr,int a, int b, int x, int y){
        int t= arr[a][b];
        arr[a][b] = arr[x][y];
        arr[x][y] = t;
    }

}
