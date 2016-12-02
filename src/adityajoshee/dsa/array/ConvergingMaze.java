package adityajoshee.dsa.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by adityajoshee on 17/05/16.
 */
public class ConvergingMaze {


    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        String[] sp = line.split(" ");
        int[] input = new int[N];
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(sp[i]);
        }
        System.out.print(maxEntries(input));
    }

    private static int maxEntries(int[] input){
        int[] hsh = new int[maxSize(input)+1];
        //System.out.print(hsh.length);

        for(int i=0;i<hsh.length;i++){
            hsh[i]=0;
        }
        for(int i=0;i<input.length;i++){
            hsh[input[i]]=hsh[input[i]]+1;
        }

        int x=0;
        for(int i=0;i<hsh.length;i++){
            if(x<hsh[i]){
                x=hsh[i];
            }
        }
        return x;
    }
    private static int maxSize(int[] input){
        int k=Integer.MIN_VALUE;
        for(int i=0;i<input.length;i++){
            if(k<input[i]){
                k=input[i];
            }
        }
        return k;
    }


}