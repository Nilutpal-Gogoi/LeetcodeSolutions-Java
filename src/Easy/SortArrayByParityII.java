// https://leetcode.com/problems/sort-array-by-parity-ii/
package Easy;

import java.util.Arrays;

public class SortArrayByParityII {

	public static void main(String[] args) {
		int[] arr = {4,2,5,7};
		sortArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	
    public static int[] sortArray(int[] nums) {
        int i = 0; 
        int j = 1;
        int n = nums.length;
        while(i<n && j<n){
            while(i<n && nums[i]%2==0){
                i+=2;
            }
            while(j<n && nums[j]%2!=0){
                j+=2;
            }
            if(i<n && j<n){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

}
