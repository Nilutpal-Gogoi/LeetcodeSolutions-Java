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
        int len = nums.length;
        while(k>len){
            k = k-len;
        }
        flip(nums,0,len-k-1);
        flip(nums,len-k,nums.length-1);
        flip(nums,0,nums.length-1);
    }
    
    public static void flip(int[] nums,int st, int end){
        while(st<end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
}
