package adityajoshee.hackerrank.ds.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

/**
 * Created by aditya on 8/29/16.
 */
public class JavaExceptionHandling {
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result=null;
        int x=-1,y=-1;
        try {
            x = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            result = e.getClass().getTypeName();
        }
        catch (NumberFormatException e) {
            result = new InputMismatchException().getClass().getTypeName();
        }
        try {
            y = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            result = e.getClass().getTypeName();
        }
        catch (NumberFormatException e) {
            result = new InputMismatchException().getClass().getTypeName();
        }

        if(result==null){
            try{
                System.out.println(x/y);
            }
            catch (ArithmeticException e) {
                result = e.getClass().getTypeName()+": / by zero";
            }
        }
        if(result!=null){
            System.out.println(result);
        }

    }
}
