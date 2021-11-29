package medium;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        Integer[] box = new Integer[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        permutation(nums, 0, box, res);
        return res;
    }
    
    public void permutation(int[] nums, int ci, Integer[] box, List<List<Integer>> res){
		if(ci == nums.length) {
			List<Integer> cres = new ArrayList<>();
			for(int val : box) {
				cres.add(val);
			}
			res.add(cres);
			return;
		}
		for(int i = 0; i<box.length; i++) {
			if(box[i] == null) {
				box[i] = nums[ci];
				permutation(nums, ci+1, box, res);
				box[i] = null;
			}
		}
	}
}
