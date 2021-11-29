package medium;

import medium.RecoverBST.TreeNode;

public class ValidateBinarySearchTree {
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
    public long maxOfBST(TreeNode root){
        if(root == null) return Long.MIN_VALUE;
        
        long max = Long.MIN_VALUE;
        max = Math.max(maxOfBST(root.left), max);
        max = Math.max(maxOfBST(root.right), max);
        
        return Math.max(max, root.val);
    }
    
    public long minOfBST(TreeNode root){
        if(root == null) return Long.MAX_VALUE;
        
        long min = Long.MAX_VALUE;
        min = Math.min(minOfBST(root.left), min);
        min = Math.min(minOfBST(root.right), min);
        
        return Math.min(min, root.val);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        long lmax = maxOfBST(root.left);
        long rmin = minOfBST(root.right);
        
        if(lmax >= root.val || rmin <= root.val){
            return false;
        }
        
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
