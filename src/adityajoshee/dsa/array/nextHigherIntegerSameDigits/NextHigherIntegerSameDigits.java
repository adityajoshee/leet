package adityajoshee.dsa.array.nextHigherIntegerSameDigits;

import java.util.Arrays;

/**
 * Created by adityajoshee on 04/05/16.
 *
 * 1234 -> 1243
 * 1243 -> 1324
 * 1324 -> 1342
 * 1342 -> 1423
 * 1423 -> 1432
 * 1432 -> 2134
 * 15432 -> 21345
 *
 */
public class NextHigherIntegerSameDigits {
    public static void main(String args[]){
        int[] input = {2,3,4,1};//{4,3,2,1};
        findNextHigher(input);
        System.out.println(Arrays.toString(input));
    }

    private static void findNextHigher(int[] input){
        boolean solutionExists = false;
        int temp=-1;
        for(int i=input.length-2; i>=0; i--){
            if(input[i]<input[i+1]){
                solutionExists=true;
                temp=i;
                break;
            }
        }
        System.out.println("solutionExists: "+solutionExists);

        int swapindex = temp+1;
        for(int j=temp+1;j<input.length;j++){
            if(input[j]<input[swapindex] && input[j]>input[temp]){
                swapindex=j;
            }
        }
        swap(input,swapindex,temp);
        sortArray(input,temp+1,input.length-1);

    }
    private static void swap(int[] arr,int x, int y){
        System.out.println("swapping index:"+x+","+y);
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    private static void sortArray(int[] arr,int x, int y){
        System.out.println("sorting from:"+x);
        for(int i=0;i<=y-x;i++){
            for(int j=x;j<y-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }

    }

}
