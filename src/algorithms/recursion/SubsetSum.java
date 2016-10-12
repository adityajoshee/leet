package algorithms.recursion;

/**
 * Created by adityajoshee on 03/05/16.
 */
public class SubsetSum {
    public static void main(String args[]){
        int[] input = {4,3,2,8,6,1,7};//{3, 34, 4, 12, 5, 2};
        printSubsetsWithSum(input,19,0,"");
    }
    private static boolean printSubsetsWithSum(int[] arr, int sumLeft, int start, String set){
        //System.out.println("sumleft:"+sumLeft+"  start:"+start+"  set:"+set);
        if(sumLeft==0){
            System.out.println("subset found: "+set);
            return true;
        }
        if(start==arr.length){
            // array processed in the current call but sum not satisfied
            return false;
        }
        for(int i=start; i<arr.length; i++){
            if(arr[i]<=sumLeft){
                sumLeft = sumLeft - arr[i];
                printSubsetsWithSum(arr,sumLeft,i+1,arr[i]+ " "+ set);
                sumLeft= sumLeft + arr[i];
            }
        }
        return false;
    }
}
