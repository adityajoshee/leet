package algorithms.recursion;

/**
 * Created by adityajoshee on 27/04/16.
 */
public class RodCutting {

    public static void main(String args[]) throws Exception{
        int[] rodPrices = {1, 5, 8, 9, 10, 17, 17, 20}; // len1 has price 1, len2 has price 5 ...
        System.out.println("Max Revenue:" + maxRevenue(rodPrices,8));
    }

    private static int maxRevenue(int[] rodPrices, int rodLength) throws Exception
    {
        int tempMaxRevenue = 0;
        for(int i=0; i<rodLength; i++){

            tempMaxRevenue =
                    Math.max(tempMaxRevenue,rodPrices[i]+maxRevenue(rodPrices,rodLength-i-1));
        }
        return tempMaxRevenue;
    }

}
