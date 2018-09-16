package adityajoshee.dsa.array;

/**
 * Created by adityajoshee on 01/05/16.
 */

/*
Find a triplet that sum to a given value
Given an array and a value, findMethod1 if there is a triplet in array whose sum is equal to the given value.
If there is such a triplet present in array, then print the triplet and return true. Else return false.
For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, then there is a triplet (12, 3 and 9) present in array whose sum is 24.

Recursive approach O(n^3) but can be solved in O(n^2)
 */

public class TripletSum {
    public static void main(String args[]){
        int[] arr = {12, 3, 4, 1, 6, 9};
        int sum = 24;
        System.out.println(tripletExists(sum, arr, 0, arr.length - 1, 0));
    }

    private static boolean tripletExists(int sumLeft, int[] arr, int start, int end, int count){
        //System.out.println("sumLeft:"+sumLeft+"start:"+start+"end:"+end+"count:"+count);
        if(count==3 && sumLeft==0){
            // 3 elements found
            return true;
        }
        if(count==3 && sumLeft>0){
            return false;
        }
        boolean solutionExists = false;
        for(int i=start;i<=end;i++){
            int currentSelection = arr[i];
            if(count==2 && sumLeft-currentSelection!=0){
                solutionExists=false;
            }
            else{
                //System.out.println("TempSelected : " + currentSelection + " count:" + count);
                solutionExists = tripletExists(sumLeft-currentSelection,arr,start+1,end,count+1);
                if(solutionExists){
                   //System.out.print("Selected : "+currentSelection+" count:"+count);
                    break;
                }
                System.out.println();
            }
        }
        return solutionExists;
    }

}
