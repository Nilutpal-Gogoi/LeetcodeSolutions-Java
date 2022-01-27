package medium;

public class MaximumXORofTwoNumbersInAnArray {
    public static int findMaximumXOR(int[] nums) {
        int res = 0;
        for(int i = 0; i<nums.length-1; i++) {
        	for(int j = i+1; j<nums.length; j++) {
        		if(res < (nums[i]^nums[j])) {
        			res = (nums[i]^nums[j]);
        		}
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {3,10,5,25,2,8};
    	System.out.println(findMaximumXOR(nums));
    }
}
