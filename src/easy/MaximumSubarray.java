package easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int csum = 0;
        int osum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(csum < 0){
                csum = nums[i];
            } else{
                csum += nums[i];
            }
            osum = Math.max(osum, csum);
        }
        return osum;
    }
}
