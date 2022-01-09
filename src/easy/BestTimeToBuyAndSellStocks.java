package easy;

public class BestTimeToBuyAndSellStocks {
    public static int maxProfit(int[] prices) {
    	int res = 0;
    	int min = prices[0];
    	for(int i = 1; i<prices.length; i++) {
    		if(prices[i] < min) {
    			min = prices[i];
    		}else {
    			res = Math.max(prices[i]-min, res);
    		}
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
    	int[] prices = {11, 6,7,19,14,1,6,18,4};
    	System.out.println(maxProfit(prices));
    }
}
