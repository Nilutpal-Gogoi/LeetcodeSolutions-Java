// https://leetcode.com/problems/array-partition-i/

package easy;

import java.util.Arrays;

public class ArrayPartitionI {
    public static void main(String[] args){
        int[] arr = {6214, -2290, 2833, -7908};
        System.out.println(arrayPairSum(arr));
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i<nums.length-1;){
            res += Math.min(nums[i],nums[i+1]);
            i+=2;
        }
        return res;
    }
}

