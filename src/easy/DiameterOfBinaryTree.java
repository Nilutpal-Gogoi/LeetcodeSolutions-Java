package easy;

public class DiameterOfBinaryTree {
	public class TreeNode {
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

	public int diameter = 0;
	
	public int heightForDiameter(TreeNode root) {
		if(root == null) return -1;
		int lh = heightForDiameter(root.left);
		int rh = heightForDiameter(root.right);
		diameter = Math.max(diameter, lh+rh+2);
		return Math.max(lh, rh)+1;
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		heightForDiameter(root);
		return diameter;
    }
}
