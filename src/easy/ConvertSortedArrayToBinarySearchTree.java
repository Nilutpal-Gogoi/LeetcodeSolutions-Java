package easy;

public class ConvertSortedArrayToBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode constructBST_using_In(int[] in, int lo, int hi) {
		if(lo > hi) return null;
		
		int mid = lo + (hi-lo) / 2;
		TreeNode root = new TreeNode(in[mid]);
		
		root.left = constructBST_using_In(in, lo, mid-1);
		root.right = constructBST_using_In(in, mid+1, hi);
		
		return root;
		
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return constructBST_using_In(nums, 0, nums.length - 1);
    }
}
