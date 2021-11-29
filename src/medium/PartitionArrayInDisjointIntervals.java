package medium;

public class PartitionArrayInDisjointIntervals {
    public int partitionDisjoint(int[] nums) {
		int leftmax = nums[0];
		int maxInRun = nums[0];
		int ans = 0;
		
		for(int i = 1; i<nums.length; i++) {
			if(nums[i] > maxInRun) {
				maxInRun = nums[i];
			} else if(nums[i] < leftmax) {
				ans = i;
				leftmax = maxInRun;
			}
		}
		
		return ans+1;
    }
}
