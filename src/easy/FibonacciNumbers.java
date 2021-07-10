package easy;

public class FibonacciNumbers {
    public int fib_tab(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
    
    public int fib(int n) {
        if(n == 0 || n==1){
            return n;
        }
        int[] dp = new int[n+1];
        int x = fib_tab(n, dp);
        return x;
    }
}
