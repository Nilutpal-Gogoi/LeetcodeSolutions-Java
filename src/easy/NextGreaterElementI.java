package easy;

public class NextGreaterElementI {
	private int nextGreater(int[] nums, int val) {
		boolean found = false;
		int max = Integer.MIN_VALUE;
        int res = -1;
		for(int ele : nums) {
			if(found) {
				if(ele>val) {
					res = ele;
                    break;
				}
			} else {
				if(ele==val) {
					found = true;
				}
			}
		}
		
		return res;
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
        	int val = nums1[i];
        	int res = nextGreater(nums2, val);
        	ans[i] = res;
        }
        
        return ans;
    }
    
}
