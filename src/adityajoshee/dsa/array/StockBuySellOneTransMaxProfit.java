package adityajoshee.dsa.array;

/**
 * Created by adityajoshee on 27/04/16.
 */


// 1. Only 1 transaction allowed
// 2. Any number of transactions...
public class StockBuySellOneTransMaxProfit {
    public static void main(String args[]){
        int[] dayPrices = {100, 180, 160, 110, 40, 535, 695,100};//{ 7, 9, 4, 6, 3, 5, 11 };//{2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxProfitSingleTrans(dayPrices));
        maxProfitMultipleTrans(dayPrices);
    }

    // p = 0, b = 2
    // p = 1, b = 2
    // p = 8, b = 2
    // p = 8, b = 2
    // p = 8, b = 2
    // p = 8, b = 2
    // p = 8, b = 1

    // O(n2)
    private static int findMaxSingleTrans(int[] prices){
        int profit =  0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                profit = prices[j]-prices[i]>profit?prices[j]-prices[i]:profit;
            }
        }
        return profit;
    }

    // O(n)
    private static int maxProfitSingleTrans(int[] prices){
        int profit = 0;
        int buyPrice = prices[0];
        for(int i=1; i<prices.length; i++){
            profit = prices[i]-buyPrice>profit?prices[i]-buyPrice:profit;
            buyPrice = prices[i]<buyPrice?prices[i]:buyPrice;
        }
        return profit;
    }

    // O(n)
    private static void maxProfitMultipleTrans(int[] prices){
        int i=0; // first day
        int totalProfit = 0;
        while(i<prices.length-1){
            while(i<prices.length-1 && prices[i+1]<=prices[i]){
                i++;
            }
            Trans t = new Trans();
            t.buy=prices[i++];

            while (i<prices.length-1 && prices[i+1]>=prices[i]){
                i++;
            }
            if (i>=prices.length){
                break;
            }
            t.sell=prices[i];
            System.out.print(t);
        }
    }

}

class Trans{
    int buy;
    int sell;
    public Trans(){}
    public String toString(){
        return "("+buy+"_"+sell+")";
    }
}
