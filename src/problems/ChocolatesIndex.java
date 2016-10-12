package problems;

/**
 * Created by aditya on 7/9/16.
 */
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        //line = br.readLine();
        //String[] stringQty = line.split(" ");
        //int[] qty = new int[N];
        int prev = 0;
        System.out.println("#");

        //Scanner sc = new Scanner(System.in);
        int[] integers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            integers[i] = Integer.parseInt(st.nextToken());
        }
        //for(int i=0; i<N; i++){
        //	qty[i] = Integer.parseInt(stringQty[i]);
        //qty[i] = qty[i]+prev;
        //prev = qty[i];
        //}
        line = br.readLine();
        int Q = Integer.parseInt(line);
        int[] input = new int[Q];
        for (int i = 0; i < Q; i++) {
            System.out.println("@");

            line = br.readLine();
            input[i] = Integer.parseInt(line);
        }




        for(int i=0; i<Q; i++){
            System.out.println(getBucketByBinarySearch(integers,input[i])+1);
        }
    }

    private static int getBucketByBinarySearch(int[] qty, int k){
        int left=0, right=qty.length-1;
        int mid = left + (right - left)/2;

        while(left<=right){
            if(qty[mid]==k){
                return mid;
            }
            if(qty[mid]<k){
                left = mid;
            }
            else{
                right = mid;
            }
            mid = left + (right - left)/2;
        }
        return mid+1;

    }
}
