package hackerrank.ds.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by aditya on 9/5/16.
 */
public class StringFreq {
    public static void main(String args[]) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> freqMap = new HashMap<>(N);
        generateFreqMap(br, N, freqMap);
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q ; i++) {
            String s = br.readLine();
            if(freqMap.containsKey(s)){
                System.out.println(freqMap.get(s));
            }
            else{
                System.out.println(0);
            }
        }
    }
    private static void generateFreqMap(BufferedReader  br, int N, HashMap<String, Integer> freqMap) throws IOException{
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(freqMap.containsKey(s)){
                freqMap.put(s,freqMap.get(s)+1);
            }
            else {
                freqMap.put(s,1);
            }
        }
    }
}
