package codechef.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 8/28/16.
 */
public class FLOW006 {
    public static void main(String args[]) throws IOException{
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bis.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bis.readLine());
            int s = N%10;
            int k = N/10;
            while(k!=0){
                s+=k%10;
                k/=10;
            }
            System.out.println(s);
        }
    }
}
