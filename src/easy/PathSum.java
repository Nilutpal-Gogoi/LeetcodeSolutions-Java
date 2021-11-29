package easy;

public class PathSum {
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
	private boolean pathSum(TreeNode root, int targetSum, int ssf) {
		if(root == null) return false;
        if(root.left == null && root.right == null) {
            return ssf+root.val == targetSum;
        }
		
		
		return pathSum(root.left, targetSum, ssf+root.val) || pathSum(root.right, targetSum, ssf+root.val);
	}
	
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }
}
