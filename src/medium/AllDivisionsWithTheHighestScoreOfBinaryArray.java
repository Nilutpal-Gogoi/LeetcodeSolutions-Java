package medium;

import java.util.*;

public class AllDivisionsWithTheHighestScoreOfBinaryArray {
    public List<Integer> maxScoreIndices(int[] nums) {
    	int ones = 0;
    	for(int i : nums) {
    		if(i == 1) {
    			ones++;
    		}
    	}
    	int ls = 0;
    	int rs = ones;
    	int max = ls+rs;
    	List<Integer> res = new ArrayList<>();
    	res.add(0);
       	for(int i = 0; i<nums.length; i++) {
    		if(nums[i]==0) {
    			ls++;
    		}else {
    			rs--;
    		}
    		int cur = ls+rs;
    		if(cur > max) {
    			max = cur;
    			res = new ArrayList<>();
    			res.add(i+1);
    		}else if(cur == max){
    			res.add(i+1);
    		}
    	}
    	
    	return res;
    }
}
