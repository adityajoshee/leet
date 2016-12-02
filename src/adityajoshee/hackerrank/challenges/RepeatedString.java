package adityajoshee.hackerrank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/10/16.
 */
public class RepeatedString {
    public static void main(String arg[]) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        long n = Long.parseLong(bufferedReader.readLine());
        System.out.println(countFreqOfA(s,n));
    }
    private static long countFreqOfA(String s, long n){
        long k = n%s.length();
        long d = n/s.length();
        int swf = singleWordFreqOfA(s, s.length());
        int f = singleWordFreqOfA(s, k);
        return d*swf+f;
    }
    private static int singleWordFreqOfA(String s, long index){
        int c=0;
        for (int i = 0; i < index; i++) {
            if(s.charAt(i)=='a'){
                c++;
            }
        }
        return c;
    }
}
