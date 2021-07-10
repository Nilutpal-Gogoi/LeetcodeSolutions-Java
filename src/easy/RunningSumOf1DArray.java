//https://leetcode.com/problems/running-sum-of-1d-array/

package easy;

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums)
    {
        int[] arr = new int[nums.length];
        int length = nums.length;
        arr[0] = nums[0];
        for(int i = 1; i< nums.length;i++)
        {
            arr[i] = nums[i]+arr[i-1];
        }
        return arr;
    }
}
