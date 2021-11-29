package medium;

public class LeastCommonAncestorInBinaryTree {
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
	public TreeNode lca = null;
	
	public boolean solveLCA(TreeNode node, TreeNode data1, TreeNode data2) {
		if(node == null) return false;
		boolean self = node == data1 || node == data2;
		
		boolean left = false, right = false;
		left = solveLCA(node.left, data1, data2);
		if(lca == null) {
			right = solveLCA(node.right, data1, data2);			
		}
		
		if((self && left) || (self && right) || (left && right)) {
			lca = node;
		}
		
		return self || left || right;
	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
		solveLCA(root, p, q);
		return lca;
    }
}
