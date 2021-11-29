package medium;

public class MaxConsecutiveOnesII {
    public static int findMaxConsecutiveOnes(int[] nums) {
    	int ans = 0;
    	
    	int j = -1;
    	int zeroCount = 0;
    	for(int i = 0 ; i<nums.length; i++) {
    		if(nums[i] == 0) {
    			zeroCount++;
    		}
    		
    		while(zeroCount > 1) {
    			j++;
    			if(nums[j] == 0) {
    				zeroCount--;
    			}
    		}
    		
    		int len = i-j;
    		if(len > ans) {
    			ans = len;
    		}
    	}
    	
    	return ans;
    }
}
