package adityajoshee.Y2K18.jan.D15;

/**
 * Created by aditya.joshee on 1/15/18.
 * https://leetcode.com/problems/house-robber/description/
 */
public class Robbery {
    public static void main(String[] args){
        int[] money  = {9,0,1,8};
        System.out.println(sol(money,money.length-1));
        System.out.println(bestSol(money));
    }
    private static int sol(int[] money, int x){
        if (x==0){
            return money[0];
        }
        if (x==1){
            return Math.max(money[0],money[1]);
        }
        return Math.max(money[x]+sol(money, x-2), sol(money, x-1));
    }

    private static int bestSol(int[] money){
        int ic = money[0];
        int nc = 0;
        for (int x=1; x<money.length; x++){
            int pnc = nc;
            nc = Math.max(nc, ic);
            ic = money[x]+pnc;
        }
        return Math.max(ic, nc);

    }
}
