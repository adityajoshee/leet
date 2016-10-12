package hackerrank.contests.w23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/13/16.
 */
public class GearsOfWar {
    public static void main(String args[]) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int q = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < q; i++) {
            System.out.println(get(Integer.parseInt(bufferedReader.readLine())));
        }
    }
    private static String get(int g){
        if(g<3){
            return "No";
        }
        return g%2==0?"Yes":"No";
    }
}
