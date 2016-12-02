package adityajoshee.dsa.array;

/**
 * Created by aditya on 11/23/16.
 */
//only profit needs to be found out..not acutal buy-sell points

public class MaximizeProfitFromStocks {
    public static void main(String args[]){
        // multiple transactions allowed...
        int[] prices = {5,4,1};//{5,2,3,10,6,4,8};
        System.out.println(exec(prices));
    }
    private static int exec(int[] prices){
        int profitTillNow = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i]<prices[i+1]){
                profitTillNow += prices[i+1]-prices[i];
            }
        }
        return profitTillNow;
    }
}
