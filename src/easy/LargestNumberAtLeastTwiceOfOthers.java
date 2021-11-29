package easy;

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int index1 = -1;
        int max2 = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
                index1 = i;
            } else if(nums[i] > max2){
                max2 = nums[i];
            }
        }
        
        return max1 >= (max2*2) ? index1:-1;
    }
}
