package medium;

import java.util.*;

public class MajorityElementII {
	private boolean checkFreqM2(int[] arr, int val) {
		int count = 0;
		for(int e:arr) {
			if(e == val) count++;
		}
		return count > arr.length/3;
	}
	
    public List<Integer> majorityElement(int[] nums) {
        // find valid candidates for majority
    	int val1 = nums[0];
    	int count1 = 1;             // count1 -> count of val1 for current window to make triplets
    	
    	int val2 = nums[0];         // count2 -> count of val2 for current window to make triplets
    	int count2 = 0;
    	
    	for(int i=1; i<nums.length; i++) {
    		if(nums[i] == val1) {
    			count1++;
    		}else if(nums[i] == val2) {
    			count2++;
    		} else {
    			if(count1 == 0) {
    				val1 = nums[i];
    				count1 = 1;
    			} else if(count2 == 0) {
    				val2 = nums[i];
    				count2 = 1;
    			} else {
    				// triplet is found, reduce freq of val1 and val2 from count1 and count2
    				count1--;
    				count2--;
    			}
    		}
    	}
    	
    	// check if it has freq more than n/3 using val1 and val2
    	List<Integer> list = new ArrayList<>();
    	boolean check1 = checkFreqM2(nums, val1);
    	if(check1 == true) list.add(val1);
    	
    	if(val1 == val2) return list;
    	
    	boolean check2 = checkFreqM2(nums, val2);
    	if(check2 == true) list.add(val2);
    	
    	return list;
    }
}
