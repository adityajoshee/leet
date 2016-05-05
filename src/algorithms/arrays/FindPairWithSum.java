package algorithms.arrays;

import java.util.Arrays;

/**
 * Created by adityajoshee on 02/05/16.
 */
public class FindPairWithSum {
    public static void main(String args[]){
        int[] input = {10, 20, 4, 6, 12, 5, 2}; // 4(i), 5, 6, 10, 12(j)
        printPair(input, 22);
    }

    private static void printPair(int[] input, int x){

        Arrays.sort(input); // nlogn
        for(int i=0,j=input.length-1; i<input.length; ){
            if(i<j){
                if(input[i]+input[j]==x){
                    System.out.print(input[i]+", "+input[j]);
                    System.out.println();

                    i++;j--;
                }
                else if(input[i]+input[j]>x){
                    j--;
                }
                else{
                    i++;
                }
            }
            else{
                break;
            }
        }

    }

}
