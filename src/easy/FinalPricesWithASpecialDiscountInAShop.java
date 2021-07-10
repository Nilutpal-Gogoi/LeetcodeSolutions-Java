//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

package easy;

import java.util.Arrays;

public class FinalPricesWithASpecialDiscountInAShop {
    public static void main(String[] args){
        int[] arr = {10,1,1,6};
        System.out.println(Arrays.toString(finalPrices(arr)));

    }
    public static int[] finalPrices(int[] prices){
        for(int i=0;i< prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    prices[i] = prices[i]-prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
