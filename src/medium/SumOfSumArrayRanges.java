package medium;

import java.util.Arrays;

public class SumOfSumArrayRanges {
	// ------------- O(n2) Approach --------------------------------------
	public static long subArrayRanges(int[] nums) {
		long count = 0;
		for(int i = 0; i<nums.length-1; i++) {
			int max = nums[i];
			int min = nums[i];
			for(int j = i+1; j<nums.length; j++) {
				max = Math.max(max, nums[j]);
				min = Math.min(min, nums[j]);
				count += (max-min);
			}
		}
		
		return count;
	}
	
	
	// ----------- O(n) Approach : Using Stacks(Next Greater concept)------------------------
	
	
	
	public static void main(String[] args) {
		int[] nums = {4,-2,-3,4,1};
		long res = subArrayRanges(nums);
		System.out.println(res);
	}
}
