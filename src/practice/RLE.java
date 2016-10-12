package practice;

import java.util.Scanner;

/**
 * Created by aditya on 8/11/16.
 */
public class RLE {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println("RLE:"+rle(str));
    }
    private static String rle(String str){
        char[] arr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<arr.length; i++){
            int count = 1;
            while(i<arr.length-1 && arr[i+1]==arr[i]){
                i++; count++;
            }
            sb.append(arr[i]);
            if(count>1){
                sb.append(count) ;
            }
        }
        return sb.toString();
    }
}
