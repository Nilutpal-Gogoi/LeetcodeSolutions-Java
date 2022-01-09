package medium;

public class BestTimeToBuyAndSellStocksWithCooldown {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;
        
        for(int i = 1; i<prices.length; i++){
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            
            nbsp = Math.max(ocsp-prices[i], obsp);
            nssp = Math.max(obsp+prices[i], ossp);
            ncsp = Math.max(ossp,ocsp);
            
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        
        return ossp;
    }
}
