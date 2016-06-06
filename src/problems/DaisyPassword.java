package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// check string insert into itself only once
public class DaisyPassword {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String[] arr = line.split(" ");
            System.out.println(printResult(arr[0], arr[1]));
        }


    }

    private static boolean printResult(String s, String p){
        int x = p.indexOf(s);
        while(x<p.length()){

            if(x<0){
                return false;
            }
            String s1="";
            if(p.length()>=s.length()*2){
                s1 = p.substring(0,x)+p.substring(x+s.length());
                if(s1.equals(s)){
                    return true;
                }
                else{
                    x=p.indexOf(s, x+1);
                    System.out.println(x);
                    if(x<0){
                        return false;
                    }
                }
            }
            else {
                return false;
            }

        }
        return false;
    }
}
