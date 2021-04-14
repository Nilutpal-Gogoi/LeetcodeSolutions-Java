package Easy;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums)
    {
        Arrays.sort(nums);
        int leftMax = (nums[0]-1)*(nums[1]-1);
        int rightMax = (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
        return Math.max(leftMax,rightMax);
    }
}
