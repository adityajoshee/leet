package algorithms.arrays;

/**
 * Created by aditya on 9/13/16.
 */
//http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

public class MinJumpsReachEnd {
    public static void main(String args[]){
        int[] jumpSet = {1,2,1,1,1};//{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.print("\n"+findMinJumps(jumpSet));
    }
    private static int findMinJumps(int[] jumpSet){

        int count = 0;
        for (int i = 0; i < jumpSet.length-1; ) {
            int max = -1;
            if(jumpSet[i]==0){
                return -1;
            }
            count++;
            int curr = i;
            System.out.print(i+" -> ");
            for (int j = curr+1; j <= curr+jumpSet[curr]; j++) {
                if(j == jumpSet.length-1){
                    System.out.print(j);
                    return count;
                }
                if(j+jumpSet[j]>max){
                    i = j;
                    max = j+jumpSet[j];
                }
            }
        }
        return count;
    }
}
