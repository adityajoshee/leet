package adityajoshee.practice.other;

import java.util.Scanner;
public class Fractions
{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        System.out.print(count(N));

    }
    private static int count(int N){
        int count=0;
        for(int i=1; i<=N; i++ ){
            int j=i;
            while(j>=i && j<=N){
                System.out.println(" "+i+" "+j+" ");
                if(!canReduce(i,j)){
                    System.out.println(i+"/"+j);
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    // not correct ... gcd of i and j if not 1 then return false
    private static boolean canReduce(int i, int j){
        if( i==j){
            return true;
        }
        if(i!=1 && j%i==0){
            return true;
        }
        return false;
    }
}