package medium;

public class BestTimeToBuyAndSellStocksII {
    public static int maxProfit(int[] prices) {
        int stk = prices[0];
        int diff = 0;
        for(int i = 1; i<prices.length; i++) {
        	if(prices[i] < stk) {
        		stk = prices[i];
        	}else {
        		diff += (prices[i]-stk);
        		stk = prices[i];
        	}
        }
        
        return diff;
    }
    
    public static void main(String[] args) {
    	int[] prices = {7,6,4,3,1};
    	System.out.println(maxProfit(prices));
    }
}
