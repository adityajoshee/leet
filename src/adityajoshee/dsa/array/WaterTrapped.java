package adityajoshee.dsa.array;

/**
 * Created by aditya on 8/12/16.
 */
public class WaterTrapped {
    public static void main(String args[]){
        int[] arr  = new int[]{3, 0, 0, 2, 0, 4};
        System.out.println(totalWaterTrappedBetweenBuildings(arr));
    }

    private static int totalWaterTrappedBetweenBuildings(int[] arr){

        int[] maxToLeftOf = new int[arr.length];  // incl of current element
        int[] maxToRightOf = new int[arr.length];  // incl of currenct element

        maxToLeftOf[0] = arr[0];
        maxToRightOf[arr.length-1] = arr[arr.length-1];

        for(int i=1; i<arr.length; i++){
            maxToLeftOf[i] = Math.max(maxToLeftOf[i-1],arr[i]);
        }
        for(int i=arr.length-2; i>=0; i--){
            maxToRightOf[i] = Math.max(arr[i],maxToRightOf[i+1]);
        }

        // calculate water stored above each element and sum up;
        int totalWater = 0;
        for(int i=0; i<arr.length; i++){
            totalWater+= Math.min(maxToLeftOf[i],maxToRightOf[i]) - arr[i] ;
        }
        return totalWater;
    }
}
