package practice;

/**
 * Created by aditya on 8/10/16.
 */
import java.util.Scanner;
public class Sorting{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arr = new int[size];
        s = new Scanner(System.in);
        String inputString = s.nextLine();
        String[] sArr = inputString.split(" ");
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(sArr[i]);
        }
        boolean canBeSorted = true;
        for(int j=0; j<size/2; j++){
            boolean b = isSorted(arr,j,size-j-1);
            System.out.println(b);
            canBeSorted = canBeSorted && b;
        }
        System.out.print(canBeSorted?"Possible":"Not Possible");
    }

    private static boolean isSorted(int[] arr, int l, int r){
        System.out.println(" "+l+" "+r);
        boolean increasing = arr[r]>arr[l]?true:false;
        while(l<r){
            if(arr[l+1]<arr[l] && increasing){
                return false;
            }
            else if(arr[l+1]>arr[l] && !increasing){
                return false;
            }
            l++;
        }
        return true;

    }
}