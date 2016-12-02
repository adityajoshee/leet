package adityajoshee.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class RodCuttingLendingKart {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {

            line = br.readLine();
            int r = Integer.parseInt(line);
            int[] counts = new int[r+1];
            counts[0]=0;
            printSpecial(r,counts);
        }
    }

    private static void printSpecial(int r, int[] counts){
        for(int i=1; i<=r; i++){

            if(i==0 || i==1){
                counts[i]=0;
                continue;
            }
            if(i==2){
                counts[i]=1;
                continue;
            }
            int t = i/2;
            if(i%2==0){
                counts[i]=0;
            }
            else{
                counts[i]=counts[t];
            }
        }
        int x = 0;
        for (int j=0; j<counts.length; j++){
            if(counts[j]>0)
                x++;
        }
        System.out.println(x);
    }

}
