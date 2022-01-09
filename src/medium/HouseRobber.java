package medium;

import java.util.Arrays;

public class HouseRobber {
    public static void rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        func(0, nums, dp);
        System.out.println(dp[0]);
    }
    
    private static int func(int indx, int[] nums, int[] dp) {
    	if(indx >= nums.length) {
    		return 0;
    	}
    	
    	if(dp[indx] != -1) return dp[indx];
    	
    	int steal = func(indx+2, nums, dp)+nums[indx];
    	int nSteal = func(indx+1, nums, dp);
    	
    	dp[indx] = Math.max(steal, nSteal);
    	return dp[indx];
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3,1,5,6};
    	rob(nums);
    }
    
    public int rob_Iter(int[] nums) {
        int[] dp = new int[nums.length+2];
        int n = nums.length;
        dp[n+1] = 0;
        dp[n] = 0;
        
        for(int i = n-1; i>=0; i--){
            int steal = dp[i+2] + nums[i];
            int nSteal = dp[i+1];
            
            dp[i] = Math.max(steal, nSteal);
        }
        
        return dp[0];
    }
}
