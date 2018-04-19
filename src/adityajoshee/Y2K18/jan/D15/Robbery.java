package adityajoshee.Y2K18.jan.D15;

/**
 * Created by aditya.joshee on 1/15/18.
 * https://leetcode.com/problems/house-robber/description/
 *
 * robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing
 * each of them is that adjacent houses have security system connected and it
 * will automatically contact the police if two adjacent houses were broken into on the same night.
 Given a list of non-negative integers representing the amount of money of each house, determine
 the maximum amount of money you can rob tonight without alerting the police.
 */
public class Robbery {
    public static void main(String[] args){
        int[] money  = {7,2,1,3,4,6};//{9,0,1,8};
        System.out.println(sol(money,money.length-1));
        System.out.println(bestSol(money));
        System.out.println(sol1(money));
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

    private static int sol1(int[] money){
        int x = money[0]; // x will be max sum taking current
        int y = 0 ; // y will be max sum not taking current.
        for (int i = 1; i < money.length; i++) {
            int k = Math.max(x, y);
            x = y + money[i]; // taking current and y, since y did not condiser previous element
            y = k; // y will become the max of previous x and current y;
        }
        return Math.max(x,y);
    }
}
