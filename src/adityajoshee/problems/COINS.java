package adityajoshee.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by aditya on 8/28/16.
 */
public class COINS {
//codechef
    private static HashMap<Long,Long> cache = new HashMap<>();
    public static void main(String args[]) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bis.readLine()) != null && line.length()!=0) {
            long N = Long.parseLong(line);
            System.out.println(maxDollars(N));
        }
    }
    private static long maxDollars(long n){
        if(n<12){
            return n;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        cache.put(n,maxDollars(n/2)+maxDollars(n/3)+maxDollars(n/4));
        return cache.get(n);
    }
}
