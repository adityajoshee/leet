package adityajoshee.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 8/28/16.
 */
//codechef
public class FLOW017 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.MIN_VALUE ;
            int b = Integer.MIN_VALUE ;
            int c = Integer.MIN_VALUE ;
            String str = br.readLine();
            String[] arr = str.split(" ");
            for (int j = 0; j < arr.length; j++) {
                a = Integer.parseInt(arr[0]);
                b = Integer.parseInt(arr[1]);
                c = Integer.parseInt(arr[2]);
            }
            int largest = a;
            int secLargest = -1;
            if(b > largest){
                secLargest = largest;
                largest = b;
            }
            else if(b > secLargest)
                secLargest = b;
            if(c > largest){
                secLargest = largest;
                largest = c;
            }
            else if(c > secLargest)
                secLargest = c;

            System.out.println(secLargest);
        }
    }
}
