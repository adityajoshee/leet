package algorithms.arrays;

/**
 * Created by adityajoshee on 27/04/16.
 */
public class StockBuySellOneTransMaxProfit {
    public static void main(String args[]){
        int[] dayPrices = { 7, 9, 5, 6, 3, 2 };//{2, 3, 10, 6, 4, 8, 1};
        System.out.println(findMaxProfitForSingleTrans(dayPrices));
    }

    // p = 0, b = 2
    // p = 1, b = 2
    // p = 8, b = 2
    // p = 8, b = 2
    // p = 8, b = 2
    // p = 8, b = 2
    // p = 8, b = 1

    private static int findMaxProfitForSingleTrans(int[] dayPrices){
        int currentMaxProfit = 0;
        int currentMinBuyPrice = dayPrices[0];

        for(int i=0; i<dayPrices.length; i++){
            currentMaxProfit = Math.max(currentMaxProfit,dayPrices[i]-currentMinBuyPrice);
            currentMinBuyPrice = Math.min(currentMinBuyPrice,dayPrices[i]);
        }
        return currentMaxProfit;
    }
}
