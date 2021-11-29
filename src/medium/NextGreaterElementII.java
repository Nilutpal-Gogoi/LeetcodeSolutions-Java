package medium;

import java.util.Stack;

public class NextGreaterElementII {
   
	public int[] nextGreaterElements(int[] nums) {
		int[] res = new int[nums.length];
		Stack<Integer> st = new Stack<>();
		
		for(int i = nums.length-2; i>=0; i--) {
			while(st.size() > 0 && st.peek() <= nums[i]) {
				st.pop();
			}
			st.push(nums[i]);
		}
		
		for(int i = nums.length-1; i >= 0 ; i--) {
			while(st.size() > 0 && st.peek() <= nums[i]) {
				st.pop();
			}
			res[i] = st.size() == 0 ? -1 : st.peek();
			st.push(nums[i]);
		}
		
		return res;
    }
}
