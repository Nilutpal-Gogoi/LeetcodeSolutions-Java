package hard;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0) return 0;
    	int[][] dp = new int[costs.length][costs[0].length];
    	
        int min1 = (int) 1e9;
        int min2 = (int) 1e9;

    	for(int i = 0; i<costs.length; i++) {
            int min = (int) 1e9;
            int smin = (int) 1e9; 
            for(int j = 0; j<costs[0].length; j++){
                if(i==0){
                    dp[i][j] = costs[i][j];
                } else {
                    if(dp[i-1][j] != min1){
                        dp[i][j] = costs[i][j] + min1;
                    }else{
                        dp[i][j] = costs[i][j] + min2;
                    }
                }

                if(dp[i][j] <= min){
                    smin = min;
                    min = dp[i][j];
                }else if(dp[i][j] < smin){
                    smin = dp[i][j];
                }
            }
            min1 = min;
            min2 = smin	;
    	}
        return min1;
    }
}
