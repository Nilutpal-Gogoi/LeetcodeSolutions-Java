package easy;

public class SortByParity {
	public int[] sortArrayByParity(int[] nums) {
		int i = 0;
		int j = 0;
		
		while(i<nums.length) {
			if(nums[i]%2 == 0) {
				// even 
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				
				i++;
				j++;
			} else {
				// odd
				i++;
			}
		}
		return nums;
	}
}
