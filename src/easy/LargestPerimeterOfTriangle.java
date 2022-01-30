package easy;

import java.util.*;

public class LargestPerimeterOfTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length-1;
        int j = nums.length-2;
        int k = nums.length-3;
        
        while(k>=0) {
            if(nums[j]+nums[k] > nums[i]) {
            	return nums[j]+nums[k]+nums[i];
            }else {
            	i--;
            	j--;
            	k--;
            }
        }
        return 0;
    }
}
