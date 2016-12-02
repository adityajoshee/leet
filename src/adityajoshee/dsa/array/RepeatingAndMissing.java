package adityajoshee.dsa.array;

/**
 * Created by aditya on 11/7/16.
 */
//http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
public class RepeatingAndMissing {
    public static void main(String args[]){
        int[] arr = {4,2,1,4,5,6};
        findUsingConstantSpace(arr);
    }
    private static void findUsingExtraSpace(int[] arr){
        int[] countArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(countArr[arr[i]-1]==1){
                System.out.println("Duplicate:"+ arr[i]);
            }
            countArr[arr[i]]++;
        }
        for (int i = 0; i < countArr.length; i++) {
            if(countArr[i]==0){
                System.out.println("Missing:"+ i);
            }
        }
    }
    
    
    private static void findUsingConstantSpace(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int x = Math.abs(arr[i]);
            if (arr[x-1]<0){
                System.out.println("Duplicate:"+ Math.abs(arr[i]));
            }
            else{
                arr[x-1]*=-1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>0){
                System.out.println("Missing:"+ i);
            }
        }
    }
}
