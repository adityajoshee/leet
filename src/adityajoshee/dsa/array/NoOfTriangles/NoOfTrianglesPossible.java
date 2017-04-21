package adityajoshee.dsa.array.NoOfTriangles;

import java.util.Arrays;

/**
 * Created by aditya.j on 3/26/17.
 */
/*
Find number of triangles possible for given sides array.
https://codility.com/media/train/13-CaterpillarMethod.pdf
 */
public class NoOfTrianglesPossible {
    public static void main(String args[]){
        int[] arr = {2,3,8,4,1,7};
        System.out.println(find(arr));
    }
    private static int find(int[] arr){
        if (arr==null || arr.length<3){
            return 0;
        }
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            int k = i+2;
            for (int j = i+1; j < arr.length-1; j++) {
                while (k<arr.length && arr[i]+arr[j]>arr[k]){
                    k++;
                }
                if (j!=k-1){
                    System.out.println(arr[i]+","+arr[j]+","+arr[k-1]);
                }
                count+=k-j-1;
            }
        }
        return count;
    }
}
