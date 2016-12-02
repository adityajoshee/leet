package adityajoshee.practice.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by adityajoshee on 17/05/16.
 */
public class DemoInput {


    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N);
        int str=br.read();   //reads String like 10<enter>
        int str1=br.read();
        //int a=Integer.parseInt(str)  ;        //reads integer
        System.out.println(str);
        System.out.println(str1);

    }

}
