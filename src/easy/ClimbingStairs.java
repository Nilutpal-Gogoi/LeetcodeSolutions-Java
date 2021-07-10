package easy;

public class ClimbingStairs {
    public int climbStairs_memo(int n, int[] dp){
        if(n==0){
            return dp[0] = 1;
        }
        
        if(dp[n] != 0) return dp[n];
        
        int count = 0;
        for(int i=1; i<=2; i++){
            if(n-i >= 0){
                count += climbStairs_memo(n-i, dp);
            }
        }
        
        return dp[n]=count;
    }
    
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        int x = climbStairs_memo(n, dp);
        return x;
    }
}
