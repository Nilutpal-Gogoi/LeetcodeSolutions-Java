package medium;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        // Another test case : arr = {1,2} , k = 3;
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] nums, int k) {
        if(k>nums.length){
            k = k-nums.length;
        }
        reverse(nums, 0, nums.length-k);
        reverse(nums, nums.length-k, nums.length);
        reverse(nums, 0, nums.length);
    }

    public static void reverse(int[] nums, int start, int end){
        end = end-1;
        int temp;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
