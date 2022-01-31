package easy;

import java.util.*;

public class KeepMultiplyingFoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int temp = original;
        while(true){
            if(find(nums, temp)){
                temp = 2*temp;
            }else{
                break;
            }
        }
        return original != temp ? temp : original;
    }
    
    public boolean find(int[] nums, int val){
        int st = 0;
        int end = nums.length-1;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(nums[mid] == val){
                return true;
            }else if(nums[mid] < val){
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}
